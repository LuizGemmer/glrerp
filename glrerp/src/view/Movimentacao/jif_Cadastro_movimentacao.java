package view.Movimentacao;

import apoio.CombosDAO;
import apoio.Formatacao;
import apoio.Validacao;
import dao.ClienteDAO;
import dao.GrupoDAO;
import dao.ItemDAO;
import dao.Movimentacao_UserDAO;
import dao.movimentacaoDAO;
import entidade.Cliente;
import entidade.Grupo;
import entidade.Item;
import entidade.Movimentacao;
import entidade.Movimentacao_User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import view.Loggin;

/**
 *
 * @author ruang
 */
public class jif_Cadastro_movimentacao extends javax.swing.JInternalFrame {

    private int id_cliente_selecionado; //Variavel que armazena o id do cliente a ser feito a movimentação
    private int id_item_selecionado; //Variavel que armazena o id do item a ser cadastrado na movimentação.
    public int pesquisar_cliente_item; //Variavel que é utilizada para dizer à tela JFF_PESQUISAR se estamos buscando um cliente(int=1) ou um item (int=2)
    private boolean apertou_editar = false; //Variavel que fica TRUE quando seleciona um insumo já cadastrado na estrutura para edição. Caso seja clicado em FECHAR ou REINICIAR antes de salvar, gerará uma mensagem de aviso.
    private String tipoMovimentacao; //Retorna, ao abrir essa tela, qual o tipo de movimentação (compra, venda ou producao)
    private String grupoTipo; //Vai vir a String da tela JIF_CADASTRO_MOVIMENTACAO. Se for nova compra retorna ('MATERIA-PRIMA', 'OUTRO', 'FERRAMENTA'). Se for Venda retorna ('PRODUTO ACABADO', 'OUTRO')
    private int linhasTabela = 1;
    private boolean validarEstoque = true;
    private int itemIdSemEstoque;
    private double qtdeItemConsumo;
    private double qtdeItemEstoque;
    private int idGrupoMovimentacao = 0;
    private boolean salvarOk = true;
    private int user_id;
    double perda;
    double valorUnd;
    ArrayList<ArrayList<Object>> dadosTabela = new ArrayList<>();

    //Criação da tabela contendo os itens
    private static ArrayList<Object[]> dados = new ArrayList<>();
    private static DefaultTableModel model;

    Color buttonDisableColor = new Color(51, 51, 51);
    Color buttonBlueColor = new Color(13, 71, 161);
    Color buttonLightBlueColor = new Color(51, 102, 255);
    Color buttonRedColor = new Color(153, 0, 0);
    Color buttonGreenColor = new Color(0, 102, 0);

    public jif_Cadastro_movimentacao(String tipoMovimentacao, int user_id) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.user_id = user_id;
        initComponents();
        Formatacao.formatarData(jff_Data);
        Formatacao.formatarHora(jff_Hora);
        jcb_und_medida.setEnabled(false);
        UIManager.put("ComboBox.disabledForeground", Color.DARK_GRAY);
        UIManager.put("ComboBox.disabledBackground", Color.RGBtoHSB(250, 250, 250, null));

