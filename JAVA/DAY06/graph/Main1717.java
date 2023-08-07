package DAY06.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1717 {
	static int N, M;
	static int p[];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int [N + 1];
		for(int i = 1; i <= N; ++i)
			p[i] = i;
		
		for(int i = 1; i <= M; ++i) {
			int n, m, l;
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			if(n == 0)
				merge(m, l);
			else if(n == 1) {
				if(find(m) == find(l)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
	static int find(int num) {
		if(p[num] == num) {
			return num;
		}
		p[num] = find(p[num]);
		return p[num];
	}

	static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) {
			p[b] = a;
		} else {
			p[a] = b;
		}

		// p[a] += p[b]; // 대표에 있는 vertex 수
		
	}
}
