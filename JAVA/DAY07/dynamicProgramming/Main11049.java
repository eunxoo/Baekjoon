package DAY07.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11049 {
	public static int N;
	public static int[][] matrix, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][2];
		dp = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//dp[i][j] : i 부터 j 까지 곱했을 때 최적의 값
		//dp[i][j] = d[i][k] + d[k+1][j], i ~ k 행렬과 k+1 ~ j 행렬 곱 수
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
			dp[i][i] = 0;
		}
		
		// dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1]) (i<=k<j)
		for(int size = 2; size <= N; size++) {
			for(int start = 0; start < N - size + 1; start++) {
				int end = start + size - 1;
				for(int k = start; k < end; k++) {
					dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k+1][end] + matrix[start][0] * matrix[k][1] * matrix[end][1]);
				}
			}
		}
		
		System.out.println(dp[0][N-1]);
		
	}

}
