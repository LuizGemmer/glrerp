package entidade;

/**
 *
 * @author rg
 */
public class Grupo {
    private int id;
    private String descricao;
    private String tipo;
    private boolean ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public String toString(){
        return String.valueOf("(" + String.valueOf(this.getTipo()) + ")  " + String.valueOf(this.getDescricao()));
    }
}
