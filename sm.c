#include <stdio.h>

#define MAX_TERMS 1001
struct term {
    int row;
    int col;
    int value;
}; 

int main() {
    int x[10][10] = {0, };
    struct term a[MAX_TERMS];
    int ro,co;
    printf("0이 아닌 데이터의 개수를 입력하세요.\n");
    scanf("%d",&a[0].value);
    a[0].row = 10;
    a[0].col = 10;
    for (int n=1 ; n<= a[0].value; n++) {
        printf("'행 열 값'을 순으로 입력하세요.\n");
        scanf("%d %d", &ro, &co);
        scanf("%d",&x[ro][co]);
        a[n].row = ro;
        a[n].col = co;
        a[n].value = x[ro][co];
    }
    printf("ROW   COL   VALUE\n");
    for (int i=0; i<=a[0].value; i++)
        printf("%3d %5d %5d\n", a[i].row, a[i].col, a[i].value);
} 
 