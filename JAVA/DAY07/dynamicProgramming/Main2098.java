package DAY07.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2098 {
public static int N;
public static int[][] map;
public static int[][] dp;
public static int INF = 2000000;

	// 1. dp 배열 정의 : 현재 i의 도시에 있고 j 비트에 포함된 도시를 방문했을 때 남은 도시 방문의 최소 비용
	// 2. 배열 초기화
	// 3. 모든 도시 탐색 : DFS로 재귀 호출
	// 3-1. 모든 도시 방문했을 경우, 방문을 한 도시인 경우 조건 추가
	// 3-2. 현재 도시에서 남은 도시 방문하는 비용 vs 다음 도시로 간 후 다음 도시에서 남은 도시로 가는 비용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][(1<<N) - 1]; // 현재 i의 도시에 있고 j 비트에 포함된 도시를 방문했을 때 남은 도시 방문의 최소 비용
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < (1<<N) - 1; j++) {
				dp[i][j] = -1; // 방문 안했으니 초기화
			}
		}
		System.out.println(dfs(0, 1));
	}
	
	public static int dfs(int now, int visit) {
		// 모든 도시를 다 방문했을 경우
		if(visit == (1<<N)-1) {
			if(map[now][0] == 0) {
				return INF;
			}
			return map[now][0];
		}
		// 방문을 한 도시인 경우 (dp 업데이트가 된 경우)
		if(dp[now][visit] != -1) {
			return dp[now][visit];
		}
		
		dp[now][visit]= INF;
		for (int i = 0; i < N; i++) {
			// 현재 도시에서 다음 도시로 가는 길이 없거나 아나면 방문한 도시일 경우
			if(map[now][i] == 0 || (visit & (1 << i)) != 0) {
				continue;
			}
			// 현재 도시에서 남은 도시들을 방문하는 비용 vs 다음 도시로 간 후 다음 도시에서 남은 도시로 가는 비용
			dp[now][visit] = Math.min(dp[now][visit],  dfs(i, visit | (1 << i)) + map[now][i]);
		}
		return dp[now][visit];
	}

}
