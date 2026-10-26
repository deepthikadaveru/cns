import javax.crypto.*; 
import javax.crypto.spec.*; 
import java.util.*; 
 
public class Main { 
    public static void main(String[] args) throws Exception { 
        String text = "Hello world"; 
        SecretKeySpec key = new SecretKeySpec("mysecret".getBytes(), "Blowfish"); 
        Cipher c = Cipher.getInstance("Blowfish"); 
        c.init(Cipher.ENCRYPT_MODE, key); 
 
        byte[] enc = c.doFinal(text.getBytes()); 
 
        System.out.print("Encrypted: "); 
        for (byte b : enc) System.out.printf("%02X", b); 
        System.out.println(); 
 
        c.init(Cipher.DECRYPT_MODE, key); 
        byte[] dec = c.doFinal(enc); 
        System.out.println("Decrypted: " + new String(dec)); 
    } 
}
