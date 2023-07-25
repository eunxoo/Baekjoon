package DAY02.timeComplexity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2003 {
	static int N, M;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N + 1]; // out of index 피하기 위해(++e)
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0, e = 0, sum = 0, count = 0;
		sum = nums[0];
		while(true) {
			if (sum == M) {
				count++;
				sum += nums[++e];
			} else if (sum > M) {
				sum -= nums[s++];
			} else {
				sum += nums[++e];
			}
			if(e == N) {
				break;
			}
		}
		
		System.out.println(count);

	}

}
