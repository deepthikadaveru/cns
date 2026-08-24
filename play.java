import java.util.*;

public class Main {

    static String m = "";

    static String process(String s, int d) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {

            int a = m.indexOf(s.charAt(i));
            int b = m.indexOf(s.charAt(i + 1));

            int r1 = a / 5, c1 = a % 5;
            int r2 = b / 5, c2 = b % 5;

            // Same row
            if (r1 == r2) {

                res.append(
                    m.charAt(r1 * 5 + (c1 + d) % 5)
                );

                res.append(
                    m.charAt(r2 * 5 + (c2 + d) % 5)
                );
            }

            // Same column
            else if (c1 == c2) {

                res.append(
                    m.charAt(((r1 + d) % 5) * 5 + c1)
                );

                res.append(
                    m.charAt(((r2 + d) % 5) * 5 + c2)
                );
            }

            // Rectangle
            else {

                res.append(
                    m.charAt(r1 * 5 + c2)
                );

                res.append(
                    m.charAt(r2 * 5 + c1)
                );
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create key matrix
        System.out.print("Enter key: ");

        String key = sc.nextLine()
                .toUpperCase()
                .replaceAll("[^A-Z]", "")
                .replace('J', 'I');

        key += "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        for (char c : key.toCharArray()) {

            if (m.indexOf(c) == -1)
                m += c;
        }

        // Read plaintext
        System.out.print("Enter text: ");

        String pt = sc.nextLine()
                .toUpperCase()
                .replaceAll("[^A-Z]", "")
                .replace('J', 'I');

        // Create pairs
        StringBuilder raw = new StringBuilder();

        for (int i = 0; i < pt.length(); i++) {

            raw.append(pt.charAt(i));

            if (i + 1 < pt.length()) {

                if (pt.charAt(i) == pt.charAt(i + 1)) {
                    raw.append('X');
                }
                else {
                    raw.append(pt.charAt(++i));
                }
            }
        }

        if (raw.length() % 2 != 0)
            raw.append('X');

        String enc = process(raw.toString(), 1);
        String dec = process(enc, 4);

        System.out.println("Formatted: " + raw);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);

        sc.close();
    }
}

/*
OUTPUT:

Enter key: mgit
Enter text: indiannavy

Formatted: INDIANNAVY
Encrypted: TLLDTOOTWZ
Decrypted: INDIANNAVY
*/
