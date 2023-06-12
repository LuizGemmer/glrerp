package view.Movimentacao;

import apoio.Formatacao;
import apoio.Validacao;
import dao.AdicionaisDAO;
import dao.ItemDAO;
import dao.Movimentacao_AdicionaisDAO;
import dao.Movimentacao_UserDAO;
import dao.movimentacaoDAO;
import entidade.Adicionais;
import entidade.Item;
import entidade.Movimentacao;
import entidade.Movimentacao_Adicionais;
import entidade.Movimentacao_User;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ruang
 */
public class Apoio_CadastroMovimentacao {

    public static boolean SalvarProducao(jif_Cadastro_movimentacao tela, JTable jtb_itens, int rowCount, LocalDateTime data, String tipoMovimentacao, int idGrupoMovimentacao, int user_id) {
        boolean salvarOk = true;

        for (int row = 0; row < rowCount; row++) {
            String Column1 = jtb_itens.getValueAt(row, 1).toString();
            String[] parts = Column1.split(" -|- ");

            int idItem = Integer.parseInt(parts[0].toString());
            double qtde = Double.parseDouble(jtb_itens.getValueAt(row, 3).toString().replace(".", "").replace(",", "."));
            String und = jtb_itens.getValueAt(row, 4).toString();
            double perda = Double.parseDouble(jtb_itens.getValueAt(row, 5).toString().replace(".", "").replace(",", "."));
            String obs = jtb_itens.getValueAt(row, 2).toString();
            int idPedido = Integer.parseInt(jtb_itens.getValueAt(row, 6).toString());

            Item item = new ItemDAO().consultarId(Integer.parseInt(parts[0]));
            if (item.getUnidade_medida().equals(und)) {
                qtde = qtde;
            } else if (und.equals(item.getUnd_conv1())) {
                qtde = item.getConv2() * qtde;
            } else {
                qtde = qtde / item.getConv2();
            }

            ArrayList<Object[]> dadosValorInsumos = Validacao.AjustarEstoqueInsumosProdução(idItem, qtde, perda);
            double valorProduto = 0;
                        
            for (int i = 0; i < dadosValorInsumos.size(); i++) {

                Object[] dados = dadosValorInsumos.get(i);
                int id_insumo = Integer.parseInt(dados[0].toString());
                double qtde_insumo = Double.parseDouble(dados[1].toString());
                valorProduto = valorProduto + ((qtde_insumo * new ItemDAO().consultarId(id_insumo).getValor()) / qtde);
            }

            //Salvar itens no BD
            Movimentacao mov = new Movimentacao();
            mov.setTipo(tipoMovimentacao);
            mov.setData(data);
            mov.setItem_id(idItem);
            mov.setCliente_id(0);
            mov.setValor(valorProduto);
            mov.setQtde(qtde);
            mov.setPerdas(perda);
            mov.setObservacao(obs);
            mov.setId_pedido(idPedido);
            mov.setId_grupo_movimentacao(idGrupoMovimentacao);

            movimentacaoDAO movDAO = new movimentacaoDAO();
            if (movDAO.salvar(mov) != null) {
                salvarOk = false;
            }

            salvarOk = SalvarUserMovimentacao(user_id);
            
            //Dar baixa do estoque nos insumos de uma produção
            ArrayList<Object[]> dadosAjusteEstoqueInsumos = Validacao.AjustarEstoqueInsumosProdução(idItem, qtde, perda);
            for (int i = 0; i < dadosAjusteEstoqueInsumos.size(); i++) {

                Object[] dados = dadosAjusteEstoqueInsumos.get(i);
                int id_insumo = Integer.parseInt(dados[0].toString());
                double qtde_insumo = Double.parseDouble(dados[1].toString());
                double valorInsumo = new ItemDAO().consultarId(id_insumo).getValor();

                Movimentacao movInsumo = new Movimentacao();
                movInsumo.setTipo("consumo");
                movInsumo.setData(data);
                movInsumo.setItem_id(id_insumo);
                movInsumo.setCliente_id(0);
                movInsumo.setValor(valorInsumo);
                movInsumo.setQtde(qtde_insumo);
                movInsumo.setPerdas(0);
                movInsumo.setObservacao("");
                movInsumo.setId_pedido(idPedido);
                movInsumo.setId_grupo_movimentacao(idGrupoMovimentacao);
                new movimentacaoDAO().salvar(movInsumo);

                if (new ItemDAO().atualizarEstoque(id_insumo, qtde_insumo) != null) {
                    JOptionPane.showMessageDialog(tela, "Erro ao inserir dados no banco de dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
                }

                salvarOk = SalvarUserMovimentacao(user_id);
            }
        }
        return salvarOk;
    }

    public static boolean SalvarUserMovimentacao(int user_id) {
        boolean salvarOk = true;

        //salvar movimentacao na tabela movimentacao_user
        int ultimaID = new movimentacaoDAO().consultarUltimaIdMovimentacao();
        Movimentacao_User movUser = new Movimentacao_User();
        movUser.setUsuario_id(user_id);
        movUser.setMovimentacao_id(ultimaID);

        Movimentacao_UserDAO movUserDAO = new Movimentacao_UserDAO();
        if (movUserDAO.salvar(movUser) != null) {
            salvarOk = false;
        }
        return salvarOk;
    }

    public static boolean SalvarVendaCompra(JTable jtb_itens, int rowCount, LocalDateTime data, JTextField cliente_id, String tipoMovimentacao, int idGrupoMovimentacao, int user_id) {
        boolean salvarOk = true;

        for (int row = 0; row < rowCount; row++) {
            int clienteId = Integer.parseInt(cliente_id.getText());
            String Column1 = jtb_itens.getValueAt(row, 1).toString();
            String[] parts = Column1.split(" -|- ");
            int pedidoId = 0;

            int idItem = Integer.parseInt(parts[0].toString());
            double qtde = Double.parseDouble(jtb_itens.getValueAt(row, 3).toString().replace(".", "").replace(",", "."));
            String und = jtb_itens.getValueAt(row, 4).toString();
            double valorUnitario = Double.parseDouble(jtb_itens.getValueAt(row, 5).toString().replace(".", "").replace(",", ".").replace("R$  ", ""));
            String obs = jtb_itens.getValueAt(row, 2).toString();

            Item item = new ItemDAO().consultarId(Integer.parseInt(parts[0]));
            if (item.getUnidade_medida().equals(und)) {
                qtde = qtde;
            } else if (und.equals(item.getUnd_conv1())) {
                qtde = item.getConv2() * qtde;
            } else {
                qtde = qtde / item.getConv2();
            }

            //Salvar itens no BD movimentacao
            Movimentacao mov = new Movimentacao();
            mov.setTipo(tipoMovimentacao);
            mov.setData(data);
            mov.setItem_id(idItem);
            mov.setCliente_id(clienteId);
            mov.setValor(valorUnitario);
            if ("venda".equals(tipoMovimentacao)) {
                mov.setQtde(qtde * (-1));
            } else {
                mov.setQtde(qtde);
            }
            mov.setPerdas(0);
            mov.setObservacao(obs);
            mov.setId_pedido(pedidoId);
            mov.setId_grupo_movimentacao(idGrupoMovimentacao);

            movimentacaoDAO movDAO = new movimentacaoDAO();
            if (movDAO.salvar(mov) != null) {
                salvarOk = false;
            }

            salvarOk = SalvarUserMovimentacao(user_id);
            salvarOk = SalvarAdicionaisBD(row, jtb_itens);

        }
        return salvarOk;
    }

    public static Object[] InserirAdicionais(ArrayList<Movimentacao_Adicionais> movimentacao_adicionais, String adicionais, double valorAdicionais, boolean possuiAdicional) {
        Object[] valores = new Object[2];
        adicionais = "";
        valorAdicionais = 0;
        if (possuiAdicional) {
            for (int i = 0; i < movimentacao_adicionais.size(); i++) {
                Adicionais adicional = new AdicionaisDAO().consultarId(movimentacao_adicionais.get(i).getAdicionais_id());
                int idAdicional = adicional.getId();
                String descricao = adicional.getDescricao();
                double valorUnt = movimentacao_adicionais.get(i).getValor();
                double qtdeItem = movimentacao_adicionais.get(i).getQtde();
                String obsAdicional = movimentacao_adicionais.get(i).getObservacao();
                double subTotalAdicionais = valorUnt * qtdeItem;

                if (i > 0) {
                    adicionais = adicionais + "    \n";
                }
                adicionais = adicionais
                        + "++ID "
                        + idAdicional
                        + " || "
                        + descricao
                        + " || "
                        + obsAdicional
                        + " || "
                        + Formatacao.formatarDecimal4casas(qtdeItem)
                        + " x "
                        + Formatacao.formatarDecimal2casasRS(valorUnt)
                        + " = " + Formatacao.formatarDecimal2casasRS(subTotalAdicionais);

                valorAdicionais = valorAdicionais + subTotalAdicionais;
            }
            valores[0] = adicionais;
            valores[1] = valorAdicionais;

        }
        return valores;
    }

    public static boolean SalvarAdicionaisBD(int row, JTable jtb_itens) {
        boolean salvarOk = true;
        if (!jtb_itens.getValueAt(row, 7).toString().equals("")) {
            ArrayList<Movimentacao_Adicionais> movimentacao_adicionais = new ArrayList<>();
            String columnAdicionais = String.valueOf(jtb_itens.getValueAt(row, 7));
            int ultimaID = new movimentacaoDAO().consultarUltimaIdMovimentacao();

            movimentacao_adicionais = ConverterAdicionaisStringToMovimentacao_Adicionais(columnAdicionais);

            //salvar adicionais na tabela movimentacao_adicionais
            for (int i = 0; i < movimentacao_adicionais.size(); i++) {
                Movimentacao_Adicionais movAdic = new Movimentacao_Adicionais();
                movAdic.setMovimentacao_id(ultimaID);
                movAdic.setAdicionais_id(movimentacao_adicionais.get(i).getAdicionais_id());
                movAdic.setValor(movimentacao_adicionais.get(i).getValor());
                movAdic.setQtde(movimentacao_adicionais.get(i).getQtde());
                movAdic.setObservacao(movimentacao_adicionais.get(i).getObservacao());

                Movimentacao_AdicionaisDAO movAdicDAO = new Movimentacao_AdicionaisDAO();
                if (movAdicDAO.salvar(movAdic) != null) {
                    salvarOk = false;
                }
            }
        }
        return salvarOk;
    }

    public static ArrayList<Movimentacao_Adicionais> ConverterAdicionaisStringToMovimentacao_Adicionais(String columnAdicionais) {

        ArrayList<Movimentacao_Adicionais> movimentacao_adicionais = new ArrayList<>();
        String[] adicionaisSplit = columnAdicionais.split("    \n");

        for (int i = 0; i < adicionaisSplit.length; i++) {
            String[] adicionaisDados = adicionaisSplit[i].split(" \\|\\| ");
            int idAdicional = Integer.parseInt(adicionaisDados[0].substring(5));
            String obsAdicional = adicionaisDados[2];
            String[] qtdeAdicionalParts = adicionaisDados[3].split(" x ");
            double qtdeAdicional = Double.parseDouble(qtdeAdicionalParts[0].replace(",", "."));
            String[] valorUnitarioParts = qtdeAdicionalParts[1].split(" = ");
            double valorUnitarioAdicional = Double.parseDouble(valorUnitarioParts[0].replace("R$  ", "").replace(".", "").replace(",", "."));

            Movimentacao_Adicionais movAdicional = new Movimentacao_Adicionais();
            movAdicional.setMovimentacao_id(0);
            movAdicional.setAdicionais_id(idAdicional);
            movAdicional.setQtde(qtdeAdicional);
            movAdicional.setValor(valorUnitarioAdicional);
            movAdicional.setObservacao(obsAdicional);

            movimentacao_adicionais.add(movAdicional);
        }
        return movimentacao_adicionais;
    }

    public static DefaultTableModel InserirTabela(JTable jtb_itens, String tipoMovimentacao) {
        //Inserir o modelo da tabela
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tornar todas as células não editáveis
            }
        };
        jtb_itens.setModel(model);

