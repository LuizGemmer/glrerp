package view.Item;

import dao.GrupoDAO;
import dao.ItemDAO;
import entidade.Grupo;
import entidade.Item;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ruang
 */
public class jif_Cadastro_item extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel model;

    public jif_Cadastro_item() {
        Grupo[] grupoComboBox = new GrupoDAO().consultarComboBox();
        this.model = new DefaultComboBoxModel(grupoComboBox);
        initComponents();
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
        jcb_Grupo = new javax.swing.JComboBox<Grupo>();
        jcb_Unidade_medida = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_Observacao = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setTitle("Cadastro - Item");
        setPreferredSize(new java.awt.Dimension(960, 500));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("*Descrição");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("*Grupo");

        jtf_Descricao.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_Descricao.setForeground(new java.awt.Color(0, 0, 0));

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
        jLabel6.setText("*Estoque Inicial");

        jtf_estoque_inicial.setBackground(new java.awt.Color(250, 250, 250));
        jtf_estoque_inicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_estoque_inicial.setForeground(new java.awt.Color(0, 0, 0));

        jcb_Grupo.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Grupo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_Grupo.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Grupo.setMaximumRowCount(150);
        jcb_Grupo.setModel(this.model);

        jcb_Unidade_medida.setBackground(new java.awt.Color(250, 250, 250));
        jcb_Unidade_medida.setForeground(new java.awt.Color(0, 0, 0));
        jcb_Unidade_medida.setMaximumRowCount(150);
        jcb_Unidade_medida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "und", "caixa", "pacote", "fração", "m", "m²", "m linear", "cm", "mm", "L", "mL", "m³", "cm³", "dm³", "ton", "kg", "g", "mg" }));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("*Unidade de medida");

        jta_Observacao.setBackground(new java.awt.Color(250, 250, 250));
        jta_Observacao.setColumns(20);
        jta_Observacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jta_Observacao.setForeground(new java.awt.Color(0, 0, 0));
        jta_Observacao.setRows(5);
        jScrollPane1.setViewportView(jta_Observacao);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Observações");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jbt_limpar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtf_estoque_inicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                            .addComponent(jcb_Unidade_medida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(57, 57, 57))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtf_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 213, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbt_fechar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(jbt_cadastrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtf_estoque_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_Unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbt_fechar)
                        .addComponent(jbt_limpar))
                    .addComponent(jbt_cadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        jtf_Descricao.setText("");
        jcb_Grupo.setSelectedIndex(0);
        jtf_estoque_inicial.setText("");
        jcb_Unidade_medida.setSelectedIndex(0);
        jta_Observacao.setText("");
        jtf_Descricao.requestFocus();
    }//GEN-LAST:event_jbt_limparActionPerformed

    private void jbt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_cadastrarActionPerformed
        //Cadastro de Item
        //Atribuir dados inseridos pelo usuario a variaveis
        String descItem = jtf_Descricao.getText().toUpperCase();
        int grupoItem = ((Grupo) jcb_Grupo.getSelectedItem()).getId();
        double estoqueItem = Double.parseDouble(jtf_estoque_inicial.getText().replace(',', '.'));
        String unidadeMedida = jcb_Unidade_medida.getSelectedItem().toString();
        String obs = jta_Observacao.getText();

        //Setar nomes das variaveis para o objeto Item
        Item item = new Item();
        item.setDescricao(descItem);
        item.setId_grupo(grupoItem);
        item.setQtde_estoque(estoqueItem);
        item.setUnidade_medida(unidadeMedida);
        item.setObservacao(obs);

        //Chamar classe ItemDAO para salvar dados no Banco de dados
        ItemDAO itemDAO = new ItemDAO();

        //Verifica se o cadastro foi bem sucessido e limpa a tela. Caso contrário apresenta mensagem de erro
        if (itemDAO.salvar(item) == null) {
            JOptionPane.showMessageDialog(this, "Novo item salvo com sucesso!", "ITEM CADASTRADO", JOptionPane.INFORMATION_MESSAGE);
            jtf_Descricao.setText("");
            jcb_Grupo.setSelectedIndex(0);
            jtf_estoque_inicial.setText("");
            jcb_Unidade_medida.setSelectedIndex(0);
            jta_Observacao.setText("");
            jtf_Descricao.requestFocus();

        } else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbt_cadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_cadastrar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_limpar;
    private javax.swing.JComboBox<Grupo> jcb_Grupo;
    private javax.swing.JComboBox jcb_Unidade_medida;
    private javax.swing.JTextArea jta_Observacao;
    private javax.swing.JTextField jtf_Descricao;
    private javax.swing.JTextField jtf_estoque_inicial;
    // End of variables declaration//GEN-END:variables
}
