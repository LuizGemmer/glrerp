package view.Adicionais;

import apoio.Validacao;
import dao.AdicionaisDAO;
import entidade.Adicionais;
import javax.swing.JOptionPane;

public class jif_Cadastro_adicionais extends javax.swing.JInternalFrame {

    public jif_Cadastro_adicionais() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlb_cpf_cnpj = new javax.swing.JLabel();
        jtf_descricao = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_cadastrar = new javax.swing.JButton();
        jtf_valor = new javax.swing.JTextField();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro - Decorativos");
        setPreferredSize(new java.awt.Dimension(960, 500));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Descrição");

        jlb_cpf_cnpj.setForeground(new java.awt.Color(0, 0, 0));
        jlb_cpf_cnpj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_cpf_cnpj.setText("*Valor (R$)");

        jtf_descricao.setBackground(new java.awt.Color(250, 250, 250));
        jtf_descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_descricao.setForeground(new java.awt.Color(0, 0, 0));
        jtf_descricao.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_descricaoFocusLost(evt);
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

        jtf_valor.setBackground(new java.awt.Color(250, 250, 250));
        jtf_valor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_valor.setForeground(new java.awt.Color(0, 0, 0));
        jtf_valor.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valorFocusLost(evt);
            }
        });
        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_valorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_cpf_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbt_cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbt_fechar)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(422, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_cpf_cnpj)
                    .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_limpar)
                    .addComponent(jbt_fechar))
                .addGap(44, 44, 44))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jlb_cpf_cnpj, jtf_descricao, jtf_valor});

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
        jtf_descricao.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_cadastrarActionPerformed
        //Faz as validações necessárias antes de salvar
        if (Validacao.ValidarJTFObrigatorio(jtf_descricao)
                && Validacao.ValidarJTFObrigatorio(jtf_valor)) {

            //Cadastrar novo Adicional
            //Atribuir dados inseridos pelo usuario a variaveis
            String descAdicional = jtf_descricao.getText().toUpperCase();
            double valorAdicional = Double.parseDouble(jtf_valor.getText().replace(",", "."));
            
            //Setar nomes das variaveis para o objeto Cliente
            Adicionais adicional = new Adicionais();
            adicional.setDescricao(descAdicional);
            adicional.setValor(valorAdicional);

            //Chamar classe AdicionaisDAO para salvar dados no Banco de dados
            AdicionaisDAO adicionaisDAO = new AdicionaisDAO();

            //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
            if (adicionaisDAO.salvar(adicional) == null) {
                JOptionPane.showMessageDialog(this, "Novo cadastro salvo com sucesso!", "NOVO CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                LimparCampos();

                jtf_descricao.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir dados de novo cadastro!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbt_cadastrarActionPerformed

    private void jtf_descricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricaoFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_descricao);
    }//GEN-LAST:event_jtf_descricaoFocusLost

    private void jtf_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_valor);
    }//GEN-LAST:event_jtf_valorFocusLost

    private void jtf_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyTyped
        Validacao.ValidarDecimal(jtf_valor, evt);
    }//GEN-LAST:event_jtf_valorKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbt_cadastrar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JLabel jlb_cpf_cnpj;
    private javax.swing.JTextField jtf_descricao;
    private javax.swing.JTextField jtf_valor;
    // End of variables declaration//GEN-END:variables

    public void LimparCampos() {
        jtf_descricao.setText("");
        jtf_valor.setText("");
    }
}
