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

    
}
