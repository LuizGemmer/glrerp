package view;

import apoio.IDAOT;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import view.Estrutura.jff_pesquisar;

/**
 *
 * @author ruang
 */
public class jif_Listagem_DAO extends javax.swing.JInternalFrame {

    private final IDAOT DAOObject;
    private final jff_ITelaAlterarCadastro telaAlterar;
    private final DefaultTableModel tableModel;
    private boolean telaEstoque = false; //Se for aberto pelo menu no acesso de ESTOQUE a variavel será true
    Color buttonDisableColor = new Color(51, 51, 51);
    Color buttonBlueColor = new Color(13, 71, 161);
    Color buttonGreenColor = new Color(0, 102, 0);

    public jif_Listagem_DAO(IDAOT dao, jff_ITelaAlterarCadastro telaAlterar) {
        this.DAOObject = dao;
        this.telaAlterar = telaAlterar;
        initComponents();
        jbt_movimentacao.setVisible(false);

        this.tableModel = (DefaultTableModel) jTable1.getModel();
        this.setTableColumns();
        this.setTableItems("");
    }

    //Método chamado apenas no menu ESTOQUE
    public jif_Listagem_DAO(IDAOT dao, jff_ITelaAlterarCadastro telaAlterar, boolean telaEstoque) {
        this.telaEstoque = telaEstoque;
        this.DAOObject = dao;
        this.telaAlterar = telaAlterar;
        initComponents();
        jbt_movimentacao.setVisible(this.telaEstoque);
        jbt_detalhar.setVisible(!this.telaEstoque);
        jbt_alterar.setVisible(!this.telaEstoque);

        this.tableModel = (DefaultTableModel) jTable1.getModel();
        this.setTableColumns();
        this.setTableItems("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbt_fechar = new javax.swing.JButton();
        jbt_visualizar = new javax.swing.JButton();
        jtf_Buscar = new javax.swing.JTextField();
        jbt_alterar = new javax.swing.JButton();
        jbt_detalhar = new javax.swing.JButton();
        jbt_movimentacao = new javax.swing.JButton();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Visualizar");
        setMaximumSize(null);
        setVisible(true);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setInheritsPopupMenu(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jTable1.setBackground(new java.awt.Color(250, 250, 250));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setEditingColumn(0);
        jTable1.setEditingRow(0);
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(13, 71, 161));
        jTable1.setSelectionForeground(new java.awt.Color(250, 250, 250));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Filtro:");

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
        jbt_visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar18x18.png"))); // NOI18N
        jbt_visualizar.setText("Visualizar");
        jbt_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_visualizarActionPerformed(evt);
            }
        });

        jtf_Buscar.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Buscar.setForeground(new java.awt.Color(0, 0, 0));
        jtf_Buscar.setCaretColor(new java.awt.Color(0, 0, 0));

        jbt_alterar.setBackground(new java.awt.Color(51, 51, 51));
        jbt_alterar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar30x30.png"))); // NOI18N
        jbt_alterar.setToolTipText("Alterar Cadastro");
        jbt_alterar.setEnabled(false);
        jbt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_alterarActionPerformed(evt);
            }
        });

        jbt_detalhar.setBackground(new java.awt.Color(51, 51, 51));
        jbt_detalhar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_detalhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/detalahar30x30.png"))); // NOI18N
        jbt_detalhar.setToolTipText("Detalhar Cadastro");
        jbt_detalhar.setEnabled(false);
        jbt_detalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_detalharActionPerformed(evt);
            }
        });

        jbt_movimentacao.setBackground(new java.awt.Color(51, 51, 51));
        jbt_movimentacao.setForeground(new java.awt.Color(255, 255, 255));
        jbt_movimentacao.setText("Movimentações");
        jbt_movimentacao.setEnabled(false);
        jbt_movimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_movimentacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbt_movimentacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_fechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_visualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_detalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbt_visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jbt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_detalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_fechar)
                    .addComponent(jbt_movimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setTableColumns() {
        String[] colunasTabela = DAOObject.getTableColumns();
        for (String coluna : colunasTabela) {
            tableModel.addColumn(coluna);
        }
        // Ajuste o tamanho das colunas, exceto a última
        TableColumnModel columnModel = jTable1.getColumnModel();
        int tableWidth = jTable1.getPreferredSize().width;
        int totalColumnWidthsExceptLast = 0;

        if (jTable1.getColumnCount() == 3) {
            TableColumn column0 = columnModel.getColumn(0);
            column0.setPreferredWidth(70);
            TableColumn column1 = columnModel.getColumn(1);
            column1.setPreferredWidth(585);
            TableColumn column2 = columnModel.getColumn(2);
            column2.setPreferredWidth(300);

        } else if (jTable1.getColumnCount() == 4) {
            TableColumn column0 = columnModel.getColumn(0);
            column0.setPreferredWidth(70);
            TableColumn column1 = columnModel.getColumn(1);
            column1.setPreferredWidth(368);
            TableColumn column2 = columnModel.getColumn(2);
            column2.setPreferredWidth(367);
            TableColumn column3 = columnModel.getColumn(3);
            column3.setPreferredWidth(150);

        } else if (jTable1.getColumnCount() == 5) {
            TableColumn column0 = columnModel.getColumn(0);
            column0.setPreferredWidth(70);
            TableColumn column1 = columnModel.getColumn(1);
            column1.setPreferredWidth(400);
            TableColumn column2 = columnModel.getColumn(2);
            column2.setPreferredWidth(115);
            TableColumn column3 = columnModel.getColumn(3);
            column3.setPreferredWidth(70);
            TableColumn column4 = columnModel.getColumn(4);
            column4.setPreferredWidth(300);

        } else if (jTable1.getColumnCount() == 6) {
            TableColumn column0 = columnModel.getColumn(0);
            column0.setPreferredWidth(70);
            TableColumn column1 = columnModel.getColumn(1);
            column1.setPreferredWidth(400);
            TableColumn column2 = columnModel.getColumn(2);
            column2.setPreferredWidth(115);
            TableColumn column3 = columnModel.getColumn(3);
            column3.setPreferredWidth(70);
            TableColumn column4 = columnModel.getColumn(4);
            column4.setPreferredWidth(300);
            TableColumn column5 = columnModel.getColumn(5);
            column5.setPreferredWidth(300);

        } else if (jTable1.getColumnCount() == 7) {
            TableColumn column0 = columnModel.getColumn(0);
            column0.setPreferredWidth(70);
            TableColumn column1 = columnModel.getColumn(1);
            column1.setPreferredWidth(100);
            TableColumn column2 = columnModel.getColumn(2);
            column2.setPreferredWidth(100);
            TableColumn column3 = columnModel.getColumn(3);
            column3.setPreferredWidth(400);
            TableColumn column4 = columnModel.getColumn(4);
            column4.setPreferredWidth(140);
            TableColumn column5 = columnModel.getColumn(5);
            column5.setPreferredWidth(70);
            TableColumn column6 = columnModel.getColumn(6);
            column6.setPreferredWidth(150);
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

        //Ajustar a centralização do texto nas colunas da tabela
        if (jTable1.getColumnCount() == 5) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        } else if (jTable1.getColumnCount() == 7) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
            
        } else {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }

        tableModel.fireTableDataChanged();
        jTable1.setDefaultEditor(Object.class, null); //Proibir a edição das células da tabela
    }

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Fechar esta janela
        this.dispose();

    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_visualizarActionPerformed
        this.setTableItems(jtf_Buscar.getText());
        jbt_alterar.setEnabled(false);
        jbt_alterar.setBackground(buttonDisableColor);
        jbt_detalhar.setEnabled(false);
        jbt_detalhar.setBackground(buttonDisableColor);
        jbt_movimentacao.setEnabled(false);
        jbt_movimentacao.setBackground(buttonDisableColor);
    }//GEN-LAST:event_jbt_visualizarActionPerformed

    private void jbt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_alterarActionPerformed
        //Abrir tela de alteração e exclusão de cadastro
        int id = this.buscarNaTabela();
        this.telaAlterar.setDetalhamento(false);
        this.telaAlterar.setDAO(DAOObject.consultarId(id));
        this.telaAlterar.setTelaParente(this);
        this.telaAlterar.showWindow(true);

    }//GEN-LAST:event_jbt_alterarActionPerformed

    private void jbt_detalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_detalharActionPerformed
        //Abrir tela de detalhamento de cadastro
        int id = this.buscarNaTabela();
        this.telaAlterar.setDAO(DAOObject.consultarId(id));
        this.telaAlterar.setDetalhamento(true);
        this.telaAlterar.setTelaParente(this);
        this.telaAlterar.showWindow(true);
    }//GEN-LAST:event_jbt_detalharActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Habilitar botões de alteração e detalhamento somente quando selecionar uma linha na tabela
        jbt_alterar.setEnabled(true);
        jbt_alterar.setBackground(buttonGreenColor);
        jbt_detalhar.setEnabled(true);
        jbt_detalhar.setBackground(buttonBlueColor);
        jbt_movimentacao.setEnabled(true);
        jbt_movimentacao.setBackground(buttonBlueColor);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbt_movimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_movimentacaoActionPerformed
        String id_tabela = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        int id_IntTabela = Integer.parseInt(id_tabela);
        jff_pesquisar movimentacoes = new jff_pesquisar(id_IntTabela);
        movimentacoes.setVisible(true);
    }//GEN-LAST:event_jbt_movimentacaoActionPerformed

    private int buscarNaTabela() {
        //Buscar o cliente de acordo com a linha selecionada na tabela de visualização
        int rowIndex = jTable1.getSelectedRow();
        int IDAOTid = Integer.parseInt(((Vector) this.tableModel.getDataVector().elementAt(rowIndex)).elementAt(0).toString());
        return IDAOTid;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbt_alterar;
    private javax.swing.JButton jbt_detalhar;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_movimentacao;
    private javax.swing.JButton jbt_visualizar;
    private javax.swing.JTextField jtf_Buscar;
    // End of variables declaration//GEN-END:variables
}
