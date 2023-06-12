package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Adicionais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ruang
 */
public class AdicionaisDAO implements IDAOT<Adicionais> {

    @Override
    public String salvar(Adicionais o) {
        //Salvar Adicional no banco de dados
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();

            String sql = "INSERT "
                    + "INTO adicionais (id, descricao, valor, ativo) "
                    + "VALUES (default, ?, ?, true)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, o.getDescricao());
            statement.setDouble(2, o.getValor());

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Adicional " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Adicionais o) {
        //Atualizar um Usuário
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "UPDATE adicionais "
                    + "SET descricao = ?, valor = ? "
                    + "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, o.getDescricao());
            statement.setDouble(2, o.getValor());
            statement.setInt(3, o.getId());

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Adicionais " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "UPDATE adicionais "
                    + "SET ativo = false "
                    + "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Adicionais " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Adicionais> consultarTodos() {
        ArrayList<Adicionais> adicionais = new ArrayList();

        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "SELECT * "
                    + "FROM adicionais "
                    + "WHERE ativo = true "
                    + "ORDER BY descricao";

            PreparedStatement statement = connection.prepareStatement(sql);

            System.out.println("SQL: " + statement.toString());
            ResultSet retorno = statement.executeQuery();
            while (retorno.next()) {
                Adicionais adicional = new Adicionais();

                adicional.setId(retorno.getInt("id"));
                adicional.setDescricao(retorno.getString("descricao"));
                adicional.setValor(retorno.getDouble("valor"));

                adicionais.add(adicional);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Adicionais " + e);
        }
        return adicionais;
    }

    @Override
    public ArrayList<Adicionais> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Adicionais consultarId(int id) {
        Adicionais adicional = new Adicionais();

        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "SELECT * "
                    + "FROM adicionais "
                    + "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            System.out.println("SQL: " + statement.toString());
            ResultSet retorno = statement.executeQuery();
            while (retorno.next()) {

                adicional.setId(retorno.getInt("id"));
                adicional.setDescricao(retorno.getString("descricao"));
                adicional.setValor(retorno.getDouble("valor"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Adicionais " + e);
        }
        return adicional;
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Adicionais> adicionais = consultarTodos();

        ArrayList<String[]> tableData = new ArrayList();
        for (Adicionais adicional : adicionais) {
            String[] data = {
                Integer.toString(adicional.getId()),
                adicional.getDescricao(),
                String.valueOf(Formatacao.formatarDecimal2casasRS(adicional.getValor()))
            };

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[2].contains(filtro.toUpperCase())
                    || data[3].contains(filtro.toUpperCase())) {
                tableData.add(data);
            }
        }
        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        return new String[]{"Id", "Descrição", "Valor"};
    }

    public void popularTabela(JTable tabela, String criterio) {
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "ID";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Valor";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM adicionais "
                    + "WHERE ativo=true "
                    + "AND (descricao ILIKE '%" + criterio + "%') "
                    + "ORDER BY descricao");
            
            while (resultadoQ.next()) {
                Object[] linha = new Object[3];
                linha[0] = resultadoQ.getInt("id");
                linha[1] = resultadoQ.getString("descricao");
                linha[2] = Formatacao.formatarDecimal2casasRS(resultadoQ.getDouble("valor"));

                dadosTabela.add(linha);
            }

        } catch (Exception e) {
            System.out.println("Erro ao popular tabela: " + e);
        }

        tabela.setModel(new DefaultTableModel(
                dadosTabela.toArray(new Object[0][0]), cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
                // if (column == 3){return true} else {return false}
            }
        });

        // Altera o número de selecao de linhas da tabela
        tabela.setSelectionMode(0);

        // Redimensiona as colunas de uma tabela
        TableColumn column = null;
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        int[] columnWidths = {20, 380, 50};
        for (int i = 0; i < tabela.getColumnModel().getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Alinhar dados da coluna 1 no centro da celula da tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumn column1 = tabela.getColumnModel().getColumn(0);

        column1.setCellRenderer(centerRenderer);
    }
}
