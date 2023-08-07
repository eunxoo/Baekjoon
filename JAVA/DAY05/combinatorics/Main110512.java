package DAY05.combinatorics;

import java.io.*;
import java.util.*;

class Main110512 {
	
	static long[][] dp; // NCK
	static final int mod = 10007;
	static final int MAX = 1000;
	static int N, K;
	static long a, b;
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		a = inversion();
		b = combi();
		
		System.out.println((a * b) % mod);
		
	}
	
	// MOD가 소수이므로 , (K!)^MOD- 1 = 1 1(mod MOD), (K!)^(MOD-2) 은 k!의 역원
	// (k!) ^ (MOD - 2) 구하기
	static long inversion()
	{
		long ret = 1l;
		long temp = 1l;
		long Want = mod - 2;
		
		for(int i = 2; i <= K; ++i)
		{
			temp *= i;
			temp %= mod;
		}
		// MOD - 2 를 이진법으로 계산해서 (K!) ^ (MOD - 2) 계산
		while(Want > 0)
		{
			if(Want % 2 == 1)
			{
				ret *= temp;
				ret %= mod;
			}
			// (k!) ^ (2^i) -> (k!)^(2^(i+1))
			temp *= temp;
			temp %= mod;
			Want /= 2;
		}
		
		return ret % mod;
	}
	
	// N! / (N-K)!
	static long combi()
	{
		long ret = 1l;
		
		for(int i = N; i > N - K; i--)
		{
			ret *= i;
			ret %= mod;
		}
		
		return ret % mod;
	}
}