/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidade.Item;
import apoio.ConexaoBD;
import apoio.IDAOT;
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
                    + "'" + o.getDescricao().toUpperCase() + "', "
                    + "'" + o.getId_grupo() + "', "
                    + "'" + o.getQtde_estoque() + "', "
                    + "'true')";

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cadastro de Item " + e);
            return e.toString();
        }

    }

    @Override
    public String atualizar(Item o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

                itens.add(item);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Cliente/Fornecedor " + e);
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
                item.setDescricao(retorno.getString("descricao").toUpperCase());
                item.setId_grupo(retorno.getInt("id_grupo"));
                item.setQtde_estoque(retorno.getDouble("qtde_estoque"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Cliente/Fornecedor " + e);
        }

        return item;
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Item> items = consultarTodos();

        ArrayList<String[]> tableData = new ArrayList();
        for (Item item : items) {
            String[] data = {
                Integer.toString(item.getId()),
                item.getDescricao(),
                new DecimalFormat("#.####").format(item.getQtde_estoque()),
                new GrupoDAO().consultarId(item.getId_grupo()).toString(),
            };

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[1].toUpperCase().contains(filtro.toUpperCase())
                    || data[4].toUpperCase().contains(filtro.toUpperCase())) {
                tableData.add(data);
            }
        }

        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        return new String[]{"Id", "Descriçao", "Qtde", "Grupo"};
    }

}
