#include <stdio.h>

int main(){
    int a;
    int n,m;
    scanf("%d", &a);
    for(n=1 ; n <= a; n++){
        for(m=1; m <= a-n+1; m++){
            printf("*");}
        printf("\n");}
    return 0;
}