#include <iostream>
using namespace std;

int main() {
    int a, b;
    int sum = 0;
    int max = 0;
    for(int i = 0; i < 10; i++) {
        cin >> a >> b;
        sum = sum - a + b;
        if (sum > max) {
            max = sum;
        }
    }
    cout << max;
}