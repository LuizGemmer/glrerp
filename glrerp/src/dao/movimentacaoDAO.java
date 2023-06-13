package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Movimentacao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ruang
 */
public class movimentacaoDAO implements IDAOT<Movimentacao> {

    private String tipo;
    private DecimalFormat formater = new DecimalFormat("#.####");

    public movimentacaoDAO(String tipo) {
        this.tipo = " where tipo='" + tipo + "' ";
    }

    public movimentacaoDAO() {
        this.tipo = "";
    }

    @Override
    public String salvar(Movimentacao o) {
        String cliente_id = "NULL";
        if (o.getCliente_id() != 0) {
            cliente_id = "" + o.getCliente_id();
        }

        String sql = "INSERT INTO movimentacao VALUES "
                + "(default, "
                + "'" + o.getTipo() + "', "
                + "'" + o.getData() + "', "
                + "" + o.getItem_id() + ", "
                + "" + cliente_id + ", "
                + "" + o.getValor() + ", "
                + "" + o.getQtde() + ", "
                + "" + o.getPerdas() + ", "
                + "'" + o.getObservacao() + "', "
                + "" + o.getId_pedido() + ", "
                + "" + o.getId_grupo_movimentacao() + ", "
                + "'" + o.getSituacao_pedido() + "');";

        //Salvar movimentacao no banco de dados
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            int retorno = st.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            return null;

        } catch (Exception e) {
            System.out.println(sql);
            System.out.println("Erro ao inserir cadastro de movimentacao " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Movimentacao o) {

        //Atualizar um movimentacao/Fornecedor
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE movimentacao SET "
                    + "tipo='" + o.getTipo() + "', "
                    + "data='" + o.getData() + "', "
                    + "item_id='" + o.getItem_id() + "', "
                    + "cliente_id='" + o.getCliente_id() + "', "
                    + "valor='" + o.getValor() + "', "
                    + "qtde='" + o.getQtde() + "', "
                    + "perda='" + o.getPerdas() + "', "
                    + "observacao='" + o.getObservacao() + "', "
                    + "id_pedido='" + o.getId_pedido() + "', "
                    + "id_grupo_movimentacao=" + o.getId_grupo_movimentacao() + ", "
                    + "situacao_pedido='" + o.getSituacao_pedido() + "' "
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
        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "DELETE FROM movimentacao "
                    + "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int retorno = statement.executeUpdate();
            System.out.println("SQL: " + statement.toString());

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Movimentacao " + e);
            return e.toString();
        }
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

    public ArrayList<Object[]> consultarValorItensTotalGrupo(String tipo) {
        ArrayList<Object[]> movimentacoes = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT id_grupo_movimentacao, SUM(valor*qtde) AS total_valor, COUNT(*) AS total_itens, "
                    + "cliente_id, SUM(perda) AS total_perda, data, tipo, situacao_pedido "
                    + "FROM movimentacao "
                    + "" + tipo + ""
                    + "GROUP BY id_grupo_movimentacao, data, cliente_id, tipo, situacao_pedido "
                    + "ORDER BY id_grupo_movimentacao DESC";

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                Object[] dados = new Object[8];
                dados[0] = retorno.getInt("id_grupo_movimentacao");
                dados[1] = retorno.getDouble("total_valor");
                dados[2] = retorno.getInt("total_itens");
                dados[3] = retorno.getInt("cliente_id");
                dados[4] = retorno.getDouble("total_perda");
                dados[5] = retorno.getDate("data");
                dados[6] = retorno.getString("tipo");
                dados[7] = retorno.getString("situacao_pedido");
                movimentacoes.add(dados);
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

    public ArrayList<Movimentacao> consultarIdGrupoMovimentacao(int id, String tipo) {
        ArrayList<Movimentacao> movimentacoes = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM movimentacao "
                    + "" + tipo + ""
                    + "AND id_grupo_movimentacao=" + id + "";

            System.out.println(" SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                Movimentacao m = new Movimentacao(retorno);
                movimentacoes.add(m);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de movimentacao " + e);
        }
        return movimentacoes;
    }

    public ArrayList<Movimentacao> consultarIdGrupoMovimentacaoEspecial(int id, String criterio) {
        ArrayList<Movimentacao> movimentacoes = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM movimentacao "
                    + "WHERE id_grupo_movimentacao=" + id + " "
                    + "AND situacao_pedido ILIKE '%" + criterio + "%' ";

            System.out.println(" SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                Movimentacao m = new Movimentacao(retorno);
                movimentacoes.add(m);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de movimentacao " + e);
        }
        return movimentacoes;
    }

    public ArrayList consultarUltimaIdGrupoMovimentacao() {
        ArrayList<Movimentacao> movimentacao = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT "
                    + "MAX(id_grupo_movimentacao) AS id_grupo_movimentacao "
                    + "FROM movimentacao";

            ResultSet retorno = st.executeQuery(sql);
            System.out.println("SQL: " + sql);
            while (retorno.next()) {
                Movimentacao mov = new Movimentacao();
                mov.setId_grupo_movimentacao(retorno.getInt("id_grupo_movimentacao"));

                movimentacao.add(mov);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Item " + e);
        }

        return movimentacao;
    }

    @Override
    public ArrayList<Movimentacao> consultarTodos() {
        return this.consultarTodos("");
    }

    public int consultarUltimaIdMovimentacao() {
        int movimentacao = 0;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT "
                    + "MAX(id) AS id "
                    + "FROM movimentacao";

            System.out.println("SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                movimentacao = retorno.getInt("id");

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Movimentacao " + e);
        }

        return movimentacao;
    }

    @Override
    public ArrayList<String[]> paraListagemTabela(String filtro) {
        ArrayList<Object[]> grupoMov = new movimentacaoDAO().consultarValorItensTotalGrupo(this.tipo);

        ArrayList<String[]> tableData = new ArrayList();
        if (this.tipo.contains("producao")) {
            for (int i = 0; i < grupoMov.size(); i++) {
                Object[] dados = grupoMov.get(i);

                String[] data = {
                    dados[0].toString(),
                    Formatacao.ajustaDataDMA(dados[5].toString()),
                    dados[6].toString().toUpperCase(),
                    dados[2].toString(),
                    Formatacao.formatarDecimal4casas(Double.parseDouble(dados[4].toString())),
                    Formatacao.formatarDecimal2casasRS(Double.parseDouble(dados[1].toString()))};

                if (filtro.equals("")) {
                    tableData.add(data);
                } else if (data[1].contains(filtro.toUpperCase())
                        || data[4].contains(filtro.toUpperCase())) {
                    tableData.add(data);
                }
            }

        } else if (this.tipo.contains("pedido venda")) {
            for (int i = 0; i < grupoMov.size(); i++) {
                Object[] dados = grupoMov.get(i);
                double valor;
                if (Double.parseDouble(dados[1].toString()) < 0) {
                    valor = Double.parseDouble(dados[1].toString()) * -1;
                } else {
                    valor = Double.parseDouble(dados[1].toString());
                }

                String[] data = {
                    dados[0].toString(),
                    Formatacao.ajustaDataDMA(dados[5].toString()),
                    dados[7].toString().toUpperCase(),
                    String.valueOf(new ClienteDAO().consultarIdComInativos(Integer.parseInt(dados[3].toString())).getNome()),
                    String.valueOf(new ClienteDAO().consultarIdComInativos(Integer.parseInt(dados[3].toString())).getCpf()),
                    dados[2].toString(),
                    Formatacao.formatarDecimal2casasRS(valor)};

                if (filtro.equals("")) {
                    tableData.add(data);
                } else if (data[3].contains(filtro.toUpperCase())
                        || data[1].contains(filtro.toUpperCase())
                        || data[4].contains(filtro.toUpperCase())) {
                    tableData.add(data);
                }
            }

        } else {
            for (int i = 0; i < grupoMov.size(); i++) {
                Object[] dados = grupoMov.get(i);
                double valor;
                if (Double.parseDouble(dados[1].toString()) < 0) {
                    valor = Double.parseDouble(dados[1].toString()) * -1;
                } else {
                    valor = Double.parseDouble(dados[1].toString());
                }

                String[] data = {
                    dados[0].toString(),
                    Formatacao.ajustaDataDMA(dados[5].toString()),
                    dados[6].toString().toUpperCase(),
                    String.valueOf(new ClienteDAO().consultarIdComInativos(Integer.parseInt(dados[3].toString())).getNome()),
                    String.valueOf(new ClienteDAO().consultarIdComInativos(Integer.parseInt(dados[3].toString())).getCpf()),
                    dados[2].toString(),
                    Formatacao.formatarDecimal2casasRS(valor)};

                if (filtro.equals("")) {
                    tableData.add(data);
                } else if (data[3].contains(filtro.toUpperCase())
                        || data[1].contains(filtro.toUpperCase())
                        || data[4].contains(filtro.toUpperCase())) {
                    tableData.add(data);
                }
            }
        }
        return tableData;
    }

    @Override
    public String[] getTableColumns() {
        if (this.tipo.contains("producao")) {
            return new String[]{"Id", "Data", "Tipo", "Itens", "Perda", "Valor Total"};
        } else {
            return new String[]{"Id", "Data", "Tipo", "Cliente/Fornecedor", "CPF/CNPJ", "Itens", "Valor Total"};
        }
    }

    public void popularTabela(JTable tabela, int id, String criterio) {
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[8];
        cabecalho[0] = "ID Movimentação";
        cabecalho[1] = "ID";
        cabecalho[2] = "Data";
        cabecalho[3] = "Tipo";
        cabecalho[4] = "Quantidade";
        cabecalho[5] = "Und";
        cabecalho[6] = "Valor Unitário";
        cabecalho[7] = "Sub Total";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT movimentacao.id_grupo_movimentacao AS mov_grupo, "
                    + "movimentacao.id AS mov_id, "
                    + "movimentacao.data AS mov_data, "
                    + "movimentacao.tipo AS mov_tipo, "
                    + "movimentacao.qtde AS mov_qtde, "
                    + "item.unidade_medida AS item_und, "
                    + "movimentacao.valor AS mov_valor "
                    + "FROM movimentacao, item "
                    + "WHERE movimentacao.item_id = item.id "
                    + "AND movimentacao.item_id=" + id + " "
                    + "AND movimentacao.tipo ILIKE '%" + criterio + "%' "
                    + "ORDER BY mov_grupo DESC");

            while (resultadoQ.next()) {
                String[] parts = resultadoQ.getString("mov_data").split(" ");
                String[] partsHora = parts[1].split(":");
                String data = Formatacao.ajustaDataDMA(parts[0].toString());
                String hora = partsHora[0] + ":" + partsHora[1];
                double qtde;
                if (resultadoQ.getDouble("mov_qtde") < 0) {
                    qtde = resultadoQ.getDouble("mov_qtde") * -1;
                } else {
                    qtde = resultadoQ.getDouble("mov_qtde");
                }

                Object[] linha = new Object[8];
                linha[0] = resultadoQ.getInt("mov_grupo");
                linha[1] = resultadoQ.getInt("mov_id");
                linha[2] = (data + " " + hora);
                linha[3] = resultadoQ.getString("mov_tipo").toUpperCase();
                linha[4] = Formatacao.formatarDecimal4casas(qtde);
                linha[5] = resultadoQ.getString("item_und");
                linha[6] = Formatacao.formatarDecimal2casasRS(resultadoQ.getDouble("mov_valor"));
                linha[7] = Formatacao.formatarDecimal2casasRS(Double.parseDouble(linha[4].toString().replace(",", "."))
                        * Double.parseDouble(linha[6].toString().replace("R$  ", "").replace(",", ".")));

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

        // Personalização das cores das linhas da tabela
        TableColumn tipoColumn = tabela.getColumnModel().getColumn(3);
        tipoColumn.setCellRenderer(new CustomTableCellRenderer());

        // Redimensiona as colunas de uma tabela
        TableColumn column = null;
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        int[] columnWidths = {50, 10, 60, 40, 50, 30, 40, 60};
        for (int i = 0; i < tabela.getColumnModel().getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Alinhar dados da coluna 1 no centro da celula da tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumn column0 = tabela.getColumnModel().getColumn(0);
        TableColumn column1 = tabela.getColumnModel().getColumn(1);
        TableColumn column2 = tabela.getColumnModel().getColumn(2);
        TableColumn column4 = tabela.getColumnModel().getColumn(4);
        TableColumn column5 = tabela.getColumnModel().getColumn(5);

        column0.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);
        column2.setCellRenderer(centerRenderer);
        column4.setCellRenderer(centerRenderer);
        column5.setCellRenderer(centerRenderer);

    }

    public void popularTabelaPedidos(JTable tabela, String situacaoPedido, String criterio) {
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "ID Pedido";
        cabecalho[1] = "Data";
        cabecalho[2] = "Cliente";
        cabecalho[3] = "CPF / CNPJ";
        cabecalho[4] = "Itens";
        cabecalho[5] = "Valor Total";
        cabecalho[6] = "Situação";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT movimentacao.id_pedido AS mov_pedido, "
                    + "movimentacao.data AS mov_data, "
                    + "cliente.id, "
                    + "cliente.nome AS cliente_nome, "
                    + "cliente.cpf AS cliente_cpf, "
                    + "COUNT(movimentacao.id) AS total_itens, "
                    + "SUM(movimentacao.valor*movimentacao.qtde) AS total_valor, "
                    + "movimentacao.situacao_pedido AS situacao "
                    + "FROM movimentacao, cliente "
                    + "WHERE movimentacao.cliente_id = cliente.id "
                    + "AND movimentacao.situacao_pedido ILIKE '%" + situacaoPedido + "%' "
                    + "AND (movimentacao.situacao_pedido ILIKE '%" + criterio + "%' "
                    + "OR cliente.nome ILIKE '%" + criterio + "%' "
                    + "OR cliente.cpf ILIKE '%" + criterio + "%') "
                    + "GROUP BY mov_pedido, mov_data, cliente_nome, cliente_cpf, movimentacao.tipo, situacao, cliente.id "
                    + "ORDER BY movimentacao.data DESC");

            while (resultadoQ.next()) {
                String[] parts = resultadoQ.getString("mov_data").split(" ");
                String[] partsHora = parts[1].split(":");
                String data = Formatacao.ajustaDataDMA(parts[0].toString());
                String hora = partsHora[0] + ":" + partsHora[1];

                Object[] linha = new Object[7];
                linha[0] = resultadoQ.getInt("mov_pedido");
                linha[1] = (data + " " + hora);
                linha[2] = resultadoQ.getString("cliente_nome");
                linha[3] = resultadoQ.getString("cliente_cpf");
                linha[4] = Formatacao.formatarDecimal4casas(resultadoQ.getDouble("total_itens"));
                linha[5] = Formatacao.formatarDecimal2casasRS(resultadoQ.getDouble("total_valor"));
                linha[6] = resultadoQ.getString("situacao");

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

        // Personalização das cores das linhas da tabela
        TableColumn tipoColumn = tabela.getColumnModel().getColumn(3);
        tipoColumn.setCellRenderer(new CustomTableCellRenderer());

        // Redimensiona as colunas de uma tabela
        TableColumn column = null;
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        int[] columnWidths = {50, 10, 60, 40, 50, 30, 40, 60};
        for (int i = 0; i < tabela.getColumnModel().getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        // Alinhar dados da coluna 1 no centro da celula da tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumn column0 = tabela.getColumnModel().getColumn(0);
        TableColumn column1 = tabela.getColumnModel().getColumn(1);
        TableColumn column3 = tabela.getColumnModel().getColumn(3);
        TableColumn column4 = tabela.getColumnModel().getColumn(4);
        TableColumn column5 = tabela.getColumnModel().getColumn(5);
        TableColumn column6 = tabela.getColumnModel().getColumn(6);

        column0.setCellRenderer(centerRenderer);
        column1.setCellRenderer(centerRenderer);
        column3.setCellRenderer(centerRenderer);
        column4.setCellRenderer(centerRenderer);
        column5.setCellRenderer(centerRenderer);
        column6.setCellRenderer(centerRenderer);

    }

    @Override
    public Movimentacao consultarId(int id) {
        this.consultarIdGrupoMovimentacao(id, this.tipo);
        Movimentacao m = new Movimentacao();

        m = consultarIdGrupoMovimentacao(id, this.tipo).get(0);
        return m;
    }

    public Movimentacao consultarIdMov(int id) {
        Movimentacao mov = new Movimentacao();

        try {
            Connection connection = ConexaoBD.getInstance().getConnection();
            String sql = "SELECT * "
                    + "FROM movimentacao "
                    + "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet retorno = statement.executeQuery();
            System.out.println("SQL: " + statement.toString());
            while (retorno.next()) {

                mov.setId(retorno.getInt("id"));
                mov.setTipo(retorno.getString("tipo"));
                //mov.setData(retorno.getString("data"));
                mov.setItem_id(retorno.getInt("item_id"));
                mov.setCliente_id(retorno.getInt("cliente_id"));
                mov.setValor(retorno.getDouble("valor"));
                mov.setQtde(retorno.getDouble("qtde"));
                mov.setPerdas(retorno.getDouble("perda"));
                mov.setObservacao(retorno.getString("observacao"));
                mov.setId_pedido(retorno.getInt("id_pedido"));
                mov.setId_grupo_movimentacao(retorno.getInt("id_grupo_movimentacao"));
                mov.setSituacao_pedido(retorno.getString("situacao_pedido"));

            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cadastro de Movimentacao " + e);
        }
        return mov;

    }

    static class CustomTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String tipo = ((String) value).toUpperCase(); // Converter para letras maiúsculas

            if (column == 3) { // Verificar a coluna 3 
                setHorizontalAlignment(SwingConstants.CENTER); // Alinhamento centralizado
            } else {
                setHorizontalAlignment(SwingConstants.LEFT); // Alinhamento padrão à esquerda
            }

            if (tipo.equalsIgnoreCase("VENDA")) {
                component.setBackground(Color.decode("#99FF99"));
                component.setForeground(Color.BLACK);
            } else if (tipo.equalsIgnoreCase("COMPRA")) {
                component.setBackground(Color.decode("#FFFF99"));
                component.setForeground(Color.BLACK);
            } else if (tipo.equalsIgnoreCase("PRODUCAO")) {
                component.setBackground(Color.decode("#99CCFF"));
                component.setForeground(Color.BLACK);
            } else if (tipo.equalsIgnoreCase("CONSUMO")) {
                component.setBackground(Color.decode("#FF9999"));
                component.setForeground(Color.BLACK);
            } else {
                component.setBackground(table.getBackground());
            }

            return component;
        }
    }

}
