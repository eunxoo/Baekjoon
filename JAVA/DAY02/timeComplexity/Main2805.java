package DAY02.timeComplexity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2805 {
	static int N, M;
	static int[] trees;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(trees[i], max);
		}
		
		int s = 0, e = max, mid = 0;
		int result = 0;
		while(true) {
			mid = (s + e) / 2;
			long sum = calc(mid);
			if(sum == M) {
				result = mid;
				break;
			} else if(sum < M) {
				e = mid - 1;
			} else { // sum > M
				result = mid;
				s = mid + 1;
				
				// result = mid; 저장 안해두면, s = mid; -> 그럼 종료 조건이 s == e 일 때인데 mid 다시 확인해야함..
			}
			if(s > e) {
				break;
			}
		}
		System.out.println(result);

	}
	
	static long calc(int value) {
		long result = 0;
		for (int t : trees) {
			if (t > value) {
				result += t - value;
			}
		}
		return result;
	}

}
