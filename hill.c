#include <stdio.h>
#include <string.h>
#include <ctype.h>

int mod(int n) {
 	return (n % 26 + 26) % 26;
}

void process(char s[], int k[], char res[]) {
 	int i, a, b, n = strlen(s);

	 for(i = 0; i < n; i += 2) {
		 a = s[i] - 'A';
		 b = s[i+1] - 'A';
		 res[i] = mod(k[0]*a + k[1]*b) + 'A';
 		 res[i+1] = mod(k[2]*a + k[3]*b) + 'A';
 	}
 	res[i] = '\0';
}

int main() {
 	int k[4], inv[4], det, d = -1, i, n;
 	char s[100], enc[100], dec[100];

	 printf("Enter key matrix: ");
	 for(i = 0; i < 4; i++)
 		scanf("%d", &k[i]);

 	det = mod(k[0]*k[3] - k[1]*k[2]);

 	for(i = 1; i < 26; i++) {
 		if(mod(det*i) == 1) {
 			d = i;
 			break;
 		}
	 }
    if(d == -1) {
        printf("Invalid key");
        return 0;
    }
    printf("Enter text: ");
    scanf("%99s", s);
    for(i = 0; s[i]; i++)
        s[i] = toupper((unsigned char)s[i]);

    n = strlen(s);
    if(n % 2 != 0)
        s[n++] = 'X', s[n] = '\0';

    inv[0] = mod(k[3]*d);
    inv[1] = mod(-k[1]*d);
    inv[2] = mod(-k[2]*d);
    inv[3] = mod(k[0]*d);

    process(s, k, enc);
    process(enc, inv, dec);

    printf("Encrypted: %s\n", enc);
    printf("Decrypted: %s\n", dec);

    return 0;
}
