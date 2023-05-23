package dao;

import entidade.Item;
import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Grupo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
 *
 * @author rg
 */
public class ItemDAO implements IDAOT<Item> {

    @Override
    public String salvar(Item o) {

        //Salvar item no banco de dados
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO item VALUES "
                    + "(default, "
                    + o.getId_grupo() + ", "
                    + "'" + o.getDescricao() + "', "
                    + o.getQtde_estoque() + ", "
                    + "'true', "
                    + "'" + o.getUnidade_medida() + "', "
                    + "'" + o.getObservacao() + "', "
                    + o.getConv1() + ", "
                    + "'" + o.getUnd_conv1()+ "', "
                    + o.getConv2() + ", "
                    + "'" + o.getUnd_conv2()+ "')";

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Item " + e);
            return e.toString();
        }

    }

    @Override
    public String atualizar(Item o) {

        //Atualizar um Item
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE item SET "
                    + "id_grupo=" + o.getId_grupo() + ", "
                    + "descricao='" + o.getDescricao() + "', "
                    + "qtde_estoque=" + o.getQtde_estoque() + ", "
                    + "ativo='true', "
                    + "unidade_medida='" + o.getUnidade_medida() + "', "
                    + "observacao='" + o.getObservacao() + "', "
                    + "conv1=" + o.getConv1() + "', "
                    + "und_conv1='" + o.getUnd_conv1() + "', "
                    + "conv2=" + o.getConv2() + "', "
                    + "und_conv2='" + o.getUnd_conv2() + "' "
                    + " WHERE id=" + o.getId();

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Item " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE item SET "
                    + "ativo=false "
                    + "WHERE id=" + id;

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Item " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Item> consultarTodos() {
        ArrayList<Item> itens = new ArrayList();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM item "
                    + "WHERE ativo=true "
                    + "ORDER BY descricao";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                Item item = new Item();

                item.setId(retorno.getInt("id"));
                item.setId_grupo(retorno.getInt("id_grupo"));
                item.setDescricao(retorno.getString("descricao"));
                item.setQtde_estoque(retorno.getDouble("qtde_estoque"));
                item.setAtivo(retorno.getBoolean("ativo"));
                item.setUnidade_medida(retorno.getString("unidade_medida"));
                item.setObservacao(retorno.getString("observacao"));
                item.setConv1(retorno.getDouble("conv1"));
                item.setUnd_conv1(retorno.getString("und_conv1"));
                item.setConv2(retorno.getDouble("conv2"));
                item.setUnd_conv2(retorno.getString("und_conv2"));

                itens.add(item);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Item " + e);
        }

        return itens;
    }

    @Override
    public ArrayList<Item> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Item consultarId(int id) {
        Item item = new Item();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM item "
                    + "WHERE id=" + id + " AND ativo=true";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                item.setId(retorno.getInt("id"));
                item.setDescricao(retorno.getString("descricao"));
                item.setId_grupo(retorno.getInt("id_grupo"));
                item.setQtde_estoque(retorno.getDouble("qtde_estoque"));
                item.setUnidade_medida(retorno.getString("unidade_medida"));
                item.setObservacao(retorno.getString("observacao"));
                item.setConv1(retorno.getDouble("conv1"));
                item.setUnd_conv1(retorno.getString("und_conv1"));
                item.setConv2(retorno.getDouble("conv2"));
                item.setUnd_conv2(retorno.getString("und_conv2"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Item " + e);
        }

        return item;
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Item> items = consultarTodos();

        ArrayList<String[]> tableData = new ArrayList();
        for (Item item : items) {
            Grupo abc = new GrupoDAO().consultarId(item.getId_grupo());
            String[] data = {
                Integer.toString(item.getId()),
                item.getDescricao(),
                new DecimalFormat("#.####").format(item.getQtde_estoque()),
                item.getUnidade_medida(),
                abc.toString()
            };

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[1].contains(filtro.toUpperCase())
                    || data[2].contains(filtro.toUpperCase())
                    || data[3].contains(filtro.toUpperCase())
                    || data[4].contains(filtro.toUpperCase())) {
                tableData.add(data);
            }
        }

        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        return new String[]{"Id", "Descriçao", "Qtde", "Unidade Medida", "Grupo"};
    }

    public int indexCBUnidadeMedida(String stringUnd) {

        //metodo para retornar o valor da unidade de medida atual nos combobox de detalhar e alterar item
        int indexCBUM = 0;
        if (stringUnd.equals("und")) {
            indexCBUM = 1;
        } else if (stringUnd.equals("caixa")) {
            indexCBUM = 2;
        } else if (stringUnd.equals("pacote")) {
            indexCBUM = 3;
        } else if (stringUnd.equals("fração")) {
            indexCBUM = 4;
        } else if (stringUnd.equals("m")) {
            indexCBUM = 5;
        } else if (stringUnd.equals("m²")) {
            indexCBUM = 6;
        } else if (stringUnd.equals("m linear")) {
            indexCBUM = 7;
        } else if (stringUnd.equals("cm")) {
            indexCBUM = 8;
        } else if (stringUnd.equals("mm")) {
            indexCBUM = 9;
        } else if (stringUnd.equals("L")) {
            indexCBUM = 10;
        } else if (stringUnd.equals("mL")) {
            indexCBUM = 11;
        } else if (stringUnd.equals("m³")) {
            indexCBUM = 12;
        } else if (stringUnd.equals("cm³")) {
            indexCBUM = 13;
        } else if (stringUnd.equals("dm³")) {
            indexCBUM = 14;
        } else if (stringUnd.equals("ton")) {
            indexCBUM = 15;
        } else if (stringUnd.equals("kg")) {
            indexCBUM = 16;
        } else if (stringUnd.equals("g³")) {
            indexCBUM = 17;
        } else {
            indexCBUM = 18;
        }
   
        return indexCBUM;
    }

}
