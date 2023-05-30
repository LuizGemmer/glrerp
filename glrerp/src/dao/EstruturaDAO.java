package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Estrutura;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
                    + "'true', "
                    + "'" + o.getUnd_medida() + "', "
                    + o.getValor_estrutura() + ")";

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
                    + "qtde_insumo=" + o.getQtde_insumo() + ", "
                    + "und_medida='" + o.getUnd_medida() + "', "
                    + "valor_estrutura=" + o.getValor_estrutura();

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
                estrutura.setUnd_medida(retorno.getString("und_medida"));
                estrutura.setValor_estrutura(retorno.getDouble("valor_estrutura"));

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
                estrutura.setUnd_medida(retorno.getString("und_medida"));
                estrutura.setValor_estrutura(retorno.getDouble("valor_estrutura"));

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
                estrutura.setUnd_medida(retorno.getString("und_medida"));
                estrutura.setValor_estrutura(retorno.getDouble("valor_estrutura"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Estrutura " + e);
        }

        return estrutura;
    }

    public Estrutura consultarIdInsumo(int insumo_id) {
        Estrutura estrutura = new Estrutura();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT "
                    + "estrutura.item_id, "
                    + "estrutura.insumo_id, "
                    + "estrutura.qtde_insumo, "
                    + "estrutura.ativo, "
                    + "item.ativo "
                    + "FROM estrutura, item "
                    + "WHERE estrutura.ativo=true "
                    + "AND item.ativo=true "
                    + "AND estrutura.insumo_id=" + insumo_id;

            System.out.println("SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                estrutura.setItem_id(retorno.getInt("item_id"));
                estrutura.setInsumo_id(retorno.getInt("insumo_id"));
                estrutura.setQtde_insumo(retorno.getDouble("qtde_insumo"));
                estrutura.setAtivo(retorno.getBoolean("ativo"));
                estrutura.setUnd_medida(retorno.getString("und_medida"));
                estrutura.setValor_estrutura(retorno.getDouble("valor_estrutura"));

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

    public void popularTabelaInsumos(JTable tabela, String criterio) {
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "ID Insumo";
        cabecalho[1] = "Insumo";
        cabecalho[2] = "Qtde Insumo";
        cabecalho[3] = "Unidade";
        cabecalho[4] = "Valor";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT "
                    + "estrutura.insumo_id, "
                    + "item.descricao, "
                    + "estrutura.qtde_insumo, "
                    + "estrutura.und_medida, "
                    + "estrutura.valor_estrutura "
                    + "FROM item, estrutura "
                    + "WHERE estrutura.insumo_id = item.id "
                    + "AND item.ativo=true "
                    + "AND estrutura.ativo=true "
                    + "AND estrutura.item_id=" + criterio + " "
                    + "ORDER BY item.descricao");

            while (resultadoQ.next()) {
                Object[] linha = new Object[5];
                linha[0] = resultadoQ.getInt("insumo_id");
                linha[1] = resultadoQ.getString("descricao");
                linha[2] = resultadoQ.getDouble("qtde_insumo");
                linha[3] = resultadoQ.getString("und_medida");
                linha[4] = resultadoQ.getDouble("valor_estrutura");
                dadosTabela.add(linha);
            }

        } catch (Exception e) {
            System.out.println("Erro ao popular tabela: " + e);
        }

        tabela.setModel(new DefaultTableModel(
                dadosTabela.toArray(new Object[0][0]), cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
                // if (column == 3){return true} else {return false}
            }
        });

        // Altera o número de selecao de linhas da tabela
        tabela.setSelectionMode(0);

        // Redimensiona as colunas de uma tabela
        TableColumn column = null;
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        int[] columnWidths = {20, 380, 50, 50, 50};
        for (int i = 0; i < tabela.getColumnModel().getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Alinhar dados da coluna 1 no centro da celula da tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumn column1 = tabela.getColumnModel().getColumn(0);
        TableColumn column2 = tabela.getColumnModel().getColumn(2);
        TableColumn column3 = tabela.getColumnModel().getColumn(3);
        TableColumn column4 = tabela.getColumnModel().getColumn(4);
        column1.setCellRenderer(centerRenderer);
        column2.setCellRenderer(centerRenderer);
        column3.setCellRenderer(centerRenderer);
        

        // Formatar número Double na coluna 2
        DefaultTableCellRenderer decimalRenderer2 = new DefaultTableCellRenderer() {
            private DecimalFormat decimalFormat = new DecimalFormat("#,####0.0000");

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value instanceof Double) {
                    double valor = (Double) value;
                    String textoFormatado = decimalFormat.format(valor);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setText(textoFormatado);
                }
                return component;
            }
        };

        column2.setCellRenderer(decimalRenderer2);
        
        // Formatar número Double na coluna 4
        DefaultTableCellRenderer decimalRenderer4 = new DefaultTableCellRenderer() {
            private DecimalFormat decimalFormat = new DecimalFormat("R$  #,##0.00");

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value instanceof Double) {
                    double valor = (Double) value;
                    String textoFormatado = decimalFormat.format(valor);
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setText(textoFormatado);
                }
                return component;
            }
        };
        column4.setCellRenderer(decimalRenderer4);
    }

    public void popularTabelaItensConsomemInsumoX(JTable tabela, int id) {
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "ID Item";
        cabecalho[1] = "Item";
        cabecalho[2] = "Qtde Insumo";
        cabecalho[3] = "Unidade";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT "
                    + "estrutura.item_id, "
                    + "item.descricao, "
                    + "estrutura.qtde_insumo, "
                    + "estrutura.und_medida "
                    + "FROM item, estrutura "
                    + "WHERE estrutura.item_id = item.id "
                    + "AND item.ativo=true "
                    + "AND estrutura.ativo=true "
                    + "AND estrutura.insumo_id=" + id + " "
                    + "ORDER BY item.descricao");

            while (resultadoQ.next()) {
                Object[] linha = new Object[4];
                linha[0] = resultadoQ.getInt("item_id");
                linha[1] = resultadoQ.getString("descricao");
                linha[2] = resultadoQ.getDouble("qtde_insumo");
                linha[3] = resultadoQ.getString("und_medida");
                dadosTabela.add(linha);
            }

        } catch (Exception e) {
            System.out.println("Erro ao popular tabela: " + e);
        }

        tabela.setModel(new DefaultTableModel(
                dadosTabela.toArray(new Object[0][0]), cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
                // if (column == 3){return true} else {return false}
            }
        });

        // Altera o número de selecao de linhas da tabela
        tabela.setSelectionMode(0);

        // Redimensiona as colunas de uma tabela
        TableColumn column = null;
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        int[] columnWidths = {50, 350, 50, 50};
        for (int i = 0; i < tabela.getColumnModel().getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Alinhar dados da coluna 1 no centro da celula da tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumn column1 = tabela.getColumnModel().getColumn(0);
        TableColumn column2 = tabela.getColumnModel().getColumn(2);
        TableColumn column3 = tabela.getColumnModel().getColumn(3);
        column1.setCellRenderer(centerRenderer);
        column2.setCellRenderer(centerRenderer);
        column3.setCellRenderer(centerRenderer);

        // Formatar número Double na coluna 2
        DefaultTableCellRenderer decimalRenderer = new DefaultTableCellRenderer() {
            private DecimalFormat decimalFormat = new DecimalFormat("#,####0.0000");

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value instanceof Double) {
                    double valor = (Double) value;
                    String textoFormatado = decimalFormat.format(valor);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setText(textoFormatado);
                }
                return component;
            }
        };

        column2.setCellRenderer(decimalRenderer);
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
