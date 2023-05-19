package dao;

import apoio.IDAOT;
import entidade.Grupo;
import java.util.ArrayList;
import apoio.ConexaoBD;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author rg
 */
public class GrupoDAO implements IDAOT<Grupo> {

    @Override
    public String salvar(Grupo o) {

        //Salvar no banco de dados
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO grupo VALUES "
                    + "(default, "
                    + "'" + o.getDescricao().toUpperCase() + "', "
                    + "'" + o.getTipo().toUpperCase() + "', "
                    + "'true')";

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Grupo " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Grupo o) {
        //Atualizar um Grupo
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE grupo SET "
                    + "descricao='" + o.getDescricao().toUpperCase() + "', "
                    + "tipo='" + o.getTipo().toUpperCase() + "' "
                    + "WHERE id=" + o.getId();

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Grupo " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE grupo SET "
                    + "ativo=false "
                    + "WHERE id=" + id;

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Grupo " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Grupo> consultarTodos() {

        //Consultar todos os Grupos
        ArrayList<Grupo> grupos = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM grupo "
                    + "WHERE ativo=true "
                    + "ORDER BY descricao";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                Grupo grupo = new Grupo();

                grupo.setId(retorno.getInt("id"));
                grupo.setDescricao(retorno.getString("descricao").toUpperCase());
                grupo.setTipo(retorno.getString("tipo").toUpperCase());

                grupos.add(grupo);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Grupo " + e);
        }

        return grupos;
    }

    @Override
    public ArrayList<Grupo> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Grupo consultarId(int id) {
        Grupo grupo = new Grupo();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM grupo "
                    + "WHERE id=" + id;

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {

                grupo.setId(retorno.getInt("id"));
                grupo.setDescricao(retorno.getString("descricao").toUpperCase());
                grupo.setTipo(retorno.getString("tipo").toUpperCase());

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Grupo " + e);
        }

        return grupo;
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Grupo> grupos = consultarTodos();

        ArrayList<String[]> tableData = new ArrayList();
        for (Grupo grupo : grupos) {
            String[] data = {
                Integer.toString(grupo.getId()),
                grupo.getDescricao(),
                grupo.getTipo()
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
        return new String[]{"Id", "Descricao", "Tipo"};
    }

    public Grupo[] consultarComboBox() {
        ArrayList<Grupo> grupos = this.consultarTodos();
        Grupo[] gruposArr = new Grupo[grupos.size()];
        for (int i = 0; i < gruposArr.length; i++) {
            gruposArr[i] = grupos.get(i);
        }
        return gruposArr;
    }

    public int indexCBUnidadeMedida(String stringUnd) {

        //metodo para retornar o valor do tipo de grupo atual nos combobox de detalhar e alterar grupo
        int indexCBUM = 0;

        System.out.println("String = " + stringUnd);
        if (stringUnd.equals("MATERIA-PRIMA")) {
            indexCBUM = 0;
        } else if (stringUnd.equals("PRODUTO ACABADO")) {
            indexCBUM = 1;
        } else if (stringUnd.equals("FERRAMENTA")) {
            indexCBUM = 2;
        } else {
            indexCBUM = 3;
        }

        System.out.println("index= " + indexCBUM);
        return indexCBUM;
    }
}
