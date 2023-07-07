#include <iostream>
using namespace std;

int main() {
    int num;
    int result[42] ={0,};
    int count = 0;
    for(int i = 0; i < 10; i++) {
        cin >> num;
        result[num % 42]++;
    }
    for(int a : result) {
        if(a > 0) {
            count++;
        }
    }
    cout << count;
}