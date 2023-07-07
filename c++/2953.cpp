#include <iostream>
using namespace std;

int main() {
    int score = 0;    
    int max = 0;
    int num = 0;
    for(int i = 0; i < 5; i++) {
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            cin >> score;
            sum += score;
        }
        if (max < sum) {
            num = i;
            max = sum;
        }
    }
    cout << num + 1 << " " << max;
}