package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ruang
 */
public class userDAO implements IDAOT<User> {

    @Override
    public String salvar(User o) {
        //Salvar Usuário no banco de dados
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();

            String sql = "INSERT "
                    + "INTO usuario (nome, senha, hierarquia, ativo, email) "
                    + "VALUES (?, ?, ?, true, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, o.getNome());
            statement.setString(2, o.getSenha());
            statement.setString(3, o.getHierarquia());
            statement.setString(4, o.getEmail());

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Usuário " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(User o) {
        //Atualizar um Usuário
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "UPDATE usuario "
                    + "SET nome = ?, hierarquia = ? "
                    + "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, o.getNome());
            statement.setString(2, o.getHierarquia());
            statement.setInt(3, o.getId());

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Usuário " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "UPDATE usuario "
                    + "SET ativo = false "
                    + "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Usuário " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<User> consultarTodos() {
        ArrayList<User> users = new ArrayList();

        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "SELECT * "
                    + "FROM usuario "
                    + "WHERE ativo = true "
                    + "ORDER BY nome";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet retorno = statement.executeQuery();
            System.out.println("SQL: " + statement.toString());
            while (retorno.next()) {
                User user = new User();

                user.setId(retorno.getInt("id"));
                user.setNome(retorno.getString("nome"));
                user.setSenha(retorno.getString("senha"));
                user.setHierarquia(retorno.getString("hierarquia"));
                user.setEmail(retorno.getString("email"));

                users.add(user);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Usuários " + e);
        }
        return users;
    }

    @Override
    public ArrayList<User> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User consultarId(int id) {
        User user = new User();

        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "SELECT * "
                    + "FROM usuario "
                    + "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet retorno = statement.executeQuery();
            System.out.println("SQL: " + statement.toString());
            while (retorno.next()) {

                user.setId(retorno.getInt("id"));
                user.setNome(retorno.getString("nome"));
                user.setHierarquia(retorno.getString("hierarquia"));
                user.setEmail(retorno.getString("email"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Usuário " + e);
        }
        return user;
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<User> users = consultarTodos();

        ArrayList<String[]> tableData = new ArrayList();
        for (User user : users) {
            String[] data = {
                Integer.toString(user.getId()),
                user.getNome(),
                user.getEmail(),
                user.getHierarquia()
            };

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[1].contains(filtro.toUpperCase())
                    || data[2].contains(filtro.toUpperCase())
                    || data[3].contains(filtro.toUpperCase())) {
                tableData.add(data);
            }
        }
        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        return new String[]{"Id", "Nome", "Email", "Hierarquia"};
    }

    public int indexCBUnidadeMedida(String stringUnd) {

        //metodo para retornar o valor da hierarquia atual nos combobox de detalhar e alterar usuario
        int indexCBUM = 0;
        if (stringUnd.equals("USUARIO")) {
            indexCBUM = 1;
        } else if (stringUnd.equals("SUPERVISOR")) {
            indexCBUM = 2;
        } else {
            indexCBUM = 3;
        }

        return indexCBUM;
    }

}
