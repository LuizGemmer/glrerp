package view;

import dao.GrupoDAO;
import dao.userDAO;
import entidade.Grupo;
import entidade.Item;
import entidade.User;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.text.DecimalFormat;

/**
 *
 * @author ruang
 */
public class jff_Alterar_User extends javax.swing.JFrame implements jff_ITelaAlterarCadastro {

    private jif_Listagem_DAO parente;

    private User user;

    private boolean keyPressed;

    private boolean inativarControles = false;

    private DefaultComboBoxModel model;

    public jff_Alterar_User() {
        Grupo[] grupoComboBox = new GrupoDAO().consultarComboBox();
        this.model = new DefaultComboBoxModel(grupoComboBox);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_Nome = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_salvar_alteracao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jll_id = new javax.swing.JLabel();
        jbt_excluir = new javax.swing.JButton();
        jcb_Hierarquia = new javax.swing.JComboBox<>();
        jpf_Senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(238, 238, 238));
        jInternalFrame1.setTitle("Alterar/Excluir");
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(960, 500));
        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("*Nome");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("*Senha");

        jtf_Nome.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Nome.setForeground(new java.awt.Color(0, 0, 0));
        jtf_Nome.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_Nome.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtf_Nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_NomeKeyPressed(evt);
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
        jLabel6.setText("*Hierarquia");

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

        jcb_Hierarquia.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Hierarquia.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Hierarquia.setMaximumRowCount(150);
        jcb_Hierarquia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "usuario", "admin" }));
        jcb_Hierarquia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcb_Hierarquia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_HierarquiaActionPerformed(evt);
            }
        });

        jpf_Senha.setBackground(new java.awt.Color(250, 250, 250));
        jpf_Senha.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbt_salvar_alteracao)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                                .addComponent(jbt_limpar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpf_Senha)
                                    .addComponent(jtf_Nome))
                                .addGap(61, 61, 61)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbt_fechar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcb_Hierarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jpf_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcb_Hierarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(191, 191, 191)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbt_fechar)
                        .addComponent(jbt_limpar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbt_salvar_alteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
                jtf_Nome.requestFocus(true);
            }
        } else {
            this.dispose();
        }

    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_limparActionPerformed

        //Botão de limpar campos de TextField
        //Botão de limpar campos de TextField
        jtf_Nome.setText("");
        jpf_Senha.setText("");
        jcb_Hierarquia.setSelectedIndex(0);
        jtf_Nome.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_salvar_alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvar_alteracaoActionPerformed

        //Alterar cadastro de Usuario
        //Atribuir dados inseridos pelo usuario a variaveis
        String nomeUser = jtf_Nome.getText();
        char[] senhaUser = jpf_Senha.getPassword();
        String hierarquiaUser = jcb_Hierarquia.getSelectedItem().toString();

        //Setar nomes das variaveis para o objeto User
        User user = new User();
        user.setId(this.user.getId());
        user.setNome(nomeUser);
        user.setSenha(this.user.getSenha());
        user.setHierarquia(hierarquiaUser);

        //Chamar classe userDAO para salvar dados no Banco de dados
        userDAO aDAO = new userDAO();

        //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
        if (aDAO.atualizar(user) == null) {
            JOptionPane.showMessageDialog(this, "Novo Usuário salvo com sucesso!", "USUÁRIO CADASTRADO", JOptionPane.INFORMATION_MESSAGE);
            this.parente.setTableItems("");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
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
            //Setar SITUAÇÃO=FALSE no objeto
            User user = new User();
            user.setId(Integer.parseInt(jll_id.getText()));
            user.setAtivo(false);

            //Chamar classe userDAO para salvar dados no Banco de dados
            userDAO aDAO = new userDAO();

            //Verifica se a exclusão foi bem sucessido e fecha a tela. Caso contrário apresenta mensagem de erro
            if (aDAO.excluir(Integer.parseInt(jll_id.getText())) == null) {
                JOptionPane.showMessageDialog(this, "Cadastro excluido com sucesso!", "CADASTRADO EXCLUÍDO", JOptionPane.INFORMATION_MESSAGE);
                this.parente.setTableItems("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jbt_excluirActionPerformed

    private void jtf_NomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_NomeKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_NomeKeyPressed

    private void jcb_HierarquiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_HierarquiaActionPerformed
        this.keyPressed = true;
    }//GEN-LAST:event_jcb_HierarquiaActionPerformed

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
            java.util.logging.Logger.getLogger(jff_Alterar_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JButton jbt_salvar_alteracao;
    private javax.swing.JComboBox<String> jcb_Hierarquia;
    private javax.swing.JLabel jll_id;
    private javax.swing.JPasswordField jpf_Senha;
    private javax.swing.JTextField jtf_Nome;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDAO(Object dao) {
        this.user = (User) dao;

        //Recuperar os valores do ID selecionado na tabela e setando eles nos TextsFields para alteração
        jll_id.setText("" + this.user.getId());
        jtf_Nome.setText(this.user.getNome());

    }

    @Override
    public void setDetalhamento(boolean inativarControles) {
        this.inativarControles = inativarControles;
        if (inativarControles) {
            jInternalFrame1.setTitle("Detalhar Cadastro");
        } else {
            jInternalFrame1.setTitle("Alterar/Excluir");
        }
        jtf_Nome.setEnabled(!inativarControles);
        jpf_Senha.setEnabled(false);
        jcb_Hierarquia.setEnabled(!inativarControles);
        jbt_excluir.setEnabled(!inativarControles);
        jbt_limpar.setEnabled(!inativarControles);
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

}
