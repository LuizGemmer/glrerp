package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Cliente;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ruang
 */
public class ClienteDAO implements IDAOT<Cliente> {

    private String tipo;

    public ClienteDAO(String tipo) {
        this.tipo = "TIPO LIKE '" + tipo + "' AND ";
    }

    public ClienteDAO() {
        this.tipo = "";
    }

    @Override
    public String salvar(Cliente o) {

        //Salvar cliente no banco de dados
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO cliente VALUES "
                    + "(default, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getCpf() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getTelefone() + "', "
                    + "'" + o.getEndereco() + "', "
                    + "'" + o.getTipo() + "', "
                    + "'true')";

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Cliente/Fornecedor " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) {

        //Atualizar um cliente/Fornecedor
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cliente SET "
                    + "nome='" + o.getNome() + "', "
                    + "cpf='" + o.getCpf() + "', "
                    + "email='" + o.getEmail() + "', "
                    + "telefone='" + o.getTelefone() + "', "
                    + "endereco='" + o.getEndereco() + "' "
                    + "WHERE id='" + o.getId() + "'";

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Cliente/Fornecedor " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cliente SET "
                    + "ativo=false "
                    + "WHERE id=" + id;

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Cliente/Fornecedor " + e);
            return e.toString();
        }
    }

    public ArrayList<Cliente> consultarTodos(String tipo) {

        //Consultar todos os clientes/Fornecedores
        ArrayList<Cliente> clientes = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM cliente "
                    + "WHERE " + this.tipo + "ativo=true "
                    + "ORDER BY nome";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(retorno.getInt("id"));
                cliente.setNome(retorno.getString("nome"));
                cliente.setCpf(retorno.getString("cpf"));
                cliente.setEmail(retorno.getString("email"));
                cliente.setTelefone(retorno.getString("telefone"));
                cliente.setEndereco(retorno.getString("endereco"));
                cliente.setTipo(retorno.getString("tipo"));

                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Cliente/Fornecedor " + e);
        }

        return clientes;
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente cliente = new Cliente();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM cliente "
                    + "WHERE id=" + id + " AND ativo=true";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {

                cliente.setId(retorno.getInt("id"));
                cliente.setNome(retorno.getString("nome"));
                cliente.setCpf(retorno.getString("cpf"));
                cliente.setEmail(retorno.getString("email"));
                cliente.setTelefone(retorno.getString("telefone"));
                cliente.setEndereco(retorno.getString("endereco"));
                cliente.setTipo(retorno.getString("tipo"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Cliente/Fornecedor " + e);
        }

        return cliente;
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        return this.consultarTodos("");
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Cliente> clientes = consultarTodos(this.tipo);

        ArrayList<String[]> tableData = new ArrayList();
        for (Cliente cliente : clientes) {
            String[] data = {
                Integer.toString(cliente.getId()),
                cliente.getNome(),
                cliente.getCpf()
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
        return new String[]{"Id", "Nome", "CPF/CNPJ"};
    }

    public void popularTabela(JTable tabela, String clienteOuFornecedor, String criterio) {
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "ID";
        cabecalho[1] = "Nome";
        cabecalho[2] = "CPF/CNPJ";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM cliente "
                    + "WHERE tipo='" + clienteOuFornecedor + "' "
                    + "AND ativo=true "
                    + "AND (nome ILIKE '%" + criterio + "%' "
                    + "OR cpf ILIKE '%" + criterio + "%') "
                    + "ORDER BY nome");

            while (resultadoQ.next()) {
                Object[] linha = new Object[3];
                linha[0] = resultadoQ.getInt("id");
                linha[1] = resultadoQ.getString("nome");
                linha[2] = resultadoQ.getString("cpf");

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
        TableColumn column2 = tabela.getColumnModel().getColumn(2);

        column1.setCellRenderer(centerRenderer);
        column2.setCellRenderer(centerRenderer);
    }

}
