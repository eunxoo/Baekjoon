#include <iostream>
using namespace std;

int main() {
    int arr[1000];
    int idx = 0;
    for(int i = 1; idx < 1000; i++){
        for(int j = 0; j < i; j++){
            arr[idx++] = i;
            if (idx == 1000){
                break;
            }
        }
    }
    int begin, end;
    int sum = 0;
    cin >> begin >> end;
    for(int i = begin-1; i <= end-1; i++){
        sum += arr[i];
    }
    cout << sum;
}