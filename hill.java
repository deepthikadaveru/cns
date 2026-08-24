import java.util.*;

public class Main {

    static int mod(int n) {
        return ((n % 26) + 26) % 26;
    }

    static String process(int[] k, String text) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {

            int p1 = text.charAt(i) - 'A';
            int p2 = text.charAt(i + 1) - 'A';

            res.append((char)(
                mod(k[0] * p1 + k[1] * p2) + 'A'
            ));

            res.append((char)(
                mod(k[2] * p1 + k[3] * p2) + 'A'
            ));
        }

        return res.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 4 key values:");

        int[] k = new int[4];

        for (int i = 0; i < 4; i++)
            k[i] = sc.nextInt();

        int det = mod(k[0] * k[3] - k[1] * k[2]);

        int invDet = -1;

        for (int i = 1; i < 26; i++) {

            if (mod(det * i) == 1) {
                invDet = i;
                break;
            }
        }

        if (invDet == -1) {
            System.out.println("Invalid key");
            return;
        }

        System.out.print("Enter text: ");

        String text = sc.next()
                .toUpperCase()
                .replaceAll("[^A-Z]", "");

        if (text.length() % 2 != 0)
            text += "X";

        int[] invK = {
            mod(k[3] * invDet),
            mod(-k[1] * invDet),
            mod(-k[2] * invDet),
            mod(k[0] * invDet)
        };

        String enc = process(k, text);
        String dec = process(invK, enc);

        System.out.println("Padded: " + text);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);

        sc.close();
    }
}

/*
OUTPUT:

Enter 4 key values:
3 3 2 5
Enter text: hello

Padded: HELLOX
Encrypted: HIOZHN
Decrypted: HELLOX
*/
