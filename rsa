import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter p and q: ");
        int p = sc.nextInt();
        int q = sc.nextInt();

        int n = p * q;
        int phi = (p - 1) * (q - 1);

        System.out.print("Enter e: ");
        int e = sc.nextInt();

        int d = 1;
        while ((d * e) % phi != 1)
            d++;

        System.out.print("Enter message: ");
        int m = sc.nextInt();

        int c = (int) (Math.pow(m, e) % n);
        int decrypted = (int) (Math.pow(c, d) % n);

        System.out.println("Encrypted = " + c);
        System.out.println("Decrypted = " + decrypted);

        sc.close();
    }
}
