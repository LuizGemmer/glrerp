package view.Item;

import apoio.ComboItem;
import apoio.CombosDAO;
import apoio.IDAOT;
import apoio.Validacao;
import dao.GrupoDAO;
import dao.GrupoDAO;
import dao.ItemDAO;
import entidade.Grupo;
import entidade.Grupo;
import entidade.Item;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.text.DecimalFormat;
import javax.swing.UIManager;
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

    public jff_Alterar_item() {
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
        initComponents();
        jtf_conv1.setEnabled(false);
        jcb_Unidade_medida.setEnabled(false);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jLabel1.setText("*Descrição");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("*Grupo");

        jtf_Descricao.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_Descricao.setForeground(new java.awt.Color(0, 0, 0));
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
        jbt_salvar_alteracao.setText("Alterar cadastro");
        jbt_salvar_alteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_salvar_alteracaoActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("*Estoque");

        jtf_estoque.setBackground(new java.awt.Color(250, 250, 250));
        jtf_estoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_estoque.setForeground(new java.awt.Color(0, 0, 0));
        jtf_estoque.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_estoque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_estoqueFocusLost(evt);
            }
        });
        jtf_estoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_estoqueKeyPressed(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbt_excluir.setBackground(new java.awt.Color(13, 71, 161));
        jbt_excluir.setForeground(new java.awt.Color(255, 255, 255));
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
        jta_Observacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jta_ObservacaoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jta_Observacao);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Observações");

        jcb_Unidade_medida.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Unidade_medida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_Unidade_medida.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Unidade_medida.setMaximumRowCount(150);
        jcb_Unidade_medida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg", "", "", "", "", "" }));
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
        jLabel3.setText("*Unidade de medida");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Conversão");

        jtf_conv1.setBackground(new java.awt.Color(250, 250, 250));
        jtf_conv1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_conv1.setForeground(new java.awt.Color(0, 0, 0));
        jtf_conv1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        jtf_conv2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jtf_conv2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_conv2KeyPressed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbt_salvar_alteracao)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_limpar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtf_conv1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcb_UndConv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_conv2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcb_UndConv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbt_inverter))
                            .addComponent(jcb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_estoque, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtf_Descricao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcb_Unidade_medida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbt_fechar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jcb_Unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_conv1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_UndConv1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtf_conv2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_UndConv2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_inverter)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jtf_estoque.setText("");
        jta_Observacao.setText("");
        jtf_Descricao.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_salvar_alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvar_alteracaoActionPerformed
        //Alterar cadastro de Item
        //Fazer as validações de campos antes de salvar.
        //new CombosDAO().popularCombo("grupo", jcb_Grupo);
        if (Validacao.ValidarJTFObrigatorio(jtf_Descricao)
                && Validacao.testarCombo(jcb_Grupo)
                && Validacao.ValidarJTFObrigatorio(jtf_estoque)
                && Validacao.testarCombo(jcb_Unidade_medida)) {

            //Atribuir dados inseridos pelo usuario a variaveis
            String descItem = jtf_Descricao.getText().toUpperCase();
            ComboItem cb = (ComboItem) jcb_Grupo.getSelectedItem();
            double estoqueItem = Double.parseDouble(jtf_estoque.getText().replace(',', '.'));
            String obs = jta_Observacao.getText();

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
                und_conv1 = jcb_UndConv1.getSelectedItem().toString();
                und_conv2 = jcb_UndConv2.getSelectedItem().toString();
            }
            
            //Setar nomes das variaveis para o objeto Item
            Item item = new Item();
            item.setId(Integer.parseInt(jll_id.getText()));
            item.setDescricao(descItem);
            item.setId_grupo(cb.getCodigo());
            item.setQtde_estoque(estoqueItem);
            item.setObservacao(obs);
            item.setConv1(conv1);
            item.setConv2(conv2);
            item.setUnd_conv1(und_conv1);
            item.setUnd_conv2(und_conv2);

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

    }//GEN-LAST:event_jbt_excluirActionPerformed

    private void jtf_DescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_DescricaoKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_DescricaoKeyPressed

    private void jtf_estoqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_estoqueKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_estoqueKeyPressed

    private void jcb_GrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_GrupoActionPerformed
        this.keyPressed = true;
    }//GEN-LAST:event_jcb_GrupoActionPerformed

    private void jta_ObservacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jta_ObservacaoKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jta_ObservacaoKeyPressed

    private void jcb_Unidade_medidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_Unidade_medidaActionPerformed
        this.keyPressed = true;
    }//GEN-LAST:event_jcb_Unidade_medidaActionPerformed

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
    }//GEN-LAST:event_jbt_inverterActionPerformed

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

    private void jtf_conv1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_conv1KeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_conv1KeyPressed

    private void jtf_conv2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_conv2KeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_conv2KeyPressed

    private void jcb_UndConv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_UndConv1ActionPerformed
        this.keyPressed = true;
    }//GEN-LAST:event_jcb_UndConv1ActionPerformed

    private void jcb_UndConv2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_UndConv2ActionPerformed
        this.keyPressed = true;
    }//GEN-LAST:event_jcb_UndConv2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_inverter;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JButton jbt_salvar_alteracao;
    private javax.swing.JComboBox jcb_Grupo;
    private javax.swing.JComboBox jcb_UndConv1;
    private javax.swing.JComboBox jcb_UndConv2;
    private javax.swing.JComboBox jcb_Unidade_medida;
    private javax.swing.JLabel jll_id;
    private javax.swing.JTextArea jta_Observacao;
    private javax.swing.JTextField jtf_Descricao;
    private javax.swing.JTextField jtf_conv1;
    private javax.swing.JTextField jtf_conv2;
    private javax.swing.JTextField jtf_estoque;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDAO(Object dao) {
        this.item = (Item) dao;
        int index = new ItemDAO().indexCBUnidadeMedida(this.item.getUnidade_medida());
        int indexUC1 = new ItemDAO().indexCBUnidadeMedida(this.item.getUnd_conv1());
        int indexUC2 = new ItemDAO().indexCBUnidadeMedida(this.item.getUnd_conv2());

        //Recuperar os valores do ID selecionado na tabela e setando eles nos TextsFields para alteração
        jll_id.setText("" + this.item.getId());
        jtf_Descricao.setText(this.item.getDescricao());
        jtf_estoque.setText(new DecimalFormat("#.####").format(this.item.getQtde_estoque()));
        jta_Observacao.setText(this.item.getObservacao());
        jtf_conv1.setText(new DecimalFormat("#.####").format(this.item.getConv1()));
        jtf_conv2.setText(new DecimalFormat("#.####").format(this.item.getConv2()));
        jcb_Unidade_medida.setSelectedIndex(index);
        jcb_UndConv1.setSelectedIndex(indexUC1);
        jcb_UndConv2.setSelectedIndex(indexUC2);

        //retornar o valor selecionado ao Combo Box GRUPO
        new CombosDAO().popularCombo("grupo", jcb_Grupo);
        ComboItem cb = new ComboItem();
        cb.setCodigo(this.item.getId_grupo());
        cb.setDescricao(new GrupoDAO().consultarId(this.item.getId_grupo()).getDescricao());
        new CombosDAO().definirItemCombo(jcb_Grupo, cb);

        //Impede a alteração da unidade de conversão caso esta já estaja salva. Caso não tenha sido salva, permite a edição
        if (this.item.getConv2() != 0) {
            jtf_conv1.setEnabled(false);
            jtf_conv2.setEnabled(false);
            jcb_UndConv1.setEnabled(false);
            jcb_UndConv2.setEnabled(false);
            jbt_inverter.setEnabled(false);
        } else {
            if (jcb_UndConv1.getSelectedIndex() == jcb_Unidade_medida.getSelectedIndex()) {
                jcb_UndConv1.setEnabled(false);
            } else if (jcb_UndConv2.getSelectedIndex() == jcb_Unidade_medida.getSelectedIndex()) {
                jcb_UndConv2.setEnabled(false);
            } else {
                jtf_conv1.setEnabled(false);
                jcb_UndConv1.setEnabled(false);
                jcb_UndConv1.setSelectedIndex(index);
            }
        }
    }

    @Override
    public void setDetalhamento(boolean inativarControles) {
        this.inativarControles = inativarControles;
        if (inativarControles) {
            jInternalFrame1.setTitle("Detalhar Cadastro");
        } else {
            jInternalFrame1.setTitle("Alterar/Excluir");
        }
        jtf_Descricao.setEditable(!inativarControles);
        jtf_estoque.setEditable(!inativarControles);
        jcb_Grupo.setEnabled(!inativarControles);
        jta_Observacao.setEditable(!inativarControles);
        jcb_UndConv1.setEnabled(!inativarControles);
        jcb_UndConv2.setEnabled(!inativarControles);
        jtf_conv2.setEditable(!inativarControles);
        jbt_inverter.setEnabled(!inativarControles);
        jbt_excluir.setEnabled(!inativarControles);
        jbt_limpar.setEnabled(!inativarControles);
        jbt_salvar_alteracao.setEnabled(!inativarControles);
        keyPressed = false;
    }

    @Override
    public void setTelaParente(jif_Listagem_DAO tela
    ) {
        this.parente = tela;
    }

    @Override
    public void showWindow(boolean s
    ) {
        //Abrir novo JFrame na mesma localização do JFrame anterior
        this.setLocation(this.parente.getLocationOnScreen());
        this.setVisible(s);
    }

}
