#include <iostream>
using namespace std;

int main() {
    int total;
    int num = 0;
    int count = 0;

    cin >> total;
    int* arr = new int[total];

    for(int i = 0; i < total; i++) {
        cin >> arr[i];
    }

    cin >> num;

    for (int i = 0; i < total; i++) {
        if (arr[i] == num) {
            count++;
        }
    }

    cout << count;
}