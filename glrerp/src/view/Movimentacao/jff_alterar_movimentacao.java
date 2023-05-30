package view.Movimentacao;

import dao.ClienteDAO;
import dao.ItemDAO;
import dao.movimentacaoDAO;
import entidade.Cliente;
import entidade.Item;
import entidade.Movimentacao;
import java.awt.Color;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import view.jff_ITelaAlterarCadastro;
import view.jif_Listagem_DAO;

/**
 *
 * @author ruang
 */
public class jff_alterar_movimentacao extends javax.swing.JFrame implements jff_ITelaAlterarCadastro {

    private jif_Listagem_DAO parente;
    private Item item;
    private Movimentacao movimentacao;
    private boolean keyPressed;
    private boolean inativarControles;
    private String tipoMovto;
    private movimentacaoDAO dao;
    private DefaultComboBoxModel comboModel;
    private String tipoCliente;
    private boolean abertaComoEdiçao;
    private boolean camposBloqueados;

    
    public jff_alterar_movimentacao() {
        this.abertaComoEdiçao = true;
        ArrayList<Cliente> clientes = new ClienteDAO(this.tipoCliente).consultarTodos();
        Cliente[] clientesArr = new Cliente[clientes.size()];
        for (int i = 0; i < clientesArr.length; i++) {
            clientesArr[i] = clientes.get(i);
        }
        this.comboModel = new DefaultComboBoxModel(clientesArr);
        initComponents();
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
        UIManager.put("ComboBox.disabledBackground", Color.RGBtoHSB(250, 250, 250, null));

        this.jbt_excluir.setEnabled(false);
        this.jbt_limpar.setEnabled(false);
        this.jbt_salvar_alteracao.setEnabled(false);
    }

