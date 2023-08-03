#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

typedef long long ll;
const int MAX = 555;

int N, M;

ll cost[MAX];
vector<int> arr[MAX];
int indegree[MAX];
queue<int> myQueue;

ll ans[MAX];

int main(){
    cin >> N;
    for(int i = 1; i <= N; ++i){
        int w;
        cin >> w;
        cost[i] = w;
        while(1){
            int pre;
            cin >> pre;
            if(pre == -1) break;
            arr[pre].push_back(i);
            indegree[i]++;
        }
    }
    for(int i = 1; i <= N; ++i){
        if(indegree[i] == 0){
            ans[i] = cost[i];
            myQueue.push(i);
        }
    }
    while (!myQueue.empty()){
        int curr = myQueue.front();
        int preW = ans[curr];
        myQueue.pop();
        for(auto next : arr[curr]){
            indegree[next]--;
            ans[next] = max(ans[next], preW + cost[next]);
            if(indegree[next] == 0)
                myQueue.push(next);
        }
    }
    for(int i = 1; i <= N; ++i){
        cout << ans[i] << '\n';
    }

    return 0;
    
}