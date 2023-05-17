
package entidade;

/**
 *
 * @author ruang
 */
public class User {
    private int id;
    private String nome;
    private String senha;
    private String hierarquia;
    private boolean ativo;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(String hierarquia) {
        this.hierarquia = hierarquia;
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
}
