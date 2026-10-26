import java.util.*; 
 
public class Main { 
    static byte[] rc4(byte[] data, String key) { 
        int[] s = new int[256]; 
        for (int i = 0; i < 256; i++) s[i] = i; 
 
        // KSA: Key Scheduling alg - Shuffle the array using the secret key 
        int j = 0; 
        for (int i = 0; i < 256; i++) { 
            j = (j + s[i] + key.charAt(i % key.length())) % 256; 
            int t = s[i]; 
            s[i] = s[j]; 
            s[j] = t; 
        } 
 
        // PRGA: Generate keystream and XOR with data 
        int i = 0; 
        j = 0; 
        byte[] out = new byte[data.length]; 
 
        for (int n = 0; n < data.length; n++) { 
            i = (i + 1) % 256;  
            j = (j + s[i]) % 256; 
            int t = s[i]; 
            s[i] = s[j]; 
            s[j] = t; 
 
            // Generate one keystream byte 
            int k = s[(s[i] + s[j]) % 256]; 
 
            // XOR input byte with keystream byte 
            out[n] = (byte) (data[n] ^ k); 
        } 
        return out; 
    } 

 
 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter text: "); 
        String text = sc.nextLine(); 
        System.out.print("Enter key: "); 
        String key = sc.nextLine(); 
 
        byte[] enc = rc4(text.getBytes(), key); 
        // Display encrypted bytes in hexadecimal 
        System.out.print("Encrypted: "); 
        for (byte b : enc) System.out.printf("%02X", b); 
        System.out.println(); 
        System.out.println("Decrypted: " + new String(rc4(enc, key))); 
    } 
}
