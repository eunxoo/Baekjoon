#include <iostream>
using namespace std;

int main() {
    int array[10] = {0,};
    int x, y, z;
    cin >> x >> y >> z;

    int cal = x * y * z;

    string scal = to_string(cal);

    for (char c : scal) {
        array[c - '0']++;
    }

    for(int out : array) {
        cout << out << '\n';
    }

    return 0;
}