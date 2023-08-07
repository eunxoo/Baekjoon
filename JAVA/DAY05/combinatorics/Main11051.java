package DAY05.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11051 {
	static int N;
	static int K;
	static int [][] dp;
	static final int MOD = 10007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][N+1];

		for(int i = 0; i <= N; ++i){
			dp[i][0] = 1;
            dp[i][i] = 1;
			for(int j = 1; j <i;++j){
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
			}
		}
		 
		 System.out.println(dp[N][K] % 10007);
	}

}
