package DAY07.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2449 {
	public static int N, K;
	public static int[] bulb;
	public static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bulb = new int[N+1];
		dp = new int[N+1][N+1];
		
		// 같은 색깔의 전구는 하나로 묶어 입력받는다.
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			bulb[i] = Integer.parseInt(st.nextToken());
			if(bulb[i] == bulb[i-1]) {
				N--;
				i--;
			}
		}
		
		// DP 배열 초기화
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
			dp[i][i] = 0;
		}
		
		// 두 개 이상의 전구들 간의 최소값을 계싼한다 > 사이즈를 늘려간다.
		// 중간 지점 K 앞 뒤 전구 색깔이 다를 경우 : dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + 1)
		// 중간 지점 K 앞 뒤 전구 색깔이 같을 경우 : dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j])
		// dp[i][j] = max(dp[i][k]+ dp[k+1][j] + 1)
		for(int size = 2; size <= N; size++) {
			for(int start = 1; start <= N - size + 1; start++) {
				int end = start + size - 1;
				for(int k = start; k < end; k++) {
					int temp = dp[start][k] + dp[k+1][end];
					if(bulb[start] != bulb[k+1]) {
						temp++;
					}
					dp[start][end] = Math.min(dp[start][end], temp);
				}
			}
		}
		
		System.out.println(dp[1][N]);
		
	}

}
