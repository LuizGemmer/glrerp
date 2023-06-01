package view.Cliente;

import apoio.Formatacao;
import apoio.Validacao;
import dao.ClienteDAO;
import entidade.Cliente;
import java.awt.Color;
import javax.swing.JOptionPane;

public class jif_Cadastro_cliente extends javax.swing.JInternalFrame {

    private boolean isCliente; //Se for TRUE = Cadastro de novo CLIENTE. Se for FALSE = Cadastro de novo fornecedor

    public jif_Cadastro_cliente(boolean tipo) {
        this.isCliente = tipo;
        
        initComponents();
        Formatacao.formatarTelefone(jff_Telefone);
        
        //Iniciar por padrão a tela de cadastro para ser for CLIENTE = Campo de CPF por padrão. FORNECEDOR = Campo de CNPJ por padrão
        if (this.isCliente) {
            Formatacao.formatarCPF(jff_Cpf);
            jlb_cpf_cnpj.setText("*CPF");
            jbt_alterarCpfCnpj.setText("Alterar para CNPJ");
            setTitle("Cadastro - Cliente");
        } else {
            Formatacao.formatarCNPJ(jff_Cpf);
            jlb_cpf_cnpj.setText("*CNPJ");
            jbt_alterarCpfCnpj.setText("Alterar para CPF");
            setTitle("Cadastro - Fornecedor");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlb_cpf_cnpj = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_Nome = new javax.swing.JTextField();
        jtf_End = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_limpar = new javax.swing.JButton();
        jbt_cadastrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();
        jff_Cpf = new javax.swing.JFormattedTextField();
        jff_Telefone = new javax.swing.JFormattedTextField();
        jbt_alterarCpfCnpj = new javax.swing.JButton();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro - Cliente");
        setPreferredSize(new java.awt.Dimension(960, 500));
        getContentPane().setLayout(new java.awt.FlowLayout());

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
        jtf_Nome.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_Nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_NomeFocusLost(evt);
            }
        });

        jtf_End.setBackground(new java.awt.Color(250, 250, 250));
        jtf_End.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_End.setForeground(new java.awt.Color(0, 0, 0));
        jtf_End.setCaretColor(new java.awt.Color(0, 0, 0));

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

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("*E-mail");

        jtf_email.setBackground(new java.awt.Color(250, 250, 250));
        jtf_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_email.setForeground(new java.awt.Color(0, 0, 0));
        jtf_email.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_emailFocusLost(evt);
            }
        });

        jff_Cpf.setBackground(new java.awt.Color(250, 250, 250));
        jff_Cpf.setForeground(new java.awt.Color(0, 0, 0));
        jff_Cpf.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_Cpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jff_Cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jff_CpfFocusLost(evt);
            }
        });

        jff_Telefone.setBackground(new java.awt.Color(250, 250, 250));
        jff_Telefone.setForeground(new java.awt.Color(0, 0, 0));
        jff_Telefone.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_Telefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jff_Telefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jff_TelefoneFocusLost(evt);
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
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jlb_cpf_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
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
                            .addComponent(jtf_End, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jff_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_alterarCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jff_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(245, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jff_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_alterarCpfCnpj)
                    .addComponent(jlb_cpf_cnpj))
                .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_limpar)
                    .addComponent(jbt_fechar))
                .addGap(44, 44, 44))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel4, jLabel6, jlb_cpf_cnpj, jtf_End, jtf_Nome, jtf_email});

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
        if (Validacao.ValidarJTFObrigatorio(jtf_Nome)
                && Validacao.ValidarJTFObrigatorio(jtf_email)
                && ValidarTelefone()
                && ValidarCPFeCNPJ()) {

            //Cadastrar novo Cliente
            //Atribuir dados inseridos pelo usuario a variaveis
            String nomeCliente = jtf_Nome.getText().toUpperCase();
            String telCliente = jff_Telefone.getText();
            String cpfCliente = jff_Cpf.getText();
            String emailCliente = jtf_email.getText();
            String endCliente = jtf_End.getText().toUpperCase();

            //Setar nomes das variaveis para o objeto Cliente
            Cliente cliente = new Cliente();
            cliente.setNome(nomeCliente);
            cliente.setCpf(cpfCliente);
            cliente.setEmail(emailCliente);
            cliente.setTelefone(telCliente);
            cliente.setEndereco(endCliente);
            String cliente_fornecedor;

            if (this.isCliente) {
                cliente_fornecedor = "cliente";
            } else {
                cliente_fornecedor = "fornecedor";
            }

            cliente.setTipo(cliente_fornecedor);

            //Chamar classe ClienteDAO para salvar dados no Banco de dados
            ClienteDAO clienteDAO = new ClienteDAO();

            //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
            if (clienteDAO.salvar(cliente) == null) {
                JOptionPane.showMessageDialog(this, "Novo cadastro salvo com sucesso!", "NOVO CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                LimparCampos();

                jtf_Nome.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir dados de novo cadastro!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbt_cadastrarActionPerformed

    private void jtf_NomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_NomeFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_Nome);
    }//GEN-LAST:event_jtf_NomeFocusLost

    private void jtf_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_emailFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_email);
    }//GEN-LAST:event_jtf_emailFocusLost

    private void jff_TelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_TelefoneFocusLost
        ValidarTelefone();
    }//GEN-LAST:event_jff_TelefoneFocusLost

    private void jff_CpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_CpfFocusLost
        ValidarCPFeCNPJ();
    }//GEN-LAST:event_jff_CpfFocusLost

    private void jbt_alterarCpfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_alterarCpfCnpjActionPerformed
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbt_alterarCpfCnpj;
    private javax.swing.JButton jbt_cadastrar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JFormattedTextField jff_Cpf;
    private javax.swing.JFormattedTextField jff_Telefone;
    private javax.swing.JLabel jlb_cpf_cnpj;
    private javax.swing.JTextField jtf_End;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JTextField jtf_email;
    // End of variables declaration//GEN-END:variables

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
