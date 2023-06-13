package view.Item;

import apoio.CombosDAO;
import apoio.Validacao;
import dao.GrupoDAO;
import dao.ItemDAO;
import entidade.Grupo;
import entidade.Item;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import view.Estrutura.jff_pesquisar;

/**
 *
 * @author ruang
 */
public class jif_Cadastro_item extends javax.swing.JInternalFrame {

    private boolean trocaInverter = false;
    private int item_id;

    public jif_Cadastro_item() {
        initComponents();

        new CombosDAO().popularCombo("grupo", jcb_Grupo);
        jtf_conv1.setText("1");
        jtf_conv1.setEnabled(false);
        jcb_UndConv1.setEnabled(false);
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
        ToolTipManager.sharedInstance().setInitialDelay(0); // Atraso de 500 milissegundos
        ToolTipManager.sharedInstance().setDismissDelay(10000); // Duração de 3000 milissegundos
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_Descricao = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_cadastrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtf_estoque = new javax.swing.JTextField();
        jcb_Grupo = new javax.swing.JComboBox();
        jcb_Unidade_medida = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_Observacao = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtf_conv1 = new javax.swing.JTextField();
        jcb_UndConv1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jcb_UndConv2 = new javax.swing.JComboBox();
        jtf_conv2 = new javax.swing.JTextField();
        jbt_inverter = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jff_valor = new javax.swing.JFormattedTextField();
        jbt_duplicar = new javax.swing.JButton();
        jtf_estoqueMin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro - Item");
        setPreferredSize(new java.awt.Dimension(960, 500));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(931, 600));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Descrição");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Grupo");

        jtf_Descricao.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_Descricao.setForeground(new java.awt.Color(0, 0, 0));
        jtf_Descricao.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_Descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_DescricaoFocusLost(evt);
            }
        });

        jbt_fechar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_fechar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_fechar.setText("Fechar");
        jbt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_fecharActionPerformed(evt);
            }
        });

        jbt_limpar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_limpar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_limpar.setText("Limpar");
        jbt_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_limparActionPerformed(evt);
            }
        });

        jbt_cadastrar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar18x18.png"))); // NOI18N
        jbt_cadastrar.setText("Cadastrar");
        jbt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_cadastrarActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Conversão");

        jtf_estoque.setBackground(new java.awt.Color(250, 250, 250));
        jtf_estoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_estoque.setForeground(new java.awt.Color(0, 0, 0));
        jtf_estoque.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_estoque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_estoqueFocusLost(evt);
            }
        });
        jtf_estoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_estoqueKeyTyped(evt);
            }
        });

        jcb_Grupo.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Grupo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_Grupo.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Grupo.setMaximumRowCount(150);
        jcb_Grupo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_GrupoFocusLost(evt);
            }
        });

        jcb_Unidade_medida.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Unidade_medida.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Unidade_medida.setMaximumRowCount(150);
        jcb_Unidade_medida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg" }));
        jcb_Unidade_medida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_Unidade_medidaFocusLost(evt);
            }
        });
        jcb_Unidade_medida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_Unidade_medidaActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("*Unidade de medida");

        jta_Observacao.setBackground(new java.awt.Color(250, 250, 250));
        jta_Observacao.setColumns(20);
        jta_Observacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jta_Observacao.setForeground(new java.awt.Color(0, 0, 0));
        jta_Observacao.setRows(5);
        jta_Observacao.setCaretColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jta_Observacao);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Observações");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("*Estoque Inicial");

        jtf_conv1.setBackground(new java.awt.Color(250, 250, 250));
        jtf_conv1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_conv1.setForeground(new java.awt.Color(0, 0, 0));
        jtf_conv1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_conv1.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_conv1.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jcb_UndConv1.setBackground(new java.awt.Color(250, 250, 250));
        jcb_UndConv1.setForeground(new java.awt.Color(0, 0, 0));
        jcb_UndConv1.setMaximumRowCount(150);
        jcb_UndConv1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg" }));
        jcb_UndConv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_UndConv1ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("=");

        jcb_UndConv2.setBackground(new java.awt.Color(250, 250, 250));
        jcb_UndConv2.setForeground(new java.awt.Color(0, 0, 0));
        jcb_UndConv2.setMaximumRowCount(150);
        jcb_UndConv2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg" }));
        jcb_UndConv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_UndConv2ActionPerformed(evt);
            }
        });

        jtf_conv2.setBackground(new java.awt.Color(250, 250, 250));
        jtf_conv2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_conv2.setForeground(new java.awt.Color(0, 0, 0));
        jtf_conv2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_conv2.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_conv2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jtf_conv2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_conv2KeyTyped(evt);
            }
        });

        jbt_inverter.setBackground(new java.awt.Color(13, 71, 161));
        jbt_inverter.setForeground(new java.awt.Color(255, 255, 255));
        jbt_inverter.setText("Inverter");
        jbt_inverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_inverterActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("*Valor Unitário");

        jff_valor.setBackground(new java.awt.Color(250, 250, 250));
        jff_valor.setForeground(new java.awt.Color(0, 0, 0));
        jff_valor.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_valor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jff_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jff_valorFocusLost(evt);
            }
        });
        jff_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jff_valorKeyTyped(evt);
            }
        });

        jbt_duplicar.setBackground(new java.awt.Color(51, 102, 255));
        jbt_duplicar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_duplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/duplicar18x18.png"))); // NOI18N
        jbt_duplicar.setText("Duplicar um Item");
        jbt_duplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_duplicarActionPerformed(evt);
            }
        });

        jtf_estoqueMin.setBackground(new java.awt.Color(250, 250, 250));
        jtf_estoqueMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_estoqueMin.setForeground(new java.awt.Color(0, 0, 0));
        jtf_estoqueMin.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_estoqueMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_estoqueMinKeyTyped(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Estoque Mínimo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbt_cadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_duplicar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbt_limpar)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_conv1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcb_UndConv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_conv2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcb_UndConv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtf_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jcb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtf_estoqueMin, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcb_Unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)))
                .addComponent(jbt_fechar)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(393, 393, 393)
                        .addComponent(jbt_inverter))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_estoque, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jff_valor))
                        .addGap(290, 290, 290)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtf_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jtf_estoqueMin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jff_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_Unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_conv1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_UndConv1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtf_conv2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_UndConv2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_inverter)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbt_limpar)
                        .addComponent(jbt_fechar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbt_duplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel6, jtf_Descricao, jtf_estoque});

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Botão de fechar
        this.dispose();
    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_limparActionPerformed
        //Botão de limpar campos de TextField
        LimparCampos();
        jtf_Descricao.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_cadastrarActionPerformed
        //Cadastro de Item
        //Fazer as validações de campos antes de salvar.
        if (Validacao.ValidarJTFObrigatorio(jtf_Descricao)
                && Validacao.testarCombo(jcb_Grupo)
                && Validacao.ValidarJTFObrigatorio(jtf_estoque)
                && Validacao.testarCombo(jcb_Unidade_medida)
                && Validacao.ValidarJTFObrigatorio(jff_valor)
                && TestarEscolhaCB(jcb_UndConv1, jcb_UndConv2)) {

            //Atribuir dados inseridos pelo usuario a variaveis
            String descItem = jtf_Descricao.getText().toUpperCase();
            Grupo cb = (Grupo) jcb_Grupo.getSelectedItem();
            double estoqueItem = Double.parseDouble(jtf_estoque.getText().replace(',', '.'));
            String unidadeMedida = jcb_Unidade_medida.getSelectedItem().toString();
            String obs = jta_Observacao.getText();
            double valorItem = Double.parseDouble(jff_valor.getText().replace(',', '.'));
            double estoqueMinItem = Double.parseDouble(jtf_estoqueMin.getText().replace(',', '.'));

            double conv1;
            double conv2;
            String und_conv1;
            String und_conv2;
            //testar se algum campo de conversão for vazio, salvar como vazio no BD as informações de conversão
            if (jtf_conv1.getText().isEmpty() || jtf_conv2.getText().isEmpty()) {
                conv1 = 1;
                conv2 = 0;
                und_conv1 = "";
                und_conv2 = "";
            } else {
                conv1 = Double.parseDouble(jtf_conv1.getText().replace(',', '.'));
                conv2 = Double.parseDouble(jtf_conv2.getText().replace(',', '.'));
                if (jcb_UndConv1.getSelectedIndex() == 0) {
                    und_conv1 = "";
                } else {
                    und_conv1 = jcb_UndConv1.getSelectedItem().toString();
                }
                if (jcb_UndConv2.getSelectedIndex() == 0) {
                    und_conv2 = "";
                } else {
                    und_conv2 = jcb_UndConv2.getSelectedItem().toString();
                }
            }

            //Setar nomes das variaveis para o objeto Item
            Item item = new Item();
            item.setDescricao(descItem);
            item.setId_grupo(cb.getId());
            item.setQtde_estoque(estoqueItem);
            item.setUnidade_medida(unidadeMedida);
            item.setObservacao(obs);
            item.setConv1(conv1);
            item.setConv2(conv2);
            item.setUnd_conv1(und_conv1);
            item.setUnd_conv2(und_conv2);
            item.setValor(valorItem);
            item.setQtde_estoque_min(estoqueMinItem);
            item.setQtde_reserva_estoque(0);

            //Chamar classe ItemDAO para salvar dados no Banco de dados
            ItemDAO itemDAO = new ItemDAO();

            //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
            if (itemDAO.salvar(item) == null) {
                JOptionPane.showMessageDialog(this, "Novo item salvo com sucesso!", "ITEM CADASTRADO", JOptionPane.INFORMATION_MESSAGE);
                LimparCampos();
                jtf_Descricao.requestFocus();

            } else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbt_cadastrarActionPerformed

    private void jbt_inverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_inverterActionPerformed
        this.trocaInverter = !trocaInverter;
        jcb_UndConv2.setEnabled(!trocaInverter);
        jcb_UndConv1.setEnabled(trocaInverter);

        if (trocaInverter) {
            jcb_UndConv1.setSelectedIndex(jcb_UndConv2.getSelectedIndex());
            jcb_UndConv2.setSelectedIndex(jcb_Unidade_medida.getSelectedIndex());
        } else {
            jcb_UndConv2.setSelectedIndex(jcb_UndConv1.getSelectedIndex());
            jcb_UndConv1.setSelectedIndex(jcb_Unidade_medida.getSelectedIndex());
        }
        TestarEscolhaCB(jcb_UndConv1, jcb_UndConv2);

    }//GEN-LAST:event_jbt_inverterActionPerformed

    private void jcb_Unidade_medidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_Unidade_medidaActionPerformed
        if (trocaInverter) {
            jcb_UndConv2.setSelectedIndex(jcb_Unidade_medida.getSelectedIndex());
        } else {
            jcb_UndConv1.setSelectedIndex(jcb_Unidade_medida.getSelectedIndex());
        }
    }//GEN-LAST:event_jcb_Unidade_medidaActionPerformed

    private void jtf_DescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_DescricaoFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_Descricao);
    }//GEN-LAST:event_jtf_DescricaoFocusLost

    private void jcb_GrupoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_GrupoFocusLost
        Validacao.testarCombo(jcb_Grupo);
    }//GEN-LAST:event_jcb_GrupoFocusLost

    private void jtf_estoqueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_estoqueFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_estoque);
    }//GEN-LAST:event_jtf_estoqueFocusLost

    private void jcb_Unidade_medidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_Unidade_medidaFocusLost
        Validacao.testarCombo(jcb_Unidade_medida);
    }//GEN-LAST:event_jcb_Unidade_medidaFocusLost

    private void jff_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_valorFocusLost
        Validacao.ValidarJTFObrigatorio(jff_valor);
    }//GEN-LAST:event_jff_valorFocusLost

    private void jff_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jff_valorKeyTyped
        Validacao.ValidarDecimal(jff_valor, evt);
    }//GEN-LAST:event_jff_valorKeyTyped

    private void jtf_estoqueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_estoqueKeyTyped
        Validacao.ValidarDecimal(jtf_estoque, evt);
    }//GEN-LAST:event_jtf_estoqueKeyTyped

    private void jtf_conv2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_conv2KeyTyped
        Validacao.ValidarDecimal(jtf_conv2, evt);
    }//GEN-LAST:event_jtf_conv2KeyTyped

    private void jcb_UndConv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_UndConv2ActionPerformed
        TestarEscolhaCB(jcb_UndConv1, jcb_UndConv2);

    }//GEN-LAST:event_jcb_UndConv2ActionPerformed

    private void jcb_UndConv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_UndConv1ActionPerformed
        TestarEscolhaCB(jcb_UndConv1, jcb_UndConv2);
    }//GEN-LAST:event_jcb_UndConv1ActionPerformed

    private void jbt_duplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_duplicarActionPerformed
        jff_pesquisar pesquisar = new jff_pesquisar(this);
        pesquisar.setVisible(true);
    }//GEN-LAST:event_jbt_duplicarActionPerformed

    private void jtf_estoqueMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_estoqueMinKeyTyped
        Validacao.ValidarDecimal(jtf_estoqueMin, evt);
    }//GEN-LAST:event_jtf_estoqueMinKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbt_cadastrar;
    private javax.swing.JButton jbt_duplicar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_inverter;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JComboBox jcb_Grupo;
    private javax.swing.JComboBox jcb_UndConv1;
    private javax.swing.JComboBox jcb_UndConv2;
    private javax.swing.JComboBox jcb_Unidade_medida;
    private javax.swing.JFormattedTextField jff_valor;
    private javax.swing.JTextArea jta_Observacao;
    private javax.swing.JTextField jtf_Descricao;
    private javax.swing.JTextField jtf_conv1;
    private javax.swing.JTextField jtf_conv2;
    private javax.swing.JTextField jtf_estoque;
    private javax.swing.JTextField jtf_estoqueMin;
    // End of variables declaration//GEN-END:variables

    private void LimparCampos() {
        jtf_Descricao.setText("");
        jcb_Grupo.setSelectedIndex(0);
        jtf_estoque.setText("");
        jcb_Unidade_medida.setSelectedIndex(0);
        jta_Observacao.setText("");
        jff_valor.setText("");
        jtf_estoqueMin.setText("");
        jcb_UndConv1.setSelectedIndex(0);
        jcb_UndConv2.setSelectedIndex(0);
        jtf_conv2.setText("");
    }

    //Testa se o Combo de conversão for igual ao Combo de Unidade de medida.
    public boolean TestarEscolhaCB(JComboBox jcombo_conv1, JComboBox jcombo_conv2) {
        jcombo_conv1.setBackground(Color.white);
        jcombo_conv2.setBackground(Color.white);

        if (trocaInverter) {
            if (jcombo_conv1.getSelectedIndex() == jcombo_conv2.getSelectedIndex()) {
                jcombo_conv1.setBackground(Color.decode("#FF9696"));
                jcombo_conv1.setRenderer(new TooltipComboBoxRenderer());
                return false;
            } else {
                jcombo_conv1.setBackground(Color.white);
                jcombo_conv1.setRenderer(new CustomComboBoxRenderer());
                return true;
            }
        } else {
            if (jcombo_conv1.getSelectedIndex() == jcombo_conv2.getSelectedIndex()) {
                jcombo_conv2.setBackground(Color.decode("#FF9696"));
                jcombo_conv2.setRenderer(new TooltipComboBoxRenderer());
                return false;
            } else {
                jcombo_conv2.setBackground(Color.white);
                jcombo_conv2.setRenderer(new CustomComboBoxRenderer());
                return true;
            }
        }
    }
    //Mostra uma ToolTip no CB caso o teste TestarEscolhaCB mostre que os dois CB são iguais

    static class TooltipComboBoxRenderer extends BasicComboBoxRenderer {

        private static final String TOOLTIP_TEXT = "<html>Você não pode selecionar no campo de CONVERSÃO a mesma unidade de medida<br> que está selecionada no campo 'UNIDADE DE MEDIDA'.<br><br>Selecione outra Unidade de medida de Conversão!</html>";

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
                list.setToolTipText(TOOLTIP_TEXT);
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setFont(list.getFont());
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    //Retira a ToolTip no CB caso o teste TestarEscolhaCB mostre que os dois CB são diferentes
    static class CustomComboBoxRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
                list.setToolTipText(null);
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setFont(list.getFont());
            setText((value == null) ? "" : value.toString());
            return this;
        }

    }

    public void DuplicarItem(int item_dup_id) {
        this.item_id = item_dup_id;
        Item item = new ItemDAO().consultarId(this.item_id);
        LimparCampos();

        //Recuperar os valores do ID selecionado na tabela e setando eles nos TextsFields para alteração
        int index = new ItemDAO().indexCBUnidadeMedida(item.getUnidade_medida());
        System.out.println(index);
        int indexUC1 = new ItemDAO().indexCBUnidadeMedida(item.getUnd_conv1());
        int indexUC2 = new ItemDAO().indexCBUnidadeMedida(item.getUnd_conv2());
        jtf_Descricao.setText(item.getDescricao() + " (CÓPIA)");
        jtf_estoque.setText(new DecimalFormat("#.####").format(item.getQtde_estoque()).replace('.', ','));
        jtf_estoqueMin.setText(new DecimalFormat("#.####").format(item.getQtde_estoque_min()).replace('.', ','));
        jta_Observacao.setText(item.getObservacao());
        jtf_conv1.setText(new DecimalFormat("#.####").format(item.getConv1()).replace('.', ','));
        jtf_conv2.setText(new DecimalFormat("#.####").format(item.getConv2()).replace('.', ','));
        jcb_Unidade_medida.setSelectedIndex(index);
        jcb_UndConv1.setSelectedIndex(indexUC1);
        jcb_UndConv2.setSelectedIndex(indexUC2);
        jff_valor.setText(new DecimalFormat("#.####").format(item.getValor()).replace('.', ','));
        if (jcb_Unidade_medida.getSelectedIndex() == jcb_UndConv2.getSelectedIndex()) {
            this.trocaInverter = true;
            jcb_UndConv2.setEnabled(!trocaInverter);
            jcb_UndConv1.setEnabled(trocaInverter);
        } else {
            this.trocaInverter = false;
            jcb_UndConv2.setEnabled(!trocaInverter);
            jcb_UndConv1.setEnabled(trocaInverter);
        }
        //retornar o valor selecionado ao Combo Box GRUPO
        new CombosDAO().popularCombo("grupo", jcb_Grupo);
        Grupo cb = new Grupo();
        cb.setId(item.getId_grupo());
        cb.setDescricao(new GrupoDAO().consultarId(item.getId_grupo()).getDescricao());
        new CombosDAO().definirComboGrupo(jcb_Grupo, cb);
    }
}
