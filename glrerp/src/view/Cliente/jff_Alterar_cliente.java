package view.Cliente;

import apoio.Formatacao;
import apoio.Validacao;
import dao.ClienteDAO;
import entidade.Cliente;
import java.awt.Color;
import javax.swing.JOptionPane;
import view.jff_ITelaAlterarCadastro;
import view.jif_Listagem_DAO;

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
        Formatacao.formatarTelefone(jff_Telefone);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlb_cpf_cnpj = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_Nome = new javax.swing.JTextField();
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
        jff_Cpf = new javax.swing.JFormattedTextField();
        jff_Telefone = new javax.swing.JFormattedTextField();
        jbt_alterarCpfCnpj = new javax.swing.JButton();

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
        jLabel1.setText("*Nome");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Telefone");

        jlb_cpf_cnpj.setForeground(new java.awt.Color(0, 0, 0));
        jlb_cpf_cnpj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_cpf_cnpj.setText("*CPF");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Endereço");

        jtf_Nome.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_Nome.setForeground(new java.awt.Color(0, 0, 0));
        jtf_Nome.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_Nome.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jtf_Nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_NomeFocusLost(evt);
            }
        });
        jtf_Nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_NomeKeyPressed(evt);
            }
        });

        jtf_End.setBackground(new java.awt.Color(250, 250, 250));
        jtf_End.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("*E-mail");

        jtf_email.setBackground(new java.awt.Color(250, 250, 250));
        jtf_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_email.setForeground(new java.awt.Color(0, 0, 0));
        jtf_email.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_emailFocusLost(evt);
            }
        });
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

        jff_Cpf.setBackground(new java.awt.Color(250, 250, 250));
        jff_Cpf.setForeground(new java.awt.Color(0, 0, 0));
        jff_Cpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jff_Cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jff_CpfFocusLost(evt);
            }
        });
        jff_Cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jff_CpfKeyPressed(evt);
            }
        });

        jff_Telefone.setBackground(new java.awt.Color(250, 250, 250));
        jff_Telefone.setForeground(new java.awt.Color(0, 0, 0));
        jff_Telefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jff_Telefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jff_TelefoneFocusLost(evt);
            }
        });
        jff_Telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jff_TelefoneKeyPressed(evt);
            }
        });

        jbt_alterarCpfCnpj.setBackground(new java.awt.Color(13, 71, 161));
        jbt_alterarCpfCnpj.setForeground(new java.awt.Color(255, 255, 255));
        jbt_alterarCpfCnpj.setText("Mudar para CNPJ");
        jbt_alterarCpfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_alterarCpfCnpjActionPerformed(evt);
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
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_cpf_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jff_Telefone, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jff_Cpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbt_alterarCpfCnpj)))
                                .addGap(0, 202, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jff_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlb_cpf_cnpj))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbt_alterarCpfCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addGap(2, 2, 2))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jff_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_End, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
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
                jtf_Nome.requestFocus(true);
            }
        } else {
            this.dispose();
        }

    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_limparActionPerformed

        //Botão de limpar campos de TextField
        LimparCampos();
        jtf_Nome.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_salvar_alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvar_alteracaoActionPerformed
        //Faz as validações necessárias antes de salvar
        if (Validacao.ValidarJTFObrigatorio(jtf_Nome)
                && Validacao.ValidarJTFObrigatorio(jtf_email)
                && ValidarTelefone()
                && ValidarCPFeCNPJ()) {

            //Alterar cadastro de Cliente
            //Atribuir dados inseridos pelo usuario a variaveis
            String nomeCliente = jtf_Nome.getText().toUpperCase();
            String telCliente = jff_Telefone.getText();
            String cpfCliente = jff_Cpf.getText();
            String emailCliente = jtf_email.getText();
            String endCliente = jtf_End.getText().toUpperCase();

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

    private void jtf_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_emailKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_emailKeyPressed

    private void jtf_EndKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_EndKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jtf_EndKeyPressed

    private void jff_CpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_CpfFocusLost
        ValidarCPFeCNPJ();
    }//GEN-LAST:event_jff_CpfFocusLost

    private void jbt_alterarCpfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_alterarCpfCnpjActionPerformed
        this.keyPressed = true;
        if (jlb_cpf_cnpj.getText().equals("*CPF")) {
            Formatacao.formatarCNPJ(jff_Cpf);
            jlb_cpf_cnpj.setText("*CNPJ");
            jbt_alterarCpfCnpj.setText("Alterar para CPF");
        } else if (jlb_cpf_cnpj.getText().equals("*CNPJ")) {
            Formatacao.formatarCPF(jff_Cpf);
            jlb_cpf_cnpj.setText("*CPF");
            jbt_alterarCpfCnpj.setText("Alterar para CNPJ");
        }
    }//GEN-LAST:event_jbt_alterarCpfCnpjActionPerformed

    private void jff_CpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jff_CpfKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jff_CpfKeyPressed

    private void jff_TelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jff_TelefoneKeyPressed
        this.keyPressed = true;
    }//GEN-LAST:event_jff_TelefoneKeyPressed

    private void jff_TelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_TelefoneFocusLost
        ValidarTelefone();
    }//GEN-LAST:event_jff_TelefoneFocusLost

    private void jtf_NomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_NomeFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_Nome);
    }//GEN-LAST:event_jtf_NomeFocusLost

    private void jtf_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_emailFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_email);
    }//GEN-LAST:event_jtf_emailFocusLost

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbt_alterarCpfCnpj;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JButton jbt_salvar_alteracao;
    private javax.swing.JFormattedTextField jff_Cpf;
    private javax.swing.JFormattedTextField jff_Telefone;
    private javax.swing.JLabel jlb_cpf_cnpj;
    private javax.swing.JLabel jll_id;
    private javax.swing.JTextField jtf_End;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JTextField jtf_email;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setDAO(Object dao) {
        this.cliente = (Cliente) dao;

        //Recuperar os valores do ID selecionado na tabela e setando eles nos TextsFields para alteração
        jll_id.setText("" + this.cliente.getId());
        jtf_Nome.setText(this.cliente.getNome());
        jtf_email.setText(this.cliente.getEmail());
        if (Formatacao.removerFormatacao(this.cliente.getCpf()).length() < 14) {
            Formatacao.formatarCPF(jff_Cpf);
            jlb_cpf_cnpj.setText("*CPF");
            jbt_alterarCpfCnpj.setText("Alterar para CNPJ");
        } else {
            Formatacao.formatarCNPJ(jff_Cpf);
            jlb_cpf_cnpj.setText("*CNPJ");
            jbt_alterarCpfCnpj.setText("Alterar para CPF");
        }
        jff_Cpf.setText(Formatacao.removerFormatacao(this.cliente.getCpf()));
        jtf_End.setText(this.cliente.getEndereco());
        jff_Telefone.setText(Formatacao.removerFormatacao(this.cliente.getTelefone()));
    }

    @Override
    public void setDetalhamento(boolean inativarControles) {
        this.inativarControles = inativarControles;
        if (inativarControles) {
            jInternalFrame1.setTitle("Detalhar Cadastro");
        } else {
            jInternalFrame1.setTitle("Alterar/Excluir");
        }
        jtf_Nome.setEditable(!inativarControles);
        jtf_email.setEditable(!inativarControles);
        jff_Cpf.setEditable(!inativarControles);
        jtf_End.setEditable(!inativarControles);
        jff_Telefone.setEditable(!inativarControles);
        jbt_excluir.setEnabled(!inativarControles);
        jbt_limpar.setEnabled(!inativarControles);
        jbt_salvar_alteracao.setEnabled(!inativarControles);
        jbt_alterarCpfCnpj.setEnabled(!inativarControles);
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
        jtf_Nome.setText("");
        jff_Telefone.setText("");
        jff_Cpf.setText("");
        jtf_End.setText("");
        jtf_email.setText("");
    }

    private boolean ValidarTelefone() {
        //Validar o Telefone
        if (!Validacao.validarTelefone(Formatacao.removerFormatacao(jff_Telefone.getText()))) {
            jff_Telefone.setBackground(Color.decode("#FF9696"));
            return false;
        } else {
            jff_Telefone.setBackground(Color.white);
            return true;
        }
    }

    public boolean ValidarCPFeCNPJ() {
        if (jlb_cpf_cnpj.getText().equals("*CPF")) {
            if (!Validacao.validarCPF(Formatacao.removerFormatacao(jff_Cpf.getText()))) {
                jff_Cpf.setBackground(Color.decode("#FF9696"));
                return false;
            } else {
                jff_Cpf.setBackground(Color.white);
                return true;
            }
        } else if (jlb_cpf_cnpj.getText().equals("*CNPJ")) {
            if (!Validacao.validarCNPJ(Formatacao.removerFormatacao(jff_Cpf.getText()))) {
                jff_Cpf.setBackground(Color.decode("#FF9696"));
                return false;
            } else {
                jff_Cpf.setBackground(Color.white);
                return true;
            }
        } else {
            return false;
        }
    }

}
