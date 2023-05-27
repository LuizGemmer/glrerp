package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Movimentacao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

/**
 *
 * @author ruang
 */
public class movimentacaoDAO implements IDAOT<Movimentacao> {

    private String tipo;
    private DecimalFormat formater = new DecimalFormat("#.####");

    public movimentacaoDAO(String tipo) {
        this.tipo = " where tipo='" + tipo + "'";
    }

    public movimentacaoDAO() {
        this.tipo = "";
    }

    @Override
    public String salvar(Movimentacao o) {
        String cliente_id = "NULL";
        if (o.getCliente_id() != 0) cliente_id = "" + o.getCliente_id();
            
        String sql = "INSERT INTO movimentacao VALUES "
            + "(default, "
            + "'" + o.getTipo()+ "', "
            + "'" + o.getData() + "', "
            + "'" + o.getItem_id()+ "', "
            + "" + cliente_id + ", "
            + "'" + o.getValor()+ "', "
            + "'" + o.getQtde()+ "', "
            + "'" + o.getPerdas() + "', "
            + "'" + o.getObservacao()+ "', "
            + "'" + o.getId_pedido()+ "');";

        //Salvar movimentacao no banco de dados
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
           
            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);

            return null;
            
        } catch (Exception e) {
            System.out.println(sql);
            System.out.println("Erro ao inserir cadastro de movimentacao/Fornecedor " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Movimentacao o) {

        //Atualizar um movimentacao/Fornecedor
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE movimentacao SET "
                    + "tipo='" + o.getTipo()+ "', "
                    + "data='" + o.getData() + "', "
                    + "item_id='" + o.getItem_id() + "', "
                    + "cliente_id='" + o.getCliente_id() + "', "
                    + "valor='" + o.getValor()+ "' "
                    + "qtde='" + o.getQtde()+ "' "
                    + "perda='" + o.getPerdas()+ "' "
                    + "observacao='" + o.getObservacao() + "' "
                    + "id_pedido='" + o.getId_pedido()+ "' "
                    + "WHERE id='" + o.getId() + "'";

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar movimentacao/Fornecedor " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        // Adiciona uma nova movimentação, mas com os valores invertidos
        Movimentacao m = this.consultarId(id);
        m.setData(LocalDateTime.now());
        m.setQtde(-m.getQtde());
        m.setPerdas(-m.getPerdas());
        m.setTipo("estorno " + m.getTipo());
        
        this.salvar(m);
        return "";
    }

    public ArrayList<Movimentacao> consultarTodos(String tipo) {
        //Consultar todos os movimentacoes/Fornecedores
        ArrayList<Movimentacao> movimentacoes = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM movimentacao "
                    + this.tipo;

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                Movimentacao m = new Movimentacao(retorno);
                movimentacoes.add(m);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de movimentacao/Fornecedor " + e);
        }

        return movimentacoes;
    }

    @Override
    public ArrayList<Movimentacao> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Movimentacao consultarId(int id) {
        Movimentacao m = new Movimentacao();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM movimentacao "
                    + "WHERE id=" + id + ";";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                m = new Movimentacao(retorno);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de movimentacao/Fornecedor " + e);
        }

        return m;
    }

    @Override
    public ArrayList<Movimentacao> consultarTodos() {
        return this.consultarTodos("");
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Movimentacao> movimentacoes = consultarTodos(this.tipo);

        ArrayList<String[]> tableData = new ArrayList();
        for (Movimentacao movimentacao : movimentacoes) {
            String[] data = {
                Integer.toString(movimentacao.getId()),
                movimentacao.getTipo(),
                this.formater.format(movimentacao.getItem_id()),
                this.formater.format(movimentacao.getQtde()),
                "R$ " + this.formater.format(movimentacao.getValor()),
                movimentacao.getObservacao()
            };

            if (filtro.equals("")) {
                tableData.add(data);
            } else if (data[1].contains(filtro.toUpperCase())
                    || data[2].contains(filtro.toUpperCase())) {
                tableData.add(data);
            }
        }

        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        return new String[]{"Id", "Tipo", "Item", "Qtde", "Valor", "Observação"};
    }

}
