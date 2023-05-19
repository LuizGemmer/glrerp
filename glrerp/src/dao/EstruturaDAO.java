package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Estrutura;
import entidade.Grupo;
import entidade.Item;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
 *
 * @author rg
 */
public class EstruturaDAO implements IDAOT<Estrutura> {

    @Override
    public String salvar(Estrutura o) {
        //Salvar estrutura no banco de dados
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO estrutura VALUES "
                    + "(default, "
                    + o.getItem_id() + ", "
                    + o.getInsumo_id() + ", "
                    + o.getQtde_insumo() + ", "
                    + "'true')";

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Estrutura " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Estrutura o) {
        //Atualizar um Estrutura
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE estrutura SET "
                    + "item_id=" + o.getItem_id() + ", "
                    + "insumo_id=" + o.getInsumo_id() + ", "
                    + "qtde_insumo=" + o.getQtde_insumo()
                    + " WHERE id=" + o.getId();

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Estrutura " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE estrutura SET "
                    + "ativo=false "
                    + "WHERE id=" + id;

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Estrutura " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Estrutura> consultarTodos() {
        ArrayList<Estrutura> estrut = new ArrayList();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM estrutura "
                    + "WHERE ativo=true ";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                Estrutura estrutura = new Estrutura();

                estrutura.setId(retorno.getInt("id"));
                estrutura.setItem_id(retorno.getInt("item_id"));
                estrutura.setInsumo_id(retorno.getInt("insumo_id"));
                estrutura.setQtde_insumo(retorno.getDouble("qtde_insumo"));
                estrutura.setAtivo(retorno.getBoolean("ativo"));

                estrut.add(estrutura);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Estrutura " + e);
        }

        return estrut;
    }

    @Override
    public ArrayList<Estrutura> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Estrutura consultarId(int id) {
        Estrutura estrutura = new Estrutura();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM estrutura "
                    + "WHERE id=" + id + " AND ativo=true";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                estrutura.setId(retorno.getInt("id"));
                estrutura.setItem_id(retorno.getInt("item_id"));
                estrutura.setInsumo_id(retorno.getInt("insumo_id"));
                estrutura.setQtde_insumo(retorno.getDouble("qtde_insumo"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Estrutura " + e);
        }

        return estrutura;
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Estrutura> estrut = consultarTodos();

        ArrayList<String[]> tableData = new ArrayList();
        for (Estrutura estrutura : estrut) {

            Item item = new ItemDAO().consultarId(estrutura.getItem_id());
            Item mp = new ItemDAO().consultarId(estrutura.getInsumo_id());
            String[] data = {
                Integer.toString(estrutura.getId()),
                item.getDescricao(),
                mp.getDescricao(),
                new DecimalFormat("#.####").format(estrutura.getQtde_insumo()),};

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[1].toUpperCase().contains(filtro.toUpperCase())
                    || data[2].toUpperCase().contains(filtro.toUpperCase())
                    || data[3].toUpperCase().contains(filtro.toUpperCase())) {
                tableData.add(data);
            }
        }

        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        return new String[]{"Id", "Produto", "Insumo", "Qtde Insumo"};
    }

}
