package DAY07.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11062 {
	public static int N, T;
	public static int[] card;
	public static int [][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tCase = 0; tCase < T; tCase++) {
			N = Integer.parseInt(br.readLine());
			card = new int[N+1];
			dp = new int[N+2][N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean gwTurn = true;
			if(N%2 == 0) {
				gwTurn = false;
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N-i+1; j++) {
					int row = j;
					int col = i + j - 1;
					
					if(gwTurn) { // 최대한 크게 DP를 업데이트
						dp[row][col] = Math.max(dp[row+1][col] + card[row], dp[row][col-1] + card[col]);
					} else { // 명우 차례에는 최대한 작게
						dp[row][col] = Math.min(dp[row+1][col], dp[row][col-1]);
					}
				}
				gwTurn = !gwTurn;
			}
			System.out.println(dp[1][N]);
		}
		
				

	}

}
