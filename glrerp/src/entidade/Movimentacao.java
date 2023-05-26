
package entidade;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.time.LocalDateTime;

/**
 *
 * @author ruang
 */
public class Movimentacao {
    private int id;
    private String tipo;
    private LocalDateTime data;
    private int item_id;
    private int cliente_id;
    private int id_pedido;
    private double valor;
    private double qtde;
    private double perdas;
    private String observacao;

    public Movimentacao() {}
    
    public Movimentacao(ResultSet retorno) {
        try {
            this.setId(retorno.getInt("id"));
            this.setTipo(retorno.getString("tipo"));
            this.setData(retorno.getTimestamp("data").toLocalDateTime());
            this.setItem_id(retorno.getInt("item_id"));
            this.setCliente_id(retorno.getInt("cliente_id"));
            this.setValor(retorno.getDouble("valor"));
            this.setQtde(retorno.getDouble("qtde"));
            this.setPerdas(retorno.getDouble("perda"));
            this.setObservacao(retorno.getString("observacao"));
            this.setId_pedido(retorno.getInt("id"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public double getPerdas() {
        return perdas;
    }

    public void setPerdas(double perdas) {
        this.perdas = perdas;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }   
}
