package view.Menu.raven.main;

import apoio.IDAOT;
import dao.ClienteDAO;
import dao.GrupoDAO;
import dao.ItemDAO;
import dao.movimentacaoDAO;
import dao.userDAO;
import view.Menu.component.DefaultForm;
import java.awt.Component;
import javax.swing.JFrame;
import view.Cliente.jff_Alterar_cliente;
import view.Cliente.jif_Cadastro_cliente;
import view.Estrutura.jif_Cadastro_estrutura;
import view.Grupo.jff_Alterar_grupo;
import view.Grupo.jif_Cadastro_grupo;
import view.Item.jff_Alterar_item;
import view.Item.jif_Cadastro_item;
import view.Menu.raven.menu.MenuEvent;
import view.Movimentacao.jff_alterar_movimentacao;
import view.Movimentacao.jff_pesquisar_item_cliente;
import view.Movimentacao.jif_Cadastro_movimentacao;
import view.Movimentacao.jif_alterar_movimentacao;
import view.Relatorio.jif_relatorio;
import view.Usuario.jff_Alterar_User;
import view.Usuario.jif_Cadastro_user;
import view.jff_ITelaAlterarCadastro;
import view.jif_Listagem_DAO;

public class Main extends javax.swing.JFrame {

    private final jif_Cadastro_cliente tipo;
    private jif_Listagem_DAO visualizarIsOpen;
    public jff_pesquisar_item_cliente telapesq;

    private void abrirListagemDAO(IDAOT dao, jff_ITelaAlterarCadastro tela, String titulo) {
        jif_Listagem_DAO telaListagem = new jif_Listagem_DAO(dao, tela);
        if (visualizarIsOpen != null) {
            this.visualizarIsOpen.dispose();
        }
        showForm(telaListagem);
        String title = ("Visualizar - " + titulo).toUpperCase();
        telaListagem.setTitle(title);
        telaListagem.setVisible(true);
        this.visualizarIsOpen = telaListagem;
    }

