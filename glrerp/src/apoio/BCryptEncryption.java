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
    
}
