package DAY03.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1202 {

	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Jewelry[] jewelries = new Jewelry[N];
		int[] bags = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());;
			int v = Integer.parseInt(st.nextToken());
			
			jewelries[i] = new Jewelry(m,v);
		}
		
		
		
		 for (int i = 0; i < K; i++) {
	            bags[i] = Integer.parseInt(br.readLine());
	        }
	        
	     // 가방 오름차순 정렬
		 Arrays.sort(bags);
		 
	     // 보석 무게순 정렬
		 Arrays.sort(jewelries, Comparator.comparingInt(Jewelry :: getMass));

		 // 보석 높은값 기준 힙
		 PriorityQueue<Jewelry> pq = new PriorityQueue<>(Comparator.comparingInt(Jewelry::getValue).reversed());
		 
		 long result = 0;
		 int jIndex = 0;
	     // 1. 남은 가방 중 제일 작은 가방을 선택. <- 정렬
		 for (int i = 0; i < bags.length; i++) {
			 // 2. 선택된 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택. <- 힙을 사용.
			 while(jIndex < N && jewelries[jIndex].mass <= bags[i]) {
				 pq.add(jewelries[jIndex++]);
			 }
			 if(!pq.isEmpty()) { //가능한 보석이 없음
				 result += pq.poll().value;
			 }
		}
		 System.out.println(result);

	}

}

class Jewelry {
	int mass;
	int value;
	
	public Jewelry(int mass, int value) {
		super();
		this.mass = mass;
		this.value = value;
	}

	public int getMass() {
		return mass;
	}

	public int getValue() {
		return value;
	}
	
	
}

/*
1. 가방 오름차순 정렬 O(NlogN)
2. 보석 무게 오름차순 정렬 O(NlogN)

--반복--
3. 가방을 선택 (총몇개선택? O(N)) -> 초기값 없는 for문은 더하기
4. 넣을 수 있는 보석을 힙에 넣음 (하나 넣을 때 logN * (보석개수) N)
5. 힙에서 Top을 가져옴 (뺄 때 logN * (보석개수)N)
-> 4NlogN + N => O(NlogN)

*/