package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Movimentacao_Adicionais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author ruang
 */
public class Movimentacao_AdicionaisDAO implements IDAOT<Movimentacao_Adicionais> {

    @Override
    public String salvar(Movimentacao_Adicionais o) {
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();

            String sql = "INSERT "
                    + "INTO movimentacao_adicionais (movimentacao_id, adicionais_id, qtde, valor, observacao) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, o.getMovimentacao_id());
            statement.setInt(2, o.getAdicionais_id());
            statement.setDouble(3, o.getQtde());
            statement.setDouble(4, o.getValor());
            statement.setString(5, o.getObservacao());

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Movimentacao_Adicional " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Movimentacao_Adicionais o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Movimentacao_Adicionais> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Movimentacao_Adicionais> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Movimentacao_Adicionais consultarId(int id) {
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

    public ArrayList<Movimentacao_Adicionais> consultarTodosIdMovimentacao(int id) {
        ArrayList<Movimentacao_Adicionais> mov_adiciconais = new ArrayList<>();

        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "SELECT * "
                    + "FROM movimentacao_adicionais "
                    + "WHERE movimentacao_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet retorno = statement.executeQuery();
            System.out.println("SQL: " + statement.toString());
            while (retorno.next()) {
                Movimentacao_Adicionais mov_adic = new Movimentacao_Adicionais();
                mov_adic.setMovimentacao_id(retorno.getInt("movimentacao_id"));
                mov_adic.setAdicionais_id(retorno.getInt("adicionais_id"));
                mov_adic.setQtde(retorno.getDouble("qtde"));
                mov_adic.setValor(retorno.getDouble("valor"));
                mov_adic.setObservacao(retorno.getString("observacao"));

                mov_adiciconais.add(mov_adic);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Movimentacao de Adicionais " + e);
        }
        return mov_adiciconais;
    }

}
