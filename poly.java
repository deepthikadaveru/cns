import java.util.*;

public class Main {

    static String process(String text, String key, boolean enc) {

        StringBuilder res = new StringBuilder();

        int keyLen = key.length();

        for (int i = 0; i < text.length(); i++) {

            int p = text.charAt(i) - 'A';
            int k = key.charAt(i % keyLen) - 'A';

            int shift;

            if (enc)
                shift = (p + k) % 26;
            else
                shift = (p - k + 26) % 26;

            res.append((char)(shift + 'A'));
        }

        return res.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");

        String text = sc.nextLine()
                .toUpperCase()
                .replaceAll("[^A-Z]", "");

        System.out.print("Enter key: ");

        String key = sc.nextLine()
                .toUpperCase()
                .replaceAll("[^A-Z]", "");

        String enc = process(text, key, true);
        String dec = process(enc, key, false);

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);

        sc.close();
    }
}

/*
OUTPUT:

Enter text: hello
Enter key: hi
Encrypted: OMSTV
Decrypted: HELLO
*/
