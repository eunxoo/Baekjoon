#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

const int MAX = 555;

int N, M, ans;
bool visited[MAX];
vector<int> inAdj[MAX];
vector<int> outAdj[MAX];

int outPath(int x){
    visited[x] = true;
    int ret = 1;

    for (auto next : outAdj[x]){
        if(visited[next]) continue;
        ret += outPath(next);
    }
    return ret;
}

int inPath(int x){
    visited[x] = true;
    int ret = 1;

    for (auto next : inAdj[x]){
        if(visited[next]) continue;
        ret += inPath(next);
    }
    return ret;
}

int main(){
    cin >> N >> M;
    for(int i = 0; i < M; ++i){
        int a, b;
        cin >> a >> b;
        outAdj[a].push_back(b);
        inAdj[b].push_back(a);
        // cout << outAdj;
    }

    for(int i = 1; i <= N; ++i){
        memset(visited, 0, sizeof(visited));
        int outPathCnt = outPath(i) - 1;
        memset(visited, 0, sizeof(visited));
        int inPathCnt = inPath(i) - 1;
        if(outPathCnt + inPathCnt == N - 1) ans++;
    }

    cout << ans << '\n';
    return 0;
}