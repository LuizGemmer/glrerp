package apoio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ruang
 */
public class Criptografar {

    public static byte[] CriptografarSenha(JPasswordField jPasswordField) {
        char[] senha = jPasswordField.getPassword();

        try {
            // Converter o array de caracteres em um array de bytes
            byte[] senhaBytes = new String(senha).getBytes();

            // Criar um InputStream usando o array de bytes da senha
            ByteArrayInputStream inputStream = new ByteArrayInputStream(senhaBytes);

            // Criar um ByteArrayOutputStream para capturar a saída criptografada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            // Chame o método encrypt para criptografar a senha
            AES.encrypt(256, senha, inputStream, outputStream);
            Arrays.fill(senha, ' ');
            // Obter a senha criptografada como um array de bytes
            byte[] senhaCriptografada = outputStream.toByteArray();

            // Fechar os fluxos de entrada e saída
            inputStream.close();
            outputStream.close();
            return senhaCriptografada;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static byte[] CriptografarEmail(JTextField jTextField) {
        String email = jTextField.getText();

        try {
            // Converter o array de caracteres em um array de bytes
            byte[] senhaBytes = new String(email).getBytes();

            // Criar um InputStream usando o array de bytes da senha
            ByteArrayInputStream inputStream = new ByteArrayInputStream(senhaBytes);

            // Criar um ByteArrayOutputStream para capturar a saída criptografada
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            // Chame o método encrypt para criptografar a senha
            AES.encrypt(256, email.toCharArray(), inputStream, outputStream);

            // Obter a senha criptografada como um array de bytes
            byte[] emailCriptografado = outputStream.toByteArray();

            // Fechar os fluxos de entrada e saída
            inputStream.close();
            outputStream.close();
            return emailCriptografado;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
