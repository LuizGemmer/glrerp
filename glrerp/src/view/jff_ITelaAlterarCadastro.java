/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import apoio.IDAOT;
import javax.swing.JFrame;

/**
 *
 * @author rg
 */
public interface jff_ITelaAlterarCadastro {
    public void setDAO(IDAOT dao);
    
    public void setDetalhamento(boolean inativarControles);
    
    public void setTelaParente(JFrame tela);
}