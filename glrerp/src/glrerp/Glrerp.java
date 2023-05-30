package glrerp;

import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import view.Loggin;
import view.Menu.raven.main.Main;
import view.telaPrincipal;

/**
 *
 * @author Gabriel Nierich, Luiz Gemmer e Ruan Gemmer
 */
public class Glrerp {

    
    public static void main(String[] args) {

        /*
        //Testa se tem conexão com o banco de dados PostgreSQL
        if (ConexaoBD.getInstance().getConnection() != null) {
            new Loggin().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de Dados!", "ERRO BANCO DE DADOS", JOptionPane.ERROR_MESSAGE);
        }
         */
        //new telaPrincipal().setVisible(true);
        new Main().setVisible(true);

    }

}
