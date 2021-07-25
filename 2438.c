#include <stdio.h>

int main(){
    int a;
    int n,m;
    scanf("%d", &a);
    for(n=1 ; n <= a; n++){
        for(m=1; m <= n; m++){
            printf("*");}
        printf("\n");}
    return 0;
}