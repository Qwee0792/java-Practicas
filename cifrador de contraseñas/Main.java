import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.io.InputStreamReader;


import libV2.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File eula = new File("eula.txt");
        if (eula.exists()) {
            if (checkEula() == false) {
                System.out.println("Error acepta el EULA");
    
            }else{
                //#region
                // resto del code 
                //#endregion
                System.out.println("Contraseña");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String pass = br.readLine();
                String[] methods = {"MD5", "SHA-1"};
                try {
                    String encryptedPass = passwordEncrip.encrypt(pass, methods);
                    System.out.println(encryptedPass);
                } catch (NoSuchAlgorithmException e) {
                    // Handle the exception
                }
            }
            
        }else{
            eula();
        }
    }

    private static void eula() throws IOException {
        FileWriter writer = new FileWriter("eula.txt");
        writer.write("EULA = false");
        writer.close();
    }

    private static boolean checkEula() throws IOException {
        FileReader reader = new FileReader("eula.txt");

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine())!= null) {
            // Check if the line contains the desired value
            switch (line) {
                case "EULA = false":
                    System.out.println("The value is found!");
                    return false;
                default:
                    break;
            }
        }

        reader.close();
        return true; // This line is added to return a value of type boolean
    }
}