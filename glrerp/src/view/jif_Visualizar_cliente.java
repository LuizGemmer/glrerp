/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import apoio.IDAOT;
import entidade.Cliente;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruang
 */
public class jif_Visualizar_cliente extends javax.swing.JInternalFrame {

    private final IDAOT DAOObject;
    private ArrayList<IDAOT> DAOresults;

    private DefaultTableModel tableModel;

    public jif_Visualizar_cliente(IDAOT dao) {
        this.DAOObject = dao;
        
        initComponents();
        this.tableModel = (DefaultTableModel) jTable1.getModel();
        this.setTableColumns();
        this.setTableItems("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbt_fechar = new javax.swing.JButton();
        jbt_visualizar = new javax.swing.JButton();
        jtf_Buscar = new javax.swing.JTextField();
        jbt_alterar = new javax.swing.JButton();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setTitle("Visualizar - Cliente");
        setPreferredSize(new java.awt.Dimension(960, 500));

        jTable1.setBackground(new java.awt.Color(250, 250, 250));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Busca:");

        jbt_fechar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_fechar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_fechar.setText("Fechar");
        jbt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_fecharActionPerformed(evt);
            }
        });

        jbt_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_visualizar.setText("Visualizar");
        jbt_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_visualizarActionPerformed(evt);
            }
        });

        jtf_Buscar.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Buscar.setForeground(new java.awt.Color(0, 0, 0));

        jbt_alterar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_alterar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_alterar.setText("Alterar Cadastro");
        jbt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_alterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_visualizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbt_alterar)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_fechar)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbt_visualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jtf_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_fechar)
                    .addComponent(jbt_alterar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setTableColumns() {
       String[] colunasTabela = DAOObject.getTableColumns();
       for(String coluna : colunasTabela) {
           tableModel.addColumn(coluna);
       }
    }
    
    public void setTableItems(String termoBusca) {
        // Remove os itens da tabela
        this.tableModel.getDataVector().removeAllElements();
        this.tableModel.fireTableDataChanged();
        
        ArrayList<String[]> novosDados = this.DAOObject.paraListagemTabela(termoBusca);
        for (String[] row : novosDados) {
            this.tableModel.addRow(row);
        }

        tableModel.fireTableDataChanged();
    }

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Fechar esta janela
        this.dispose();

    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_visualizarActionPerformed
        this.setTableItems(jtf_Buscar.getText());
    }//GEN-LAST:event_jbt_visualizarActionPerformed

    private void jbt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_alterarActionPerformed
        //Abrir tela de alteração e exclusão de cadastro
        int rowIndex = jTable1.getSelectedRow();
        int IDAOTid = Integer.parseInt(((Vector) this.tableModel.getDataVector().elementAt(rowIndex)).elementAt(0).toString());

        new jff_Alterar_cliente((Cliente)DAOObject.consultarId(IDAOTid), this).setVisible(true);

    }//GEN-LAST:event_jbt_alterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbt_alterar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_visualizar;
    private javax.swing.JTextField jtf_Buscar;
    // End of variables declaration//GEN-END:variables
}
