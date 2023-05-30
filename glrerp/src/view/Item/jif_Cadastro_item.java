package view.Item;

import apoio.CombosDAO;
import apoio.Validacao;
import dao.ItemDAO;
import entidade.Grupo;
import entidade.Item;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ruang
 */
public class jif_Cadastro_item extends javax.swing.JInternalFrame {

    private boolean trocaInverter = false;

    public jif_Cadastro_item() {
        initComponents();

        new CombosDAO().popularCombo("grupo", jcb_Grupo);
        jtf_conv1.setText("1");
        jtf_conv1.setEnabled(false);
        jcb_UndConv1.setEnabled(false);
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
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
        jtf_estoque_inicial = new javax.swing.JTextField();
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
        jff_valor_inicial = new javax.swing.JFormattedTextField();

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
        jbt_cadastrar.setText("Cadastrar");
        jbt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_cadastrarActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Conversão");

        jtf_estoque_inicial.setBackground(new java.awt.Color(250, 250, 250));
        jtf_estoque_inicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_estoque_inicial.setForeground(new java.awt.Color(0, 0, 0));
        jtf_estoque_inicial.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_estoque_inicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_estoque_inicialFocusLost(evt);
            }
        });
        jtf_estoque_inicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_estoque_inicialKeyTyped(evt);
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

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("=");

        jcb_UndConv2.setBackground(new java.awt.Color(250, 250, 250));
        jcb_UndConv2.setForeground(new java.awt.Color(0, 0, 0));
        jcb_UndConv2.setMaximumRowCount(150);
        jcb_UndConv2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg" }));

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

        jff_valor_inicial.setBackground(new java.awt.Color(250, 250, 250));
        jff_valor_inicial.setForeground(new java.awt.Color(0, 0, 0));
        jff_valor_inicial.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_valor_inicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jff_valor_inicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jff_valor_inicialFocusLost(evt);
            }
        });
        jff_valor_inicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jff_valor_inicialKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(393, 393, 393)
                                .addComponent(jbt_inverter))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_estoque_inicial, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(jff_valor_inicial))
                                .addGap(290, 290, 290))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbt_cadastrar)
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
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcb_Unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jbt_fechar)
                .addContainerGap())
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
                            .addComponent(jtf_estoque_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_Unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jff_valor_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jbt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel6, jtf_Descricao, jtf_estoque_inicial});

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
                && Validacao.ValidarJTFObrigatorio(jtf_estoque_inicial)
                && Validacao.testarCombo(jcb_Unidade_medida)
                && Validacao.ValidarJTFObrigatorio(jff_valor_inicial)) {

            //Atribuir dados inseridos pelo usuario a variaveis
            String descItem = jtf_Descricao.getText().toUpperCase();
            Grupo cb = (Grupo) jcb_Grupo.getSelectedItem();
            double estoqueItem = Double.parseDouble(jtf_estoque_inicial.getText().replace(',', '.'));
            String unidadeMedida = jcb_Unidade_medida.getSelectedItem().toString();
            String obs = jta_Observacao.getText();
            double valorItem = Double.parseDouble(jff_valor_inicial.getText().replace(',', '.'));

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

    private void jtf_estoque_inicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_estoque_inicialFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_estoque_inicial);
    }//GEN-LAST:event_jtf_estoque_inicialFocusLost

    private void jcb_Unidade_medidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_Unidade_medidaFocusLost
        Validacao.testarCombo(jcb_Unidade_medida);
    }//GEN-LAST:event_jcb_Unidade_medidaFocusLost

    private void jff_valor_inicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_valor_inicialFocusLost
        Validacao.ValidarJTFObrigatorio(jff_valor_inicial);
    }//GEN-LAST:event_jff_valor_inicialFocusLost

    private void jff_valor_inicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jff_valor_inicialKeyTyped
        Validacao.ValidarDecimal(jff_valor_inicial, evt);
    }//GEN-LAST:event_jff_valor_inicialKeyTyped

    private void jtf_estoque_inicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_estoque_inicialKeyTyped
        Validacao.ValidarDecimal(jtf_estoque_inicial, evt);
    }//GEN-LAST:event_jtf_estoque_inicialKeyTyped

    private void jtf_conv2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_conv2KeyTyped
        Validacao.ValidarDecimal(jtf_conv2, evt);
    }//GEN-LAST:event_jtf_conv2KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_inverter;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JComboBox jcb_Grupo;
    private javax.swing.JComboBox jcb_UndConv1;
    private javax.swing.JComboBox jcb_UndConv2;
    private javax.swing.JComboBox jcb_Unidade_medida;
    private javax.swing.JFormattedTextField jff_valor_inicial;
    private javax.swing.JTextArea jta_Observacao;
    private javax.swing.JTextField jtf_Descricao;
    private javax.swing.JTextField jtf_conv1;
    private javax.swing.JTextField jtf_conv2;
    private javax.swing.JTextField jtf_estoque_inicial;
    // End of variables declaration//GEN-END:variables

    private void LimparCampos() {
        jtf_Descricao.setText("");
        jcb_Grupo.setSelectedIndex(0);
        jtf_estoque_inicial.setText("");
        jcb_Unidade_medida.setSelectedIndex(0);
        jta_Observacao.setText("");
        jff_valor_inicial.setText("");
        jcb_UndConv1.setSelectedIndex(0);
        jcb_UndConv2.setSelectedIndex(0);
        jtf_conv2.setText("");
    }

}
