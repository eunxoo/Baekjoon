#include <iostream>
using namespace std;

int main() {
    int arr[10];
    int arr2[1000] = {0,};
    int sum = 0;
    for (int i = 0; i < 10; i++) {
        cin >> arr[i];
        sum += arr[i];
        arr2[arr[i]]++;
    }
    
    int max = 0;
    int num;
    for(int i = 10; i < 1000; i+=10) {
        if (arr2[i] > max) {
            max = arr2[i];
            num = i;
        }
    }
    cout << sum / 10 << '\n';
    cout << num;
}