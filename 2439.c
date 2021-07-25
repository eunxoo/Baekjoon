#include <stdio.h>

int main(){
    int a;
    int n,m;
    int i;
    scanf("%d", &a);
    for(n=1 ; n <= a; n++){
        for(m=1; m <= a-n; m++){
            printf(" ");}
        for(i=1; i<=n;i++){
            printf("*");}
        printf("\n");}
    return 0;
}