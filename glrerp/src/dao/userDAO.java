package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.User;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ruang
 */
public class userDAO implements IDAOT<User> {

    @Override
    public String salvar(User o) {
                //Salvar Usuário no banco de dados
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO usuario VALUES "
                    + "(default, "
                    + "'" + o.getNome().toUpperCase() + "', "
                    + "'" + o.getSenha() + "', "
                    + "'" + o.getHierarquia() + "', "
                    + "'true')";

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
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
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario SET "
                    + "nome='" + o.getNome().toUpperCase() + "', "
                    + "hierarquia='" + o.getHierarquia() + "' " 
                    + "WHERE id=" + o.getId();

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Usuário " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario SET "
                    + "ativo=false "
                    + "WHERE id=" + id;

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Usuário " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<User> consultarTodos() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        ArrayList<User> users = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from usuario "
                    + "WHERE ativo = true "
                    + "order by nome";

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                User user = new User();

                user.setId(retorno.getInt("id"));
                user.setNome(retorno.getString("nome"));
                user.setSenha(retorno.getString("senha"));
                user.setHierarquia(retorno.getString("hierarquia"));

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
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM usuario "
                    + "WHERE id=" + id + " AND ativo=true";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {

                user.setId(retorno.getInt("id"));
                user.setNome(retorno.getString("nome").toUpperCase());
                user.setHierarquia(retorno.getString("hierarquia"));

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
                user.getHierarquia()
            };

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[1].toUpperCase().contains(filtro.toUpperCase())
                    || data[2].toUpperCase().contains(filtro.toUpperCase())) {
                tableData.add(data);
            }
        }

        return tableData;
    }

    @Override
    public String[] getTableColumns() {
         return new String[]{"Id", "Nome", "Hierarquia"};
    }

}
