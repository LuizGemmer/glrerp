package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruang
 */
public class ClienteDAO implements IDAOT<Cliente> {

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
                    + "situacao=false "
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
                    + "WHERE TIPO LIKE '" + tipo + "' AND ativo=true "
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
        ArrayList<Cliente> clientes = consultarTodos("cliente");

        ArrayList<String[]> tableData = new ArrayList();
        for (Cliente cliente : clientes) {
            String[] data = {
                Integer.toString(cliente.getId()),
                cliente.getNome(),
                cliente.getCpf()
            };

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[1].toLowerCase().contains(filtro.toLowerCase())
                    || data[2].toLowerCase().contains(filtro.toLowerCase())) {
                tableData.add(data);
            }
        }

        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        return new String[]{"Id", "Nome", "CPF/CNPJ"};
    }

}
