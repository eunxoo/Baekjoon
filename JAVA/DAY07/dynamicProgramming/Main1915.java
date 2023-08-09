package DAY07.dynamicProgramming;

import java.util.*;
import java.io.*;

public class Main1915 {
	public static int N, M, ans;
	public static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1][M+1];

		ans = 0;
		// dp[i][j] = i, j를 오른쪽 아래 꼭지점으로 하는 정사각형의 길이
		// dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				int temp = Integer.parseInt(input[j-1]);
				if(temp == 1) {
					dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		System.out.println(ans * ans);
	}

}
