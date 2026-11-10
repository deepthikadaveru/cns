#include <stdio.h>
int main() {
    char str[50];
    int k;
    printf("Enter string : ");
    scanf("%49[^\n]", str);
    printf("Enter key : ");
    scanf("%d", &k);
    k = k % 26;
    char enc[50] , dec[50] ;
    for(int i = 0; str[i] != '\0'; i++){
        if(str[i] >= 'a' && str[i] <= 'z'){
            enc[i] = ((str[i] - 'a' + k) % 26) + 'a';
        } else if(str[i] >= 'A' && str[i] <= 'Z'){
            enc[i] = ((str[i] - 'A' + k) % 26) + 'A';
        } else {
            enc[i] = str[i];
        }
    }
    for(int i = 0; str[i] != '\0'; i++){
        if(enc[i] >= 'a' && enc[i] <= 'z'){
            dec[i] = ((enc[i] - 'a' - k + 26) % 26) + 'a';
        } else if(enc[i] >= 'A' && enc[i] <= 'Z'){
            dec[i] = ((enc[i] - 'A' - k + 26) % 26) + 'A';
        } else {
            dec[i] = enc[i];
        }
    }
    printf("Encrypted : %s\n", enc);
    printf("Decrypted : %s\n", dec);
    return 0;
}
