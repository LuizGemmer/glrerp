package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Estrutura;
import entidade.Item;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

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
                    + "( "
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
                    + "qtde_insumo=" + o.getQtde_insumo();

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
                    + "WHERE ativo=true";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
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
            Estrutura est = new EstruturaDAO().consultarId((estrutura.getItem_id()));
            String[] data = {
                Integer.toString(estrutura.getItem_id()),
                item.getDescricao(),
                mp.getDescricao(),
                Double.toString(est.getQtde_insumo()),
                new DecimalFormat("#.####").format(estrutura.getQtde_insumo()),};

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
        return new String[]{"ID Produto", "Produto", "Insumo", "Qtde Insumo"};
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        ResultSet resultadoQ;

        //Dados da Tabela
        Object[][] dadosTabela = null;

        //Cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "ID Produto";
        cabecalho[1] = "Produto";
        cabecalho[2] = "ID Insumo";
        cabecalho[3] = "Insumo";
        cabecalho[4] = "Qtde Insumo";
        cabecalho[5] = "Unidade";

        //Cria a matriz com número de registros na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT "
                    + "estrutura.item_id AS item_id, "
                    + "item.descricao, "
                    + "estrutura.insumo_id, "
                    + "item.descricao AS insumo_descricrao, "
                    + "estrutura.qtde_insumo, "
                    + "item.unidade_medida "
                    + "FROM item, estrutura "
                    + "WHERE estrutura.item_id = item.id "
                    + "AND item.ativo=true "
                    + "AND estrutura.insumo_id = item.id"
                    + "AND estrutura.ativo=true "
                    + "ORDER BY item.descricao");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];
        } catch (Exception e) {
            System.out.println("Erro ao consultar tabela: " + e);
        }
        int lin = 0;

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT "
                    + "estrutura.item_id AS item_id, "
                    + "item.descricao, "
                    + "estrutura.insumo_id, "
                    + "item.descricao AS insumo_descricrao, "
                    + "estrutura.qtde_insumo, "
                    + "item.unidade_medida "
                    + "FROM item, estrutura "
                    + "WHERE estrutura.item_id = item.id "
                    + "AND item.ativo=true "
                    + "AND estrutura.insumo_id = item.id"
                    + "AND estrutura.ativo=true "
                    + "ORDER BY item.descricao");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("item_id");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = resultadoQ.getInt("insumo_id");
                dadosTabela[lin][3] = resultadoQ.getString("insumo_descricao");
                dadosTabela[lin][4] = resultadoQ.getDouble("qtde_insumo");
                dadosTabela[lin][5] = resultadoQ.getString("unidade_medida");
                
                lin++;
            }

        } catch (Exception e) {
            System.out.println("Erro ao popular tabela: " + e);
        }

        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            //Quando retorno for FALSE, a tabela não é editável
            public boolean isCellEditable(int row, int column) {
                return false;
                //if (column == 3){return true} else {return false}
            }

            //Alteração do metodo que determina a coluna em que o objeto ImageIcon Devera aparecer
            @Override
            public Class getColumnClass(int column) {
                if (column == 2) {
                    //retunr ImageIcon.class
                }
                return Object.class;
            }
        });

        //Altera o número de selecao de linhas da tabela
        tabela.setSelectionMode(0);

        //Redimensiona as colunas de uma tabela
        TableColumn column = null;
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        for (int i = 0; i < tabela.getColumnModel().getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(5);
                    break;
                case 1:
                    column.setPreferredWidth(200);
                    break;
                case 2:
                    column.setPreferredWidth(20);
                    break;
            }
        }

        //Alinhar dados da coluna 1 no centro da celula da tabela
        class AlinharCentro extends DefaultTableCellRenderer {

            public AlinharCentro() {
                setHorizontalAlignment(CENTER); // ou LEFT, RIGHT, etc
            }
        }

        TableCellRenderer tcr = new AlinharCentro();
        column = tabela.getColumnModel().getColumn(0);
        column.setCellRenderer(tcr);

    }

}