        if ("compra".equals(tipoMovimentacao) || "venda".equals(tipoMovimentacao)) {
            // Definição das colunas da tabela
            model.addColumn("Nº");
            model.addColumn("ID -|- Item");
            model.addColumn("Observação");
            model.addColumn("Qtde");
            model.addColumn("Und");
            model.addColumn("Valor Unitário");
            model.addColumn("Sub-Total");
            model.addColumn("Adicionais");

            // Centralizar conteúdo dascolunas
            centralizarConteudoColuna(0, jtb_itens);
            centralizarConteudoColuna(3, jtb_itens);
            centralizarConteudoColuna(4, jtb_itens);
            centralizarConteudoColuna(5, jtb_itens);

            //ajusta o tamanho da fonte
            int fontSize = 10; // Defina o tamanho da fonte desejado
            TableColumn column0 = jtb_itens.getColumnModel().getColumn(0);
            TableColumn column2 = jtb_itens.getColumnModel().getColumn(2);
            TableColumn column4 = jtb_itens.getColumnModel().getColumn(4);
            column0.setCellRenderer(new CustomRenderer2(fontSize));
            column2.setCellRenderer(new CustomRenderer(fontSize));
            column4.setCellRenderer(new CustomRenderer2(fontSize));

            TableColumn column = jtb_itens.getColumnModel().getColumn(7);
            column.setCellRenderer(new LineWrapCellRenderer(7));

        } else {
            // Definição das colunas da tabela
            model.addColumn("Nº");
            model.addColumn("ID -|- Item");
            model.addColumn("Observação");
            model.addColumn("Qtde");
            model.addColumn("Und");
            model.addColumn("Perda");
            model.addColumn("ID Pedido");
            model.addColumn("Adicionais");

            // Centralizar conteúdo dascolunas
            centralizarConteudoColuna(0, jtb_itens);
            centralizarConteudoColuna(3, jtb_itens);
            centralizarConteudoColuna(4, jtb_itens);
            centralizarConteudoColuna(5, jtb_itens);
            centralizarConteudoColuna(6, jtb_itens);

            //ajusta o tamanho da fonte
            int fontSize = 10; // Defina o tamanho da fonte desejado
            TableColumn column5 = jtb_itens.getColumnModel().getColumn(5);
            column5.setCellRenderer(new CustomRenderer2(fontSize));

            TableColumn column = jtb_itens.getColumnModel().getColumn(7);
            column.setCellRenderer(new LineWrapCellRenderer(7));
        }
        // Ajustar tamanho das colunas
        ajustarTamanhoColunas(tipoMovimentacao, jtb_itens);
        return model;
    }

    public static void ajustarTamanhoColunas(String tipoMovimentacao, JTable jtb_itens) {
        // Definir o tamanho manual das colunas (menos da última)
        if ("compra".equals(tipoMovimentacao) || "venda".equals(tipoMovimentacao)) {
            int[] columnWidths = {2, 270, 150, 50, 8, 80, 150};
            for (int i = 0; i < columnWidths.length; i++) {
                TableColumn column = jtb_itens.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }
        } else {
            int[] columnWidths = {10, 270, 80, 80, 50, 10, 150};
            for (int i = 0; i < columnWidths.length; i++) {
                TableColumn column = jtb_itens.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }
        }
        // Configurar a última coluna para redimensionar automaticamente
        jtb_itens.setAutoResizeMode(jtb_itens.AUTO_RESIZE_LAST_COLUMN);
    }

    public static void centralizarConteudoColuna(int columnIndex, JTable jtb_itens) {
        // Criar um objeto DefaultTableCellRenderer para centralizar o conteúdo da coluna
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderer à coluna específica da tabela
        jtb_itens.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);

    }

    public static class CustomRenderer extends DefaultTableCellRenderer {

        private int fontSize;

        public CustomRenderer(int fontSize) {
            this.fontSize = fontSize;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Define o tamanho da fonte
            Font font = cell.getFont();
            font = font.deriveFont(Font.PLAIN, fontSize);
            cell.setFont(font);
            return cell;
        }
    }

    public static class CustomRenderer2 extends DefaultTableCellRenderer {

        private int fontSize;

        public CustomRenderer2(int fontSize) {
            this.fontSize = fontSize;
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Define o tamanho da fonte
            Font font = cell.getFont();
            font = font.deriveFont(Font.PLAIN, fontSize);
            cell.setFont(font);
            return cell;
        }
    }

    public static class LineWrapCellRenderer extends DefaultTableCellRenderer {

        private int targetColumnIndex;

        public LineWrapCellRenderer(int targetColumnIndex) {
            this.targetColumnIndex = targetColumnIndex;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (column == targetColumnIndex) {
                JTextArea textArea = new JTextArea();
                textArea.setText((String) value);
                textArea.setWrapStyleWord(true);
                textArea.setLineWrap(true);
                textArea.setFont(new Font("Arial", Font.PLAIN, 8));

                if (isSelected) {
                    textArea.setBackground(table.getSelectionBackground());
                    textArea.setForeground(table.getSelectionForeground());
                } else {
                    textArea.setBackground(table.getBackground());
                    textArea.setForeground(table.getForeground());
                }

                // Calcular a altura necessária
                int textAreaWidth = table.getColumnModel().getColumn(column).getWidth();
                textArea.setSize(textAreaWidth, Short.MAX_VALUE);
                int textAreaPreferredHeight;
                if (textArea.getPreferredSize().height > 25) {
                    textAreaPreferredHeight = textArea.getPreferredSize().height;
                } else {
                    textAreaPreferredHeight = 25;
                }
                // Definir a altura da linha
                table.setRowHeight(row, textAreaPreferredHeight);

                return textArea;
            }

            return component;
        }
    }

}
