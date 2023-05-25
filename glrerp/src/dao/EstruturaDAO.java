package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Estrutura;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
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

    public String inativar(int item_id, int insumo_id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE estrutura SET "
                    + "ativo=false "
                    + "WHERE item_id=" + item_id + " "
                    + "AND insumo_id=" + insumo_id;

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Estrutura " + e);
            return e.toString();
        }
    }

    public String excluir(int item_id, int insumo_id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM estrutura "
                    + "WHERE ativo=true "
                    + "AND item_id=" + item_id + " "
                    + "AND insumo_id=" + insumo_id;

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

    public ArrayList<Estrutura> consultar(int item_id, int insumo_id) {
        ArrayList<Estrutura> estruturas = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM estrutura "
                    + "WHERE ativo=true "
                    + "AND item_id=" + item_id + " "
                    + "AND insumo_id=" + insumo_id;

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);

            while (retorno.next()) {
                Estrutura estrutura = new Estrutura();

                estrutura.setItem_id(retorno.getInt("item_id"));
                estrutura.setInsumo_id(retorno.getInt("insumo_id"));
                estrutura.setQtde_insumo(retorno.getDouble("qtde_insumo"));
                estrutura.setAtivo(retorno.getBoolean("ativo"));

                estruturas.add(estrutura);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro " + e);
        }

        return estruturas;
    }

    public Estrutura consultarId(int item_id, int insumo_id) {
        Estrutura estrutura = new Estrutura();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM estrutura "
                    + "WHERE ativo=true "
                    + "AND item_id=" + item_id + " "
                    + "AND insumo_id=" + insumo_id;

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                estrutura.setItem_id(retorno.getInt("item_id"));
                estrutura.setInsumo_id(retorno.getInt("insumo_id"));
                estrutura.setQtde_insumo(retorno.getDouble("qtde_insumo"));
                estrutura.setAtivo(retorno.getBoolean("ativo"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Estrutura " + e);
        }

        return estrutura;
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
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "ID Insumo";
        cabecalho[1] = "Insumo";
        cabecalho[2] = "Qtde Insumo";
        cabecalho[3] = "Unidade";

        //Cria a matriz com número de registros na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT "
                    + "estrutura.insumo_id, "
                    + "item.descricao, "
                    + "estrutura.qtde_insumo, "
                    + "item.unidade_medida "
                    + "FROM item, estrutura "
                    + "WHERE estrutura.insumo_id = item.id "
                    + "AND item.ativo=true "
                    + "AND estrutura.ativo=true "
                    + "AND estrutura.item_id=" + criterio + " "
                    + "ORDER BY item.descricao");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][4];
        } catch (Exception e) {
            System.out.println("Erro ao consultar tabela: " + e);
        }
        int lin = 0;

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT "
                    + "estrutura.insumo_id, "
                    + "item.descricao, "
                    + "estrutura.qtde_insumo, "
                    + "item.unidade_medida "
                    + "FROM item, estrutura "
                    + "WHERE estrutura.insumo_id = item.id "
                    + "AND item.ativo=true "
                    + "AND estrutura.ativo=true "
                    + "AND estrutura.item_id=" + criterio + " "
                    + "ORDER BY item.descricao");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("insumo_id");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = resultadoQ.getDouble("qtde_insumo");
                dadosTabela[lin][3] = resultadoQ.getString("unidade_medida");

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
                    column.setPreferredWidth(300);
                    break;
                case 2:
                    column.setPreferredWidth(10);
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

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        return this.excluir(0, 0);
    }

    @Override
    public ArrayList<Estrutura> consultar(String criterio) {
        return this.consultar(0, 0);
    }

    @Override
    public Estrutura consultarId(int id) {
        return this.consultarId(0, 0);
    }

}
