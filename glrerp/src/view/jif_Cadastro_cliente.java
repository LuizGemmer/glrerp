
package view;

import dao.ClienteDAO;
import entidade.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author ruang
 */
public class jif_Cadastro_cliente extends javax.swing.JInternalFrame {

    private boolean isCliente;
    
       
    public jif_Cadastro_cliente() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbt_Acessar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
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
        jbt_cadastrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();

        jbt_Acessar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_Acessar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_Acessar.setText("Fechar");
        jbt_Acessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_AcessarActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setTitle("Cadastro - Cliente");
        setPreferredSize(new java.awt.Dimension(960, 500));

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

        jtf_Tel.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Tel.setForeground(new java.awt.Color(0, 0, 0));

        jtf_Cpf.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Cpf.setForeground(new java.awt.Color(0, 0, 0));

        jtf_End.setBackground(new java.awt.Color(250, 250, 250));
        jtf_End.setForeground(new java.awt.Color(0, 0, 0));

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
        jLabel6.setText("*E-mail");

        jtf_email.setBackground(new java.awt.Color(250, 250, 250));
        jtf_email.setForeground(new java.awt.Color(0, 0, 0));

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
                                .addComponent(jbt_cadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbt_limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbt_fechar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_End, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
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
                    .addComponent(jbt_cadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel6, jtf_Cpf, jtf_End, jtf_Nome, jtf_Tel, jtf_email});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_AcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_AcessarActionPerformed
        this.dispose();

    }//GEN-LAST:event_jbt_AcessarActionPerformed

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Botão de fechar
        this.dispose();
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

    private void jbt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_cadastrarActionPerformed
        
        //Cadastrar novo Cliente
        //Atribuir dados inseridos pelo usuario a variaveis
        String nomeCliente = jtf_Nome.getText();
        String telCliente = jtf_Tel.getText();
        String cpfCliente = jtf_Cpf.getText();
        String emailCliente = jtf_email.getText();
        String endCliente = jtf_End.getText();

        //Setar nomes das variaveis para o objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setCpf(cpfCliente);
        cliente.setEmail(emailCliente);
        cliente.setTelefone(telCliente);
        cliente.setEndereco(endCliente);
        String cliente_fornecedor;
        
        if(this.isCliente){
            cliente_fornecedor = "cliente";
        }else{
            cliente_fornecedor = "fornecedor";
        }
                    
        cliente.setTipo(cliente_fornecedor);
        
        //Chamar classe ClienteDAO para salvar dados no Banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        
        //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
        if (clienteDAO.salvar(cliente) == null){
            JOptionPane.showMessageDialog(this, "Novo cadastro salvo com sucesso!", "NOVO CADASTRO", JOptionPane.INFORMATION_MESSAGE);
            jtf_Nome.setText("");
            jtf_Tel.setText("");
            jtf_Cpf.setText("");
            jtf_email.setText("");
            jtf_End.setText("");
            
            jtf_Nome.requestFocus();
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao inserir dados de novo cadastro!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbt_cadastrarActionPerformed

    public void setIsCliente(boolean t) {
        this.isCliente = t;
        if(t){
            setTitle("Cadastro - Cliente");
        }else{
            setTitle("Cadastro - Fornecedor");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbt_Acessar;
    private javax.swing.JButton jbt_cadastrar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JTextField jtf_Cpf;
    private javax.swing.JTextField jtf_End;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JTextField jtf_Tel;
    private javax.swing.JTextField jtf_email;
    // End of variables declaration//GEN-END:variables

   
}
