package view;

import apoio.IDAOT;
import dao.ClienteDAO;
import entidade.Cliente;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ruang
 */
public class jff_Alterar_cliente extends javax.swing.JFrame implements jff_ITelaAlterarCadastro {

    private jif_Listagem_DAO parente;

    private Cliente cliente;

    private boolean keyPressed;

    private boolean inativarControles;

    public jff_Alterar_cliente() {
        initComponents();
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
        jtf_Nome = new javax.swing.JTextField();
        jtf_Tel = new javax.swing.JTextField();
        jtf_Cpf = new javax.swing.JTextField();
        jtf_End = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_salvar_alteracao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jll_id = new javax.swing.JLabel();
        jbt_excluir = new javax.swing.JButton();

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
        jLabel2.setText("*Telefone");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("*CPF/CNPJ");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Endereço");

        jtf_Nome.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Nome.setForeground(new java.awt.Color(0, 0, 0));
        jtf_Nome.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_Nome.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtf_Nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_NomeKeyPressed(evt);
            }
        });

        jtf_Tel.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Tel.setForeground(new java.awt.Color(0, 0, 0));
        jtf_Tel.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_Tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_TelKeyPressed(evt);
            }
        });

        jtf_Cpf.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Cpf.setForeground(new java.awt.Color(0, 0, 0));
        jtf_Cpf.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_Cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_CpfKeyPressed(evt);
            }
        });

        jtf_End.setBackground(new java.awt.Color(250, 250, 250));
        jtf_End.setForeground(new java.awt.Color(0, 0, 0));
        jtf_End.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_End.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_EndKeyPressed(evt);
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
        jLabel6.setText("*E-mail");

        jtf_email.setBackground(new java.awt.Color(250, 250, 250));
        jtf_email.setForeground(new java.awt.Color(0, 0, 0));
        jtf_email.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_emailKeyPressed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbt_salvar_alteracao)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                                .addComponent(jbt_limpar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 214, Short.MAX_VALUE))
                            .addComponent(jtf_End))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtf_Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_End, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
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
        jtf_Nome.setText("");
        jtf_Tel.setText("");
        jtf_Cpf.setText("");
        jtf_End.setText("");
        jtf_email.setText("");
        jtf_Nome.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_salvar_alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvar_alteracaoActionPerformed

        //Alterar cadastro de Cliente
        //Atribuir dados inseridos pelo usuario a variaveis
        String nomeCliente = jtf_Nome.getText();
        String telCliente = jtf_Tel.getText();
        String cpfCliente = jtf_Cpf.getText();
        String emailCliente = jtf_email.getText();
        String endCliente = jtf_End.getText();

        //Setar nomes das variaveis para o objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(jll_id.getText()));
        cliente.setNome(nomeCliente);
        cliente.setCpf(cpfCliente);
        cliente.setEmail(emailCliente);
        cliente.setTelefone(telCliente);
        cliente.setEndereco(endCliente);

        //Chamar classe ClienteDAO para salvar dados no Banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();

        //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
        if (clienteDAO.atualizar(cliente) == null) {
            JOptionPane.showMessageDialog(this, "Cadastro alterado com sucesso!", "CADASTRADO ALTERADO", JOptionPane.INFORMATION_MESSAGE);
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
            //Excluir cadastro de Cliente
            //Setar SITUAÇÃO=FALSE o objeto Cliente
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(jll_id.getText()));
            cliente.setAtivo(false);

            //Chamar classe ClienteDAO para salvar dados no Banco de dados
            ClienteDAO clienteDAO = new ClienteDAO();

            //Verifica se a exclusão foi bem sucessido e fecha a tela. Caso contrário apresenta mensagem de erro
            if (clienteDAO.excluir(Integer.parseInt(jll_id.getText())) == null) {
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

    private void jtf_TelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_TelKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_TelKeyPressed

    private void jtf_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_emailKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_emailKeyPressed

    private void jtf_CpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_CpfKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_CpfKeyPressed

    private void jtf_EndKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_EndKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_EndKeyPressed

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
            java.util.logging.Logger.getLogger(jff_Alterar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JButton jbt_salvar_alteracao;
    private javax.swing.JLabel jll_id;
    private javax.swing.JTextField jtf_Cpf;
    private javax.swing.JTextField jtf_End;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JTextField jtf_Tel;
    private javax.swing.JTextField jtf_email;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDAO(Object dao) {
        this.cliente = (Cliente) dao;

        //Recuperar os valores do ID selecionado na tabela e setando eles nos TextsFields para alteração
        jll_id.setText("" + this.cliente.getId());
        jtf_Nome.setText(this.cliente.getNome());
        jtf_email.setText(this.cliente.getEmail());
        jtf_Cpf.setText(this.cliente.getCpf());
        jtf_End.setText(this.cliente.getEndereco());
        jtf_Tel.setText(this.cliente.getTelefone());

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
        jtf_email.setEnabled(!inativarControles);
        jtf_Cpf.setEnabled(!inativarControles);
        jtf_End.setEnabled(!inativarControles);
        jtf_Tel.setEnabled(!inativarControles);
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
