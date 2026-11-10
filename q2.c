#include <stdio.h> 
int main() 
{ 
    char str[50]; 
    printf("Enter string : "); 
    scanf("%49[^\n]",str);      

    printf("And with 127 : "); 
    for(int i=0;str[i]!=0;i++){ 
        printf("%c",str[i]&127); 
    } 

    printf("\nOr with 127 : "); 
    for(int i=0;str[i]!=0;i++){ 
        printf("%c",str[i]|127); 
    } 

    printf("\nXor with 127 : "); 
    for(int i=0;str[i]!=0;i++){ 
        printf("%c",str[i]^127);
    } 
    return 0; 
} 
