#include <iostream>
using namespace std;

int main() {
    int T, num = 0;
    cin >> T;
    for(int i = 0; i < T; i++) {
        cin >> num;
        int digit = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                cout << digit << " ";
            }
            num /= 2;
            digit++;
        }
        cout << endl;
    }
}