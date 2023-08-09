package DAY07.dynamicProgramming;

import java.io.*;
import java.util.*;

public class Main2579 {
	public static int N;
	public static int[] step, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		step = new int[N+1];
		dp = new int[N+1];
		for(int i = 1; i <= N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		// 1. 마지막 계단 직전(N-1)의 계단을 밟고 마지막 계단을 밟는 것 -> N-3 번째 계단을 무조건 밟고 가야함.
		// 2. 마지막 계단보다 두 칸 낮은 계단(N-2)을 밟고 마지막 계단을 밟는 것
		// dp[n] = max(dp[n-2], dp[n-3]+step[n-1]) + step[n];
		
        if (N >= 1) {
            dp[1] = step[1];
        }
        if (N >= 2) {
            dp[2] = step[1] + step[2];
        }
		
		for(int i = 3; i <= N; i++){
			dp[i] = Math.max(dp[i-2], dp[i-3]+step[i-1]) + step[i];
		}
		
		System.out.println(dp[N]);
	}

}
