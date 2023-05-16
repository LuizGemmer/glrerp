
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author ruang
 */
public class ClienteDAO implements IDAOT<Cliente> {

    @Override
    public String salvar(Cliente o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into cliente values "
                    + "(default, 'cliente', "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getCpf() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getTelefone() + "', "
                    + "'" + o.getEndereco() + "')";

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Cliente " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
