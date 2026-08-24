import java.util.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        String keyStr = sc.nextLine();

        SecretKeySpec key =
            new SecretKeySpec(keyStr.getBytes(), "Blowfish");

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        Cipher cipher = Cipher.getInstance("Blowfish");

        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encBytes =
            cipher.doFinal(text.getBytes());

        String enc =
            Base64.getEncoder().encodeToString(encBytes);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decBytes =
            cipher.doFinal(
                Base64.getDecoder().decode(enc)
            );

        String dec = new String(decBytes);

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);

        sc.close();
    }
}

/*
OUTPUT:

Enter key: hello
Enter text: deepthi

Encrypted: uc9SBEYCM4E=
Decrypted: deepthi
*/
