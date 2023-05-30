package glrerp;

import view.Menu.raven.main.Main;

/**
 *
 * @author Gabriel Nierich, Luiz Gemmer e Ruan Gemmer
 */
public class Glrerp {

    
    public static void main(String[] args) {

       /*
        //Testa se tem conexão com o banco de dados PostgreSQL
        if (ConexaoBD.getInstance().getConnection() != null) {
            new Loggin(new Main(), true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de Dados!", "ERRO BANCO DE DADOS", JOptionPane.ERROR_MESSAGE);
        }*/
               
        new Main().setVisible(true);
         
        

    }

}
