package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Movimentacao_User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author ruang
 */
public class Movimentacao_UserDAO implements IDAOT<Movimentacao_User> {


    @Override
    public String salvar(Movimentacao_User o) {
        //Salvar no banco de dados
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();

            String sql = "INSERT "
                    + "INTO movimentacao_usuario (movimentacao_id, usuario_id) "
                    + "VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, o.getMovimentacao_id());
            statement.setInt(2, o.getUsuario_id());
            
            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir movimentação_usuario " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Movimentacao_User o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
         try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "DELETE FROM movimentacao_usuario "
                    + "WHERE movimentacao_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Movimentacao " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Movimentacao_User> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Movimentacao_User> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Movimentacao_User consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getTableColumns() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
