package glrerp;

import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import view.telaLoggin;
import view.telaPrincipal;

/**
 *
 * @author Gabriel Nierich, Luiz Gemmer e Ruan Gemmer
 */
public class Glrerp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
        //Testa se tem conexão com o banco de dados PostgreSQL
        if (ConexaoBD.getInstance().getConnection() != null) {
            new telaLoggin().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de Dados!", "ERRO BANCO DE DADOS", JOptionPane.ERROR_MESSAGE);
        }
         */
        new telaPrincipal().setVisible(true);

    }

}
