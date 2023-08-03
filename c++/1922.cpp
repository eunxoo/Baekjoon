#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef pair<int, int> pii;
const int MAX = 1111;

int N, M;
vector <pair<int, int>> arr[MAX];
bool visited[MAX];
int cnt, ans;

struct cmp {
    bool operator()(pii a, pii b){
        return a.second > b.second;
    }
};
priority_queue<pii, vector<pii>, cmp> pq;

int main(){
    cin >> N >> M;

    for(int i = 0; i < M; ++i){
        int a, b, c;
        cin >> a >> b >> c;
        arr[b].push_back(make_pair(a,c));
        arr[a].push_back(make_pair(b,c));
    }

    pq.push(pii(1, 0));

    while(cnt < N){
        int u = pq.top().first;
        int cost = pq.top().second;
        pq.pop();

        if(visited[u]) continue;

        cnt++;
        ans += cost;
        visited[u] = true;

        for(int i = 0; i < arr[u].size(); ++i){
            if(visited[arr[u][i].first]) continue;
            pq.push(arr[u][i]);
        }
    }

    cout << ans << endl;

    return 0;
}
