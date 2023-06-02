package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Item;
import entidade.Movimentacao;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ruang
 */
public class movimentacaoDAO implements IDAOT<Movimentacao> {

    private String tipo;
    private DecimalFormat formater = new DecimalFormat("#.####");

    public movimentacaoDAO(String tipo) {
        this.tipo = " where tipo='" + tipo + "'";
    }

    public movimentacaoDAO() {
        this.tipo = "";
    }

    private void atualizarEstoques(int idItem, double soma) {
        Item item = new ItemDAO().consultarId(idItem);
        item.setQtde_estoque(item.getQtde_estoque() + soma);
    }

    @Override
    public String salvar(Movimentacao o) {
        String cliente_id = "NULL";
        if (o.getCliente_id() != 0) {
            cliente_id = "" + o.getCliente_id();
        }

        String sql = "INSERT INTO movimentacao VALUES "
                + "(default, "
                + "'" + o.getTipo() + "', "
                + "'" + o.getData() + "', "
                + "'" + o.getItem_id() + "', "
                + "" + cliente_id + ", "
                + "'" + o.getValor() + "', "
                + "'" + o.getQtde() + "', "
                + "'" + o.getPerdas() + "', "
                + "'" + o.getObservacao() + "', "
                + "'" + o.getId_pedido() + "' "
                + "'" + o.getId_grupo_movimentacao() + ");";

        //Salvar movimentacao no banco de dados
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);

            atualizarEstoques(o.getItem_id(), o.getQtde());

            return null;

        } catch (Exception e) {
            System.out.println(sql);
            System.out.println("Erro ao inserir cadastro de movimentacao " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Movimentacao o) {

        //Atualizar um movimentacao/Fornecedor
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE movimentacao SET "
                    + "tipo='" + o.getTipo() + "', "
                    + "data='" + o.getData() + "', "
                    + "item_id='" + o.getItem_id() + "', "
                    + "cliente_id='" + o.getCliente_id() + "', "
                    + "valor='" + o.getValor() + "', "
                    + "qtde='" + o.getQtde() + "', "
                    + "perda='" + o.getPerdas() + "', "
                    + "observacao='" + o.getObservacao() + "', "
                    + "id_pedido='" + o.getId_pedido() + "', "
                    + "id_grupo_movimentacao=" + o.getId_grupo_movimentacao() + " "
                    + "WHERE id='" + o.getId() + "'";

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            atualizarEstoques(o.getItem_id(), o.getQtde());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar movimentacao/Fornecedor " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        // Adiciona uma nova movimentação, mas com os valores invertidos
        Movimentacao m = this.consultarId(id);
        m.setData(LocalDateTime.now());
        m.setQtde(-m.getQtde());
        m.setPerdas(-m.getPerdas());
        m.setValor(-m.getValor());
        m.setTipo(m.getTipo());

        this.salvar(m);
        return "";
    }

    public ArrayList<Movimentacao> consultarTodos(String tipo) {
        //Consultar todos os movimentacoes/Fornecedores
        ArrayList<Movimentacao> movimentacoes = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM movimentacao "
                    + this.tipo;

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                Movimentacao m = new Movimentacao(retorno);
                movimentacoes.add(m);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de movimentacao/Fornecedor " + e);
        }

        return movimentacoes;
    }

    @Override
    public ArrayList<Movimentacao> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Movimentacao consultarId(int id) {
        Movimentacao m = new Movimentacao();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM movimentacao "
                    + "WHERE id=" + id + ";";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                m = new Movimentacao(retorno);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de movimentacao/Fornecedor " + e);
        }

        return m;
    }

    @Override
    public ArrayList<Movimentacao> consultarTodos() {
        return this.consultarTodos("");
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Movimentacao> movimentacoes = consultarTodos(this.tipo);

        ArrayList<String[]> tableData = new ArrayList();
        for (Movimentacao movimentacao : movimentacoes) {
            String[] data = {
                Integer.toString(movimentacao.getId()),
                movimentacao.getTipo(),
                this.formater.format(movimentacao.getItem_id()),
                this.formater.format(movimentacao.getQtde()),
                "R$ " + this.formater.format(movimentacao.getValor()),
                movimentacao.getObservacao()
            };

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[1].contains(filtro.toUpperCase())
                    || data[2].contains(filtro.toUpperCase())) {
                tableData.add(data);
            }
        }

        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        return new String[]{"Id", "Tipo", "Item", "Qtde", "Valor", "Observação"};
    }

    public void popularTabela(JTable tabela, int id, String criterio) {
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "ID";
        cabecalho[1] = "Data";
        cabecalho[2] = "Tipo";
        cabecalho[3] = "Quantidade";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM movimentacao "
                    + "WHERE item_id=" + id + " "
                    + "AND tipo ILIKE '%" + criterio + "%' "
                    + "ORDER BY data");

            while (resultadoQ.next()) {
                Object[] linha = new Object[4];
                linha[0] = resultadoQ.getInt("id");
                linha[1] = Formatacao.ajustaDataDMA(resultadoQ.getDate("data").toString());
                linha[2] = resultadoQ.getString("tipo").toUpperCase();
                linha[3] = Formatacao.formatarDecimal4casas(resultadoQ.getDouble("qtde"));

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

        // Personalização das cores das linhas da tabela
        TableColumn tipoColumn = tabela.getColumnModel().getColumn(2);
        tipoColumn.setCellRenderer(new CustomTableCellRenderer());

        // Redimensiona as colunas de uma tabela
        TableColumn column = null;
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        int[] columnWidths = {20, 200, 200, 50};
        for (int i = 0; i < tabela.getColumnModel().getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Alinhar dados da coluna 1 no centro da celula da tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumn column0 = tabela.getColumnModel().getColumn(0);
        TableColumn column1 = tabela.getColumnModel().getColumn(1);
        TableColumn column3 = tabela.getColumnModel().getColumn(3);

        column0.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);
        column3.setCellRenderer(centerRenderer);
    }

    static class CustomTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String tipo = ((String) value).toUpperCase(); // Converter para letras maiúsculas

            if (column == 2) { // Verificar a coluna 2 (índice 2)
                setHorizontalAlignment(SwingConstants.CENTER); // Alinhamento centralizado
            } else {
                setHorizontalAlignment(SwingConstants.LEFT); // Alinhamento padrão à esquerda
            }

            if (tipo.equalsIgnoreCase("VENDA")) {
                component.setBackground(Color.decode("#99FF99"));
                component.setForeground(Color.BLACK);
            } else if (tipo.equalsIgnoreCase("COMPRA")) {
                component.setBackground(Color.decode("#FFFF99"));
                component.setForeground(Color.BLACK);
            } else if (tipo.equalsIgnoreCase("PRODUCAO")) {
                component.setBackground(Color.decode("#99CCFF"));
                component.setForeground(Color.BLACK);
            } else {
                component.setBackground(table.getBackground());
            }

            return component;
        }
    }
}
