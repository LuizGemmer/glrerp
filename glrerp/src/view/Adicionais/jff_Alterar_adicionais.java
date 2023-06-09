package view.Adicionais;

import apoio.Formatacao;
import apoio.Validacao;
import dao.AdicionaisDAO;
import entidade.Adicionais;
import java.awt.Color;
import javax.swing.JOptionPane;
import view.jff_ITelaAlterarCadastro;
import view.jif_Listagem_DAO;

/**
 *
 * @author ruang
 */
public class jff_Alterar_adicionais extends javax.swing.JFrame implements jff_ITelaAlterarCadastro {

    private jif_Listagem_DAO parente;
    private Adicionais adicional;
    private boolean keyPressed;
    private boolean inativarControles;
    Color buttonDisableColor = new Color(51, 51, 51);
    Color buttonBlueColor = new Color(13, 71, 161);
    Color buttonRedColor = new Color(153, 0, 0);

    public jff_Alterar_adicionais() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlb_cpf_cnpj = new javax.swing.JLabel();
        jtf_descricao = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_salvar_alteracao = new javax.swing.JButton();
        jtf_valor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jll_id = new javax.swing.JLabel();
        jbt_excluir = new javax.swing.JButton();

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
        jLabel1.setText("*Descrição");

        jlb_cpf_cnpj.setForeground(new java.awt.Color(0, 0, 0));
        jlb_cpf_cnpj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_cpf_cnpj.setText("*Valor (R$)");

        jtf_descricao.setBackground(new java.awt.Color(250, 250, 250));
        jtf_descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_descricao.setForeground(new java.awt.Color(0, 0, 0));
        jtf_descricao.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_descricao.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_descricao.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtf_descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_descricaoFocusLost(evt);
            }
        });
        jtf_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_descricaoKeyPressed(evt);
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

        jtf_valor.setBackground(new java.awt.Color(250, 250, 250));
        jtf_valor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_valor.setForeground(new java.awt.Color(0, 0, 0));
        jtf_valor.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_valor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valorFocusLost(evt);
            }
        });
        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_valorKeyTyped(evt);
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

        jbt_excluir.setBackground(new java.awt.Color(153, 0, 0));
        jbt_excluir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir18x18.png"))); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbt_salvar_alteracao)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbt_limpar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlb_cpf_cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jtf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(jtf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_cpf_cnpj)
                            .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                jtf_descricao.requestFocus(true);
            }
        } else {
            this.dispose();
        }

    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_limparActionPerformed
        //Botão de limpar campos de TextField
        LimparCampos();
        jtf_descricao.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_salvar_alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvar_alteracaoActionPerformed
        //Faz as validações necessárias antes de salvar
        if (Validacao.ValidarJTFObrigatorio(jtf_descricao)
                && Validacao.ValidarJTFObrigatorio(jtf_valor)) {

            //Cadastrar novo Adicional
            //Atribuir dados inseridos pelo usuario a variaveis
            String descAdicional = jtf_descricao.getText().toUpperCase();
            double valorAdicional = Double.parseDouble(jtf_valor.getText().replace(",", "."));

            //Setar nomes das variaveis para o objeto Cliente
            Adicionais adicional = new Adicionais();
            adicional.setId(Integer.parseInt(jll_id.getText()));
            adicional.setDescricao(descAdicional);
            adicional.setValor(valorAdicional);

            //Chamar classe AdicionaisDAO para salvar dados no Banco de dados
            AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
            
            //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
            if (adicionaisDAO.atualizar(adicional) == null) {
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
            //Excluir cadastro de Adicional
            //Setar SITUAÇÃO=FALSE o objeto Adicional
            Adicionais adicional = new Adicionais();
            adicional.setId(Integer.parseInt(jll_id.getText()));
            adicional.setAtivo(false);

            //Chamar classe AdicionaisDAO para salvar dados no Banco de dados
            AdicionaisDAO adicionalDAO = new AdicionaisDAO();

            //Verifica se a exclusão foi bem sucessido e fecha a tela. Caso contrário apresenta mensagem de erro
            if (adicionalDAO.excluir(Integer.parseInt(jll_id.getText())) == null) {
                JOptionPane.showMessageDialog(this, "Cadastro excluido com sucesso!", "CADASTRADO EXCLUÍDO", JOptionPane.INFORMATION_MESSAGE);
                this.parente.setTableItems("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jbt_excluirActionPerformed

    private void jtf_descricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricaoKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_descricaoKeyPressed

    private void jtf_valorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_valorKeyPressed

    private void jtf_descricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricaoFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_descricao);
    }//GEN-LAST:event_jtf_descricaoFocusLost

    private void jtf_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_valor);
    }//GEN-LAST:event_jtf_valorFocusLost

    private void jtf_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyTyped
        Validacao.ValidarDecimal(jtf_valor, evt);
    }//GEN-LAST:event_jtf_valorKeyTyped

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
            java.util.logging.Logger.getLogger(jff_Alterar_adicionais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_adicionais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_adicionais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jff_Alterar_adicionais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JButton jbt_salvar_alteracao;
    private javax.swing.JLabel jlb_cpf_cnpj;
    private javax.swing.JLabel jll_id;
    private javax.swing.JTextField jtf_descricao;
    private javax.swing.JTextField jtf_valor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDAO(Object dao) {
        this.adicional = (Adicionais) dao;

        //Recuperar os valores do ID selecionado na tabela e setando eles nos TextsFields para alteração
        jll_id.setText("" + this.adicional.getId());
        jtf_descricao.setText(this.adicional.getDescricao());
        jtf_valor.setText(String.valueOf(this.adicional.getValor()).replace(".", ","));
        
        this.keyPressed = false;
    }

    @Override
    public void setDetalhamento(boolean inativarControles) {
        this.inativarControles = inativarControles;
        if (inativarControles) {
            jInternalFrame1.setTitle("Detalhar Cadastro");
            jbt_excluir.setBackground(buttonDisableColor);
            jbt_limpar.setBackground(buttonDisableColor);
            jbt_salvar_alteracao.setBackground(buttonDisableColor);
        } else {
            jInternalFrame1.setTitle("Alterar/Excluir");
            jbt_excluir.setBackground(buttonRedColor);
            jbt_limpar.setBackground(buttonBlueColor);
            jbt_salvar_alteracao.setBackground(buttonBlueColor);
        }
        jtf_descricao.setEditable(!inativarControles);
        jtf_valor.setEditable(!inativarControles);
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

    public void LimparCampos() {
        jtf_descricao.setText("");
        jtf_valor.setText("");
    }

}
