package view.Movimentacao;

import apoio.Formatacao;
import dao.ClienteDAO;
import dao.ItemDAO;
import dao.movimentacaoDAO;
import entidade.Item;
import entidade.Movimentacao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import view.jff_ITelaAlterarCadastro;
import view.jif_Listagem_DAO;

/**
 *
 * @author ruang
 */
public class jff_Visualizar_movimentacao extends javax.swing.JFrame implements jff_ITelaAlterarCadastro {
    
    private String tipoMovimentacao; //Retorna, ao abrir essa tela, qual o tipo de movimentação (compra, venda ou producao)
    private int linhasTabela = 1;
    private int idGrupoMovimentacao;
    private jif_Listagem_DAO parente;
    private Item item;
    private Movimentacao movimentacao;
    private movimentacaoDAO dao;
    private ArrayList<Movimentacao> mov;

    //Criação da tabela contendo os itens
    private static ArrayList<Object[]> dados = new ArrayList<>();
    private static DefaultTableModel model;
    
    public jff_Visualizar_movimentacao(String tipoMovimentacao, int idItem) {
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
        jlb_ValorTotal1 = new javax.swing.JLabel();
        jtf_SomaItens = new javax.swing.JTextField();
        jtf_pedido = new javax.swing.JTextField();
        jlb_Data1 = new javax.swing.JLabel();
        jlb_cliente_fornecedor1 = new javax.swing.JLabel();
        jtf_movimentacao = new javax.swing.JTextField();

        setTitle("Cadastro - Estrutura");
        setBackground(new java.awt.Color(238, 238, 238));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));

        jlb_cliente_fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        jlb_cliente_fornecedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_cliente_fornecedor.setText("Cliente");

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
        jff_Data.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jff_Data.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_Data.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jff_Data.setEnabled(false);
        jff_Data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jlb_Data.setForeground(new java.awt.Color(0, 0, 0));
        jlb_Data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_Data.setText("Data e Hora");

        jff_Hora.setBackground(new java.awt.Color(250, 250, 250));
        jff_Hora.setForeground(new java.awt.Color(0, 0, 0));
        jff_Hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jff_Hora.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_Hora.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jff_Hora.setEnabled(false);
        jff_Hora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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

        jtf_pedido.setBackground(new java.awt.Color(250, 250, 250));
        jtf_pedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_pedido.setForeground(new java.awt.Color(0, 0, 0));
        jtf_pedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_pedido.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_pedido.setEnabled(false);

        jlb_Data1.setForeground(new java.awt.Color(0, 0, 0));
        jlb_Data1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_Data1.setText("Pedido");

        jlb_cliente_fornecedor1.setForeground(new java.awt.Color(0, 0, 0));
        jlb_cliente_fornecedor1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_cliente_fornecedor1.setText("Movimentação");

        jtf_movimentacao.setBackground(new java.awt.Color(250, 250, 250));
        jtf_movimentacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_movimentacao.setForeground(new java.awt.Color(0, 0, 0));
        jtf_movimentacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_movimentacao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_movimentacao.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlb_ValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtf_SomaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(jbt_fechar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlb_ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtf_SomaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlb_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlb_cliente_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jff_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jff_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlb_Data1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jtf_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jlb_cliente_fornecedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtf_movimentacao)
                                .addComponent(jtf_cpf_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(jtf_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_movimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_cliente_fornecedor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_cliente_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_cpf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jff_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jff_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_Data1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_ValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_SomaValor, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jbt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_ValorTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_SomaItens, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(608, 608, 608))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Botão de fechar
        this.dispose();
    }//GEN-LAST:event_jbt_fecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JFormattedTextField jff_Data;
    private javax.swing.JFormattedTextField jff_Hora;
    private javax.swing.JLabel jlb_Data;
    private javax.swing.JLabel jlb_Data1;
    private javax.swing.JLabel jlb_ValorTotal;
    private javax.swing.JLabel jlb_ValorTotal1;
    private javax.swing.JLabel jlb_cliente_fornecedor;
    private javax.swing.JLabel jlb_cliente_fornecedor1;
    private javax.swing.JTable jtb_itens;
    private javax.swing.JTextField jtf_SomaItens;
    private javax.swing.JTextField jtf_SomaValor;
    private javax.swing.JTextField jtf_cpf_cliente;
    private javax.swing.JTextField jtf_id_cliente;
    private javax.swing.JTextField jtf_movimentacao;
    private javax.swing.JTextField jtf_nome_cliente;
    private javax.swing.JTextField jtf_pedido;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDAO(Object dao) {
        this.dao = new movimentacaoDAO();
        this.movimentacao = (Movimentacao) dao;
        this.idGrupoMovimentacao = movimentacao.getId_grupo_movimentacao();
        this.mov = new movimentacaoDAO().consultarIdGrupoMovimentacao(this.idGrupoMovimentacao);
        this.tipoMovimentacao = mov.get(0).getTipo();
        
        jff_Data.setText(mov.get(0).getData().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
        jff_Hora.setText(mov.get(0).getData().format(DateTimeFormatter.ofPattern("HH:mm")));
        jtf_pedido.setText(String.valueOf(mov.get(0).getId_pedido()));
        jtf_movimentacao.setText(String.valueOf(this.idGrupoMovimentacao));
        
        if (!this.tipoMovimentacao.equals("producao")) {
            jtf_id_cliente.setText(String.valueOf(mov.get(0).getCliente_id()));
            jtf_nome_cliente.setText(new ClienteDAO().consultarIdComInativos(mov.get(0).getCliente_id()).getNome());
            jtf_cpf_cliente.setText(String.valueOf(new ClienteDAO().consultarIdComInativos(mov.get(0).getCliente_id()).getCpf()));
        }
        
        model.setRowCount(0);
        for (Movimentacao movimentacao : this.mov) {
            Object[] rowData;
            item = new ItemDAO().consultarId(movimentacao.getItem_id());
            String idDescricaoItem = item.getId() + " --|-- " + item.getDescricao();
             String subTotal;
             double qtde;
            if(movimentacao.getQtde()<0){
                qtde = movimentacao.getQtde() *-1;
                subTotal = Formatacao.formatarDecimal2casasRS(movimentacao.getValor() * qtde);
                
            } else{
                subTotal = Formatacao.formatarDecimal2casasRS(movimentacao.getValor() * movimentacao.getQtde());
                qtde = movimentacao.getQtde();
            }
                        
            if ("compra".equals(this.tipoMovimentacao) || "venda".equals(this.tipoMovimentacao)) {
                rowData = new Object[]{
                    this.linhasTabela,
                    idDescricaoItem,
                    movimentacao.getObservacao(),
                    Formatacao.formatarDecimal4casas(qtde),
                    item.getUnidade_medida(),
                    Formatacao.formatarDecimal2casasRS(movimentacao.getValor()),
                    subTotal
                };
            } else {
                rowData = new Object[]{
                    this.linhasTabela,
                    idDescricaoItem,
                    movimentacao.getObservacao(),
                    Formatacao.formatarDecimal4casas(qtde),
                    item.getUnidade_medida(),
                    Formatacao.formatarDecimal4casas(movimentacao.getPerdas()),
                    movimentacao.getId_pedido()
                };
            }
            model.addRow(rowData);
            this.linhasTabela++;
        }
        
        jtf_SomaValor.setText(Formatacao.formatarDecimal2casasRS(SomarTotalValorTabela()));
        jtf_SomaItens.setText(String.valueOf(model.getRowCount()));
    }
    
    @Override
    public void setDetalhamento(boolean inativarControles) {
        
    }
    
    @Override
    public void setTelaParente(jif_Listagem_DAO tela) {
        this.parente = tela;
    }
    
    @Override
    public void showWindow(boolean s) {
        //Abrir novo JFrame na mesma localização do JFrame anterior
        this.setLocation(this.parente.getLocationOnScreen());
        this.setVisible(s);
    }
    
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
        jtf_SomaValor.setVisible(true);
        jlb_ValorTotal.setVisible(true);
        
        if ("compra".equals(this.tipoMovimentacao)) {
            this.setTitle("Nova Movimentação - COMPRA");
            jlb_cliente_fornecedor.setText("*Fornecedor");
            
        } else if ("venda".equals(this.tipoMovimentacao)) {
            this.setTitle("Nova Movimentação - VENDA");
            jlb_cliente_fornecedor.setText("*Cliente");
            
        } else if ("producao".equals(this.tipoMovimentacao)) {
            this.setTitle("Nova Movimentação - PRODUÇÃO");
            jlb_cliente_fornecedor.setText("Pedido");
            jtf_cpf_cliente.setEnabled(false);
            jtf_nome_cliente.setEnabled(false);
            jtf_cpf_cliente.setEnabled(false);
            jtf_SomaValor.setVisible(false);
            jlb_ValorTotal.setVisible(false);
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