        //Configurar a tabela
        InserirTabela();
        ConfigurarBotoesJTF();
    }

    public void NomearCliente(int id_tabela) {
        this.id_cliente_selecionado = id_tabela;

        //Coloca os valores referentes ao ID do cliente/Fornecedor para os campos JTF
        Cliente cliente = new ClienteDAO().consultarId(this.id_cliente_selecionado);
        jtf_id_cliente.setText(String.valueOf(cliente.getId()));
        jtf_nome_cliente.setText(cliente.getNome());
        jtf_cpf_cliente.setText(cliente.getCpf());
        jbt_nova_movimentacao.setEnabled(true);
        jbt_nova_movimentacao.setBackground(buttonBlueColor);
        jbt_nova_movimentacao.requestFocus();
    }

    public void NomearItem(int id_tabela) {
        this.id_item_selecionado = id_tabela;

        //Coloca os valores referentes ao ID do item para os campos JTF
        Item item = new ItemDAO().consultarId(this.id_item_selecionado);
        Grupo grupo = new GrupoDAO().consultarId(item.getId_grupo());

        jtf_id_item.setText(String.valueOf(item.getId()));
        jtf_nome_item.setText(item.getDescricao());
        jtf_grupo_item.setText(grupo.getTipo() + " - " + grupo.getDescricao());
        jcb_und_medida.setEnabled(true);
        jtf_perda.setEnabled(true);
        jtf_qtde_item.setEnabled(true);
        if ("compra".equals(this.tipoMovimentacao) || "venda".equals(this.tipoMovimentacao)) {
            jtf_valor.setEnabled(true);
            jlb_und_valor.setText("/ " + item.getUnidade_medida());
        }
        if ("venda".equals(this.tipoMovimentacao)) {
            jtf_valor.setText(String.valueOf(Formatacao.formatarDecimal2casas(item.getValor())));
        }
        jta_obs.setEnabled(true);
        jbt_inserir.setEnabled(true);
        jbt_inserir.setBackground(buttonBlueColor);
        jbt_decoracao.setEnabled(true);
        jbt_decoracao.setBackground(buttonLightBlueColor);

        //retornar o valor selecionado ao Combo Box Und_medida a partir da tabela ITEM no BD
        new CombosDAO().popularComboUndMedida(this.id_item_selecionado, jcb_und_medida);
        jcb_und_medida.setSelectedItem(item.getUnidade_medida());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_cliente_fornecedor = new javax.swing.JLabel();
        jtf_id_cliente = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_nova_movimentacao = new javax.swing.JButton();
        jtf_nome_cliente = new javax.swing.JTextField();
        jtf_cpf_cliente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jbt_pesquisar_cliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtf_id_item = new javax.swing.JTextField();
        jtf_nome_item = new javax.swing.JTextField();
        jtf_grupo_item = new javax.swing.JTextField();
        jbt_pesquisar_item = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtf_qtde_item = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_itens = new javax.swing.JTable();
        jbt_inserir = new javax.swing.JButton();
        jbt_excluir = new javax.swing.JButton();
        jbt_editar = new javax.swing.JButton();
        jlb_ValorTotal = new javax.swing.JLabel();
        jtf_SomaValor = new javax.swing.JTextField();
        jff_Data = new javax.swing.JFormattedTextField();
        jlb_Data = new javax.swing.JLabel();
        jff_Hora = new javax.swing.JFormattedTextField();
        jbt_pedido = new javax.swing.JButton();
        jcb_und_medida = new javax.swing.JComboBox<>();
        jtf_perda = new javax.swing.JTextField();
        jlb_perda = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta_obs = new javax.swing.JTextArea();
        jbt_decoracao = new javax.swing.JButton();
        jlb_valor = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField();
        jbt_salvar = new javax.swing.JButton();
        jlb_und_valor = new javax.swing.JLabel();
        jlb_ValorTotal1 = new javax.swing.JLabel();
        jtf_SomaItens = new javax.swing.JTextField();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro - Estrutura");
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jlb_cliente_fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        jlb_cliente_fornecedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_cliente_fornecedor.setText("*Cliente");

        jtf_id_cliente.setBackground(new java.awt.Color(250, 250, 250));
        jtf_id_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_id_cliente.setForeground(new java.awt.Color(0, 0, 0));
        jtf_id_cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_id_cliente.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_id_cliente.setEnabled(false);

        jbt_fechar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_fechar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_fechar.setText("Fechar");
        jbt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_fecharActionPerformed(evt);
            }
        });

        jbt_nova_movimentacao.setBackground(new java.awt.Color(51, 51, 51));
        jbt_nova_movimentacao.setForeground(new java.awt.Color(255, 255, 255));
        jbt_nova_movimentacao.setText("NOVO ...");
        jbt_nova_movimentacao.setEnabled(false);
        jbt_nova_movimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_nova_movimentacaoActionPerformed(evt);
            }
        });

        jtf_nome_cliente.setBackground(new java.awt.Color(250, 250, 250));
        jtf_nome_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_nome_cliente.setForeground(new java.awt.Color(0, 0, 0));
        jtf_nome_cliente.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_nome_cliente.setEnabled(false);

        jtf_cpf_cliente.setBackground(new java.awt.Color(250, 250, 250));
        jtf_cpf_cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_cpf_cliente.setForeground(new java.awt.Color(0, 0, 0));
        jtf_cpf_cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_cpf_cliente.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_cpf_cliente.setEnabled(false);

        jbt_pesquisar_cliente.setBackground(new java.awt.Color(13, 71, 161));
        jbt_pesquisar_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jbt_pesquisar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar18x18.png"))); // NOI18N
        jbt_pesquisar_cliente.setText("Pesquisar");
        jbt_pesquisar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_pesquisar_clienteActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("*Item");

        jtf_id_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_id_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_id_item.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_id_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_id_item.setEnabled(false);

        jtf_nome_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_nome_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_nome_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_nome_item.setEnabled(false);

        jtf_grupo_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_grupo_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_grupo_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_grupo_item.setEnabled(false);

        jbt_pesquisar_item.setBackground(new java.awt.Color(51, 51, 51));
        jbt_pesquisar_item.setForeground(new java.awt.Color(255, 255, 255));
        jbt_pesquisar_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar18x18.png"))); // NOI18N
        jbt_pesquisar_item.setText("Pesquisar");
        jbt_pesquisar_item.setEnabled(false);
        jbt_pesquisar_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_pesquisar_itemActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("*Quantidade");

        jtf_qtde_item.setBackground(new java.awt.Color(250, 250, 250));
        jtf_qtde_item.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_qtde_item.setForeground(new java.awt.Color(0, 0, 0));
        jtf_qtde_item.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_qtde_item.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_qtde_item.setEnabled(false);
        jtf_qtde_item.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_qtde_itemFocusLost(evt);
            }
        });
        jtf_qtde_item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_qtde_itemKeyTyped(evt);
            }
        });

        jtb_itens.setBackground(new java.awt.Color(250, 250, 250));
        jtb_itens.setForeground(new java.awt.Color(51, 51, 51));
        jtb_itens.setModel(new javax.swing.table.DefaultTableModel(
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
        jtb_itens.setRowHeight(25);
        jtb_itens.setSelectionBackground(new java.awt.Color(13, 71, 161));
        jtb_itens.setSelectionForeground(new java.awt.Color(250, 250, 250));
        jtb_itens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtb_itens.setShowGrid(false);
        jtb_itens.setShowHorizontalLines(true);
        jtb_itens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_itensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_itens);

        jbt_inserir.setBackground(new java.awt.Color(51, 51, 51));
        jbt_inserir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_inserir.setText("Inserir");
        jbt_inserir.setEnabled(false);
        jbt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_inserirActionPerformed(evt);
            }
        });

        jbt_excluir.setBackground(new java.awt.Color(51, 51, 51));
        jbt_excluir.setForeground(new java.awt.Color(255, 255, 255));
        jbt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir18x18.png"))); // NOI18N
        jbt_excluir.setText("Excluir");
        jbt_excluir.setEnabled(false);
        jbt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_excluirActionPerformed(evt);
            }
        });

        jbt_editar.setBackground(new java.awt.Color(51, 51, 51));
        jbt_editar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar18x18.png"))); // NOI18N
        jbt_editar.setText("Editar");
        jbt_editar.setEnabled(false);
        jbt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_editarActionPerformed(evt);
            }
        });

        jlb_ValorTotal.setForeground(new java.awt.Color(0, 0, 0));
        jlb_ValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_ValorTotal.setText("Valor Total:");

        jtf_SomaValor.setBackground(new java.awt.Color(250, 250, 250));
        jtf_SomaValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_SomaValor.setForeground(new java.awt.Color(0, 0, 0));
        jtf_SomaValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_SomaValor.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_SomaValor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_SomaValor.setEnabled(false);

        jff_Data.setBackground(new java.awt.Color(250, 250, 250));
        jff_Data.setForeground(new java.awt.Color(0, 0, 0));
        jff_Data.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_Data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jff_Data.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jff_DataFocusLost(evt);
            }
        });

        jlb_Data.setForeground(new java.awt.Color(0, 0, 0));
        jlb_Data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_Data.setText("*Data e Hora");

        jff_Hora.setBackground(new java.awt.Color(250, 250, 250));
        jff_Hora.setForeground(new java.awt.Color(0, 0, 0));
        jff_Hora.setCaretColor(new java.awt.Color(0, 0, 0));
        jff_Hora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jff_Hora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jff_HoraFocusLost(evt);
            }
        });

        jbt_pedido.setBackground(new java.awt.Color(13, 71, 161));
        jbt_pedido.setForeground(new java.awt.Color(255, 255, 255));
        jbt_pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/detalhar18x18.png"))); // NOI18N
        jbt_pedido.setText("Pedido");
        jbt_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_pedidoActionPerformed(evt);
            }
        });

        jcb_und_medida.setBackground(new java.awt.Color(250, 250, 250));
        jcb_und_medida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcb_und_medida.setForeground(new java.awt.Color(0, 0, 0));
        jcb_und_medida.setToolTipText("");
        jcb_und_medida.setEnabled(false);

        jtf_perda.setBackground(new java.awt.Color(250, 250, 250));
        jtf_perda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_perda.setForeground(new java.awt.Color(0, 0, 0));
        jtf_perda.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_perda.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_perda.setEnabled(false);
        jtf_perda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_perdaFocusLost(evt);
            }
        });
        jtf_perda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_perdaKeyTyped(evt);
            }
        });

        jlb_perda.setForeground(new java.awt.Color(0, 0, 0));
        jlb_perda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_perda.setText("*Perda");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Observações");

        jta_obs.setBackground(new java.awt.Color(250, 250, 250));
        jta_obs.setColumns(20);
        jta_obs.setForeground(new java.awt.Color(0, 0, 0));
        jta_obs.setRows(4);
        jta_obs.setCaretColor(new java.awt.Color(0, 0, 0));
        jta_obs.setEnabled(false);
        jScrollPane2.setViewportView(jta_obs);

        jbt_decoracao.setBackground(new java.awt.Color(51, 51, 51));
        jbt_decoracao.setForeground(new java.awt.Color(255, 255, 255));
        jbt_decoracao.setText("Decorativos");
        jbt_decoracao.setEnabled(false);
        jbt_decoracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_decoracaoActionPerformed(evt);
            }
        });

        jlb_valor.setForeground(new java.awt.Color(0, 0, 0));
        jlb_valor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_valor.setText("*Valor Unitário (R$)");

        jtf_valor.setBackground(new java.awt.Color(250, 250, 250));
        jtf_valor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_valor.setForeground(new java.awt.Color(0, 0, 0));
        jtf_valor.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_valor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_valor.setEnabled(false);
        jtf_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valorFocusLost(evt);
            }
        });
        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_valorKeyTyped(evt);
            }
        });

        jbt_salvar.setBackground(new java.awt.Color(51, 51, 51));
        jbt_salvar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar18x18.png"))); // NOI18N
        jbt_salvar.setText("Salvar");
        jbt_salvar.setEnabled(false);
        jbt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_salvarActionPerformed(evt);
            }
        });

        jlb_und_valor.setForeground(new java.awt.Color(0, 0, 0));
        jlb_und_valor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jlb_ValorTotal1.setForeground(new java.awt.Color(0, 0, 0));
        jlb_ValorTotal1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlb_ValorTotal1.setText("Itens:");

        jtf_SomaItens.setBackground(new java.awt.Color(250, 250, 250));
        jtf_SomaItens.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_SomaItens.setForeground(new java.awt.Color(0, 0, 0));
        jtf_SomaItens.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtf_SomaItens.setCaretColor(new java.awt.Color(0, 0, 0));
        jtf_SomaItens.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jtf_SomaItens.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlb_cliente_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jff_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jff_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtf_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtf_cpf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbt_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbt_nova_movimentacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbt_pesquisar_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtf_id_item, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                            .addComponent(jtf_qtde_item))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jcb_und_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jlb_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlb_und_valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jtf_nome_item, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jlb_perda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtf_perda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbt_decoracao))
                                            .addComponent(jtf_grupo_item, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jbt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbt_pesquisar_item, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane2)))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlb_ValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_SomaItens, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jbt_fechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_SomaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_cliente_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbt_pesquisar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jtf_cpf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jff_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jff_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_nova_movimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_id_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nome_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_grupo_item, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_pesquisar_item, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_und_valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_qtde_item, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcb_und_medida, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(jtf_perda, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(jlb_perda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbt_decoracao, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlb_valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_valor, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_ValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_SomaValor, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jbt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_ValorTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_SomaItens, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
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

    private void jbt_nova_movimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_nova_movimentacaoActionPerformed
        jbt_nova_movimentacao.setEnabled(false);
        jbt_nova_movimentacao.setBackground(buttonDisableColor);
        jbt_pesquisar_cliente.setEnabled(false);
        jbt_pesquisar_cliente.setBackground(buttonDisableColor);
        jbt_pesquisar_item.setEnabled(true);
        jbt_pesquisar_item.setBackground(buttonBlueColor);
        jbt_pedido.setEnabled(false);
        jbt_pedido.setBackground(buttonDisableColor);
        if (Formatacao.removerFormatacao(jff_Data.getText()).equals("")) {
            jff_Data.setText(Formatacao.getDataAtual());
        }
        if (Formatacao.removerFormatacao(jff_Hora.getText()).equals("")) {
            jff_Hora.setText(Formatacao.getDataHoraAtual());
        }
        jff_Data.setEditable(false);
        jff_Hora.setEditable(false);
        ValidarData();
        ValidarHora();
    }//GEN-LAST:event_jbt_nova_movimentacaoActionPerformed

    private void jbt_pesquisar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_pesquisar_clienteActionPerformed
        jff_pesquisar_item_cliente jff_pesquisar = new jff_pesquisar_item_cliente(this, this.tipoMovimentacao, this.pesquisar_cliente_item, this.grupoTipo);
        jff_pesquisar.setVisible(true);
    }//GEN-LAST:event_jbt_pesquisar_clienteActionPerformed

    private void jbt_pesquisar_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_pesquisar_itemActionPerformed
        this.pesquisar_cliente_item = 3;
        jff_pesquisar_item_cliente jff_pesquisar = new jff_pesquisar_item_cliente(this, this.tipoMovimentacao, this.pesquisar_cliente_item, this.grupoTipo);
        jff_pesquisar.setVisible(true);
    }//GEN-LAST:event_jbt_pesquisar_itemActionPerformed

    private void jbt_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_inserirActionPerformed
        if ("producao".equals(this.tipoMovimentacao)) {
            if (Validacao.ValidarJTFObrigatorio(jtf_perda)) {
                this.perda = Double.parseDouble(jtf_perda.getText().replace(",", "."));
                jtf_valor.setText("0");
                this.valorUnd = 0;
                InserirDadosTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (!"producao".equals(this.tipoMovimentacao)) {
            if (Validacao.ValidarJTFObrigatorio(jtf_valor)) {
                this.valorUnd = Double.parseDouble(jtf_valor.getText().replace(",", "."));
                jtf_perda.setText("0");
                this.perda = 0;
                InserirDadosTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }

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

            //Excluir item da tabela        
            int rowIndex = jtb_itens.getSelectedRow();
            if (rowIndex >= 0) {
                model.removeRow(rowIndex);
                model.fireTableDataChanged();
            }

        }
        jbt_editar.setEnabled(false);
        jbt_editar.setBackground(buttonDisableColor);
        jbt_excluir.setEnabled(false);
        jbt_excluir.setBackground(buttonDisableColor);

        jtf_SomaItens.setText(String.valueOf(jtb_itens.getRowCount()));
        if (!"producao".equals(this.tipoMovimentacao)) {
            jtf_SomaValor.setText(String.valueOf(Formatacao.formatarDecimal2casasRS(SomarTotalValorTabela())));
        }

        if (jtb_itens.getRowCount() == 0) {
            jbt_salvar.setEnabled(false);
            jbt_salvar.setBackground(buttonDisableColor);
            this.apertou_editar = false;
        }

    }//GEN-LAST:event_jbt_excluirActionPerformed

    private void jtf_qtde_itemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_qtde_itemKeyTyped
        Validacao.ValidarDecimal(jtf_qtde_item, evt);
    }//GEN-LAST:event_jtf_qtde_itemKeyTyped

    private void jbt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_editarActionPerformed
        this.apertou_editar = true;
        //Editar quantidade Insumo na Estrutura
        int rowIndex = jtb_itens.getSelectedRow();
        String Column1 = String.valueOf(jtb_itens.getValueAt(jtb_itens.getSelectedRow(), 1));
        String[] parts = Column1.split(" -|- ");
        int id_item_edicao = Integer.parseInt(parts[0]);
        LimparCampos();

        //puxar valores da tabela para os JTF correspondentes
        NomearItem(id_item_edicao);
        jtf_qtde_item.setText(String.valueOf(jtb_itens.getValueAt(jtb_itens.getSelectedRow(), 3)).replace(".", ","));
        jta_obs.setText(String.valueOf(jtb_itens.getValueAt(jtb_itens.getSelectedRow(), 2)));
        jtf_qtde_item.requestFocus();
        jbt_pesquisar_item.setEnabled(false);
        jbt_pesquisar_item.setBackground(buttonDisableColor);
        jcb_und_medida.setEnabled(true);
        //Puxar o valor setado anteriormente de unidade de medida para o ComboBox
        String und_medidaTabela = String.valueOf(jtb_itens.getValueAt(jtb_itens.getSelectedRow(), 4));
        jcb_und_medida.setSelectedItem(und_medidaTabela);
        if ("producao".equals(this.tipoMovimentacao)) {
            jtf_perda.setText(String.valueOf(jtb_itens.getValueAt(jtb_itens.getSelectedRow(), 5)).replace(".", ","));
        } else {
            jtf_valor.setText(String.valueOf(jtb_itens.getValueAt(jtb_itens.getSelectedRow(), 5)).replace(".", ",").replace("R$  ", ""));
        }

        //Excluir item da tabela        
        if (rowIndex >= 0) {
            model.removeRow(rowIndex);
        }

        jbt_editar.setEnabled(false);
        jbt_editar.setBackground(buttonDisableColor);
        jbt_excluir.setEnabled(false);
        jbt_excluir.setBackground(buttonDisableColor);
    }//GEN-LAST:event_jbt_editarActionPerformed

    private void jtb_itensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_itensMouseClicked
        //Habilitar botões de alteração e detalhamento somente quando selecionar uma linha na tabela
        jbt_editar.setEnabled(true);
        jbt_editar.setBackground(buttonGreenColor);
        jbt_excluir.setEnabled(true);
        jbt_excluir.setBackground(buttonRedColor);
    }//GEN-LAST:event_jtb_itensMouseClicked

    private void jff_DataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_DataFocusLost
        ValidarData();
    }//GEN-LAST:event_jff_DataFocusLost

    private void jff_HoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jff_HoraFocusLost
        ValidarHora();
    }//GEN-LAST:event_jff_HoraFocusLost

    private void jbt_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_pedidoActionPerformed
        JOptionPane.showMessageDialog(this, "Função em implementação, ainda não está disponível!", "FUNÇÃO EM IMPLEMENTAÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbt_pedidoActionPerformed

    private void jtf_perdaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_perdaKeyTyped
        Validacao.ValidarDecimal(jtf_perda, evt);
    }//GEN-LAST:event_jtf_perdaKeyTyped

    private void jbt_decoracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_decoracaoActionPerformed
        JOptionPane.showMessageDialog(this, "Função em implementação, ainda não está disponível!", "FUNÇÃO EM IMPLEMENTAÇÃO", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbt_decoracaoActionPerformed

    private void jtf_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyTyped
        Validacao.ValidarDecimal(jtf_valor, evt);
    }//GEN-LAST:event_jtf_valorKeyTyped

    private void jbt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_salvarActionPerformed
        ArrayList<Movimentacao> m = new movimentacaoDAO().consultarUltimaIdGrupoMovimentacao();
        this.idGrupoMovimentacao = m.get(0).getId_grupo_movimentacao() + 1;
        String dataHora = Formatacao.ajustaDataAMD(jff_Data.getText()) + " " + jff_Hora.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime data = LocalDateTime.parse(dataHora, formatter);

        int rowCount = jtb_itens.getRowCount();

        if ("producao".equals(this.tipoMovimentacao)) {
            SalvarProducao(jtb_itens, rowCount, data);

        } else {
            SalvarVendaCompra(jtb_itens, rowCount, data);
        }

        if (salvarOk) {
            JOptionPane.showMessageDialog(this,
                    "Nova "
                    + this.tipoMovimentacao.toUpperCase()
                    + " salva com sucesso!",
                    "SUCESSO NA MOVIMENTAÇÃO",
                    JOptionPane.INFORMATION_MESSAGE);

            LimparCampos();
            model.setRowCount(0);
            jtf_SomaItens.setText(String.valueOf(jtb_itens.getRowCount()));
            if (this.tipoMovimentacao != "producao") {
                jtf_SomaValor.setText(String.valueOf(Formatacao.formatarDecimal2casasRS(SomarTotalValorTabela())));
            }
            jbt_salvar.setEnabled(false);
            jbt_salvar.setBackground(buttonDisableColor);
            this.apertou_editar = false;
            jbt_editar.setEnabled(false);
            jbt_editar.setBackground(buttonDisableColor);
            jbt_excluir.setEnabled(false);
            jbt_excluir.setBackground(buttonDisableColor);
            ConfigurarBotoesJTF();

        } else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir dados no banco de dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jbt_salvarActionPerformed

    private void jtf_qtde_itemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_qtde_itemFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_qtde_item);
    }//GEN-LAST:event_jtf_qtde_itemFocusLost

    private void jtf_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_valor);
    }//GEN-LAST:event_jtf_valorFocusLost

    private void jtf_perdaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_perdaFocusLost
        Validacao.ValidarJTFObrigatorio(jtf_perda);
    }//GEN-LAST:event_jtf_perdaFocusLost

    private void SalvarProducao(JTable jtb_itens, int rowCount, LocalDateTime data) {
        for (int row = 0; row < rowCount; row++) {
            String Column1 = jtb_itens.getValueAt(row, 1).toString();
            String[] parts = Column1.split(" -|- ");

            int idItem = Integer.parseInt(parts[0].toString());
            double qtde = Double.parseDouble(jtb_itens.getValueAt(row, 3).toString().replace(",", "."));
            String und = jtb_itens.getValueAt(row, 4).toString();
            double perda = Double.parseDouble(jtb_itens.getValueAt(row, 5).toString().replace(",", "."));
            String obs = jtb_itens.getValueAt(row, 2).toString();
            int idPedido = Integer.parseInt(jtb_itens.getValueAt(row, 6).toString());

            Item item = new ItemDAO().consultarId(Integer.parseInt(parts[0]));
            if (item.getUnidade_medida().equals(und)) {
                qtde = qtde;
            } else if (und.equals(item.getUnd_conv1())) {
                qtde = item.getConv2() * qtde;
            } else {
                qtde = qtde / item.getConv2();
            }

            ArrayList<Object[]> dadosValorInsumos = Validacao.AjustarEstoqueInsumosProdução(idItem, qtde, perda);
            double valorProduto = 0;
            for (int i = 0; i < dadosValorInsumos.size(); i++) {

                Object[] dados = dadosValorInsumos.get(i);
                int id_insumo = Integer.parseInt(dados[0].toString());
                double qtde_insumo = Double.parseDouble(dados[1].toString());
                valorProduto = valorProduto + ((qtde_insumo * new ItemDAO().consultarId(id_insumo).getValor()) / qtde);
            }

            //Salvar itens no BD
            Movimentacao mov = new Movimentacao();
            mov.setTipo(this.tipoMovimentacao);
            mov.setData(data);
            mov.setItem_id(idItem);
            mov.setCliente_id(0);
            mov.setValor(valorProduto);
            mov.setQtde(qtde);
            mov.setPerdas(perda);
            mov.setObservacao(obs);
            mov.setId_pedido(idPedido);
            mov.setId_grupo_movimentacao(this.idGrupoMovimentacao);

            movimentacaoDAO movDAO = new movimentacaoDAO();
            if (movDAO.salvar(mov) != null) {
                this.salvarOk = false;
            }
            
            SalvarUserMovimentacao();

            //Dar baixa do estoque nos insumos de uma produção
            ArrayList<Object[]> dadosAjusteEstoqueInsumos = Validacao.AjustarEstoqueInsumosProdução(idItem, qtde, perda);
            for (int i = 0; i < dadosAjusteEstoqueInsumos.size(); i++) {

                Object[] dados = dadosAjusteEstoqueInsumos.get(i);
                int id_insumo = Integer.parseInt(dados[0].toString());
                double qtde_insumo = Double.parseDouble(dados[1].toString());
                double valorInsumo = new ItemDAO().consultarId(id_insumo).getValor();

                Movimentacao movInsumo = new Movimentacao();
                movInsumo.setTipo("consumo");
                movInsumo.setData(data);
                movInsumo.setItem_id(id_insumo);
                movInsumo.setCliente_id(0);
                movInsumo.setValor(valorInsumo);
                movInsumo.setQtde(qtde_insumo);
                movInsumo.setPerdas(0);
                movInsumo.setObservacao("");
                movInsumo.setId_pedido(idPedido);
                movInsumo.setId_grupo_movimentacao(this.idGrupoMovimentacao);
                new movimentacaoDAO().salvar(movInsumo);

                if (new ItemDAO().atualizarEstoque(id_insumo, qtde_insumo) != null) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir dados no banco de dados!", "ERRO AO SALVAR", JOptionPane.ERROR_MESSAGE);
                }
                
                SalvarUserMovimentacao();
            }
        }
    }

    private void SalvarVendaCompra(JTable jtb_itens, int rowCount, LocalDateTime data) {
        for (int row = 0; row < rowCount; row++) {
            int clienteId = Integer.parseInt(jtf_id_cliente.getText());
            String Column1 = jtb_itens.getValueAt(row, 1).toString();
            String[] parts = Column1.split(" -|- ");
            int pedidoId = 0;

            int idItem = Integer.parseInt(parts[0].toString());
            double qtde = Double.parseDouble(jtb_itens.getValueAt(row, 3).toString().replace(",", "."));
            String und = jtb_itens.getValueAt(row, 4).toString();
            double valorUnitario = Double.parseDouble(jtb_itens.getValueAt(row, 5).toString().replace(",", ".").replace("R$  ", ""));
            String obs = jtb_itens.getValueAt(row, 2).toString();

            Item item = new ItemDAO().consultarId(Integer.parseInt(parts[0]));
            if (item.getUnidade_medida().equals(und)) {
                qtde = qtde;
            } else if (und.equals(item.getUnd_conv1())) {
                qtde = item.getConv2() * qtde;
            } else {
                qtde = qtde / item.getConv2();
            }

            //Salvar itens no BD movimentacao
            Movimentacao mov = new Movimentacao();
            mov.setTipo(this.tipoMovimentacao);
            mov.setData(data);
            mov.setItem_id(idItem);
            mov.setCliente_id(clienteId);
            mov.setValor(valorUnitario);
            if ("venda".equals(this.tipoMovimentacao)) {
                mov.setQtde(qtde * (-1));
            } else {
                mov.setQtde(qtde);
            }
            mov.setPerdas(0);
            mov.setObservacao(obs);
            mov.setId_pedido(pedidoId);
            mov.setId_grupo_movimentacao(this.idGrupoMovimentacao);

            movimentacaoDAO movDAO = new movimentacaoDAO();
            if (movDAO.salvar(mov) != null) {
                this.salvarOk = false;
            }

            SalvarUserMovimentacao();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbt_decoracao;
    private javax.swing.JButton jbt_editar;
    private javax.swing.JButton jbt_excluir;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_inserir;
    private javax.swing.JButton jbt_nova_movimentacao;
    private javax.swing.JButton jbt_pedido;
    private javax.swing.JButton jbt_pesquisar_cliente;
    private javax.swing.JButton jbt_pesquisar_item;
    private javax.swing.JButton jbt_salvar;
    private javax.swing.JComboBox<String> jcb_und_medida;
    private javax.swing.JFormattedTextField jff_Data;
    private javax.swing.JFormattedTextField jff_Hora;
    private javax.swing.JLabel jlb_Data;
    private javax.swing.JLabel jlb_ValorTotal;
    private javax.swing.JLabel jlb_ValorTotal1;
    private javax.swing.JLabel jlb_cliente_fornecedor;
    private javax.swing.JLabel jlb_perda;
    private javax.swing.JLabel jlb_und_valor;
    private javax.swing.JLabel jlb_valor;
    private javax.swing.JTextArea jta_obs;
    private javax.swing.JTable jtb_itens;
    private javax.swing.JTextField jtf_SomaItens;
    private javax.swing.JTextField jtf_SomaValor;
    private javax.swing.JTextField jtf_cpf_cliente;
    private javax.swing.JTextField jtf_grupo_item;
    private javax.swing.JTextField jtf_id_cliente;
    private javax.swing.JTextField jtf_id_item;
    private javax.swing.JTextField jtf_nome_cliente;
    private javax.swing.JTextField jtf_nome_item;
    private javax.swing.JTextField jtf_perda;
    private javax.swing.JTextField jtf_qtde_item;
    private javax.swing.JTextField jtf_valor;
    // End of variables declaration//GEN-END:variables

    public void SalvarUserMovimentacao(){
        //salvar movimentacao na tabela movimentacao_user
            int ultimaID = new movimentacaoDAO().consultarUltimaIdMovimentacao();
            Movimentacao_User movUser = new Movimentacao_User();
            movUser.setUsuario_id(this.user_id);
            movUser.setMovimentacao_id(ultimaID);

            Movimentacao_UserDAO movUserDAO = new Movimentacao_UserDAO();
            if (movUserDAO.salvar(movUser) != null) {
                this.salvarOk = false;
            }
    }
    
    public double SomarTotalValorTabela() {
        int columnIndex = 6; // Índice da coluna a ser somada
        int rowCount = jtb_itens.getRowCount();
        double sum = 0.00;

        for (int i = 0; i < rowCount; i++) {
            String valorTabela = jtb_itens.getValueAt(i, columnIndex).toString().replaceAll("[^\\d.,]", "");
            valorTabela = valorTabela.replace(".", "");
            valorTabela = valorTabela.replace(",", ".");
            double value = Double.parseDouble(valorTabela);
            sum += value;
        }
        return sum;
    }

    private void ConfigurarBotoesJTF() {
        //Configurar labels e texts Fields de acordo com o tipo de movimentação que foi aberta 
        jtf_id_cliente.setText("");
        jtf_nome_cliente.setText("");
        jtf_cpf_cliente.setText("");
        jff_Data.setText("");
        jff_Hora.setText("");
        jtf_qtde_item.setEnabled(false);
        jtf_perda.setEnabled(false);
        jtf_valor.setEnabled(false);
        jcb_und_medida.setEnabled(false);
        jbt_pesquisar_item.setEnabled(false);
        jbt_pesquisar_item.setBackground(buttonDisableColor);
        jbt_decoracao.setVisible(true);
        jbt_decoracao.setBackground(buttonDisableColor);
        jlb_perda.setVisible(false);
        jtf_perda.setVisible(false);
        jbt_pedido.setVisible(false);
        jtf_nome_cliente.setEnabled(false);
        jtf_cpf_cliente.setEnabled(false);
        jbt_pesquisar_cliente.setEnabled(true);
        jbt_pesquisar_cliente.setBackground(buttonBlueColor);
        jbt_nova_movimentacao.setEnabled(false);
        jbt_nova_movimentacao.setBackground(buttonDisableColor);
        jbt_pedido.setVisible(true);
        jbt_pedido.setBackground(buttonBlueColor);
        jbt_pedido.setEnabled(true);
        jtf_valor.setVisible(true);
        jlb_und_valor.setVisible(true);
        jlb_valor.setVisible(true);
        jtf_SomaValor.setVisible(true);
        jlb_ValorTotal.setVisible(true);
        jbt_pesquisar_item.setVisible(true);

        if ("compra".equals(this.tipoMovimentacao)) {
            this.pesquisar_cliente_item = 1;
            this.grupoTipo = "'MATERIA-PRIMA', 'FERRAMENTA', 'SERVICO', 'OUTRO'";
            this.setTitle("Nova Movimentação - COMPRA");
            jbt_nova_movimentacao.setText("NOVA COMPRA");
            jbt_decoracao.setVisible(false);
            jlb_cliente_fornecedor.setText("*Fornecedor");
            jbt_pedido.setVisible(false);

        } else if ("venda".equals(this.tipoMovimentacao)) {
            this.pesquisar_cliente_item = 2;
            this.grupoTipo = "'PRODUTO ACABADO', 'SERVICO', 'OUTRO'";
            this.setTitle("Nova Movimentação - VENDA");
            jbt_nova_movimentacao.setText("NOVA VENDA");
            jlb_cliente_fornecedor.setText("*Cliente");

        } else if ("producao".equals(this.tipoMovimentacao)) {
            this.grupoTipo = "'PRODUTO ACABADO'";
            this.setTitle("Nova Movimentação - PRODUÇÃO");
            jbt_nova_movimentacao.setText("NOVA PRODUÇÃO");
            jbt_nova_movimentacao.setEnabled(true);
            jbt_nova_movimentacao.setBackground(buttonBlueColor);
            jlb_perda.setVisible(true);
            jtf_perda.setVisible(true);
            jlb_cliente_fornecedor.setText("Pedido");
            jtf_cpf_cliente.setEnabled(false);
            jtf_nome_cliente.setEnabled(false);
            jtf_cpf_cliente.setEnabled(false);
            jbt_pesquisar_cliente.setEnabled(false);
            jbt_pesquisar_cliente.setBackground(buttonDisableColor);
            jtf_valor.setVisible(false);
            jlb_und_valor.setVisible(true);
            jlb_valor.setVisible(false);
            jtf_SomaValor.setVisible(false);
            jlb_ValorTotal.setVisible(false);
        }
        jbt_pesquisar_cliente.requestFocus();
    }

    private void LimparCampos() {
        jtf_id_item.setText("");
        jtf_nome_item.setText("");
        jtf_qtde_item.setText("");
        jtf_grupo_item.setText("");
        jcb_und_medida.setSelectedItem(null);
        jtf_valor.setText("");
        jta_obs.setText("");
        jtf_perda.setText("");
    }

    private void MensagemFecharComEdicaoEmAndamento() {
        Object[] options = {"Sim",
            "Não"};
        int n = JOptionPane.showOptionDialog(this,
                "Você começou a fazer uma nova movimentação de item e não salvou as alterações. "
                + "\n Se você sair agora sem SALVAR todas as movimentações da lista serão EXCLUÍDAS! "
                + "\n\nTem certeza que deseja sair e excluir essas movimentações?",
                "ALTERAÇÕES NÃO SALVAS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (n == 0) {
            this.dispose();
            this.apertou_editar = false;
        } else {
            jbt_inserir.requestFocus(true);
        }
    }

    private boolean ValidarData() {
        //Validar a Data
        if (Formatacao.removerFormatacao(jff_Data.getText()).equals("") || !Validacao.validarDataFormatada(jff_Data.getText())) {
            jff_Data.setBackground(Color.decode("#FF9696"));
            return false;
        } else {
            jff_Data.setBackground(Color.white);
            return true;
        }
    }

    private boolean ValidarHora() {
        //Validar a Hora
        if (Formatacao.removerFormatacao(jff_Hora.getText()).equals("") || !Validacao.validarHoraFormatada(jff_Hora.getText())) {
            jff_Hora.setBackground(Color.decode("#FF9696"));
            return false;
        } else {
            jff_Hora.setBackground(Color.white);
            return true;
        }
    }

    private void InserirDadosTabela() {

        //Validar se os campos obrigatórios foram preenchidos corretamente
        if (Validacao.ValidarJTFObrigatorio(jtf_qtde_item)) {

            //Pegar valores dos campos JTF
            String itemDesc = jtf_id_item.getText() + " -|- " + jtf_nome_item.getText();
            double QtdeItem = Double.parseDouble(jtf_qtde_item.getText().replace(",", "."));
            String und = jcb_und_medida.getSelectedItem().toString();
            String obs = jta_obs.getText();

            //Validar se possui estoque do item ou do insumo para nova Venda/Produção
            for (int i = 0; i < Validacao.ValidarEstoque(this.id_item_selecionado,
                    QtdeItem,
                    und,
                    perda,
                    jtb_itens,
                    this.tipoMovimentacao).size(); i++) {

                Object[] dadosValidacaoEstoque = Validacao.ValidarEstoque(this.id_item_selecionado,
                        QtdeItem,
                        und,
                        perda,
                        jtb_itens,
                        this.tipoMovimentacao).get(i);

                this.validarEstoque = Boolean.parseBoolean(dadosValidacaoEstoque[0].toString());
                if (!this.validarEstoque) {
                    this.itemIdSemEstoque = Integer.parseInt(dadosValidacaoEstoque[1].toString());
                    this.qtdeItemConsumo = Double.parseDouble(dadosValidacaoEstoque[2].toString());
                    this.qtdeItemEstoque = Double.parseDouble(dadosValidacaoEstoque[3].toString());
                    break;
                }

            }

            if (this.validarEstoque) {

                // Adição de linhas na tabela e ao ArrayList
                if (this.tipoMovimentacao == "venda" || this.tipoMovimentacao == "compra") {
                    double subTotal;

                    Item item = new ItemDAO().consultarId(this.id_item_selecionado);
                    if (item.getUnidade_medida().equals(und)) {
                        subTotal = valorUnd * QtdeItem;
                    } else if (und.equals(item.getUnd_conv1())) {
                        subTotal = valorUnd * item.getConv2() * QtdeItem;
                    } else {
                        subTotal = valorUnd / item.getConv2() * QtdeItem;
                    }

                    //Na VENDA a OBS fica personalizada com desconto/acrescimo de valor
                    if ("venda".equals(this.tipoMovimentacao)) {
                        if (valorUnd < item.getValor()) {
                            obs = "Desconto de R$ " + Formatacao.formatarDecimal2casas(item.getValor() - valorUnd) + "/" + item.getUnidade_medida() + " | " + obs;
                        }
                        if (valorUnd > item.getValor()) {
                            obs = "Acrescimo de R$ " + Formatacao.formatarDecimal2casas(valorUnd - item.getValor()) + "/" + item.getUnidade_medida() + " | " + obs;
                        }
                    }

                    //Adicionar os itens da linha em um Objeto
                    Object[] novaLinha = {this.linhasTabela,
                        itemDesc,
                        obs,
                        Formatacao.formatarDecimal4casas(QtdeItem),
                        und,
                        Formatacao.formatarDecimal2casasRS(valorUnd),
                        Formatacao.formatarDecimal2casasRS(subTotal)};

                    model.addRow(novaLinha);
                    this.linhasTabela++;
                    jtf_SomaValor.setText(String.valueOf(Formatacao.formatarDecimal2casasRS(SomarTotalValorTabela())));
                    
                } else {
                    int pedido;
                    try {
                        pedido = Integer.parseInt(jtf_id_cliente.getText());
                    } catch (Exception e) {
                        pedido = 0;
                    }

                    //Adicionar os itens da linha em um Objeto
                    Object[] novaLinha = {this.linhasTabela,
                        itemDesc,
                        obs,
                        Formatacao.formatarDecimal4casas(QtdeItem),
                        und,
                        Formatacao.formatarDecimal4casas(perda),
                        pedido};

                    model.addRow(novaLinha);
                    this.linhasTabela++;
                }
                LimparCampos();
                jbt_inserir.setEnabled(false);
                jbt_inserir.setBackground(buttonDisableColor);
                jbt_salvar.setEnabled(true);
                jbt_salvar.setBackground(buttonBlueColor);
                jbt_pesquisar_item.requestFocus();

            } else {
                JOptionPane.showMessageDialog(this, "Item "
                        + this.itemIdSemEstoque + " - " + new ItemDAO().consultarId(this.itemIdSemEstoque).getDescricao()
                        + " sem estoque suficiente.\n\n"
                        + "Quantidade a ser consumida = "
                        + Formatacao.formatarDecimal4casas(this.qtdeItemConsumo)
                        + " " + new ItemDAO().consultarId(this.itemIdSemEstoque).getUnidade_medida()
                        + "\nQuantidade em estoque = "
                        + Formatacao.formatarDecimal4casas(this.qtdeItemEstoque) + " "
                        + new ItemDAO().consultarId(this.itemIdSemEstoque).getUnidade_medida(),
                        "ITEM SEM ESTOQUE", JOptionPane.ERROR_MESSAGE);
                jtf_qtde_item.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Você possui campos obrigatórios (*) em branco ou preenchidos incorretamente. Verifique!", "ERRO", JOptionPane.ERROR_MESSAGE);
            jbt_pesquisar_item.requestFocus();
        }

        this.apertou_editar = true;
        jtf_SomaItens.setText(String.valueOf(jtb_itens.getRowCount()));
        jbt_pesquisar_item.setEnabled(true);
        jbt_pesquisar_item.setBackground(buttonBlueColor);
        jbt_editar.setEnabled(false);
        jbt_editar.setBackground(buttonDisableColor);
        jbt_excluir.setEnabled(false);
        jbt_excluir.setBackground(buttonDisableColor);

    }

    private void InserirTabela() {
        //Inserir o modelo da tabela
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tornar todas as células não editáveis
            }
        };
        jtb_itens.setModel(model);

        if ("compra".equals(this.tipoMovimentacao) || "venda".equals(this.tipoMovimentacao)) {
            // Definição das colunas da tabela
            model.addColumn("Nº");
            model.addColumn("ID -|- Item");
            model.addColumn("Observação");
            model.addColumn("Qtde");
            model.addColumn("Und");
            model.addColumn("Valor Unitário");
            model.addColumn("Sub-Total");

            // Centralizar conteúdo dascolunas
            centralizarConteudoColuna(0);
            centralizarConteudoColuna(3);
            centralizarConteudoColuna(4);
            centralizarConteudoColuna(5);

            //ajusta o tamanho da fonte
            int fontSize = 10; // Defina o tamanho da fonte desejado
            TableColumn column0 = jtb_itens.getColumnModel().getColumn(0);
            TableColumn column2 = jtb_itens.getColumnModel().getColumn(2);
            TableColumn column4 = jtb_itens.getColumnModel().getColumn(4);
            column0.setCellRenderer(new CustomRenderer2(fontSize));
            column2.setCellRenderer(new CustomRenderer(fontSize));
            column4.setCellRenderer(new CustomRenderer2(fontSize));

        } else {
            // Definição das colunas da tabela
            model.addColumn("Nº");
            model.addColumn("ID -|- Item");
            model.addColumn("Observação");
            model.addColumn("Qtde");
            model.addColumn("Und");
            model.addColumn("Perda");
            model.addColumn("ID Pedido");

            // Centralizar conteúdo dascolunas
            centralizarConteudoColuna(0);
            centralizarConteudoColuna(3);
            centralizarConteudoColuna(4);
            centralizarConteudoColuna(5);
            centralizarConteudoColuna(6);

            //ajusta o tamanho da fonte
            int fontSize = 10; // Defina o tamanho da fonte desejado
            TableColumn column = jtb_itens.getColumnModel().getColumn(5);
            column.setCellRenderer(new CustomRenderer2(fontSize));
        }
        // Ajustar tamanho das colunas
        ajustarTamanhoColunas(this.tipoMovimentacao);
    }

    private void ajustarTamanhoColunas(String tipoMovimentacao) {
        // Definir o tamanho manual das colunas (menos da última)
        if ("compra".equals(this.tipoMovimentacao) || "venda".equals(this.tipoMovimentacao)) {
            int[] columnWidths = {5, 270, 200, 50, 10, 80};
            for (int i = 0; i < columnWidths.length; i++) {
                TableColumn column = jtb_itens.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }
        } else {
            int[] columnWidths = {50, 300, 80, 80, 100, 100};
            for (int i = 0; i < columnWidths.length; i++) {
                TableColumn column = jtb_itens.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }
        }
        // Configurar a última coluna para redimensionar automaticamente
        jtb_itens.setAutoResizeMode(jtb_itens.AUTO_RESIZE_LAST_COLUMN);
    }

    private void centralizarConteudoColuna(int columnIndex) {
        // Criar um objeto DefaultTableCellRenderer para centralizar o conteúdo da coluna
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar o renderer à coluna específica da tabela
        jtb_itens.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);

    }

    public class CustomRenderer extends DefaultTableCellRenderer {

        private int fontSize;

        public CustomRenderer(int fontSize) {
            this.fontSize = fontSize;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Define o tamanho da fonte
            Font font = cell.getFont();
            font = font.deriveFont(Font.PLAIN, fontSize);
            cell.setFont(font);
            return cell;
        }
    }

    public class CustomRenderer2 extends DefaultTableCellRenderer {

        private int fontSize;

        public CustomRenderer2(int fontSize) {
            this.fontSize = fontSize;
            setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Define o tamanho da fonte
            Font font = cell.getFont();
            font = font.deriveFont(Font.PLAIN, fontSize);
            cell.setFont(font);
            return cell;
        }
    }

}
