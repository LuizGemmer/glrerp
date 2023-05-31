package apoio;


import org.mindrot.jbcrypt.BCrypt;

public class BCryptEncryption {

    public static String encryptPassword(char[] password) {
        String passwordString = new String(password);
        String hashedPassword = BCrypt.hashpw(passwordString, BCrypt.gensalt());
        return hashedPassword;
    }

    public static boolean verifyPassword(char[] password, String hashedPassword) {
        String passwordString = new String(password);
        return BCrypt.checkpw(passwordString, hashedPassword);
    }

    /*public static void main(String[] args) {
        String password = "myPassword123";
        String hashedPassword = encryptPassword(password);
        System.out.println("Senha criptografada em bcrypt: " + hashedPassword);

        // Verificar se a senha original corresponde à senha criptografada
        boolean isPasswordMatch = verifyPassword(password, hashedPassword);
        System.out.println("A senha corresponde à senha criptografada: " + isPasswordMatch);
    }*/
}
