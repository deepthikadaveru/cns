import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        char[] s = sc.nextLine().toCharArray();

        System.out.print("Enter key: ");
        int k = sc.nextInt() % 26;

        // Encryption
        for (int i = 0; i < s.length; i++) {

            if (s[i] >= 'a' && s[i] <= 'z')
                s[i] = (char)((s[i] - 'a' + k) % 26 + 'a');

            else if (s[i] >= 'A' && s[i] <= 'Z')
                s[i] = (char)((s[i] - 'A' + k) % 26 + 'A');
        }

        System.out.println("Encrypted: " + new String(s));

        // Decryption
        for (int i = 0; i < s.length; i++) {

            if (s[i] >= 'a' && s[i] <= 'z')
                s[i] = (char)((s[i] - 'a' + 26 - k) % 26 + 'a');

            else if (s[i] >= 'A' && s[i] <= 'Z')
                s[i] = (char)((s[i] - 'A' + 26 - k) % 26 + 'A');
        }

        System.out.println("Decrypted: " + new String(s));

        sc.close();
    }
}

/*
OUTPUT:

Enter string: hi all
Enter key: 3
Encrypted: kl doo
Decrypted: hi all
*/
