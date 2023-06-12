
package entidade;

/**
 *
 * @author ruang
 */
public class Movimentacao_Adicionais {
    private int movimentacao_id;
    private int adicionais_id;
    private double qtde;
    private double valor;
    private String observacao;

    public int getMovimentacao_id() {
        return movimentacao_id;
    }

    public void setMovimentacao_id(int movimentacao_id) {
        this.movimentacao_id = movimentacao_id;
    }

    public int getAdicionais_id() {
        return adicionais_id;
    }

    public void setAdicionais_id(int adicionais_id) {
        this.adicionais_id = adicionais_id;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
  
}
