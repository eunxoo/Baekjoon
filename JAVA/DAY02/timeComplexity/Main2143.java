package DAY02.timeComplexity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main2143 {
	static long T;
	static int N,M;
	static long[] inputA, inputB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Long.parseLong(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		inputA = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputA[i] = Long.parseLong(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		inputB = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			inputB[i] = Long.parseLong(st.nextToken());
		}
		
		// 1. subA, subB 만들기
		
		List<Long> subA = new ArrayList<>();
		long sum = 0;
		for(int i = 0; i< N; i++) {
			sum = 0;
			for(int j = i; j < N; j++) {
				sum += inputA[j];
				subA.add(sum);
			}
		}
		
		List<Long> subB = new ArrayList<>();
		for(int i = 0; i< M; i++) {
			sum = 0;
			for(int j = i; j < M; j++) {
				sum += inputB[j];
				subB.add(sum);
			}
		}
		
		// 2. sub 정렬
		Collections.sort(subA);
		Collections.sort(subB, Comparator.reverseOrder());
		
		// 3. 2 pointers
		
		long result = 0;
		int ptA = 0;
		int ptB = 0;
		while (true) {
			long currentA = subA.get(ptA);
			long currentB = subB.get(ptB);
			sum = currentA + currentB;
			if(sum == T) {
				long countA = 0;
				while(ptA < subA.size() && currentA == subA.get(ptA)) {
					countA++;
					ptA++;
				}
				long countB = 0;
				while(ptB < subB.size() && currentB == subB.get(ptB)) {
					countB++;
					ptB++;
				}
				result += countA * countB;
			} else if(sum < T) {
				ptA++;
			} else {
				ptB++;
			}
			
			if(ptA == subA.size() || ptB == subB.size()) {
				break;
			}
		}
		System.out.println(result);
				

	}
}
