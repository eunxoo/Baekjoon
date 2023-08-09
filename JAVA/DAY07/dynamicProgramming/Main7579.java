package DAY07.dynamicProgramming;

import java.io.*;
import java.util.*;

public class Main7579 {
	public static int N, M;
	public static int memory[];
	public static int cost[];
	public static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;
		
		memory = new int[N];
		cost = new int[N];
		dp = new int[N][100001]; // 최대 발생할 수 있는 cost의 경우 : N*C
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// DP 수행
		for(int i = 0; i < N; i++) {
			int c = cost[i];
			int m = memory[i];
			for(int j = 0; j <= 10000; j++) {
				if(i == 0) {
					if(j >= c) {
						dp[i][j] = m;
					}
				} else {
					if(j >= c) {
						// dp[i][j] = max(dp[i -1][j - cost] + memory, dp[i - 1][j])
						dp[i][j] = Math.max(dp[i -1][j - c] + m, dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
				if(dp[i][j] >= M) {
					ans = Math.min(ans, j);
				}
			}
		}
		System.out.println(ans);
	}

}
