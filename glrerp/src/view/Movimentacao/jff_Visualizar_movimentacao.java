package view.Movimentacao;

import apoio.Formatacao;
import apoio.Validacao;
import dao.ClienteDAO;
import dao.GrupoDAO;
import dao.ItemDAO;
import entidade.Cliente;
import entidade.Grupo;
import entidade.Item;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ruang
 */
public class jff_Visualizar_movimentacao extends javax.swing.JFrame {

    private int id_cliente_selecionado; //Variavel que armazena o id do cliente a ser feito a movimentação
    private int id_item_selecionado; //Variavel que armazena o id do item a ser cadastrado na movimentação.
    public int pesquisar_cliente_item; //Variavel que é utilizada para dizer à tela JFF_PESQUISAR se estamos buscando um cliente(int=1) ou um item (int=2)
    private boolean apertou_editar = false; //Variavel que fica TRUE quando seleciona um insumo já cadastrado na estrutura para edição. Caso seja clicado em FECHAR ou REINICIAR antes de salvar, gerará uma mensagem de aviso.
    private String tipoMovimentacao; //Retorna, ao abrir essa tela, qual o tipo de movimentação (compra, venda ou producao)
    private String grupoTipo; //Vai vir a String da tela JIF_CADASTRO_MOVIMENTACAO. Se for nova compra retorna ('MATERIA-PRIMA', 'OUTRO', 'FERRAMENTA'). Se for Venda retorna ('PRODUTO ACABADO', 'OUTRO')
    private int linhasTabela = 1;
    private boolean validarEstoque = true;
    private int itemIdSemEstoque;
    private double qtdeItemConsumo;
    private double qtdeItemEstoque;
    private int idGrupoMovimentacao = 0;
    double perda;
    double valorUnd;
    ArrayList<ArrayList<Object>> dadosTabela = new ArrayList<>();

    //Criação da tabela contendo os itens
    private static ArrayList<Object[]> dados = new ArrayList<>();
    private static DefaultTableModel model;

    Color buttonDisableColor = new Color(51, 51, 51);
    Color buttonBlueColor = new Color(13, 71, 161);
    Color buttonLightBlueColor = new Color(51, 102, 255);
    Color buttonRedColor = new Color(153, 0, 0);
    Color buttonGreenColor = new Color(0, 102, 0);

    public jff_Visualizar_movimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
        initComponents();
        Formatacao.formatarData(jff_Data);
        Formatacao.formatarHora(jff_Hora);
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
        UIManager.put("ComboBox.disabledBackground", Color.RGBtoHSB(250, 250, 250, null));