    public jff_alterar_movimentacao(String tipoMovto, int idItem) {
        this.tipoMovto = tipoMovto;
        if (this.tipoMovto.equals("venda")) {
            this.tipoCliente = "cliente";
        } else {
            this.tipoCliente = "fornecedor";
        }

        try {
            ArrayList<Cliente> clientes = new ClienteDAO(this.tipoCliente).consultarTodos();
            Cliente[] clientesArr = new Cliente[clientes.size()];
            for (int i = 0; i < clientesArr.length; i++) {
                clientesArr[i] = clientes.get(i);
            }
            this.comboModel = new DefaultComboBoxModel(clientesArr);

            initComponents();
            UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
            UIManager.put("ComboBox.disabledBackground", Color.RGBtoHSB(250, 250, 250, null));

            MaskFormatter dateFormater = new MaskFormatter("##/##/####");
            jft_data.setFormatterFactory(new DefaultFormatterFactory(dateFormater));

            MaskFormatter hourFormater = new MaskFormatter("##:##");
            jft_hora.setFormatterFactory(new DefaultFormatterFactory(hourFormater));

            switch (tipoMovto) {
                case "producao" ->
                    this.initFormProducao();
                case "compra" ->
                    this.initFormCompra();
                case "venda" ->
                    this.initFormVenda();
            }
        } catch (ParseException ex) {
            Logger.getLogger(jff_alterar_movimentacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initFormProducao() {
        jtf_valor.setEnabled(false);
        jcb_cliente.setEnabled(false);
    }

    private void initFormVenda() {
        jtf_perda.setEnabled(false);
        lbl_clienteTipo.setText("Cliente");
    }

    private void initFormCompra() {
        jtf_perda.setEnabled(false);
        lbl_clienteTipo.setText("Fornecedor");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_item = new javax.swing.JTextField();
        jtf_tipo = new javax.swing.JTextField();
        jtf_qtde = new javax.swing.JTextField();
        jtf_observacao = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_salvar_alteracao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jbt_excluir = new javax.swing.JButton();
        jft_data = new javax.swing.JFormattedTextField();
        jft_hora = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField();
        jtf_perda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl_clienteTipo = new javax.swing.JLabel();
        jcb_cliente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jInternalFrame1.setBackground(new java.awt.Color(238, 238, 238));
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Alterar/Excluir");
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(960, 500));
        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Item");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Tipo de Movimento");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("*Quantidade");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Observações");

        jtf_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_item.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_item.setEnabled(false);
        jtf_item.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtf_item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_itemKeyPressed(evt);
            }
        });

        jtf_tipo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_tipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_tipo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_tipo.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_tipo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_tipo.setEnabled(false);
        jtf_tipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_tipoKeyPressed(evt);
            }
        });

        jtf_qtde.setBackground(new java.awt.Color(250, 250, 250));
        jtf_qtde.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_qtde.setForeground(new java.awt.Color(0, 0, 0));
        jtf_qtde.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_qtde.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_qtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_qtdeKeyPressed(evt);
            }
        });

        jtf_observacao.setBackground(new java.awt.Color(250, 250, 250));
        jtf_observacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_observacao.setForeground(new java.awt.Color(0, 0, 0));
        jtf_observacao.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_observacao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_observacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_observacaoKeyPressed(evt);
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
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("*Data");

        jbt_excluir.setBackground(new java.awt.Color(13, 71, 161));
        jbt_excluir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_excluir.setText("Excluir cadastro");
        jbt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_excluirActionPerformed(evt);
            }
        });

        jft_data.setBackground(new java.awt.Color(250, 250, 250));
        jft_data.setForeground(new java.awt.Color(0, 0, 0));
        jft_data.setCaretColor(new java.awt.Color(0, 0, 0));
        jft_data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jft_hora.setBackground(new java.awt.Color(250, 250, 250));
        jft_hora.setForeground(new java.awt.Color(0, 0, 0));
        jft_hora.setCaretColor(new java.awt.Color(0, 0, 0));
        jft_hora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("*Hora");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("*Valor");

        jtf_valor.setBackground(new java.awt.Color(250, 250, 250));
        jtf_valor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_valor.setForeground(new java.awt.Color(0, 0, 0));
        jtf_valor.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_valor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valorKeyPressed(evt);
            }
        });

        jtf_perda.setBackground(new java.awt.Color(250, 250, 250));
        jtf_perda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_perda.setForeground(new java.awt.Color(0, 0, 0));
        jtf_perda.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_perda.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_perda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_perdaKeyPressed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("*Perdas");

        lbl_clienteTipo.setForeground(new java.awt.Color(0, 0, 0));
        lbl_clienteTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_clienteTipo.setText("Cliente");

        jcb_cliente.setBackground(new java.awt.Color(250, 250, 250));
        jcb_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_cliente.setModel(this.comboModel);
        jcb_cliente.setMinimumSize(new java.awt.Dimension(72, 28));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_clienteTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbt_salvar_alteracao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbt_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_limpar)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_fechar))
                    .addComponent(jtf_observacao)
                    .addComponent(jtf_item)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jft_data, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jft_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtf_tipo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_qtde, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_perda, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcb_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jft_data, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jft_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_qtde, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtf_perda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_observacao, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_clienteTipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_salvar_alteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_limpar)
                    .addComponent(jbt_fechar))
                .addGap(14, 14, 14))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_excluirActionPerformed
        dao.excluir(movimentacao.getId());
    }//GEN-LAST:event_jbt_excluirActionPerformed

    private void jbt_salvar_alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvar_alteracaoActionPerformed
        double perda = 0.0;
        int cliente_id = 0;
        double valor = 0.0;
        double qtde = Double.parseDouble(jtf_qtde.getText().replace(',', '.'));
        if (this.tipoMovto.equals("producao")) {
            perda = Double.parseDouble(jtf_perda.getText().replace(',', '.'));
        }
        if (!this.tipoMovto.equals("producao")) {
            cliente_id = ((Cliente) jcb_cliente.getSelectedItem()).getId();
        }
        if (!this.tipoMovto.equals("producao")) {
            valor = Double.parseDouble(jtf_valor.getText().replace(',', '.'));
        }
        if (this.tipoMovto.equals("venda")) {
            qtde = -qtde;
        }

        String[] datePart = jft_data.getText().split("/");
        String[] hourPart = jft_hora.getText().split(":");
        String str = datePart[2] + "-" + datePart[1] + "-" + datePart[0] + " " + hourPart[0] + ":" + hourPart[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        Movimentacao movto = new Movimentacao();

        movto.setData(dateTime);
        if (cliente_id != 0) {
            movto.setCliente_id(cliente_id);
        }
        movto.setItem_id(item.getId());
        movto.setObservacao(jtf_observacao.getText());
        movto.setPerdas(perda);
        movto.setQtde(qtde);
        movto.setTipo(this.tipoMovto);
        movto.setValor(valor);

        if (this.dao.salvar(movto) == null) {
            JOptionPane.showMessageDialog(this, "Cadastro incluído com sucesso");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "erro na inclusão do cadastro");
        }
    }//GEN-LAST:event_jbt_salvar_alteracaoActionPerformed

    private void jbt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_limparActionPerformed
        //Botão de limpar campos de TextField
        jtf_qtde.setText("");
        jtf_observacao.setText("");
        jft_data.setText("");
        jft_hora.setText("");
        jtf_item.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

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
                jtf_item.requestFocus(true);
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jtf_observacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_observacaoKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_observacaoKeyPressed

    private void jtf_qtdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_qtdeKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_qtdeKeyPressed

    private void jtf_tipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_tipoKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_tipoKeyPressed

    private void jtf_itemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_itemKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_itemKeyPressed

    private void jtf_valorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorKeyPressed

    private void jtf_perdaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_perdaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_perdaKeyPressed

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
            java.util.logging.Logger.getLogger(jff_alterar_movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jff_alterar_movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jff_alterar_movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jff_alterar_movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JButton jbt_salvar_alteracao;
    private javax.swing.JComboBox<Cliente> jcb_cliente;
    private javax.swing.JFormattedTextField jft_data;
    private javax.swing.JFormattedTextField jft_hora;
    private javax.swing.JTextField jtf_item;
    private javax.swing.JTextField jtf_observacao;
    private javax.swing.JTextField jtf_perda;
    private javax.swing.JTextField jtf_qtde;
    private javax.swing.JTextField jtf_tipo;
    private javax.swing.JTextField jtf_valor;
    private javax.swing.JLabel lbl_clienteTipo;
    // End of variables declaration//GEN-END:variables

    public void setItem(int id) {
        this.item = new ItemDAO().consultarId(id);

        jtf_item.setText(this.item.getDescricao());
        String tipoMotivo = this.tipoMovto.toUpperCase();
        jtf_tipo.setText(tipoMotivo);
    }

    @Override
    public void setDAO(Object dao) {
        this.dao = new movimentacaoDAO();
        if (this.abertaComoEdiçao) {
            this.movimentacao = (Movimentacao) dao;
            this.item = new ItemDAO().consultarId(movimentacao.getItem_id());

            jtf_qtde.setText(String.valueOf(movimentacao.getQtde()));
            jtf_observacao.setText(movimentacao.getObservacao());
            jft_data.setText(movimentacao.getData().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            jft_hora.setText(movimentacao.getData().format(DateTimeFormatter.ofPattern("hh:mm")));

            this.setItem(movimentacao.getItem_id());
        }
    }

    @Override
    public void setDetalhamento(boolean inativarControles) {
        this.camposBloqueados = inativarControles;
        jtf_qtde.setEnabled(!inativarControles);
        jtf_observacao.setEnabled(!inativarControles);
        jft_data.setEnabled(!inativarControles);
        jft_hora.setEnabled(!inativarControles);
        jtf_item.setEnabled(!inativarControles);
        jtf_perda.setEnabled(!inativarControles);
        jtf_valor.setEnabled(!inativarControles);

    }

    @Override
    public void setTelaParente(jif_Listagem_DAO tela) {
        this.parente = tela;
    }

    @Override
    public void showWindow(boolean s) {
        if (this.abertaComoEdiçao && !this.camposBloqueados) {
            JOptionPane.showMessageDialog(
                    this.parente,
                    "Para garantir a integridade do historico de movimentaçoes, nao é permitido "
                    + "a alteraçao desses registros. Favor exclua esse registro e lance novamente com"
                    + "os valores corretos");
        } else {
            this.setVisible(true);
        }
    }

}
