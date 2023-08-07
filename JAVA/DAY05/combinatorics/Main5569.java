package DAY05.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5569 {
static int MOD = 100000;
static int W, H;
static long dp[][][];
	public static void main(String[] args) throws Exception {
		dp = new long[111][111][4];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());	
		
		for(int i = 2; i <= W; ++i) dp[i][1][0] = 1;
		for(int j = 2; j <= H; ++j) dp[1][j][1] = 1;
		dp[2][2][2] = 1;
		dp[2][2][3] = 1;
		
		for(int i = 2; i <= W; ++i) {
			for(int j = 2; j <= H; ++j) {
				if(i == 2 && j == 2) continue;
				// 오른쪽 직진
				if(i > 2) dp[i][j][0] = (dp[i-2][j][0] + dp[i-2][j][1] + dp[i-2][j][2]) % MOD;
				// 위쪽 직진
				if(j > 2) dp[i][j][1] = (dp[i][j-2][0] + dp[i][j-2][1] + dp[i][j-2][3]) % MOD;
				// 위로 가다 오른쪽 턴
				dp[i][j][2] = (dp[i-1][j-1][1] + dp[i-1][j-1][3]) % MOD;
				// 오른쪽 가다 위로 턴
				dp[i][j][3] = (dp[i-1][j-1][0] + dp[i-1][j-1][2]) % MOD;
			}
		}
		
		System.out.println((dp[W][H][0] + dp[W][H][1] + dp[W][H][2] + dp[W][H][3]) % MOD);
	}

}
