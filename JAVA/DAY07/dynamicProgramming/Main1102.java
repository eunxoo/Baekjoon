package DAY07.dynamicProgramming;

import java.io.*;
import java.util.*;

public class Main1102 {
	public static int N, P;
	public static int cost[][];
	public static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		dp = new int[N][1<<N]; // 현재 N개의 발전소가 켜져 있고 N개 중에 on/off된 발전소의 상태가 되기 위한 최소비용

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 1<<N; j++) {
				dp[i][j] = Integer.MAX_VALUE; // 최소 비용 비교를 위한 DP배열 초기화
			}
		}
		
		String state = br.readLine();
		P = Integer.parseInt(br.readLine());
		
		// 발전기의 상태를 비트마스크 형태로 저장
		// OR 연산을 통해 i 번째 해당하는 발전소를 On
		int cnt = 0;
		int bit = 0;
		for (int i = 0; i < N; i++) {
			if(state.charAt(i) == 'Y') {
				bit = bit | (1 << i);
				cnt++;
			}
		}
		
		int answer = dfs(cnt, bit);
		if(answer == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(answer);
		}
	}
	
	// DFS 수행
	public static int dfs(int cnt, int bit) {
		// 발전소 수리가 더 이상 필요가 없음
		if(cnt >= P) {
			return 0;
		} 
		// 최소 비용이 업데이트 된 경우 리턴
		if(dp[cnt][bit] != Integer.MAX_VALUE) {
			return dp[cnt][bit];
		}
		// 반복문을 돌면서 재귀 호출 탐색
		for (int i = 0; i < N; i++) {
			// 켜져 있는 발전소 탐색
			if((bit & (1 << i)) != 0) {
				for (int j = 0; j < N; j++) {
					// 같은 번호의 발전소이거나 j도 켜져 있는 발전소일 경우 스킵
					if( i == j || ((bit & (1 << j)) != 0)) {
						continue;
					}
					// 최소값 구하기
					dp[cnt][bit] = Math.min(dp[cnt][bit], dfs(cnt+1, bit | (1 << j)) + cost[i][j]);
				}
			}
		}
		return dp[cnt][bit];
	}

}
