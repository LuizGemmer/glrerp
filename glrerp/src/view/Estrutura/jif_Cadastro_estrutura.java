package view.Estrutura;

import apoio.CombosDAO;
import apoio.Formatacao;
import apoio.Validacao;
import dao.EstruturaDAO;
import dao.GrupoDAO;
import dao.ItemDAO;
import entidade.Estrutura;
import entidade.Grupo;
import entidade.Item;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ruang
 */
public class jif_Cadastro_estrutura extends javax.swing.JInternalFrame {

    private int id_item_selecionado; //Variavel que armazena o id do item a ser cadastrada a estrutura
    private int id_insumo_selecionado; //Variavel que armazena o id do iNSUMO a ser cadastrada NA estrutura. Tal valor retorna na da tabela na tela JFF_PESQUISAR
    public int pesquisar_insumo_item; //Variavel que é utilizada para dizer à tela JFF_PESQUISAR se estamos buscando um item(int=1) ou um insumo (int=2)
    private boolean editar_insumos = false; //Variavel fica TRUE quando é clicado no botão EDITAR ESTRUTURA. Quando TRUE ela libera os botões de editar e excluir do BD.
    private boolean apertou_editar = false; //Variavel que fica TRUE quando seleciona um insumo já cadastrado na estrutura para edição. Caso seja clicado em FECHAR ou REINICIAR antes de salvar, gerará uma mensagem de aviso.

    
    public jif_Cadastro_estrutura() {
        initComponents();
        jcb_und_medida.setEnabled(false);
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
        UIManager.put("ComboBox.disabledBackground", Color.RGBtoHSB(250, 250, 250, null));
    }

    public void NomearItem(int id_tabela) {
        this.id_item_selecionado = id_tabela;

        //popula tabela com a estrutura já cadastrada no item
        new EstruturaDAO().popularTabelaInsumos(jtb_insumos_estrutura, String.valueOf(this.id_item_selecionado));
        jtf_SomaValor.setText("R$  " + String.valueOf(Formatacao.formatarDecimal(SomarTotalValorTabela()).replace('.', ',')));

        //Coloca os valores referentes ao ID do item para os campos JTF
        Item item = new ItemDAO().consultarId(this.id_item_selecionado);
        Grupo grupo = new GrupoDAO().consultarId(item.getId_grupo());

        jtf_id_item.setText(String.valueOf(item.getId()));
        jtf_nome_item.setText(item.getDescricao());
        jtf_grupo_item.setText(grupo.getTipo() + " - " + grupo.getDescricao());
        jbt_editar_estrutura.setEnabled(true);
        jlb_Valor.setText("VALOR DA ESTRUTURA POR CADA " + item.getUnidade_medida() + " =");
    }

