package view.Movimentacao;

import dao.ClienteDAO;
import dao.ItemDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author ruang
 */
public class jff_pesquisar_item_cliente extends javax.swing.JFrame {

    private int item_id; //Id de cliente ou item selecionado na tabela de pesquisa
    private int pesquisa_item_cliente; //=2: Pesquisa de cliente. =1: Pesquisa de fornecedor. =3: Pesquisa de item
    private String menuSelecionado; //compra, venda ou producao
    private jif_Cadastro_movimentacao jif_cadastroMovimentacao;
    private String grupoTipo; //Vai vir a String da tela JIF_CADASTRO_MOVIMENTACAO. Se for nova compra retorna ('MATERIA-PRIMA', 'OUTRO', 'FERRAMENTA'). Se for Venda retorna ('PRODUTO ACABADO', 'OUTRO')

    public jff_pesquisar_item_cliente(jif_Cadastro_movimentacao tela, String menuSelecionado, int item_cliente, String grupoTipo) {
        this.pesquisa_item_cliente = item_cliente;
        this.menuSelecionado = menuSelecionado;
        this.jif_cadastroMovimentacao = tela;
        this.grupoTipo = grupoTipo;
        initComponents();

        if (this.pesquisa_item_cliente == 2) {
            //Setar o nome dos botões e dos JLabels
            jLabel1.setText("Clientes Cadastrados");
            this.setTitle("Pesquisa - Cliente");
            //Popular a tabela
            new ClienteDAO().popularTabela(jtb_pesquisa, "cliente", "");
        } else if (this.pesquisa_item_cliente == 1) {
            //Setar o nome dos botões e dos JLabels
            jLabel1.setText("Fornecedores Cadastrados");
            this.setTitle("Pesquisa - Fornecedor");
            //Popular a tabela
            new ClienteDAO().popularTabela(jtb_pesquisa, "fornecedor", "");
        } else if (this.pesquisa_item_cliente == 3) {
            //Setar o nome dos botões e dos JLabels
            jLabel1.setText("Itens Cadastrados");
            this.setTitle("Pesquisa - Itens");
            //Popular a tabela
            new ItemDAO().popularTabela(jtb_pesquisa, "", this.grupoTipo);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_pesquisa = new javax.swing.JTable();
        jbt_fechar = new javax.swing.JButton();
        jbt_selecionar = new javax.swing.JButton();
        jtf_filtro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbt_filtrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PESQUISAR");

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 450));

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        jtb_pesquisa.setBackground(new java.awt.Color(250, 250, 250));
        jtb_pesquisa.setForeground(new java.awt.Color(51, 51, 51));
        jtb_pesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtb_pesquisa.setRowHeight(25);
        jtb_pesquisa.setSelectionBackground(new java.awt.Color(13, 71, 161));
        jtb_pesquisa.setSelectionForeground(new java.awt.Color(250, 250, 250));
        jtb_pesquisa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtb_pesquisa.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jtb_pesquisa);

        jbt_fechar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_fechar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_fechar.setText("Fechar");
        jbt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_fecharActionPerformed(evt);
            }
        });

        jbt_selecionar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_selecionar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_selecionar.setText("Selecionar");
        jbt_selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_selecionarActionPerformed(evt);
            }
        });

        jtf_filtro.setBackground(new java.awt.Color(250, 250, 250));
        jtf_filtro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_filtro.setForeground(new java.awt.Color(0, 0, 0));
        jtf_filtro.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_filtro.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Filtro");

        jbt_filtrar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_filtrar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_filtrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar18x18.png"))); // NOI18N
        jbt_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_filtrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbt_selecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbt_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jbt_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_selecionar)
                    .addComponent(jbt_fechar))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_selecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_selecionarActionPerformed
        this.item_id = Integer.parseInt(
                String.valueOf(jtb_pesquisa.getValueAt(jtb_pesquisa.getSelectedRow(), 0))
        );

        if (this.item_id == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela acima", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            if (this.pesquisa_item_cliente == 1 || this.pesquisa_item_cliente == 2) {
                jif_cadastroMovimentacao.NomearCliente(this.item_id);
            } else if (this.pesquisa_item_cliente == 3) {//ITEM
                jif_cadastroMovimentacao.NomearItem(this.item_id);
            }
            this.dispose();
        }
    }//GEN-LAST:event_jbt_selecionarActionPerformed


    private void jbt_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_filtrarActionPerformed
        if (this.pesquisa_item_cliente == 1) {
            //Popular a tabela
            new ClienteDAO().popularTabela(jtb_pesquisa, "cliente", jtf_filtro.getText());
        } else if (this.pesquisa_item_cliente == 2) {
            //Popular a tabela
            new ClienteDAO().popularTabela(jtb_pesquisa, "fornecedor", jtf_filtro.getText());
        } else if (this.pesquisa_item_cliente == 3) {
            //Popular a tabela
            new ItemDAO().popularTabela(jtb_pesquisa, jtf_filtro.getText(), this.grupoTipo);
        }
    }//GEN-LAST:event_jbt_filtrarActionPerformed

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
            java.util.logging.Logger.getLogger(jff_pesquisar_item_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jff_pesquisar_item_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jff_pesquisar_item_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jff_pesquisar_item_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new jff_pesquisar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_filtrar;
    private javax.swing.JButton jbt_selecionar;
    private javax.swing.JTable jtb_pesquisa;
    private javax.swing.JTextField jtf_filtro;
    // End of variables declaration//GEN-END:variables
}
