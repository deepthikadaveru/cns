import java.util.*;
import java.security.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter text :  ");
        String p = sc.nextLine();

        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] enc=md.digest(p.getBytes());
        System.out.println("Encrypted: " );
        for(byte b:enc)
            System.out.printf("%02X",b);
    }
}
