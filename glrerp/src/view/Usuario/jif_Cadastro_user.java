package view.Usuario;

import apoio.Validacao;
import dao.userDAO;
import entidade.User;
import javax.swing.JOptionPane;

/**
 *
 * @author ruang
 */
public class jif_Cadastro_user extends javax.swing.JInternalFrame {

    public jif_Cadastro_user() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_Nome = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_cadastrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jpf_Senha = new javax.swing.JPasswordField();
        jcb_Hierarquia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro - Usuário");
        setPreferredSize(new java.awt.Dimension(960, 500));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("*Nome");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("*Senha");

        jtf_Nome.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_Nome.setForeground(new java.awt.Color(0, 0, 0));
        jtf_Nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_NomeFocusLost(evt);
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
        jLabel6.setText("*Hierarquia");

        jpf_Senha.setBackground(new java.awt.Color(250, 250, 250));
        jpf_Senha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpf_Senha.setForeground(new java.awt.Color(0, 0, 0));
        jpf_Senha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpf_SenhaFocusLost(evt);
            }
        });

        jcb_Hierarquia.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Hierarquia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_Hierarquia.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Hierarquia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "USUARIO", "SUPERVISOR", "ADMIN" }));
        jcb_Hierarquia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_HierarquiaFocusLost(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("*E-mail");

        jtf_email.setBackground(new java.awt.Color(250, 250, 250));
        jtf_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_email.setForeground(new java.awt.Color(0, 0, 0));
        jtf_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_emailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbt_cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_limpar)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_fechar)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcb_Hierarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpf_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(311, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpf_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 170, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbt_cadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbt_limpar)
                                .addComponent(jbt_fechar)))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcb_Hierarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel6, jtf_Nome});

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
        jtf_Nome.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_cadastrarActionPerformed
        //Faz as validações necessárias antes de salvar
        if (Validacao.testarCombo(jcb_Hierarquia)
                && Validacao.ValidarJTFObrigatorio(jtf_Nome)
                && Validacao.ValidarJTFObrigatorio(jtf_email)
                && Validacao.ValidarPasswdObrigatorio(jpf_Senha)) {

            //Cadastrar novo Usuário
            //Atribuir dados inseridos pelo usuario a variaveis
            String nomeUser = jtf_Nome.getText().toUpperCase();
            char[] senhaUser = jpf_Senha.getPassword();
            String passwd = String.valueOf(senhaUser);
            String hierarquiaUser = jcb_Hierarquia.getSelectedItem().toString().toUpperCase();
            String email = jtf_email.getText();

            //Setar nomes das variaveis para o objeto User
            User user = new User();
            user.setNome(nomeUser);
            user.setSenha(passwd);
            user.setHierarquia(hierarquiaUser);
            user.setEmail(email);

            //Chamar classe ClienteDAO para salvar dados no Banco de dados
            userDAO aDAO = new userDAO();

            //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
            if (aDAO.salvar(user) == null) {
                JOptionPane.showMessageDialog(this, "Novo Usuário salvo com sucesso!", "USUÁRIO CADASTRADO", JOptionPane.INFORMATION_MESSAGE);
                LimparCampos();
                jtf_Nome.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir dados de novo cliente!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbt_cadastrarActionPerformed

    private void jtf_NomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_NomeFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_Nome);
    }//GEN-LAST:event_jtf_NomeFocusLost

    private void jpf_SenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpf_SenhaFocusLost
        Validacao.ValidarPasswdObrigatorio(jpf_Senha);
    }//GEN-LAST:event_jpf_SenhaFocusLost

    private void jtf_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_emailFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_email);
    }//GEN-LAST:event_jtf_emailFocusLost

    private void jcb_HierarquiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_HierarquiaFocusLost
        Validacao.testarCombo(jcb_Hierarquia);
    }//GEN-LAST:event_jcb_HierarquiaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbt_cadastrar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JComboBox<String> jcb_Hierarquia;
    private javax.swing.JPasswordField jpf_Senha;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JTextField jtf_email;
    // End of variables declaration//GEN-END:variables

    private void LimparCampos() {
        jtf_Nome.setText("");
        jpf_Senha.setText("");
        jtf_email.setText("");
        jcb_Hierarquia.setSelectedIndex(0);
    }
}
