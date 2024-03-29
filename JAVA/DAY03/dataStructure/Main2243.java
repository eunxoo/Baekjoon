package DAY03.dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2243 {
	static int N, M;
	static int A, B, C;
	static int MAX = 1000000;
	static int S;
	static int[] tree; // all

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = 1;
		while (S < MAX) {
			S *= 2;
		}
		tree = new int[2 * S];
		N = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A= Integer.parseInt(st.nextToken());
			if(A==1) {
				B= Integer.parseInt(st.nextToken());
				//사탕 꺼내기, B번째
				int index= query(1, S, 1, B);
				sb.append(index+"\n");
				update(1, S, 1, index, -1);
			}else {
				B= Integer.parseInt(st.nextToken());
				C= Integer.parseInt(st.nextToken());
				//사탕 넣기 B맛 C개(양수+, 음수-)
				update(1, S, 1, B, C);
			}
		}
		System.out.println(sb.toString());
	}
	
	static int query(int left, int right, int node, int target) {
		if (left == right) {
			return left;
		}else {
			int mid = (left + right) / 2;
			if(tree[node * 2] >= target) {
				return query(left, mid, node * 2, target);
			} else {
				target -= tree[node * 2];
				return query(mid + 1, right, node * 2 + 1, target);
			}
		}
	}
	
	static void update(int left, int right, int node, int target, long diff) {
        if (target < left || right < target) {
            return;
        } else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

}
