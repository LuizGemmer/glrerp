/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String atualizar(Grupo o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Grupo> consultarTodos() {
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
                grupo.setTipo(retorno.getString("tipo"));

                grupos.add(grupo);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Cliente/Fornecedor " + e);
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
                    + "WHERE id=" + id + " AND ativo=true";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {

                grupo.setId(retorno.getInt("id"));
                grupo.setDescricao(retorno.getString("descricao").toUpperCase());
                grupo.setTipo(retorno.getString("tipo"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Cliente/Fornecedor " + e);
        }

        return grupo;
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getTableColumns() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Grupo[] consultarComboBox(){
        ArrayList<Grupo> grupos = this.consultarTodos();
        Grupo[] gruposArr = new Grupo[grupos.size()];
        for (int i = 0; i < gruposArr.length; i++) {
            gruposArr[i] = grupos.get(i);
        }
        return gruposArr;
    }
}