    public void NomearInsumo(int id_tabela) {
        //Coloca os valores referentes ao ID do insumo para os campos JTF
        this.id_insumo_selecionado = id_tabela;
        Item item = new ItemDAO().consultarId(this.id_insumo_selecionado);
        Grupo grupo = new GrupoDAO().consultarId(item.getId_grupo());

        jtf_id_insumo.setText(String.valueOf(item.getId()));
        jtf_nome_insumo.setText(item.getDescricao());
        jtf_grupo_insumo.setText(grupo.getTipo() + " - " + grupo.getDescricao());
        jtf_qtde_insumo.setEnabled(true);
        jbt_inserir.setEnabled(true);

        //retornar o valor selecionado ao Combo Box Und_medida a partir da tabela ITEM no BD
        new CombosDAO().popularComboUndMedida(this.id_insumo_selecionado, jcb_und_medida);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_id_item = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_editar_estrutura = new javax.swing.JButton();
        jtf_nome_item = new javax.swing.JTextField();
        jtf_grupo_item = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jbt_pesquisar_item = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtf_id_insumo = new javax.swing.JTextField();
        jtf_nome_insumo = new javax.swing.JTextField();
        jtf_grupo_insumo = new javax.swing.JTextField();
        jbt_pesquisar_insumo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtf_qtde_insumo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_insumos_estrutura = new javax.swing.JTable();
        jbt_inserir = new javax.swing.JButton();
        jbt_excluir = new javax.swing.JButton();
        jbt_editar = new javax.swing.JButton();
        jcb_und_medida = new javax.swing.JComboBox<>();
        jlb_Valor = new javax.swing.JLabel();
        jtf_SomaValor = new javax.swing.JTextField();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro - Estrutura");
        setPreferredSize(new java.awt.Dimension(960, 500));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Item");

        jtf_id_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_id_item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_id_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_id_item.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_id_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_id_item.setEnabled(false);

        jbt_fechar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_fechar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_fechar.setText("Fechar");
        jbt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_fecharActionPerformed(evt);
            }
        });

        jbt_editar_estrutura.setBackground(new java.awt.Color(13, 71, 161));
        jbt_editar_estrutura.setForeground(new java.awt.Color(255, 255, 255));
        jbt_editar_estrutura.setText("Editar Estrutura");
        jbt_editar_estrutura.setEnabled(false);
        jbt_editar_estrutura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_editar_estruturaActionPerformed(evt);
            }
        });

        jtf_nome_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_nome_item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_nome_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_nome_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_nome_item.setEnabled(false);

        jtf_grupo_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_grupo_item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_grupo_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_grupo_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_grupo_item.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Grupo do item");

        jbt_pesquisar_item.setBackground(new java.awt.Color(13, 71, 161));
        jbt_pesquisar_item.setForeground(new java.awt.Color(255, 255, 255));
        jbt_pesquisar_item.setText("Pesquisar");
        jbt_pesquisar_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_pesquisar_itemActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("*Insumo");

        jtf_id_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_id_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_id_insumo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_id_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_id_insumo.setEnabled(false);

        jtf_nome_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_nome_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_nome_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_nome_insumo.setEnabled(false);

        jtf_grupo_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_grupo_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_grupo_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_grupo_insumo.setEnabled(false);
        jtf_grupo_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_grupo_insumoActionPerformed(evt);
            }
        });

        jbt_pesquisar_insumo.setBackground(new java.awt.Color(13, 71, 161));
        jbt_pesquisar_insumo.setForeground(new java.awt.Color(255, 255, 255));
        jbt_pesquisar_insumo.setText("Pesquisar");
        jbt_pesquisar_insumo.setEnabled(false);
        jbt_pesquisar_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_pesquisar_insumoActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("*Quantidade");

        jtf_qtde_insumo.setBackground(new java.awt.Color(250, 250, 250));
        jtf_qtde_insumo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_qtde_insumo.setForeground(new java.awt.Color(0, 0, 0));
        jtf_qtde_insumo.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_qtde_insumo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_qtde_insumo.setEnabled(false);
        jtf_qtde_insumo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_qtde_insumoKeyTyped(evt);
            }
        });

        jtb_insumos_estrutura.setBackground(new java.awt.Color(250, 250, 250));
        jtb_insumos_estrutura.setForeground(new java.awt.Color(51, 51, 51));
        jtb_insumos_estrutura.setModel(new javax.swing.table.DefaultTableModel(
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
        jtb_insumos_estrutura.setRowHeight(25);
        jtb_insumos_estrutura.setSelectionBackground(new java.awt.Color(13, 71, 161));
        jtb_insumos_estrutura.setSelectionForeground(new java.awt.Color(250, 250, 250));
        jtb_insumos_estrutura.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtb_insumos_estrutura.setShowGrid(false);
        jtb_insumos_estrutura.setShowHorizontalLines(true);
        jtb_insumos_estrutura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_insumos_estruturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_insumos_estrutura);

        jbt_inserir.setBackground(new java.awt.Color(13, 71, 161));
        jbt_inserir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_inserir.setText("Inserir/Salvar");
        jbt_inserir.setEnabled(false);
        jbt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_inserirActionPerformed(evt);
            }
        });

        jbt_excluir.setBackground(new java.awt.Color(13, 71, 161));
        jbt_excluir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_excluir.setText("Excluir");
        jbt_excluir.setEnabled(false);
        jbt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_excluirActionPerformed(evt);
            }
        });

        jbt_editar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_editar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_editar.setText("Editar");
        jbt_editar.setEnabled(false);
        jbt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_editarActionPerformed(evt);
            }
        });

        jcb_und_medida.setBackground(new java.awt.Color(250, 250, 250));
        jcb_und_medida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_und_medida.setForeground(new java.awt.Color(0, 0, 0));
        jcb_und_medida.setToolTipText("");

        jlb_Valor.setForeground(new java.awt.Color(0, 0, 0));
        jlb_Valor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_Valor.setText("Valor da Estrutura:");

        jtf_SomaValor.setBackground(new java.awt.Color(250, 250, 250));
        jtf_SomaValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_SomaValor.setForeground(new java.awt.Color(0, 0, 0));
        jtf_SomaValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_SomaValor.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_SomaValor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_SomaValor.setEnabled(false);
        jtf_SomaValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_SomaValorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jtf_id_item)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_nome_item, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtf_grupo_item, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jbt_pesquisar_item, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_editar_estrutura))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_id_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_nome_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_qtde_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcb_und_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbt_inserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtf_grupo_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbt_excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbt_pesquisar_insumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbt_fechar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlb_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_SomaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_id_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_grupo_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbt_pesquisar_item, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbt_editar_estrutura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_id_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_grupo_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbt_pesquisar_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtf_qtde_insumo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jcb_und_medida, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_Valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_SomaValor, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(550, 550, 550))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        //Botão de fechar
        if (this.apertou_editar) {
            MensagemFecharComEdicaoEmAndamento();
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_editar_estruturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_editar_estruturaActionPerformed
        jbt_editar_estrutura.setEnabled(false);
        jbt_pesquisar_item.setEnabled(false);
        jbt_pesquisar_insumo.setEnabled(true);
        this.editar_insumos = true;
    }//GEN-LAST:event_jbt_editar_estruturaActionPerformed

    private void jbt_pesquisar_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_pesquisar_itemActionPerformed
        this.pesquisar_insumo_item = 1;
        jff_pesquisar jff_pesquisar = new jff_pesquisar(this, this.pesquisar_insumo_item);
        jff_pesquisar.setVisible(true);
    }//GEN-LAST:event_jbt_pesquisar_itemActionPerformed

    private void jtf_grupo_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_grupo_insumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_grupo_insumoActionPerformed

    private void jbt_pesquisar_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_pesquisar_insumoActionPerformed
        this.pesquisar_insumo_item = 2;
        jff_pesquisar jff_pesquisar = new jff_pesquisar(this, this.pesquisar_insumo_item);
        jff_pesquisar.setVisible(true);
        jcb_und_medida.setEnabled(true);
    }//GEN-LAST:event_jbt_pesquisar_insumoActionPerformed

    private void jbt_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_inserirActionPerformed
        this.apertou_editar = false;
        //Validar se os campos obrigatórios foram preenchidos corretamente
        if (Validacao.ValidarJTFObrigatorio(jtf_qtde_insumo)
                && Validacao.ValidarJTFObrigatorio(jtf_nome_insumo)) {

            //Valida se o insumo a ser inserido na estrutura já consta na mesma. 
            //Caso o insumo já esteja na esturua ele mostra uma mensagem de erro. 
            //Também não permite que o proprio item seja usado como insumo.
            if (this.id_insumo_selecionado == this.id_item_selecionado) {
                JOptionPane.showMessageDialog(this, "Você não pode inserir como Insumo o próprio item a qual se refere a estrutura!", "ERRO AO SALVAR (INSUMO IGUAL AO ITEM)", JOptionPane.ERROR_MESSAGE);

            } else if (this.id_insumo_selecionado == new EstruturaDAO().consultarId(this.id_item_selecionado, this.id_insumo_selecionado).getInsumo_id()) {
                JOptionPane.showMessageDialog(this, "Você já inseriu esse insumo como compenente dessa estrutura de item. \n"
                        + "Edite o insumo correspondente ou exclua-o antes de inserir-lo novamente.", "INSUMO DUPLICADO NÃO PERMITIDO", JOptionPane.ERROR_MESSAGE);
            } else {
                //Salvar item da estrutura no BD
                int id_item = Integer.parseInt(jtf_id_item.getText());
                int id_insumo = Integer.parseInt(jtf_id_insumo.getText());
                double qtde_insumo = Double.parseDouble(jtf_qtde_insumo.getText().replace(',', '.'));
                String und_medida = String.valueOf(jcb_und_medida.getSelectedItem());
                //Pegar o valor do item e inserir na estrutura o valor ponderado por insumo
                double valor_estrutura = 0;
                Item itemDAO = new ItemDAO().consultarId(this.id_insumo_selecionado);
                if (und_medida.equals(itemDAO.getUnidade_medida())) {
                    valor_estrutura = itemDAO.getValor() * qtde_insumo;
                } else if (und_medida.equals(itemDAO.getUnd_conv1())) {
                    valor_estrutura = itemDAO.getValor() * itemDAO.getConv2() * qtde_insumo;
                } else if (und_medida.equals(itemDAO.getUnd_conv2())) {
                    valor_estrutura = itemDAO.getValor() / itemDAO.getConv2() * qtde_insumo;
                } else{
                    valor_estrutura = 0;
                }

                Estrutura estrutura = new Estrutura();
                estrutura.setItem_id(id_item);
                estrutura.setInsumo_id(id_insumo);
                estrutura.setQtde_insumo(qtde_insumo);
                estrutura.setUnd_medida(und_medida);
                estrutura.setValor_estrutura(valor_estrutura);

                EstruturaDAO estruturaDAO = new EstruturaDAO();
                if (estruturaDAO.salvar(estrutura) == null) {
                    JOptionPane.showMessageDialog(this, "Insumo inserido com sucesso!", "SUCESSO NO CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                    new EstruturaDAO().popularTabelaInsumos(jtb_insumos_estrutura, String.valueOf(estrutura.getItem_id()));
                    jtf_SomaValor.setText("R$  " + String.valueOf(Formatacao.formatarDecimal(SomarTotalValorTabela()).replace('.', ',')));
                    LimparCampos();
                    jcb_und_medida.setEnabled(false);
                    jcb_und_medida.setSelectedItem(null);
                    jbt_pesquisar_insumo.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir dados no banco de dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
            jbt_pesquisar_insumo.requestFocus();
        }
        jbt_pesquisar_insumo.setEnabled(true);

    }//GEN-LAST:event_jbt_inserirActionPerformed

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
            this.apertou_editar = false;
            //Excluir cadastro
            //Setar SITUAÇÃO=FALSE mo objeto
            String id_tabela = String.valueOf(jtb_insumos_estrutura.getValueAt(jtb_insumos_estrutura.getSelectedRow(), 0));
            int id_IntTabela = Integer.parseInt(id_tabela);

            //Chamar classe ItemDAO para salvar dados no Banco de dados
            EstruturaDAO estruturaDAO = new EstruturaDAO();

            //Verifica se a exclusão foi bem sucessido e fecha a tela. Caso contrário apresenta mensagem de erro
            if (estruturaDAO.inativar(this.id_item_selecionado, id_IntTabela) == null) {
                JOptionPane.showMessageDialog(this, "Insumo excluido com sucesso!", "INSUMO EXCLUÍDO", JOptionPane.INFORMATION_MESSAGE);
                new EstruturaDAO().popularTabelaInsumos(jtb_insumos_estrutura, String.valueOf(this.id_item_selecionado));
                jtf_SomaValor.setText("R$  " + String.valueOf(Formatacao.formatarDecimal(SomarTotalValorTabela()).replace('.', ',')));

            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!", "ERRO AO EXCLUIR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbt_excluirActionPerformed

    private void jtf_qtde_insumoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_qtde_insumoKeyTyped
        Validacao.ValidarDecimal(jtf_grupo_insumo, evt);
    }//GEN-LAST:event_jtf_qtde_insumoKeyTyped

    private void jbt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_editarActionPerformed
        this.apertou_editar = true;
        //Editar quantidade Insumo na Estrutura
        String id_tabela = String.valueOf(jtb_insumos_estrutura.getValueAt(jtb_insumos_estrutura.getSelectedRow(), 0));
        int id_IntTabela = Integer.parseInt(id_tabela);
        LimparCampos();

        //Chamar classe EstruturaAO para puxar os dados no Banco de dados e após excluir a linha selecionada na tabela
        EstruturaDAO estruturaDAO = new EstruturaDAO();

        //puxar valores da tabela para os JTF correspondentes
        NomearInsumo(id_IntTabela);
        jtf_qtde_insumo.setText(String.valueOf(new EstruturaDAO().consultarId(this.id_item_selecionado, id_IntTabela).getQtde_insumo()).replace(".", ","));
        jtf_qtde_insumo.requestFocus();
        jbt_pesquisar_insumo.setEnabled(false);
        jcb_und_medida.setEnabled(true);
        //Puxar o valor setado anteriormente de unidade de medida para o ComboBox
        String und_medidaTabela = String.valueOf(jtb_insumos_estrutura.getValueAt(jtb_insumos_estrutura.getSelectedRow(), 3));
        jcb_und_medida.setSelectedItem(und_medidaTabela);

        //Verifica se a exclusão foi bem sucessido e fecha a tela. Caso contrário apresenta mensagem de erro
        if (estruturaDAO.excluir(this.id_item_selecionado, id_IntTabela) == null) {
            System.out.println("Exclusão OK");
            jbt_editar.setEnabled(false);
        } else {
            System.out.println("Falha na exclusão");
        }

    }//GEN-LAST:event_jbt_editarActionPerformed

    private void jtb_insumos_estruturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_insumos_estruturaMouseClicked
        //Habilitar botões de alteração e detalhamento somente quando selecionar uma linha na tabela
        if (this.editar_insumos == true) {
            jbt_editar.setEnabled(true);
            jbt_excluir.setEnabled(true);
        }
    }//GEN-LAST:event_jtb_insumos_estruturaMouseClicked

    private void jtf_SomaValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_SomaValorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_SomaValorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbt_editar;
    private javax.swing.JButton jbt_editar_estrutura;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_inserir;
    private javax.swing.JButton jbt_pesquisar_insumo;
    private javax.swing.JButton jbt_pesquisar_item;
    private javax.swing.JComboBox<String> jcb_und_medida;
    private javax.swing.JLabel jlb_Valor;
    private javax.swing.JTable jtb_insumos_estrutura;
    private javax.swing.JTextField jtf_SomaValor;
    private javax.swing.JTextField jtf_grupo_insumo;
    private javax.swing.JTextField jtf_grupo_item;
    private javax.swing.JTextField jtf_id_insumo;
    private javax.swing.JTextField jtf_id_item;
    private javax.swing.JTextField jtf_nome_insumo;
    private javax.swing.JTextField jtf_nome_item;
    private javax.swing.JTextField jtf_qtde_insumo;
    // End of variables declaration//GEN-END:variables

    private void LimparCampos() {
        jtf_id_insumo.setText("");
        jtf_nome_insumo.setText("");
        jtf_qtde_insumo.setText("");
        jtf_grupo_insumo.setText("");
        jcb_und_medida.setSelectedItem(null);
    }

    private void MensagemFecharComEdicaoEmAndamento() {
        Object[] options = {"Sim",
            "Não"};
        int n = JOptionPane.showOptionDialog(this,
                "Você começou a editar um Insumo na estrutura e não salvou as alterações. "
                + "\n Se você sair agora sem INSERIR/SALVAR esse item será EXCLUÍDO da estrutura! "
                + "\n\nTem certeza que deseja sair e excluir esse insumo?",
                "ALTERAÇÕES NÃO SALVAS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (n == 0) {
            this.dispose();
        } else {
            jbt_inserir.requestFocus(true);
        }

    }
    
    public double SomarTotalValorTabela() {
        int columnIndex = 4; // Índice da coluna a ser somada
        int rowCount = jtb_insumos_estrutura.getRowCount();
        double sum = 0.00;

        for (int i = 0; i < rowCount; i++) {
            Object value = jtb_insumos_estrutura.getValueAt(i, columnIndex);
            if (value instanceof Number) {
                double cellValue = ((Number) value).doubleValue();
                sum += cellValue;
            }
        }
        return sum;
    }
}
