package view.Estrutura;

import dao.GrupoDAO;
import entidade.Grupo;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ruang
 */
public class jif_Cadastro_estrutura extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel model;
    
    
    public jif_Cadastro_estrutura() {
        Grupo[] grupoComboBox = new GrupoDAO().consultarComboBox();
        this.model = new DefaultComboBoxModel(grupoComboBox);
        initComponents();                    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_id_item = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_nova_estrutura = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlb_id = new javax.swing.JLabel();
        jtf_nome_item = new javax.swing.JTextField();
        jtf_grupo_item = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jbt_pesquisar_item = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtf_id_insumo = new javax.swing.JTextField();
        jtf_nome_insumo = new javax.swing.JTextField();
        jtf_grupo_insumo = new javax.swing.JTextField();
        jbt_pesquisar_insumo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtf_qtde_insumo = new javax.swing.JTextField();
        jtf_und_medida_insumo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_insumos_estrutura = new javax.swing.JTable();
        jbt_inserir = new javax.swing.JButton();
        jbt_excluir = new javax.swing.JButton();
        jbt_salvar = new javax.swing.JButton();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro - Estrutura");
        setPreferredSize(new java.awt.Dimension(960, 500));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Item");

        jtf_id_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_id_item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_id_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_id_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_id_item.setEnabled(false);

        jbt_fechar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_fechar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_fechar.setText("Fechar");
        jbt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_fecharActionPerformed(evt);
            }
        });

        jbt_nova_estrutura.setBackground(new java.awt.Color(13, 71, 161));
        jbt_nova_estrutura.setForeground(new java.awt.Color(255, 255, 255));
        jbt_nova_estrutura.setText("Nova Estrutura");
        jbt_nova_estrutura.setEnabled(false);
        jbt_nova_estrutura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_nova_estruturaActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Estrutura N°");

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setEnabled(false);
        jPanel2.setFocusable(false);

        jlb_id.setForeground(new java.awt.Color(102, 102, 102));
        jlb_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_id.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_id, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_id, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtf_nome_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_nome_item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_nome_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_nome_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_nome_item.setEnabled(false);

        jtf_grupo_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_grupo_item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_grupo_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_grupo_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_grupo_item.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Grupo do item");

        jbt_pesquisar_item.setBackground(new java.awt.Color(13, 71, 161));
        jbt_pesquisar_item.setForeground(new java.awt.Color(255, 255, 255));
        jbt_pesquisar_item.setText("Pesquisar");
        jbt_pesquisar_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_pesquisar_itemActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("*Insumo");

        jtf_id_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_id_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_id_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_id_insumo.setEnabled(false);

        jtf_nome_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_nome_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_nome_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_nome_insumo.setEnabled(false);

        jtf_grupo_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_grupo_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_grupo_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_grupo_insumo.setEnabled(false);
        jtf_grupo_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_grupo_insumoActionPerformed(evt);
            }
        });

        jbt_pesquisar_insumo.setBackground(new java.awt.Color(13, 71, 161));
        jbt_pesquisar_insumo.setForeground(new java.awt.Color(255, 255, 255));
        jbt_pesquisar_insumo.setText("Pesquisar");
        jbt_pesquisar_insumo.setEnabled(false);
        jbt_pesquisar_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_pesquisar_insumoActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("*Quantidade");

        jtf_qtde_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_qtde_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_qtde_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_qtde_insumo.setEnabled(false);

        jtf_und_medida_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_und_medida_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_und_medida_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_und_medida_insumo.setEnabled(false);

        jtb_insumos_estrutura.setBackground(new java.awt.Color(250, 250, 250));
        jtb_insumos_estrutura.setForeground(new java.awt.Color(51, 51, 51));
        jtb_insumos_estrutura.setModel(new javax.swing.table.DefaultTableModel(
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
        jtb_insumos_estrutura.setRowHeight(25);
        jtb_insumos_estrutura.setSelectionBackground(new java.awt.Color(13, 71, 161));
        jtb_insumos_estrutura.setSelectionForeground(new java.awt.Color(250, 250, 250));
        jtb_insumos_estrutura.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtb_insumos_estrutura.setShowGrid(false);
        jtb_insumos_estrutura.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jtb_insumos_estrutura);

        jbt_inserir.setBackground(new java.awt.Color(13, 71, 161));
        jbt_inserir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_inserir.setText("Inserir");
        jbt_inserir.setEnabled(false);
        jbt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_inserirActionPerformed(evt);
            }
        });

        jbt_excluir.setBackground(new java.awt.Color(13, 71, 161));
        jbt_excluir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_excluir.setText("Excluir");
        jbt_excluir.setEnabled(false);
        jbt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_excluirActionPerformed(evt);
            }
        });

        jbt_salvar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_salvar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_salvar.setText("Salvar Estrutura");
        jbt_salvar.setEnabled(false);
        jbt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_qtde_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_und_medida_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_id_insumo, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_nome_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_grupo_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbt_excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbt_pesquisar_insumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbt_fechar))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtf_id_item, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_nome_item, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtf_grupo_item))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbt_pesquisar_item, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_nova_estrutura))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_id_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_grupo_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbt_pesquisar_item, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbt_nova_estrutura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_id_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_grupo_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbt_pesquisar_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_qtde_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_und_medida_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(550, 550, 550))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Botão de fechar
        this.dispose();
    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_nova_estruturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_nova_estruturaActionPerformed
        //Cadastro de Item
        

    }//GEN-LAST:event_jbt_nova_estruturaActionPerformed

    private void jbt_pesquisar_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_pesquisar_itemActionPerformed
        jff_pesquisar jff_pesquisar = new jff_pesquisar();    
        jff_pesquisar.setVisible(true);
    }//GEN-LAST:event_jbt_pesquisar_itemActionPerformed

    private void jtf_grupo_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_grupo_insumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_grupo_insumoActionPerformed

    private void jbt_pesquisar_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_pesquisar_insumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt_pesquisar_insumoActionPerformed

    private void jbt_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_inserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt_inserirActionPerformed

    private void jbt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_excluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt_excluirActionPerformed

    private void jbt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt_salvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_inserir;
    private javax.swing.JButton jbt_nova_estrutura;
    private javax.swing.JButton jbt_pesquisar_insumo;
    private javax.swing.JButton jbt_pesquisar_item;
    private javax.swing.JButton jbt_salvar;
    private javax.swing.JLabel jlb_id;
    private javax.swing.JTable jtb_insumos_estrutura;
    private javax.swing.JTextField jtf_grupo_insumo;
    private javax.swing.JTextField jtf_grupo_item;
    private javax.swing.JTextField jtf_id_insumo;
    private javax.swing.JTextField jtf_id_item;
    private javax.swing.JTextField jtf_nome_insumo;
    private javax.swing.JTextField jtf_nome_item;
    private javax.swing.JTextField jtf_qtde_insumo;
    private javax.swing.JTextField jtf_und_medida_insumo;
    // End of variables declaration//GEN-END:variables
}