    public Main() {
        this.tipo = null;
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu1.setEvent(new MenuEvent() {

            @Override
            public void selected(int index, int subIndex) {
                if (index == 0 && subIndex == 1) { // --------------------------- VISUALIZAR CLIENTES
                    jif_Listagem_DAO jifVis_cliente = new jif_Listagem_DAO(new ClienteDAO("cliente"), new jff_Alterar_cliente());
                    showForm(jifVis_cliente);
                    jifVis_cliente.setTitle("VISUALIZAR - CLIENTES");
                    jifVis_cliente.setVisible(true);

                } else if (index == 0 && subIndex == 2) { // --------------------------- CADASTRAR CLIENTES
                    jif_Cadastro_cliente jif_cad_cliente = new jif_Cadastro_cliente(true);
                    showForm(jif_cad_cliente);
                    jif_cad_cliente.setVisible(true);

                } else if (index == 1 && subIndex == 1) { // --------------------------- VISUALIZAR FORNECEDORES
                    jif_Listagem_DAO jifVis_cliente = new jif_Listagem_DAO(new ClienteDAO("fornecedor"), new jff_Alterar_cliente());
                    showForm(jifVis_cliente);
                    jifVis_cliente.setTitle("VISUALIZAR - FORNECEDORES");
                    jifVis_cliente.setVisible(true);

                } else if (index == 1 && subIndex == 2) { // --------------------------- CADASTRAR FORNECEDORES
                    jif_Cadastro_cliente jif_cad_cliente = new jif_Cadastro_cliente(false);
                    showForm(jif_cad_cliente);
                    jif_cad_cliente.setVisible(true);

                } else if (index == 2 && subIndex == 1) { // --------------------------- VISUALIZAR ITEM
                    jif_Listagem_DAO jifVis_item = new jif_Listagem_DAO(new ItemDAO(), new jff_Alterar_item());
                    showForm(jifVis_item);
                    jifVis_item.setTitle("VISUALIZAR - ITENS");
                    jifVis_item.setVisible(true);

                } else if (index == 2 && subIndex == 2) { // --------------------------- CADASTRAR ITEM
                    jif_Cadastro_item jif_cad_item = new jif_Cadastro_item();
                    showForm(jif_cad_item);
                    jif_cad_item.setVisible(true);

                } else if (index == 3 && subIndex == 1) { // --------------------------- VISUALIZAR GRUPO
                    jif_Listagem_DAO jifVis_grupo = new jif_Listagem_DAO(new GrupoDAO(), new jff_Alterar_grupo());
                    showForm(jifVis_grupo);
                    jifVis_grupo.setTitle("VISUALIZAR - GRUPOS");
                    jifVis_grupo.setVisible(true);

                } else if (index == 3 && subIndex == 2) { // --------------------------- CADASTRAR GRUPO
                    jif_Cadastro_grupo jif_cad_grupo = new jif_Cadastro_grupo();
                    showForm(jif_cad_grupo);
                    jif_cad_grupo.setVisible(true);

                } else if (index == 4 && subIndex == 1) { // --------------------------- CADASTRAR ESTRUTURA
                    jif_Cadastro_estrutura jif_cad_est = new jif_Cadastro_estrutura();
                    showForm(jif_cad_est);
                    jif_cad_est.setVisible(true);
                    
                } else if (index == 5 && subIndex == 1) { // --------------------------- VISUALIZAR COMPRAS
                    abrirListagemDAO(new movimentacaoDAO("compra"), new jff_alterar_movimentacao(), "Compras");

                } else if (index == 5 && subIndex == 2) { // --------------------------- CADASTRAR COMPRAS
                    jif_Cadastro_movimentacao cadastro_movimentacao = new jif_Cadastro_movimentacao("compra");
                    showForm(cadastro_movimentacao);
                    cadastro_movimentacao.setVisible(true);
                    
                } else if (index == 6 && subIndex == 1) { // --------------------------- VISUALIZAR PRODUÇÃO
                    abrirListagemDAO(new movimentacaoDAO("producao"), new jff_alterar_movimentacao(), "Produção");

                } else if (index == 6 && subIndex == 2) { // --------------------------- CADASTRAR PRODUÇÃO
                    jif_Cadastro_movimentacao cadastro_movimentacao = new jif_Cadastro_movimentacao("producao");
                    showForm(cadastro_movimentacao);
                    cadastro_movimentacao.setVisible(true);

                } else if (index == 7 && subIndex == 1) { // --------------------------- VISUALIZAR VENDAS
                    abrirListagemDAO(new movimentacaoDAO("venda"), new jff_alterar_movimentacao(), "Vendas");

                } else if (index == 7 && subIndex == 2) { // --------------------------- CADASTRAR VENDAS
                    jif_Cadastro_movimentacao cadastro_movimentacao = new jif_Cadastro_movimentacao("venda");
                    showForm(cadastro_movimentacao);
                    cadastro_movimentacao.setVisible(true);

                } else if (index == 8 && subIndex == 1) { // --------------------------- VISUALIZAR ESTOQUE
                    jif_Listagem_DAO jifVis_item = new jif_Listagem_DAO(new ItemDAO(), new jff_Alterar_item(), true);
                    showForm(jifVis_item);
                    jifVis_item.setTitle("VISUALIZAR - ESTOQUE");
                    jifVis_item.setVisible(true);

                } else if (index == 9 && subIndex == 1) { // --------------------------- VISUALIZAR RELATÓRIOS
                    jif_relatorio jif_rel = new jif_relatorio();
                    showForm(jif_rel);
                    jif_rel.setVisible(true);

                } else if (index == 10 && subIndex == 1) { // --------------------------- VISUALIZAR USUARIO
                    jif_Listagem_DAO jif_listagem_user = new jif_Listagem_DAO(new userDAO(), new jff_Alterar_User());

                    jif_listagem_user.setTitle("VISUALIZAR - USUÁRIOS");
                    showForm(jif_listagem_user);
                    jif_listagem_user.setVisible(true);

                } else if (index == 10 && subIndex == 2) { // --------------------------- CADASTRAR USUARIO
                    jif_Cadastro_user jif_cad_user = new jif_Cadastro_user();
                    showForm(jif_cad_user);
                    jif_cad_user.setVisible(true);

                } else {
                    showForm(new DefaultForm("Form : " + index + " " + subIndex));
                }
            }
        });
    }

    public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPaneWin111 = new view.Menu.raven.scroll.win11.ScrollPaneWin11();
        menu1 = new view.Menu.raven.menu.Menu();
        header1 = new view.Menu.component.Header();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(163, 163, 163)));

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setViewportView(menu1);

        body.setBackground(new java.awt.Color(238, 238, 238));
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private view.Menu.component.Header header1;
    private javax.swing.JPanel jPanel1;
    private view.Menu.raven.menu.Menu menu1;
    private view.Menu.raven.scroll.win11.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
