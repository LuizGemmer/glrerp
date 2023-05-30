package entidade;

/**
 *
 * @author rg
 */
public class Estrutura {

    private int item_id;
    private int insumo_id;
    private double qtde_insumo;
    private boolean ativo;
    private String und_medida;
    private double valor_estrutura;

    
    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getInsumo_id() {
        return insumo_id;
    }

    public void setInsumo_id(int insumo_id) {
        this.insumo_id = insumo_id;
    }

    public double getQtde_insumo() {
        return qtde_insumo;
    }

    public void setQtde_insumo(double qtde_insumo) {
        this.qtde_insumo = qtde_insumo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getUnd_medida() {
        return und_medida;
    }

    public void setUnd_medida(String und_medida) {
        this.und_medida = und_medida;
    }

    public double getValor_estrutura() {
        return valor_estrutura;
    }

    public void setValor_estrutura(double valor_estrutura) {
        this.valor_estrutura = valor_estrutura;
    }

    
}
