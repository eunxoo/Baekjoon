package DAY05.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15664 {
	static int N, M;
	static int arr[], ans[];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		ans = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		MakeAns(0, -1);

	}
	
	static void MakeAns(int idx, int pre_idx) {
		if(idx == M) {
			for(int i = 0; i < M; ++i) {
				System.out.print(ans[i]+ " ");
			}
			System.out.println();
//			return;
		}
		int prevNumber = 0;
		for(int i = pre_idx + 1; i < N; ++i) {
			if(visited[i] || arr[i] == prevNumber) continue;
			
			ans[idx] = arr[i];
			prevNumber = arr[i];
			visited[i] = true;
			MakeAns(idx + 1, i);
			visited[i] = false;
		}
	}

}
