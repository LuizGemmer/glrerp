package view.Item;

import apoio.CombosDAO;
import apoio.Validacao;
import dao.EstruturaDAO;
import dao.GrupoDAO;
import dao.ItemDAO;
import entidade.Estrutura;
import entidade.Grupo;
import entidade.Item;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import view.Estrutura.jff_pesquisar;
import view.jff_ITelaAlterarCadastro;
import view.jif_Listagem_DAO;

/**
 *
 * @author ruang
 */
public class jff_Alterar_item extends javax.swing.JFrame implements jff_ITelaAlterarCadastro {

    private jif_Listagem_DAO parente;
    private boolean trocaInverter = false;
    private Item item;
    private boolean keyPressed;
    private boolean inativarControles;
    private boolean confirma_exclusao;
    Color buttonDisableColor = new Color(51, 51, 51);
    Color buttonBlueColor = new Color(13, 71, 161);
    Color buttonRedColor = new Color(153, 0, 0);

    public jff_Alterar_item() {
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
        UIManager.put("ComboBox.disabledBackground", Color.RGBtoHSB(250, 250, 250, null));
        initComponents();

        ToolTipManager.sharedInstance().setInitialDelay(100); // Atraso de 500 milissegundos
        ToolTipManager.sharedInstance().setDismissDelay(10000); // Duração de 3000 milissegundos
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_Descricao = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_salvar_alteracao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtf_estoque = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jll_id = new javax.swing.JLabel();
        jbt_excluir = new javax.swing.JButton();
        jcb_Grupo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_Observacao = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jcb_Unidade_medida = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtf_conv1 = new javax.swing.JTextField();
        jcb_UndConv1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jtf_conv2 = new javax.swing.JTextField();
        jcb_UndConv2 = new javax.swing.JComboBox();
        jbt_inverter = new javax.swing.JButton();
        jff_valor = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtf_estoqueMin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jInternalFrame1.setBackground(new java.awt.Color(238, 238, 238));
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Alterar/Excluir");
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(960, 600));
        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

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
        jtf_Descricao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_Descricao.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtf_Descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_DescricaoFocusLost(evt);
            }
        });
        jtf_Descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_DescricaoKeyPressed(evt);
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

        jbt_salvar_alteracao.setBackground(new java.awt.Color(13, 71, 161));
        jbt_salvar_alteracao.setForeground(new java.awt.Color(255, 255, 255));
        jbt_salvar_alteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar18x18.png"))); // NOI18N
        jbt_salvar_alteracao.setText("Alterar cadastro");
        jbt_salvar_alteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_salvar_alteracaoActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Estoque Atual");

        jtf_estoque.setBackground(new java.awt.Color(250, 250, 250));
        jtf_estoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_estoque.setForeground(new java.awt.Color(0, 0, 0));
        jtf_estoque.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_estoque.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(187, 187, 187));
        jLabel7.setText("ID");

        jll_id.setBackground(new java.awt.Color(238, 238, 238));
        jll_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jll_id.setToolTipText("");
        jll_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jll_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jll_id, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jbt_excluir.setBackground(new java.awt.Color(153, 0, 0));
        jbt_excluir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir18x18.png"))); // NOI18N
        jbt_excluir.setText("Excluir cadastro");
        jbt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_excluirActionPerformed(evt);
            }
        });

        jcb_Grupo.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Grupo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_Grupo.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Grupo.setMaximumRowCount(150);
        jcb_Grupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcb_Grupo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_GrupoFocusLost(evt);
            }
        });
        jcb_Grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_GrupoActionPerformed(evt);
            }
        });

        jta_Observacao.setBackground(new java.awt.Color(250, 250, 250));
        jta_Observacao.setColumns(20);
        jta_Observacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jta_Observacao.setForeground(new java.awt.Color(0, 0, 0));
        jta_Observacao.setRows(5);
        jta_Observacao.setCaretColor(new java.awt.Color(0, 0, 0));
        jta_Observacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jta_ObservacaoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jta_Observacao);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Observações");

        jcb_Unidade_medida.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Unidade_medida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_Unidade_medida.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Unidade_medida.setMaximumRowCount(150);
        jcb_Unidade_medida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg" }));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Unidade de medida");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Conversão");

        jtf_conv1.setBackground(new java.awt.Color(250, 250, 250));
        jtf_conv1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_conv1.setForeground(new java.awt.Color(0, 0, 0));
        jtf_conv1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_conv1.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_conv1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jtf_conv1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_conv1KeyPressed(evt);
            }
        });

        jcb_UndConv1.setBackground(new java.awt.Color(250, 250, 250));
        jcb_UndConv1.setForeground(new java.awt.Color(0, 0, 0));
        jcb_UndConv1.setMaximumRowCount(150);
        jcb_UndConv1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg" }));
        jcb_UndConv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_UndConv1ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("=");

        jtf_conv2.setBackground(new java.awt.Color(250, 250, 250));
        jtf_conv2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_conv2.setForeground(new java.awt.Color(0, 0, 0));
        jtf_conv2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_conv2.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_conv2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jtf_conv2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_conv2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_conv2KeyTyped(evt);
            }
        });

        jcb_UndConv2.setBackground(new java.awt.Color(250, 250, 250));
        jcb_UndConv2.setForeground(new java.awt.Color(0, 0, 0));
        jcb_UndConv2.setMaximumRowCount(150);
        jcb_UndConv2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg" }));
        jcb_UndConv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_UndConv2ActionPerformed(evt);
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

        jff_valor.setBackground(new java.awt.Color(250, 250, 250));
        jff_valor.setForeground(new java.awt.Color(0, 0, 0));
        jff_valor.setToolTipText("<html><p>O \"<b>VALOR UNITÁRIO</b>\" é atualizado automaticamente quando é feita uma nova compra do item</p>\n<br><br>\n<p>O valor novo é um valor ponderado, feito pela fórmula abaixo:</p>\n<p><b> [(Ea x Pa) + (Cn + Pn)] / (Ea + Cn) </b></p>\n<br>\n<p> Onde:\n<br> Ea = Estoque anterior a compra\n<br> Pa = Preço da compra anterior\n<br> Cn = Quantidade da nova compra\n<br> Pn = Preço da nova compra\n<br><br>\nMas você pode alterar esse valor manualmente mesmo assim.</p>\n</html>");
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

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("*Valor Unitário");
        jLabel11.setToolTipText("<html><p>O \"<b>VALOR UNITÁRIO</b>\" é atualizado automaticamente quando é feita uma nova compra do item</p> <br><br> <p>O valor novo é um valor ponderado, feito pela fórmula abaixo:</p> <p><b> [(Ea x Pa) + (Cn + Pn)] / (Ea + Cn) </b></p> <br> <p> Onde: <br> Ea = Estoque anterior a compra <br> Pa = Preço da compra anterior <br> Cn = Quantidade da nova compra <br> Pn = Preço da nova compra <br><br> Mas você pode alterar esse valor manualmente mesmo assim.</p> </html>");

        jtf_estoqueMin.setBackground(new java.awt.Color(250, 250, 250));
        jtf_estoqueMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_estoqueMin.setForeground(new java.awt.Color(0, 0, 0));
        jtf_estoqueMin.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_estoqueMin.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jtf_estoqueMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_estoqueMinKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_estoqueMinKeyTyped(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Estoque Mínimo");
        jLabel12.setToolTipText("<html><p>O \"<b>VALOR UNITÁRIO</b>\" é atualizado automaticamente quando é feita uma nova compra do item</p> <br><br> <p>O valor novo é um valor ponderado, feito pela fórmula abaixo:</p> <p><b> [(Ea x Pa) + (Cn + Pn)] / (Ea + Cn) </b></p> <br> <p> Onde: <br> Ea = Estoque anterior a compra <br> Pa = Preço da compra anterior <br> Cn = Quantidade da nova compra <br> Pn = Preço da nova compra <br><br> Mas você pode alterar esse valor manualmente mesmo assim.</p> </html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbt_salvar_alteracao)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbt_limpar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_Descricao, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_estoque)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcb_Unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_conv1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jcb_UndConv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtf_conv2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcb_UndConv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbt_inverter))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jff_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtf_estoqueMin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbt_fechar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtf_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jff_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jtf_estoqueMin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_conv1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_UndConv1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtf_conv2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_UndConv2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_inverter)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_Unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbt_salvar_alteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbt_limpar)
                        .addComponent(jbt_fechar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Botão de fechar
        if (inativarControles == false && keyPressed) {
            Object[] options = {"Sim",
                "Não"};
            int n = JOptionPane.showOptionDialog(this,
                    "Você pode ter alterações não salvas. Tem certeza que deseja sair?",
                    "ALTERAÇÕES NÃO SALVAS",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (n == 0) {
                this.dispose();
                keyPressed = false;
            } else {
                jtf_Descricao.requestFocus(true);
            }
        } else {
            this.dispose();
        }

    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_limparActionPerformed
        //Botão de limpar campos de TextField
        jtf_Descricao.setText("");
        jcb_Grupo.setSelectedIndex(0);
        jta_Observacao.setText("");
        jff_valor.setText("");
        jtf_estoqueMin.setText("");
        jtf_Descricao.requestFocus();

    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_salvar_alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvar_alteracaoActionPerformed
        //Alterar cadastro de Item
        //Fazer as validações de campos antes de salvar.
        //new CombosDAO().popularCombo("grupo", jcb_Grupo);
        if (Validacao.ValidarJTFObrigatorio(jtf_Descricao)
                && Validacao.testarCombo(jcb_Grupo)
                && Validacao.ValidarJTFObrigatorio(jtf_estoque)
                && Validacao.testarCombo(jcb_Unidade_medida)
                && Validacao.ValidarJTFObrigatorio(jff_valor)
                && TestarEscolhaCB(jcb_UndConv1, jcb_UndConv2)) {

            //Atribuir dados inseridos pelo usuario a variaveis
            String descItem = jtf_Descricao.getText().toUpperCase();
            Grupo cb = (Grupo) jcb_Grupo.getSelectedItem();
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
            item.setId(Integer.parseInt(jll_id.getText()));
            item.setDescricao(descItem);
            item.setId_grupo(cb.getId());
            item.setObservacao(obs);
            item.setConv1(conv1);
            item.setConv2(conv2);
            item.setUnd_conv1(und_conv1);
            item.setUnd_conv2(und_conv2);
            item.setValor(valorItem);
            item.setQtde_estoque_min(estoqueMinItem);

            //Chamar classe ItemDAO para salvar dados no Banco de dados
            ItemDAO itemDAO = new ItemDAO();

            //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
            if (itemDAO.atualizar(item) == null) {
                JOptionPane.showMessageDialog(this, "Cadastro alterado com sucesso!", "CADASTRADO ALTERADO", JOptionPane.INFORMATION_MESSAGE);
                this.parente.setTableItems("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbt_salvar_alteracaoActionPerformed

    private void jbt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_excluirActionPerformed
        //pegar do JTL o ID do item
        String id = jll_id.getText();
        int id_item = Integer.parseInt(id);

        Estrutura estrutura = new EstruturaDAO().consultarIdInsumo(id_item);

        //Verificar se o item a ser Excluído esta cadastrado como um INSUMO na tela de estrutura
        //Caso Positivo, irá abrir a tela mostrando os produtos que possuem o item a ser excluído como Insumo
        //Caso negativo continua com a exclusão.
        System.out.println(estrutura.getItem_id());
        if (estrutura.getItem_id() > 0) {
            jff_pesquisar jff_pesquisar = new jff_pesquisar(this, id_item);
            jff_pesquisar.setVisible(true);
        } else {
            ExcluirCadastroItem(true);
        }
    }//GEN-LAST:event_jbt_excluirActionPerformed

    public void ExcluirCadastroItem(boolean confirmar) {
        this.confirma_exclusao = confirmar;
        //pegar do JTL o ID do item
        String id = jll_id.getText();
        int id_item = Integer.parseInt(id);
        Estrutura estrutura = new EstruturaDAO().consultarIdInsumo(id_item);

        if (this.confirma_exclusao) {
            if (estrutura.getItem_id() > 0) {
                //Excluir cadastro
                //Setar SITUAÇÃO=FALSE mo objeto
                Item item = new Item();
                item.setId(Integer.parseInt(jll_id.getText()));
                item.setAtivo(false);

                //Chamar classe ItemDAO para salvar dados no Banco de dados
                ItemDAO itemDAO = new ItemDAO();

                //Verifica se a exclusão foi bem sucessido e fecha a tela. Caso contrário apresenta mensagem de erro
                if (itemDAO.excluir(Integer.parseInt(jll_id.getText())) == null) {
                    JOptionPane.showMessageDialog(this, "Cadastro excluido com sucesso!", "CADASTRADO EXCLUÍDO", JOptionPane.INFORMATION_MESSAGE);
                    this.parente.setTableItems("");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                Object[] options = {"Sim",
                    "Não"};
                int n = JOptionPane.showOptionDialog(this,
                        "Essa exclusão é IRREVERSÍVEL. Deseja continuar?",
                        "EXCLUSÃO DE CADASTRO",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (n == 0) {
                    //Excluir cadastro
                    //Setar SITUAÇÃO=FALSE mo objeto
                    Item item = new Item();
                    item.setId(Integer.parseInt(jll_id.getText()));
                    item.setAtivo(false);

                    //Chamar classe ItemDAO para salvar dados no Banco de dados
                    ItemDAO itemDAO = new ItemDAO();

                    //Verifica se a exclusão foi bem sucessido e fecha a tela. Caso contrário apresenta mensagem de erro
                    if (itemDAO.excluir(Integer.parseInt(jll_id.getText())) == null) {
                        JOptionPane.showMessageDialog(this, "Cadastro excluido com sucesso!", "CADASTRADO EXCLUÍDO", JOptionPane.INFORMATION_MESSAGE);
                        this.parente.setTableItems("");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Exclusão cancelada. Cadastro permanece ativo!", "EXCLUSÃO CANCELADA", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void jtf_DescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_DescricaoKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_DescricaoKeyPressed

    private void jcb_GrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_GrupoActionPerformed
        this.keyPressed = true;
    }//GEN-LAST:event_jcb_GrupoActionPerformed

    private void jta_ObservacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jta_ObservacaoKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jta_ObservacaoKeyPressed

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

    private void jtf_DescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_DescricaoFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_Descricao);
    }//GEN-LAST:event_jtf_DescricaoFocusLost

    private void jcb_GrupoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_GrupoFocusLost
        Validacao.testarCombo(jcb_Grupo);
    }//GEN-LAST:event_jcb_GrupoFocusLost

    private void jtf_conv1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_conv1KeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_conv1KeyPressed

    private void jtf_conv2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_conv2KeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_conv2KeyPressed

    private void jcb_UndConv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_UndConv1ActionPerformed
        this.keyPressed = true;
        TestarEscolhaCB(jcb_UndConv1, jcb_UndConv2);
    }//GEN-LAST:event_jcb_UndConv1ActionPerformed

    private void jcb_UndConv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_UndConv2ActionPerformed
        this.keyPressed = true;
        TestarEscolhaCB(jcb_UndConv1, jcb_UndConv2);
    }//GEN-LAST:event_jcb_UndConv2ActionPerformed

    private void jff_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_valorFocusLost
        Validacao.ValidarJTFObrigatorio(jff_valor);
    }//GEN-LAST:event_jff_valorFocusLost

    private void jff_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jff_valorKeyTyped
        Validacao.ValidarDecimal(jff_valor, evt);
        this.keyPressed = true;
    }//GEN-LAST:event_jff_valorKeyTyped

    private void jtf_conv2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_conv2KeyTyped
        Validacao.ValidarDecimal(jtf_conv2, evt);
    }//GEN-LAST:event_jtf_conv2KeyTyped

    private void jtf_estoqueMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_estoqueMinKeyTyped
        Validacao.ValidarDecimal(jtf_estoqueMin, evt);
    }//GEN-LAST:event_jtf_estoqueMinKeyTyped

    private void jtf_estoqueMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_estoqueMinKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_estoqueMinKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_inverter;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JButton jbt_salvar_alteracao;
    private javax.swing.JComboBox jcb_Grupo;
    private javax.swing.JComboBox jcb_UndConv1;
    private javax.swing.JComboBox jcb_UndConv2;
    private javax.swing.JComboBox jcb_Unidade_medida;
    private javax.swing.JFormattedTextField jff_valor;
    private javax.swing.JLabel jll_id;
    private javax.swing.JTextArea jta_Observacao;
    private javax.swing.JTextField jtf_Descricao;
    private javax.swing.JTextField jtf_conv1;
    private javax.swing.JTextField jtf_conv2;
    private javax.swing.JTextField jtf_estoque;
    private javax.swing.JTextField jtf_estoqueMin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDAO(Object dao) {
        this.item = (Item) dao;
        int index = new ItemDAO().indexCBUnidadeMedida(this.item.getUnidade_medida());
        int indexUC1 = new ItemDAO().indexCBUnidadeMedida(this.item.getUnd_conv1());
        int indexUC2 = new ItemDAO().indexCBUnidadeMedida(this.item.getUnd_conv2());

        //Ajustar comportamento dos botões e labels
        jtf_conv1.setEnabled(false);
        jcb_Unidade_medida.setEnabled(false);
        jtf_estoque.setEditable(false);
        jbt_salvar_alteracao.setText("Alterar Cadastro");
        jbt_excluir.setVisible(true);
        this.trocaInverter = false;

        //Recuperar os valores do ID selecionado na tabela e setando eles nos TextsFields para alteração
        jll_id.setText("" + this.item.getId());
        jtf_Descricao.setText(this.item.getDescricao());
        jtf_estoque.setText(new DecimalFormat("#.####").format(this.item.getQtde_estoque()).replace('.', ','));
        jta_Observacao.setText(this.item.getObservacao());
        jtf_conv1.setText(new DecimalFormat("#.####").format(this.item.getConv1()).replace('.', ','));
        jtf_conv2.setText(new DecimalFormat("#.####").format(this.item.getConv2()).replace('.', ','));
        jcb_Unidade_medida.setSelectedIndex(index);
        jcb_UndConv1.setSelectedIndex(indexUC1);
        jcb_UndConv2.setSelectedIndex(indexUC2);
        jff_valor.setText(new DecimalFormat("#.####").format(this.item.getValor()).replace('.', ','));
        jtf_estoqueMin.setText(new DecimalFormat("#.####").format(this.item.getQtde_estoque_min()).replace('.', ','));

        //retornar o valor selecionado ao Combo Box GRUPO
        new CombosDAO().popularCombo("grupo", jcb_Grupo);
        Grupo cb = new Grupo();
        cb.setId(this.item.getId_grupo());
        cb.setDescricao(new GrupoDAO().consultarId(this.item.getId_grupo()).getDescricao());
        new CombosDAO().definirComboGrupo(jcb_Grupo, cb);

        //Impede a alteração da unidade de conversão caso esta já estaja salva. Caso não tenha sido salva, permite a edição
        if (this.item.getConv2() != 0) {
            jtf_conv1.setEnabled(false);
            jtf_conv2.setEnabled(false);
            jcb_UndConv1.setEnabled(false);
            jcb_UndConv2.setEnabled(false);
            jbt_inverter.setEnabled(false);
            jbt_inverter.setBackground(buttonDisableColor);
        } else {
            if (jcb_UndConv1.getSelectedIndex() == jcb_Unidade_medida.getSelectedIndex()) {
                jcb_UndConv1.setEnabled(false);
                jtf_conv2.setEnabled(true);
            } else if (jcb_UndConv2.getSelectedIndex() == jcb_Unidade_medida.getSelectedIndex()) {
                jcb_UndConv2.setEnabled(false);
                jtf_conv2.setEnabled(true);
            } else {
                jtf_conv1.setEnabled(false);
                jcb_UndConv1.setEnabled(false);
                jcb_UndConv1.setSelectedIndex(index);
                jtf_conv2.setEnabled(true);
            }
        }
        keyPressed = false;
    }

    @Override
    public void setDetalhamento(boolean inativarControles) {
        this.inativarControles = inativarControles;
        if (inativarControles) {
            jInternalFrame1.setTitle("Detalhar Cadastro");
            jbt_excluir.setBackground(buttonDisableColor);
            jbt_salvar_alteracao.setBackground(buttonDisableColor);
            jbt_inverter.setBackground(buttonDisableColor);
            jbt_limpar.setBackground(buttonDisableColor);
        } else {
            jInternalFrame1.setTitle("Alterar/Excluir");
            jbt_excluir.setBackground(buttonRedColor);
            jbt_salvar_alteracao.setBackground(buttonBlueColor);
            jbt_inverter.setBackground(buttonBlueColor);
            jbt_limpar.setBackground(buttonBlueColor);
        }
        jtf_Descricao.setEditable(!inativarControles);
        jtf_estoqueMin.setEditable(!inativarControles);
        jcb_Grupo.setEnabled(!inativarControles);
        jta_Observacao.setEditable(!inativarControles);
        jcb_UndConv1.setEnabled(!inativarControles);
        jcb_UndConv2.setEnabled(!inativarControles);
        jtf_conv2.setEditable(!inativarControles);
        jbt_inverter.setEnabled(!inativarControles);
        jbt_excluir.setEnabled(!inativarControles);
        jbt_limpar.setEnabled(!inativarControles);
        jff_valor.setEditable(!inativarControles);
        jbt_salvar_alteracao.setEnabled(!inativarControles);
        keyPressed = false;
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

}
