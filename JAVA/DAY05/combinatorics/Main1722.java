package DAY05.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1722 { // 수정해야함
	static int MAX = 22;
	
	static int N, Q;
	static long K, ans;
	static boolean visited[];
	static long facto[];
	public static void main(String[] args) throws Exception {
		visited = new boolean [MAX];
		facto = new long [MAX];
		
		facto[0] = 1;
		facto[1] = 1;
		for(int i = 2; i < MAX; ++i) facto[i] = facto[i - 1] + i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Q = Integer.parseInt(st.nextToken());
		if(Q == 1) {
			boolean flag = false;
			K = Long.parseLong(st.nextToken());
			// 자리 인덱스
			for (int i = 1; i <= N; ++i) {
				if(flag) break;
				// 숫자
				for(int j = 1; j <= N; ++j) { // 남은 개수로 만들 수 있는 가지수
					if(visited[j]) continue;
					
					if(facto[N - i] < K) {
						K -= facto[N - i];
					}
					else if(facto[N - i] > K) {
						System.out.println(j + " ");
						visited[j] = true;
						break;
					}
					else {
						System.out.println(j + " ");
						visited[j] = true;
						flag = true;
						break;
					}
					
				}
				
			}
			
			for (int i = N; i > 0; i--) // 딱 맞은 경우
				if (!visited[i]) System.out.println(i + ' ');
		}
		else {
			for(int i = 1; i <= N; ++i) {
				int a;
				a = Integer.parseInt(st.nextToken());
				visited[a] = true;
				// 앞에 몇 개 숫자나 안 썼나
				long cnt = 0;
				for(int j = i; j < a; ++j)
					if(!visited[j]) cnt++;
				ans += cnt + facto[N - i];
			}
			System.out.println((ans + 1) + '\n');
		}
	}

}
