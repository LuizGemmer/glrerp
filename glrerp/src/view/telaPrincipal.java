package view;

import apoio.IDAOT;
import view.Usuario.jff_Alterar_User;
import view.Item.jif_Cadastro_item;
import view.Usuario.jif_Cadastro_user;
import view.Item.jff_Alterar_item;
import view.Cliente.jff_Alterar_cliente;
import view.Cliente.jif_Cadastro_cliente;
import dao.ClienteDAO;
import dao.GrupoDAO;
import dao.ItemDAO;
import dao.movimentacaoDAO;
import dao.userDAO;
import view.Estrutura.jif_Cadastro_estrutura;
import view.Grupo.jff_Alterar_grupo;
import view.Grupo.jif_Cadastro_grupo;
import view.Movimentacao.jff_alterar_movimentacao;
import view.Movimentacao.jff_pesquisar_item;

/**
 *
 * @author ruang
 */
public class telaPrincipal extends javax.swing.JFrame {

    private final jif_Cadastro_cliente tipo;

    private jif_Listagem_DAO visualizarIsOpen;

    public telaPrincipal() {
        initComponents();
        this.tipo = null;
        this.setExtendedState(MAXIMIZED_BOTH);

    }

    private void abrirListagemDAO(IDAOT dao, jff_ITelaAlterarCadastro tela) {
        jif_Listagem_DAO telaListagem = new jif_Listagem_DAO(dao, tela);
        if (visualizarIsOpen != null) {
            this.visualizarIsOpen.dispose();
        }
        jDesktopPane1.add(telaListagem);
        telaListagem.setTitle("VISUALIZAR - ITENS");
        telaListagem.setVisible(true);
        this.visualizarIsOpen = telaListagem;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jm_pessoa = new javax.swing.JMenu();
        jm_cliente = new javax.swing.JMenu();
        jm_cliente_visualizar = new javax.swing.JMenuItem();
        jm_cliente_cadastro = new javax.swing.JMenuItem();
        jm_fornecedor = new javax.swing.JMenu();
        jm_fornecedor_visualizar = new javax.swing.JMenuItem();
        jm_fornecedor_cadastro = new javax.swing.JMenuItem();
        jm_item = new javax.swing.JMenu();
        jm_item2 = new javax.swing.JMenu();
        jm_item_visualizar = new javax.swing.JMenuItem();
        jm_item_cadastro = new javax.swing.JMenuItem();
        jm_grupo = new javax.swing.JMenu();
        jm_grupo_visualizar = new javax.swing.JMenuItem();
        jm_grupo_cadastro = new javax.swing.JMenuItem();
        jm_estrutura = new javax.swing.JMenu();
        jm_estrutura_cadastro = new javax.swing.JMenuItem();
        jm_movimentacoes = new javax.swing.JMenu();
        jm_vendas = new javax.swing.JMenu();
        jm_vendas_visualizar = new javax.swing.JMenuItem();
        jm_vendas_cadastro = new javax.swing.JMenuItem();
        jm_compras = new javax.swing.JMenu();
        jm_compras_visualizar = new javax.swing.JMenuItem();
        jm_compras_cadastro = new javax.swing.JMenuItem();
        jm_producao = new javax.swing.JMenu();
        jm_producao_visualizar = new javax.swing.JMenuItem();
        jm_producao_cadastro = new javax.swing.JMenuItem();
        jm_almox = new javax.swing.JMenu();
        jm_almox_visualizar = new javax.swing.JMenuItem();
        jm_user = new javax.swing.JMenu();
        jm_user_visualizar = new javax.swing.JMenuItem();
        jm_user_cadastro = new javax.swing.JMenuItem();
        jm_relatorio = new javax.swing.JMenu();
        jm_relatorio_visualizar = new javax.swing.JMenuItem();
        jm_relatorio_cadastro = new javax.swing.JMenuItem();
        jm_ajuda = new javax.swing.JMenu();
        jm_ajuda_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(13, 71, 161));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jDesktopPane1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenuBar2.setBackground(new java.awt.Color(13, 71, 161));
        jMenuBar2.setBorder(null);
        jMenuBar2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar2.setAutoscrolls(true);
        jMenuBar2.setBorderPainted(false);
        jMenuBar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jMenuBar2.setMargin(new java.awt.Insets(30, 30, 30, 30));
        jMenuBar2.setMinimumSize(new java.awt.Dimension(434, 50));
        jMenuBar2.setOpaque(true);
        jMenuBar2.setPreferredSize(new java.awt.Dimension(500, 40));

