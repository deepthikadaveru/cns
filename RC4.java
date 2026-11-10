import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter text : ");
        String txt=sc.nextLine();
        System.out.printf("Enter key : ");
        String key=sc.nextLine();
        
        try{
            SecretKeySpec sk=new SecretKeySpec(key.getBytes(),"RC4");
            Cipher c=Cipher.getInstance("RC4");
            c.init(Cipher.ENCRYPT_MODE,sk);
            byte enc[]=c.doFinal(txt.getBytes());
            System.out.printf("Encrypted : ");
            for(byte b:enc) 
                System.out.printf("%02X",b);
            
            c.init(Cipher.DECRYPT_MODE,sk);
            byte dec[]=c.doFinal(enc);
            System.out.printf("\nDecrypted : "+new String(dec));
        }
        catch(Exception e){
            System.out.println("NO alg");
        }
    }
}
