#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;
    int idx = 1;
    string str;
    for (int i = 0; i < num; i++) {
        cin >> idx >> str;
        for (int i = 0; i < str.size(); i++) {
            if (i != idx-1) {
                cout << str[i];
            }
        }
        cout << '\n';
    }
}