        jm_pessoa.setBackground(new java.awt.Color(13, 71, 161));
        jm_pessoa.setBorder(null);
        jm_pessoa.setForeground(new java.awt.Color(255, 255, 255));
        jm_pessoa.setText("PESSOA");
        jm_pessoa.setAlignmentX(1.0F);
        jm_pessoa.setAlignmentY(1.0F);
        jm_pessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_pessoa.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_pessoa.setHideActionText(true);
        jm_pessoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jm_pessoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jm_pessoa.setIconTextGap(10);
        jm_pessoa.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jm_pessoa.setOpaque(true);

        jm_cliente.setBackground(new java.awt.Color(13, 71, 161));
        jm_cliente.setBorder(null);
        jm_cliente.setForeground(new java.awt.Color(250, 250, 250));
        jm_cliente.setText("CLIENTE");
        jm_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_cliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_cliente.setHideActionText(true);
        jm_cliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_cliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_cliente.setMaximumSize(null);
        jm_cliente.setMinimumSize(null);
        jm_cliente.setOpaque(true);
        jm_cliente.setPreferredSize(new java.awt.Dimension(150, 35));

        jm_cliente_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_cliente_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_cliente_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_cliente_visualizar.setText("Visualizar/Editar");
        jm_cliente_visualizar.setBorder(null);
        jm_cliente_visualizar.setBorderPainted(false);
        jm_cliente_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_cliente_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_cliente_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_cliente_visualizar.setMaximumSize(null);
        jm_cliente_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_cliente_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_cliente_visualizarActionPerformed(evt);
            }
        });
        jm_cliente.add(jm_cliente_visualizar);

        jm_cliente_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_cliente_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_cliente_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_cliente_cadastro.setText("Novo Cliente");
        jm_cliente_cadastro.setBorder(null);
        jm_cliente_cadastro.setBorderPainted(false);
        jm_cliente_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_cliente_cadastro.setFocusPainted(true);
        jm_cliente_cadastro.setFocusable(true);
        jm_cliente_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_cliente_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_cliente_cadastro.setMaximumSize(null);
        jm_cliente_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_cliente_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_cliente_cadastroActionPerformed(evt);
            }
        });
        jm_cliente.add(jm_cliente_cadastro);

        jm_pessoa.add(jm_cliente);

        jm_fornecedor.setBackground(new java.awt.Color(13, 71, 161));
        jm_fornecedor.setBorder(null);
        jm_fornecedor.setForeground(new java.awt.Color(250, 250, 250));
        jm_fornecedor.setText("FORNECEDOR");
        jm_fornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_fornecedor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_fornecedor.setHideActionText(true);
        jm_fornecedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_fornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_fornecedor.setMaximumSize(null);
        jm_fornecedor.setMinimumSize(null);
        jm_fornecedor.setOpaque(true);
        jm_fornecedor.setPreferredSize(new java.awt.Dimension(150, 35));

        jm_fornecedor_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_fornecedor_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_fornecedor_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_fornecedor_visualizar.setText("Visualizar/Editar");
        jm_fornecedor_visualizar.setBorder(null);
        jm_fornecedor_visualizar.setBorderPainted(false);
        jm_fornecedor_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_fornecedor_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_fornecedor_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_fornecedor_visualizar.setMaximumSize(null);
        jm_fornecedor_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_fornecedor_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_fornecedor_visualizarActionPerformed(evt);
            }
        });
        jm_fornecedor.add(jm_fornecedor_visualizar);

        jm_fornecedor_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_fornecedor_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_fornecedor_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_fornecedor_cadastro.setText("Novo Fornecedor");
        jm_fornecedor_cadastro.setBorder(null);
        jm_fornecedor_cadastro.setBorderPainted(false);
        jm_fornecedor_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_fornecedor_cadastro.setFocusPainted(true);
        jm_fornecedor_cadastro.setFocusable(true);
        jm_fornecedor_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_fornecedor_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_fornecedor_cadastro.setMaximumSize(null);
        jm_fornecedor_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_fornecedor_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_fornecedor_cadastroActionPerformed(evt);
            }
        });
        jm_fornecedor.add(jm_fornecedor_cadastro);

        jm_pessoa.add(jm_fornecedor);

        jMenuBar2.add(jm_pessoa);

        jm_item.setBackground(new java.awt.Color(13, 71, 161));
        jm_item.setBorder(null);
        jm_item.setForeground(new java.awt.Color(255, 255, 255));
        jm_item.setText("ITEM");
        jm_item.setAlignmentX(1.0F);
        jm_item.setAlignmentY(1.0F);
        jm_item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_item.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_item.setHideActionText(true);
        jm_item.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jm_item.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jm_item.setIconTextGap(10);
        jm_item.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jm_item.setOpaque(true);

        jm_item2.setBackground(new java.awt.Color(13, 71, 161));
        jm_item2.setBorder(null);
        jm_item2.setForeground(new java.awt.Color(250, 250, 250));
        jm_item2.setText("ITEM");
        jm_item2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_item2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_item2.setHideActionText(true);
        jm_item2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_item2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_item2.setMaximumSize(null);
        jm_item2.setMinimumSize(null);
        jm_item2.setOpaque(true);
        jm_item2.setPreferredSize(new java.awt.Dimension(150, 35));

        jm_item_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_item_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_item_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_item_visualizar.setText("Visualizar/Editar");
        jm_item_visualizar.setBorder(null);
        jm_item_visualizar.setBorderPainted(false);
        jm_item_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_item_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_item_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_item_visualizar.setMaximumSize(null);
        jm_item_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_item_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_item_visualizarActionPerformed(evt);
            }
        });
        jm_item2.add(jm_item_visualizar);

        jm_item_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_item_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_item_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_item_cadastro.setText("Novo Item");
        jm_item_cadastro.setBorder(null);
        jm_item_cadastro.setBorderPainted(false);
        jm_item_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_item_cadastro.setFocusPainted(true);
        jm_item_cadastro.setFocusable(true);
        jm_item_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_item_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_item_cadastro.setMaximumSize(null);
        jm_item_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_item_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_item_cadastroActionPerformed(evt);
            }
        });
        jm_item2.add(jm_item_cadastro);

        jm_item.add(jm_item2);

        jm_grupo.setBackground(new java.awt.Color(13, 71, 161));
        jm_grupo.setBorder(null);
        jm_grupo.setForeground(new java.awt.Color(250, 250, 250));
        jm_grupo.setText("GRUPO");
        jm_grupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_grupo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_grupo.setHideActionText(true);
        jm_grupo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_grupo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_grupo.setMaximumSize(null);
        jm_grupo.setMinimumSize(null);
        jm_grupo.setOpaque(true);
        jm_grupo.setPreferredSize(new java.awt.Dimension(150, 35));

        jm_grupo_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_grupo_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_grupo_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_grupo_visualizar.setText("Visualizar/Editar");
        jm_grupo_visualizar.setBorder(null);
        jm_grupo_visualizar.setBorderPainted(false);
        jm_grupo_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_grupo_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_grupo_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_grupo_visualizar.setMaximumSize(null);
        jm_grupo_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_grupo_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_grupo_visualizarActionPerformed(evt);
            }
        });
        jm_grupo.add(jm_grupo_visualizar);

        jm_grupo_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_grupo_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_grupo_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_grupo_cadastro.setText("Novo Grupo");
        jm_grupo_cadastro.setBorder(null);
        jm_grupo_cadastro.setBorderPainted(false);
        jm_grupo_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_grupo_cadastro.setFocusPainted(true);
        jm_grupo_cadastro.setFocusable(true);
        jm_grupo_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_grupo_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_grupo_cadastro.setMaximumSize(null);
        jm_grupo_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_grupo_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_grupo_cadastroActionPerformed(evt);
            }
        });
        jm_grupo.add(jm_grupo_cadastro);

        jm_item.add(jm_grupo);

        jm_estrutura.setBackground(new java.awt.Color(13, 71, 161));
        jm_estrutura.setBorder(null);
        jm_estrutura.setForeground(new java.awt.Color(250, 250, 250));
        jm_estrutura.setText("ESTRUTURA");
        jm_estrutura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_estrutura.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_estrutura.setHideActionText(true);
        jm_estrutura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_estrutura.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_estrutura.setMaximumSize(null);
        jm_estrutura.setMinimumSize(null);
        jm_estrutura.setOpaque(true);
        jm_estrutura.setPreferredSize(new java.awt.Dimension(150, 35));

        jm_estrutura_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_estrutura_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_estrutura_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_estrutura_cadastro.setText("Gerenciar Estruturas");
        jm_estrutura_cadastro.setBorder(null);
        jm_estrutura_cadastro.setBorderPainted(false);
        jm_estrutura_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_estrutura_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_estrutura_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_estrutura_cadastro.setMaximumSize(null);
        jm_estrutura_cadastro.setPreferredSize(new java.awt.Dimension(170, 35));
        jm_estrutura_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_estrutura_cadastroActionPerformed(evt);
            }
        });
        jm_estrutura.add(jm_estrutura_cadastro);

        jm_item.add(jm_estrutura);

        jMenuBar2.add(jm_item);

        jm_movimentacoes.setBackground(new java.awt.Color(13, 71, 161));
        jm_movimentacoes.setBorder(null);
        jm_movimentacoes.setForeground(new java.awt.Color(255, 255, 255));
        jm_movimentacoes.setText("MOVIMENTAÇÕES");
        jm_movimentacoes.setAlignmentX(1.0F);
        jm_movimentacoes.setAlignmentY(1.0F);
        jm_movimentacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_movimentacoes.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_movimentacoes.setHideActionText(true);
        jm_movimentacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jm_movimentacoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jm_movimentacoes.setIconTextGap(10);
        jm_movimentacoes.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jm_movimentacoes.setOpaque(true);

        jm_vendas.setBackground(new java.awt.Color(13, 71, 161));
        jm_vendas.setBorder(null);
        jm_vendas.setForeground(new java.awt.Color(250, 250, 250));
        jm_vendas.setText("VENDAS");
        jm_vendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_vendas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_vendas.setHideActionText(true);
        jm_vendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_vendas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_vendas.setMaximumSize(null);
        jm_vendas.setMinimumSize(null);
        jm_vendas.setOpaque(true);
        jm_vendas.setPreferredSize(new java.awt.Dimension(150, 35));

        jm_vendas_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_vendas_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_vendas_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_vendas_visualizar.setText("Visualizar/Editar");
        jm_vendas_visualizar.setBorder(null);
        jm_vendas_visualizar.setBorderPainted(false);
        jm_vendas_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_vendas_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_vendas_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_vendas_visualizar.setMaximumSize(null);
        jm_vendas_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_vendas_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_vendas_visualizarActionPerformed(evt);
            }
        });
        jm_vendas.add(jm_vendas_visualizar);

        jm_vendas_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_vendas_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_vendas_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_vendas_cadastro.setText("Nova Venda");
        jm_vendas_cadastro.setBorder(null);
        jm_vendas_cadastro.setBorderPainted(false);
        jm_vendas_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_vendas_cadastro.setFocusPainted(true);
        jm_vendas_cadastro.setFocusable(true);
        jm_vendas_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_vendas_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_vendas_cadastro.setMaximumSize(null);
        jm_vendas_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_vendas_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_vendas_cadastroActionPerformed(evt);
            }
        });
        jm_vendas.add(jm_vendas_cadastro);

        jm_movimentacoes.add(jm_vendas);

        jm_compras.setBackground(new java.awt.Color(13, 71, 161));
        jm_compras.setBorder(null);
        jm_compras.setForeground(new java.awt.Color(250, 250, 250));
        jm_compras.setText("COMPRAS");
        jm_compras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_compras.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_compras.setHideActionText(true);
        jm_compras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_compras.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_compras.setMaximumSize(null);
        jm_compras.setMinimumSize(null);
        jm_compras.setOpaque(true);
        jm_compras.setPreferredSize(new java.awt.Dimension(150, 35));

        jm_compras_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_compras_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_compras_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_compras_visualizar.setText("Visualizar/Editar");
        jm_compras_visualizar.setBorder(null);
        jm_compras_visualizar.setBorderPainted(false);
        jm_compras_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_compras_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_compras_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_compras_visualizar.setMaximumSize(null);
        jm_compras_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_compras_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_compras_visualizarActionPerformed(evt);
            }
        });
        jm_compras.add(jm_compras_visualizar);

        jm_compras_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_compras_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_compras_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_compras_cadastro.setText("Nova Compra");
        jm_compras_cadastro.setBorder(null);
        jm_compras_cadastro.setBorderPainted(false);
        jm_compras_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_compras_cadastro.setFocusPainted(true);
        jm_compras_cadastro.setFocusable(true);
        jm_compras_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_compras_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_compras_cadastro.setMaximumSize(null);
        jm_compras_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_compras_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_compras_cadastroActionPerformed(evt);
            }
        });
        jm_compras.add(jm_compras_cadastro);

        jm_movimentacoes.add(jm_compras);

        jm_producao.setBackground(new java.awt.Color(13, 71, 161));
        jm_producao.setBorder(null);
        jm_producao.setForeground(new java.awt.Color(250, 250, 250));
        jm_producao.setText("PRODUÇÃO");
        jm_producao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_producao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_producao.setHideActionText(true);
        jm_producao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_producao.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_producao.setMaximumSize(null);
        jm_producao.setMinimumSize(null);
        jm_producao.setOpaque(true);
        jm_producao.setPreferredSize(new java.awt.Dimension(150, 35));

        jm_producao_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_producao_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_producao_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_producao_visualizar.setText("Visualizar/Editar");
        jm_producao_visualizar.setBorder(null);
        jm_producao_visualizar.setBorderPainted(false);
        jm_producao_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_producao_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_producao_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_producao_visualizar.setMaximumSize(null);
        jm_producao_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_producao_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_producao_visualizarActionPerformed(evt);
            }
        });
        jm_producao.add(jm_producao_visualizar);

        jm_producao_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_producao_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_producao_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_producao_cadastro.setText("Nova Produção");
        jm_producao_cadastro.setBorder(null);
        jm_producao_cadastro.setBorderPainted(false);
        jm_producao_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_producao_cadastro.setFocusPainted(true);
        jm_producao_cadastro.setFocusable(true);
        jm_producao_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_producao_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_producao_cadastro.setMaximumSize(null);
        jm_producao_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_producao_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_producao_cadastroActionPerformed(evt);
            }
        });
        jm_producao.add(jm_producao_cadastro);

        jm_movimentacoes.add(jm_producao);

        jMenuBar2.add(jm_movimentacoes);

        jm_almox.setBackground(new java.awt.Color(13, 71, 161));
        jm_almox.setBorder(null);
        jm_almox.setForeground(new java.awt.Color(255, 255, 255));
        jm_almox.setText("ESTOQUE");
        jm_almox.setAlignmentX(1.0F);
        jm_almox.setAlignmentY(1.0F);
        jm_almox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_almox.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_almox.setHideActionText(true);
        jm_almox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jm_almox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jm_almox.setIconTextGap(10);
        jm_almox.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jm_almox.setOpaque(true);

        jm_almox_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_almox_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_almox_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_almox_visualizar.setText("Visualizar");
        jm_almox_visualizar.setBorder(null);
        jm_almox_visualizar.setBorderPainted(false);
        jm_almox_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_almox_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_almox_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_almox_visualizar.setMaximumSize(null);
        jm_almox_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_almox_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_almox_visualizarActionPerformed(evt);
            }
        });
        jm_almox.add(jm_almox_visualizar);

        jMenuBar2.add(jm_almox);

        jm_user.setBackground(new java.awt.Color(13, 71, 161));
        jm_user.setBorder(null);
        jm_user.setForeground(new java.awt.Color(255, 255, 255));
        jm_user.setText("USUÁRIO");
        jm_user.setAlignmentX(1.0F);
        jm_user.setAlignmentY(1.0F);
        jm_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_user.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_user.setHideActionText(true);
        jm_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jm_user.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jm_user.setIconTextGap(10);
        jm_user.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jm_user.setOpaque(true);

        jm_user_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_user_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_user_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_user_visualizar.setText("Visualizar/Editar");
        jm_user_visualizar.setBorder(null);
        jm_user_visualizar.setBorderPainted(false);
        jm_user_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_user_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_user_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_user_visualizar.setMaximumSize(null);
        jm_user_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_user_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_user_visualizarActionPerformed(evt);
            }
        });
        jm_user.add(jm_user_visualizar);

        jm_user_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_user_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_user_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_user_cadastro.setText("Cadastro");
        jm_user_cadastro.setBorder(null);
        jm_user_cadastro.setBorderPainted(false);
        jm_user_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_user_cadastro.setFocusPainted(true);
        jm_user_cadastro.setFocusable(true);
        jm_user_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_user_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_user_cadastro.setMaximumSize(null);
        jm_user_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_user_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_user_cadastroActionPerformed(evt);
            }
        });
        jm_user.add(jm_user_cadastro);

        jMenuBar2.add(jm_user);

        jm_relatorio.setBackground(new java.awt.Color(13, 71, 161));
        jm_relatorio.setBorder(null);
        jm_relatorio.setForeground(new java.awt.Color(255, 255, 255));
        jm_relatorio.setText("RELATÓRIOS");
        jm_relatorio.setAlignmentX(1.0F);
        jm_relatorio.setAlignmentY(1.0F);
        jm_relatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_relatorio.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_relatorio.setHideActionText(true);
        jm_relatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jm_relatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jm_relatorio.setIconTextGap(10);
        jm_relatorio.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jm_relatorio.setOpaque(true);

        jm_relatorio_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_relatorio_visualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_relatorio_visualizar.setForeground(new java.awt.Color(250, 250, 250));
        jm_relatorio_visualizar.setText("Visualizar");
        jm_relatorio_visualizar.setBorder(null);
        jm_relatorio_visualizar.setBorderPainted(false);
        jm_relatorio_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_relatorio_visualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_relatorio_visualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_relatorio_visualizar.setMaximumSize(null);
        jm_relatorio_visualizar.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_relatorio_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_relatorio_visualizarActionPerformed(evt);
            }
        });
        jm_relatorio.add(jm_relatorio_visualizar);

        jm_relatorio_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_relatorio_cadastro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_relatorio_cadastro.setForeground(new java.awt.Color(250, 250, 250));
        jm_relatorio_cadastro.setText("Cadastro");
        jm_relatorio_cadastro.setBorder(null);
        jm_relatorio_cadastro.setBorderPainted(false);
        jm_relatorio_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_relatorio_cadastro.setFocusPainted(true);
        jm_relatorio_cadastro.setFocusable(true);
        jm_relatorio_cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_relatorio_cadastro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_relatorio_cadastro.setMaximumSize(null);
        jm_relatorio_cadastro.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_relatorio_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_relatorio_cadastroActionPerformed(evt);
            }
        });
        jm_relatorio.add(jm_relatorio_cadastro);

        jMenuBar2.add(jm_relatorio);

        jm_ajuda.setBackground(new java.awt.Color(13, 71, 161));
        jm_ajuda.setBorder(null);
        jm_ajuda.setForeground(new java.awt.Color(255, 255, 255));
        jm_ajuda.setText("AJUDA");
        jm_ajuda.setAlignmentX(1.0F);
        jm_ajuda.setAlignmentY(1.0F);
        jm_ajuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_ajuda.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_ajuda.setHideActionText(true);
        jm_ajuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jm_ajuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jm_ajuda.setIconTextGap(10);
        jm_ajuda.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jm_ajuda.setOpaque(true);

        jm_ajuda_sair.setBackground(new java.awt.Color(13, 71, 161));
        jm_ajuda_sair.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jm_ajuda_sair.setForeground(new java.awt.Color(250, 250, 250));
        jm_ajuda_sair.setText("Sair");
        jm_ajuda_sair.setBorder(null);
        jm_ajuda_sair.setBorderPainted(false);
        jm_ajuda_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jm_ajuda_sair.setFocusPainted(true);
        jm_ajuda_sair.setFocusable(true);
        jm_ajuda_sair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jm_ajuda_sair.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jm_ajuda_sair.setMaximumSize(null);
        jm_ajuda_sair.setPreferredSize(new java.awt.Dimension(150, 35));
        jm_ajuda_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_ajuda_sairActionPerformed(evt);
            }
        });
        jm_ajuda.add(jm_ajuda_sair);

        jMenuBar2.add(jm_ajuda);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jm_ajuda_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_ajuda_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jm_ajuda_sairActionPerformed

    private void jm_cliente_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_cliente_cadastroActionPerformed
        jif_Cadastro_cliente jif_cad_cliente = new jif_Cadastro_cliente(true);
        jDesktopPane1.add(jif_cad_cliente);
        jif_cad_cliente.setVisible(true);

    }//GEN-LAST:event_jm_cliente_cadastroActionPerformed

    private void jm_item_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_item_visualizarActionPerformed
        jif_Listagem_DAO jifVis_item = new jif_Listagem_DAO(new ItemDAO(), new jff_Alterar_item());
        if (visualizarIsOpen != null) {
            this.visualizarIsOpen.dispose();
        }
        jDesktopPane1.add(jifVis_item);
        jifVis_item.setTitle("VISUALIZAR - ITENS");
        jifVis_item.setVisible(true);
        this.visualizarIsOpen = jifVis_item;
    }//GEN-LAST:event_jm_item_visualizarActionPerformed


    private void jm_user_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_user_cadastroActionPerformed
        jif_Cadastro_user jif_cad_user = new jif_Cadastro_user();
        jDesktopPane1.add(jif_cad_user);
        jif_cad_user.setVisible(true);
    }//GEN-LAST:event_jm_user_cadastroActionPerformed

    private void jm_item_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_item_cadastroActionPerformed
        jif_Cadastro_item jif_cad_item = new jif_Cadastro_item();
        jDesktopPane1.add(jif_cad_item);
        jif_cad_item.setVisible(true);
    }//GEN-LAST:event_jm_item_cadastroActionPerformed

    private void jm_user_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_user_visualizarActionPerformed
        jif_Listagem_DAO jif_listagem_user = new jif_Listagem_DAO(new userDAO(), new jff_Alterar_User());
        if (visualizarIsOpen != null) {
            this.visualizarIsOpen.dispose();
        }
        jif_listagem_user.setTitle("VISUALIZAR - USUÁRIOS");
        jDesktopPane1.add(jif_listagem_user);
        jif_listagem_user.setVisible(true);
        this.visualizarIsOpen = jif_listagem_user;
    }//GEN-LAST:event_jm_user_visualizarActionPerformed

    private void jm_fornecedor_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_fornecedor_cadastroActionPerformed
        jif_Cadastro_cliente jif_cad_cliente = new jif_Cadastro_cliente(false);
        jDesktopPane1.add(jif_cad_cliente);
        jif_cad_cliente.setVisible(true);
    }//GEN-LAST:event_jm_fornecedor_cadastroActionPerformed

    private void jm_cliente_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_cliente_visualizarActionPerformed
        jif_Listagem_DAO jifVis_cliente = new jif_Listagem_DAO(new ClienteDAO("cliente"), new jff_Alterar_cliente());
        if (visualizarIsOpen != null) {
            this.visualizarIsOpen.dispose();
        }
        jDesktopPane1.add(jifVis_cliente);
        jifVis_cliente.setTitle("VISUALIZAR - CLIENTES");
        jifVis_cliente.setVisible(true);
        this.visualizarIsOpen = jifVis_cliente;
    }//GEN-LAST:event_jm_cliente_visualizarActionPerformed

    private void jm_almox_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_almox_visualizarActionPerformed
        jif_Listagem_DAO jifVis_item = new jif_Listagem_DAO(new ItemDAO(), new jff_Alterar_item());
        if (visualizarIsOpen != null) {
            this.visualizarIsOpen.dispose();
        }
        jDesktopPane1.add(jifVis_item);
        jifVis_item.setTitle("VISUALIZAR - ESTOQUE");
        jifVis_item.setVisible(true);
        this.visualizarIsOpen = jifVis_item;
    }//GEN-LAST:event_jm_almox_visualizarActionPerformed

    private void jm_grupo_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_grupo_visualizarActionPerformed
        jif_Listagem_DAO jifVis_grupo = new jif_Listagem_DAO(new GrupoDAO(), new jff_Alterar_grupo());
        if (visualizarIsOpen != null) {
            this.visualizarIsOpen.dispose();
        }
        jDesktopPane1.add(jifVis_grupo);
        jifVis_grupo.setTitle("VISUALIZAR - GRUPOS");
        jifVis_grupo.setVisible(true);
        this.visualizarIsOpen = jifVis_grupo;
    }//GEN-LAST:event_jm_grupo_visualizarActionPerformed

    private void jm_grupo_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_grupo_cadastroActionPerformed
        jif_Cadastro_grupo jif_cad_grupo = new jif_Cadastro_grupo();
        jDesktopPane1.add(jif_cad_grupo);
        jif_cad_grupo.setVisible(true);
    }//GEN-LAST:event_jm_grupo_cadastroActionPerformed

    private void jm_producao_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_producao_cadastroActionPerformed
        jff_pesquisar_item telaPesquisa = new jff_pesquisar_item(
                "'PRODUTO ACABADO'", "producao"
        );
        telaPesquisa.setVisible(true);
        
    }//GEN-LAST:event_jm_producao_cadastroActionPerformed

    private void jm_fornecedor_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_fornecedor_visualizarActionPerformed
        jif_Listagem_DAO jifVis_cliente = new jif_Listagem_DAO(new ClienteDAO("fornecedor"), new jff_Alterar_cliente());
        if (visualizarIsOpen != null) {
            this.visualizarIsOpen.dispose();
        }
        jDesktopPane1.add(jifVis_cliente);
        jifVis_cliente.setTitle("VISUALIZAR - FORNECEDORES");
        jifVis_cliente.setVisible(true);
        this.visualizarIsOpen = jifVis_cliente;
    }//GEN-LAST:event_jm_fornecedor_visualizarActionPerformed

    private void jm_compras_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_compras_visualizarActionPerformed
        abrirListagemDAO(new movimentacaoDAO("compra"), new jff_alterar_movimentacao());
    }//GEN-LAST:event_jm_compras_visualizarActionPerformed

    private void jm_estrutura_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_estrutura_cadastroActionPerformed
        jif_Cadastro_estrutura jif_cad_est = new jif_Cadastro_estrutura(this.jDesktopPane1);
        jDesktopPane1.add(jif_cad_est);
        jif_cad_est.setVisible(true);
    }//GEN-LAST:event_jm_estrutura_cadastroActionPerformed

    private void jm_relatorio_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_relatorio_visualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_relatorio_visualizarActionPerformed

    private void jm_relatorio_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_relatorio_cadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_relatorio_cadastroActionPerformed

    private void jm_vendas_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_vendas_visualizarActionPerformed
        abrirListagemDAO(new movimentacaoDAO("venda"), new jff_alterar_movimentacao());
    }//GEN-LAST:event_jm_vendas_visualizarActionPerformed

    private void jm_producao_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_producao_visualizarActionPerformed
        abrirListagemDAO(new movimentacaoDAO("producao"), new jff_alterar_movimentacao());
    }//GEN-LAST:event_jm_producao_visualizarActionPerformed

    private void jm_compras_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_compras_cadastroActionPerformed
        jff_pesquisar_item telaPesquisa = new jff_pesquisar_item(
                "'MATERIA-PRIMA', 'FERRAMENTA', 'OUTRO'", "compra"
        );
        telaPesquisa.setVisible(true);
    }//GEN-LAST:event_jm_compras_cadastroActionPerformed

    private void jm_vendas_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_vendas_cadastroActionPerformed
        jff_pesquisar_item telaPesquisa = new jff_pesquisar_item(
                "'PRODUTO ACABADO'", "venda"
        );
        telaPesquisa.setVisible(true);
    }//GEN-LAST:event_jm_vendas_cadastroActionPerformed

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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jm_ajuda;
    private javax.swing.JMenuItem jm_ajuda_sair;
    private javax.swing.JMenu jm_almox;
    private javax.swing.JMenuItem jm_almox_visualizar;
    private javax.swing.JMenu jm_cliente;
    private javax.swing.JMenuItem jm_cliente_cadastro;
    private javax.swing.JMenuItem jm_cliente_visualizar;
    private javax.swing.JMenu jm_compras;
    private javax.swing.JMenuItem jm_compras_cadastro;
    private javax.swing.JMenuItem jm_compras_visualizar;
    private javax.swing.JMenu jm_estrutura;
    private javax.swing.JMenuItem jm_estrutura_cadastro;
    private javax.swing.JMenu jm_fornecedor;
    private javax.swing.JMenuItem jm_fornecedor_cadastro;
    private javax.swing.JMenuItem jm_fornecedor_visualizar;
    private javax.swing.JMenu jm_grupo;
    private javax.swing.JMenuItem jm_grupo_cadastro;
    private javax.swing.JMenuItem jm_grupo_visualizar;
    private javax.swing.JMenu jm_item;
    private javax.swing.JMenu jm_item2;
    private javax.swing.JMenuItem jm_item_cadastro;
    private javax.swing.JMenuItem jm_item_visualizar;
    private javax.swing.JMenu jm_movimentacoes;
    private javax.swing.JMenu jm_pessoa;
    private javax.swing.JMenu jm_producao;
    private javax.swing.JMenuItem jm_producao_cadastro;
    private javax.swing.JMenuItem jm_producao_visualizar;
    private javax.swing.JMenu jm_relatorio;
    private javax.swing.JMenuItem jm_relatorio_cadastro;
    private javax.swing.JMenuItem jm_relatorio_visualizar;
    private javax.swing.JMenu jm_user;
    private javax.swing.JMenuItem jm_user_cadastro;
    private javax.swing.JMenuItem jm_user_visualizar;
    private javax.swing.JMenu jm_vendas;
    private javax.swing.JMenuItem jm_vendas_cadastro;
    private javax.swing.JMenuItem jm_vendas_visualizar;
    // End of variables declaration//GEN-END:variables
}
