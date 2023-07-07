#include <iostream>
using namespace std;

int main() {
    int T;
    cin >> T;
    for(int i = 0; i < T; i++){
        int N;
        cin >> N;
        int arr[N];
        int min = 99;
        int max = 0;
    
        for(int i = 0; i < N; i++){
            cin >> arr[i];
            if (max < arr[i]) {max = arr[i];}
            if (min > arr[i]) {min = arr[i];}
        }
    
        cout << 2 * (max - min) << endl;

    }
}