
package view;

import apoio.IDAOT;

/**
 *
 * @author rg
 */
public interface jff_ITelaAlterarCadastro {
    public void setDAO(Object dao);
    
    public void setDetalhamento(boolean inativarControles);
    
    public void setTelaParente(jif_Listagem_DAO tela);
    
    public void showWindow(boolean show);
}
