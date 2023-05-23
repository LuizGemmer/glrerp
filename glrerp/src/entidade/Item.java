package entidade;

/**
 *
 * @author rg
 */
public class Item {

    private int id;
    private int id_grupo;
    private String descricao;
    private double qtde_estoque;
    private boolean ativo;
    private String unidade_medida;
    private String observacao;
    private double conv1;
    private String und_conv1;
    private double conv2;
    private String und_conv2;
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQtde_estoque() {
        return qtde_estoque;
    }

    public void setQtde_estoque(double qtde_estoque) {
        this.qtde_estoque = qtde_estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getConv1() {
        return conv1;
    }

    public void setConv1(double conv1) {
        this.conv1 = conv1;
    }

    public String getUnd_conv1() {
        return und_conv1;
    }

    public void setUnd_conv1(String und_conv1) {
        this.und_conv1 = und_conv1;
    }

    public double getConv2() {
        return conv2;
    }

    public void setConv2(double conv2) {
        this.conv2 = conv2;
    }

    public String getUnd_conv2() {
        return und_conv2;
    }

    public void setUnd_conv2(String und_conv2) {
        this.und_conv2 = und_conv2;
    }
}
