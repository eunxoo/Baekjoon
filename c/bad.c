#include <stdio.h>
#define STUDENTS 100

int main(void)
{
int i, value, sum=0, a;
int score[STUDENTS];
double average;
int get_sum(int a[]);


for(i=0; i<STUDENTS; i++)
{
printf("[%d]학생의 점수를 입력하세요(-1이 입력되면 종료됩니다) = ", i); 
scanf("%d", &score[i]); 

if(score[i] == -1){
    break;
}
}


value = get_sum(score);
printf("합 = %d\n", value);
printf("평균 = %d\n", (value / i));
return 0;
}

int get_sum(int a[]){
    int i;
    int sum = 0;
    for (i = 0; a[i] >= 0; i++)
        sum += a[i];
        if (a[i] == -1){
            return sum;
        }
}
