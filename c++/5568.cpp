#include <iostream>
#include <cstring>
#include <set>
#include <vector>
using namespace std;

const int MAX = 11;

int N, K;

set<int> S;
int cards[MAX];
bool visited[MAX];

void MakeAns(int ret = 0, int cnt = 0){
    if(cnt == K){
        S.insert(ret);
        return;
    }

    for(int i = 0; i < N; ++i){
        if(visited[i]) continue;

        visited[i] = true;
        int temp = cards[i] >= 10 ? 100 : 10;
        MakeAns(ret * temp + cards[i], cnt + 1);
        visited[i] = false;
    }
}

int main() {
    cin >> N >> K;
    for (int i = 0; i < N; ++i) cin >> cards[i];

    MakeAns();
    cout << S.size() << '\n';

    return 0;
}