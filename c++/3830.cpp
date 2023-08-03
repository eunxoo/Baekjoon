#include <iostream>
using namespace std;
const int MAX = 100001;
typedef long long ll;

int N, M, p[MAX]; // P[x] : x의 대표
ll dist[MAX]; // dist[x] : x의 대표 ~ x 사이 거리

//find
int find(int x){
    if(p[x] < 0) return x;
    int R = find(p[x]);
    // root까지 비용 업데이트
    dist[x] += dist[p[x]];
    return p[x] = R;
}

//union
void merge(int a, int b, int diff){
    int aRoot = find(a);
    int bRoot = find(b);
    if(aRoot == bRoot) return;

    int NewD = dist[a] + diff; // aRoot 기준 b의 위치
    int OriginD = dist[b]; // bRoot 기준 b의 위치

    p[bRoot] = aRoot; // bRoot를 aRoot로 재조정
    dist[bRoot] = NewD - OriginD; // 기존 bRoot 에서 aRoot의 거리
}

int main(){ 
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    while(1){
        cin >> N >> M;
        if(N == 0 && M == 0) break;
        for(int i = 1; i <= N; i++){ // 초기화 
            p[i] = -1;
            dist[i] = 0;
        }
        for(int i = 0; i < M; ++i){
            char ch;
            int a, b, w;
            cin >> ch >> a >> b;

            if(ch == '!'){
                cin >> w;
                merge(a, b, w);
            }
            else{
                if(find(a) == find(b)) cout << dist[b] - dist[a] << '\n';
                else cout << "UNKNOWN" << '\n';
            }
        }
    }
    return 0;
}