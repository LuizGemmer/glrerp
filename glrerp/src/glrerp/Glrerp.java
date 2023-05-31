package glrerp;

import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import view.Loggin;
import view.Menu.raven.main.Main;

/**
 *
 * @author Gabriel Nierich, Luiz Gemmer e Ruan Gemmer
 */
public class Glrerp {

    public static void main(String[] args) {
        //Testa se tem conexão com o banco de dados PostgreSQL
        if (ConexaoBD.getInstance().getConnection() != null) {
            new Loggin(new Main(), true).setVisible(true);
        } else {

            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de Dados!", "ERRO BANCO DE DADOS", JOptionPane.ERROR_MESSAGE);
            MensagemInicial();
        }
        
        //new Main().setVisible(true);
    }

    public static void MensagemInicial() {
        JOptionPane.showMessageDialog(null,
                "Bem-vindo!"
                + "\nPrograma feito por Gabriel Nierich, Luiz Gemmer e Ruan Gemmer."
                + "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------"
                + "\n\nIMPORTANTE: Para acessar o programa faça o RESTORE do backup no pgAdmin. O backup se encontra em /glrerp/glrerp/Banco de dados/backup.sql"
                + "\n\n O usuário e senha pode ser deixado VAZIOS e clicar em ACESSAR para iniciar o programa. O programa ainda não verifica usuário e senha com o BD.",
                "OLÁ",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
