#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    char text[100], key[100];
    printf("Enter text: ");
    scanf("%s", text);

    printf("Enter key: ");
    scanf("%s", key);

    for (int i = 0; text[i] != '\0'; i++)
        text[i] = toupper(text[i]);
    for (int i = 0; key[i] != '\0'; i++)
        key[i] = toupper(key[i]);

    int keyLen = strlen(key);
    for (int i = 0; text[i] != '\0'; i++) {        
            int p = text[i] - 'A';
            int k = key[i % keyLen] - 'A';
            text[i] = (p + k) % 26 + 'A';
    }
    printf("Encrypted: %s\n", text);

    for (int i = 0; text[i] != '\0'; i++) {
            int p = text[i] - 'A';
            int k = key[i % keyLen] - 'A';
            text[i] = (p - k + 26) % 26 + 'A';
    }
    printf("Decrypted: %s\n", text);
}
