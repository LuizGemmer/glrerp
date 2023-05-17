/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.ClienteDAO;
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

    private final ClienteDAO clienteDAO = new ClienteDAO();
    private ArrayList<Cliente> clientes = clienteDAO.consultarTodos("cliente");

    private DefaultTableModel tableModel;

    public jif_Visualizar_cliente() {
        initComponents();
        this.tableModel = (DefaultTableModel) jTable1.getModel();
        this.getTableItems("");
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
        jbt_detalhar = new javax.swing.JButton();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setTitle("Visualizar - Cliente");
        setPreferredSize(new java.awt.Dimension(960, 500));

        jTable1.setBackground(new java.awt.Color(250, 250, 250));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF/CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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
        jbt_alterar.setEnabled(false);
        jbt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_alterarActionPerformed(evt);
            }
        });

        jbt_detalhar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_detalhar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_detalhar.setText("Detalhar Cadastro");
        jbt_detalhar.setEnabled(false);
        jbt_detalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_detalharActionPerformed(evt);
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
                        .addComponent(jbt_detalhar)
                        .addGap(18, 18, 18)
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
                    .addComponent(jbt_alterar)
                    .addComponent(jbt_detalhar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void getTableItems(String termoBusca) {
        // Remove os itens da tabela
        this.tableModel.getDataVector().removeAllElements();
        this.tableModel.fireTableDataChanged();

        this.clientes = clienteDAO.consultarTodos("cliente");

        // filtra os novos itens
        ArrayList<String[]> newData = new ArrayList();
        for (Cliente cliente : clientes) {
            String[] data = {
                Integer.toString(cliente.getId()),
                cliente.getNome(),
                cliente.getCpf()
            };

            if (termoBusca.equals("")) {
                newData.add(data);
            } else if (data[1].toLowerCase().contains(termoBusca.toLowerCase())
                    || data[2].toLowerCase().contains(termoBusca.toLowerCase())) {
                newData.add(data);
            }
        }

        for (String[] data : newData) {
            this.tableModel.addRow(data);
        }

        tableModel.fireTableDataChanged();
    }

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Fechar esta janela
        this.dispose();

    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_visualizarActionPerformed
        this.getTableItems(jtf_Buscar.getText());
        jbt_alterar.setEnabled(false);
        jbt_detalhar.setEnabled(false);
    }//GEN-LAST:event_jbt_visualizarActionPerformed

    private void jbt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_alterarActionPerformed
        //Abrir tela de alteração e exclusão de cadastro
        new jff_Alterar_cliente(this.buscarNaTabela(), this, false);
    }//GEN-LAST:event_jbt_alterarActionPerformed

    private void jbt_detalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_detalharActionPerformed
        //Abrir tela de detalhamento de cadastro
        new jff_Alterar_cliente(this.buscarNaTabela(), this, true);
    }//GEN-LAST:event_jbt_detalharActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Habilitar botões de alteração e detalhamento somente quando selecionar uma linha na tabela
        jbt_alterar.setEnabled(true);
        jbt_detalhar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private Cliente buscarNaTabela() {
        //Buscar o cliente de acordo com a linha selecionada na tabela de visualização
        int rowIndex = jTable1.getSelectedRow();
        String clienteId = ((Vector) this.tableModel.getDataVector().elementAt(rowIndex)).elementAt(0).toString();

        for (Cliente c : clientes) {
            if (("" + c.getId()).equals(clienteId)) {
                return c;
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbt_alterar;
    private javax.swing.JButton jbt_detalhar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_visualizar;
    private javax.swing.JTextField jtf_Buscar;
    // End of variables declaration//GEN-END:variables
}