        //Configurar a tabela
        InserirTabela();
        ConfigurarBotoesJTF();
    }

    public void NomearCliente(int id_tabela) {
        this.id_cliente_selecionado = id_tabela;

        //Coloca os valores referentes ao ID do cliente/Fornecedor para os campos JTF
        Cliente cliente = new ClienteDAO().consultarId(this.id_cliente_selecionado);
        jtf_id_cliente.setText(String.valueOf(cliente.getId()));
        jtf_nome_cliente.setText(cliente.getNome());
        jtf_cpf_cliente.setText(cliente.getCpf());

    }

    public void NomearItem(int id_tabela) {
        this.id_item_selecionado = id_tabela;

        //Coloca os valores referentes ao ID do item para os campos JTF
        Item item = new ItemDAO().consultarId(this.id_item_selecionado);
        Grupo grupo = new GrupoDAO().consultarId(item.getId_grupo());

        if ("compra".equals(this.tipoMovimentacao) || "venda".equals(this.tipoMovimentacao)) {
            jlb_und_valor.setText("/ " + item.getUnidade_medida());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_cliente_fornecedor = new javax.swing.JLabel();
        jtf_id_cliente = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jtf_nome_cliente = new javax.swing.JTextField();
        jtf_cpf_cliente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_itens = new javax.swing.JTable();
        jlb_ValorTotal = new javax.swing.JLabel();
        jtf_SomaValor = new javax.swing.JTextField();
        jff_Data = new javax.swing.JFormattedTextField();
        jlb_Data = new javax.swing.JLabel();
        jff_Hora = new javax.swing.JFormattedTextField();
        jlb_und_valor = new javax.swing.JLabel();
        jlb_ValorTotal1 = new javax.swing.JLabel();
        jtf_SomaItens = new javax.swing.JTextField();

        setTitle("Cadastro - Estrutura");
        setBackground(new java.awt.Color(238, 238, 238));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jlb_cliente_fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        jlb_cliente_fornecedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_cliente_fornecedor.setText("*Cliente");

        jtf_id_cliente.setBackground(new java.awt.Color(250, 250, 250));
        jtf_id_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_id_cliente.setForeground(new java.awt.Color(0, 0, 0));
        jtf_id_cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_id_cliente.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_id_cliente.setEnabled(false);

        jbt_fechar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_fechar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_fechar.setText("Fechar");
        jbt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_fecharActionPerformed(evt);
            }
        });

        jtf_nome_cliente.setBackground(new java.awt.Color(250, 250, 250));
        jtf_nome_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_nome_cliente.setForeground(new java.awt.Color(0, 0, 0));
        jtf_nome_cliente.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_nome_cliente.setEnabled(false);

        jtf_cpf_cliente.setBackground(new java.awt.Color(250, 250, 250));
        jtf_cpf_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_cpf_cliente.setForeground(new java.awt.Color(0, 0, 0));
        jtf_cpf_cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_cpf_cliente.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_cpf_cliente.setEnabled(false);

        jtb_itens.setBackground(new java.awt.Color(250, 250, 250));
        jtb_itens.setForeground(new java.awt.Color(51, 51, 51));
        jtb_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtb_itens.setRowHeight(25);
        jtb_itens.setSelectionBackground(new java.awt.Color(13, 71, 161));
        jtb_itens.setSelectionForeground(new java.awt.Color(250, 250, 250));
        jtb_itens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtb_itens.setShowGrid(false);
        jtb_itens.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jtb_itens);

        jlb_ValorTotal.setForeground(new java.awt.Color(0, 0, 0));
        jlb_ValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_ValorTotal.setText("Valor Total:");

        jtf_SomaValor.setBackground(new java.awt.Color(250, 250, 250));
        jtf_SomaValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_SomaValor.setForeground(new java.awt.Color(0, 0, 0));
        jtf_SomaValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_SomaValor.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_SomaValor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_SomaValor.setEnabled(false);

        jff_Data.setBackground(new java.awt.Color(250, 250, 250));
        jff_Data.setForeground(new java.awt.Color(0, 0, 0));
        jff_Data.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_Data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jlb_Data.setForeground(new java.awt.Color(0, 0, 0));
        jlb_Data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_Data.setText("*Data e Hora");

        jff_Hora.setBackground(new java.awt.Color(250, 250, 250));
        jff_Hora.setForeground(new java.awt.Color(0, 0, 0));
        jff_Hora.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_Hora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jlb_und_valor.setForeground(new java.awt.Color(0, 0, 0));
        jlb_und_valor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jlb_ValorTotal1.setForeground(new java.awt.Color(0, 0, 0));
        jlb_ValorTotal1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_ValorTotal1.setText("Itens:");

        jtf_SomaItens.setBackground(new java.awt.Color(250, 250, 250));
        jtf_SomaItens.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_SomaItens.setForeground(new java.awt.Color(0, 0, 0));
        jtf_SomaItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_SomaItens.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_SomaItens.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_SomaItens.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlb_cliente_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jff_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jff_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_cpf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(519, 519, 519)
                                .addComponent(jlb_und_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(376, 476, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_ValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_SomaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jbt_fechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlb_ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_SomaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_cliente_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_cpf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jff_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jff_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jlb_und_valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_ValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_SomaValor, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jlb_ValorTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_SomaItens, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(550, 550, 550))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Botão de fechar
        if (this.apertou_editar) {
            MensagemFecharComEdicaoEmAndamento();
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_jbt_fecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JFormattedTextField jff_Data;
    private javax.swing.JFormattedTextField jff_Hora;
    private javax.swing.JLabel jlb_Data;
    private javax.swing.JLabel jlb_ValorTotal;
    private javax.swing.JLabel jlb_ValorTotal1;
    private javax.swing.JLabel jlb_cliente_fornecedor;
    private javax.swing.JLabel jlb_und_valor;
    private javax.swing.JTable jtb_itens;
    private javax.swing.JTextField jtf_SomaItens;
    private javax.swing.JTextField jtf_SomaValor;
    private javax.swing.JTextField jtf_cpf_cliente;
    private javax.swing.JTextField jtf_id_cliente;
    private javax.swing.JTextField jtf_nome_cliente;
    // End of variables declaration//GEN-END:variables

    public double SomarTotalValorTabela() {
        int columnIndex = 6; // Índice da coluna a ser somada
        int rowCount = jtb_itens.getRowCount();
        double sum = 0.00;

        for (int i = 0; i < rowCount; i++) {
            Object value = Double.parseDouble(jtb_itens.getValueAt(i, columnIndex).toString().replace("R$  ", "").replace(",", "."));
            if (value instanceof Number) {
                double cellValue = ((Number) value).doubleValue();
                sum += cellValue;
            }
        }
        return sum;
    }

    private void ConfigurarBotoesJTF() {
        //Configurar labels e texts Fields de acordo com o tipo de movimentação que foi aberta 
        jtf_id_cliente.setText("");
        jtf_nome_cliente.setText("");
        jtf_cpf_cliente.setText("");
        jff_Data.setText("");
        jff_Hora.setText("");
        jtf_nome_cliente.setEnabled(false);
        jtf_cpf_cliente.setEnabled(false);
        jlb_und_valor.setVisible(true);
        jtf_SomaValor.setVisible(true);
        jlb_ValorTotal.setVisible(true);

        if ("compra".equals(this.tipoMovimentacao)) {
            this.pesquisar_cliente_item = 1;
            this.grupoTipo = "'MATERIA-PRIMA', 'FERRAMENTA', 'SERVICO', 'OUTRO'";
            this.setTitle("Nova Movimentação - COMPRA");
            jlb_cliente_fornecedor.setText("*Fornecedor");

        } else if ("venda".equals(this.tipoMovimentacao)) {
            this.pesquisar_cliente_item = 2;
            this.grupoTipo = "'PRODUTO ACABADO', 'SERVICO', 'OUTRO'";
            this.setTitle("Nova Movimentação - VENDA");
            jlb_cliente_fornecedor.setText("*Cliente");

        } else if ("producao".equals(this.tipoMovimentacao)) {
            this.grupoTipo = "'PRODUTO ACABADO'";
            this.setTitle("Nova Movimentação - PRODUÇÃO");
            jlb_cliente_fornecedor.setText("Pedido");
            jtf_cpf_cliente.setEnabled(false);
            jtf_nome_cliente.setEnabled(false);
            jtf_cpf_cliente.setEnabled(false);
            jlb_und_valor.setVisible(true);
            jtf_SomaValor.setVisible(false);
            jlb_ValorTotal.setVisible(false);
        }
    }

    private void MensagemFecharComEdicaoEmAndamento() {
        Object[] options = {"Sim",
            "Não"};
        int n = JOptionPane.showOptionDialog(this,
                "Você começou a fazer uma nova movimentação de item e não salvou as alterações. "
                + "\n Se você sair agora sem SALVAR todas as movimentações da lista serão EXCLUÍDAS! "
                + "\n\nTem certeza que deseja sair e excluir essas movimentações?",
                "ALTERAÇÕES NÃO SALVAS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (n == 0) {
            this.dispose();
            this.apertou_editar = false;
        }
    }

    private void InserirDadosTabela() {

        //Validar se os campos obrigatórios foram preenchidos corretamente
        //Pegar valores dos campos JTF
        String itemDesc = "";
        double QtdeItem = 0;
        String und = "";
        String obs = "";

        //Validar se possui estoque do item ou do insumo para nova Venda/Produção
        for (int i = 0; i < Validacao.ValidarEstoque(this.id_item_selecionado,
                QtdeItem,
                und,
                perda,
                jtb_itens,
                this.tipoMovimentacao).size(); i++) {

            Object[] dadosValidacaoEstoque = Validacao.ValidarEstoque(this.id_item_selecionado,
                    QtdeItem,
                    und,
                    perda,
                    jtb_itens,
                    this.tipoMovimentacao).get(i);

            this.validarEstoque = Boolean.parseBoolean(dadosValidacaoEstoque[0].toString());
            if (!this.validarEstoque) {
                this.itemIdSemEstoque = Integer.parseInt(dadosValidacaoEstoque[1].toString());
                this.qtdeItemConsumo = Double.parseDouble(dadosValidacaoEstoque[2].toString());
                this.qtdeItemEstoque = Double.parseDouble(dadosValidacaoEstoque[3].toString());
            }
            break;
        }

        if (this.validarEstoque) {

            // Adição de linhas na tabela e ao ArrayList
            if (this.tipoMovimentacao == "venda" || this.tipoMovimentacao == "compra") {
                double subTotal;

                Item item = new ItemDAO().consultarId(this.id_item_selecionado);
                if (item.getUnidade_medida().equals(und)) {
                    subTotal = valorUnd * QtdeItem;
                } else if (und.equals(item.getUnd_conv1())) {
                    subTotal = valorUnd * item.getConv2() * QtdeItem;
                } else {
                    subTotal = valorUnd / item.getConv2() * QtdeItem;
                }

                //Na VENDA a OBS fica personalizada com desconto/acrescimo de valor
                if ("venda".equals(this.tipoMovimentacao)) {
                    if (valorUnd < item.getValor()) {
                        obs = "Desconto de R$ " + Formatacao.formatarDecimal2casas(item.getValor() - valorUnd) + "/" + item.getUnidade_medida() + " | " + obs;
                    }
                    if (valorUnd > item.getValor()) {
                        obs = "Acrescimo de R$ " + Formatacao.formatarDecimal2casas(valorUnd - item.getValor()) + "/" + item.getUnidade_medida() + " | " + obs;
                    }
                }

                //Adicionar os itens da linha em um Objeto
                Object[] novaLinha = {this.linhasTabela,
                    itemDesc,
                    obs,
                    Formatacao.formatarDecimal4casas(QtdeItem),
                    und,
                    Formatacao.formatarDecimal2casasRS(valorUnd),
                    Formatacao.formatarDecimal2casasRS(subTotal)};

                model.addRow(novaLinha);
                this.linhasTabela++;

                jtf_SomaValor.setText(String.valueOf(Formatacao.formatarDecimal2casasRS(SomarTotalValorTabela()).replace('.', ',')));

            } else {
                int pedido;
                try {
                    pedido = Integer.parseInt(jtf_id_cliente.getText());
                } catch (Exception e) {
                    pedido = 0;
                }

                //Adicionar os itens da linha em um Objeto
                Object[] novaLinha = {this.linhasTabela,
                    itemDesc,
                    obs,
                    Formatacao.formatarDecimal4casas(QtdeItem),
                    und,
                    Formatacao.formatarDecimal4casas(perda),
                    pedido};

                model.addRow(novaLinha);
                this.linhasTabela++;
            }

        } else {
            JOptionPane.showMessageDialog(this, "Item "
                    + this.itemIdSemEstoque + " - " + new ItemDAO().consultarId(this.itemIdSemEstoque).getDescricao()
                    + " sem estoque suficiente.\n\n"
                    + "Quantidade a ser consumida = "
                    + this.qtdeItemConsumo
                    + "\nQuantidade em estoque = "
                    + this.qtdeItemEstoque, "ITEM SEM ESTOQUE", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void InserirTabela() {
        //Inserir o modelo da tabela
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tornar todas as células não editáveis
            }
        };
        jtb_itens.setModel(model);

        if ("compra".equals(this.tipoMovimentacao) || "venda".equals(this.tipoMovimentacao)) {
            // Definição das colunas da tabela
            model.addColumn("Nº");
            model.addColumn("ID -|- Item");
            model.addColumn("Observação");
            model.addColumn("Qtde");
            model.addColumn("Und");
            model.addColumn("Valor Unitário");
            model.addColumn("Sub-Total");

            // Centralizar conteúdo dascolunas
            centralizarConteudoColuna(0);
            centralizarConteudoColuna(3);
            centralizarConteudoColuna(4);
            centralizarConteudoColuna(5);

            //ajusta o tamanho da fonte
            int fontSize = 10; // Defina o tamanho da fonte desejado
            TableColumn column0 = jtb_itens.getColumnModel().getColumn(0);
            TableColumn column2 = jtb_itens.getColumnModel().getColumn(2);
            TableColumn column4 = jtb_itens.getColumnModel().getColumn(4);
            column0.setCellRenderer(new CustomRenderer2(fontSize));
            column2.setCellRenderer(new CustomRenderer(fontSize));
            column4.setCellRenderer(new CustomRenderer2(fontSize));

        } else {
            // Definição das colunas da tabela
            model.addColumn("Nº");
            model.addColumn("ID -|- Item");
            model.addColumn("Observação");
            model.addColumn("Qtde");
            model.addColumn("Und");
            model.addColumn("Perda");
            model.addColumn("ID Pedido");

            // Centralizar conteúdo dascolunas
            centralizarConteudoColuna(0);
            centralizarConteudoColuna(3);
            centralizarConteudoColuna(4);
            centralizarConteudoColuna(5);
            centralizarConteudoColuna(6);

            //ajusta o tamanho da fonte
            int fontSize = 10; // Defina o tamanho da fonte desejado
            TableColumn column = jtb_itens.getColumnModel().getColumn(5);
            column.setCellRenderer(new CustomRenderer2(fontSize));
        }
        // Ajustar tamanho das colunas
        ajustarTamanhoColunas(this.tipoMovimentacao);
    }

    private void ajustarTamanhoColunas(String tipoMovimentacao) {
        // Definir o tamanho manual das colunas (menos da última)
        if ("compra".equals(this.tipoMovimentacao) || "venda".equals(this.tipoMovimentacao)) {
            int[] columnWidths = {5, 270, 200, 50, 10, 80};
            for (int i = 0; i < columnWidths.length; i++) {
                TableColumn column = jtb_itens.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }
        } else {
            int[] columnWidths = {50, 300, 80, 80, 100, 100};
            for (int i = 0; i < columnWidths.length; i++) {
                TableColumn column = jtb_itens.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }
        }
        // Configurar a última coluna para redimensionar automaticamente
        jtb_itens.setAutoResizeMode(jtb_itens.AUTO_RESIZE_LAST_COLUMN);
    }

    private void centralizarConteudoColuna(int columnIndex) {
        // Criar um objeto DefaultTableCellRenderer para centralizar o conteúdo da coluna
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderer à coluna específica da tabela
        jtb_itens.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);

    }

    public class CustomRenderer extends DefaultTableCellRenderer {

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

    public class CustomRenderer2 extends DefaultTableCellRenderer {

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

}
