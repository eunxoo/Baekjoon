package DAY05.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main110502 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
		
		
	}
	static int factorial(int N) {
		if(N == 0) {
			return 1;
		}
		return N * factorial(N - 1);
	}

}
