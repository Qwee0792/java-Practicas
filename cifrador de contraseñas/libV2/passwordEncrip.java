package libV2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class passwordEncrip {

    private static final String[] METHODS = {
        "MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512"
    };
    
    public static String encrypt(String password, String method) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(method);
        byte[] hash = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
    
    public static void main(String[] args) {
        try {
            String password = "password";
            String encrypted = encrypt(password, "MD5");
            System.out.println("MD5: " + encrypted);
    
            encrypted = encrypt(password, "SHA-1");
            System.out.println("SHA-1: " + encrypted);
    
            encrypted = encrypt(password, "SHA-256");
            System.out.println("SHA-256: " + encrypted);
    
            encrypted = encrypt(password, "SHA-384");
            System.out.println("SHA-384: " + encrypted);
    
            encrypted = encrypt(password, "SHA-512");
            System.out.println("SHA-512: " + encrypted);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    public static String encrypt(String password) throws NoSuchAlgorithmException {
        String[] methods = {"MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512"};
        String result = "";
        for (String method : methods) {
            result = encrypt(password, method);
        }
        return result;
    }
    
    public static String encrypt(String password, String[] methods) throws NoSuchAlgorithmException {
        String result = "";
        for (String method : methods) {
            result = encrypt(password, method);
        }
        return result;
    }
}