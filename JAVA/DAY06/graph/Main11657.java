package DAY06.graph;

import java.util.*;
import java.io.*;

public class Main11657 {
	public static int N, M;
	public static List<Edge>[] adjList;
	public static long[] dist;
	public static boolean minusCycle = false;
	public static StringTokenizer st;

	
	// 1. 출발 노드를 먼저 설정한다.
	// 2. 최단 거리 테이블을 초기화한다.
	// 3. 모든 간선 M개를 하나씩 전부다 확인을 해서 업데이트한다. > N-1 번 수행
	// 3-2. 만약 음수 간선 존재 유무를 파악하고 싶다. 3번을 한 번 더 수행한다. > dist 업데이트가 되면 음수 사이클이 존재한다. 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[s].add(new Edge(e, c));
		}
		
		bellmanFord(); // 벨만 포드 수행
		
		if(minusCycle) {
			System.out.println("-1");
		} else {
			for (int i = 2; i <= N ; i++) {
				if(dist[i] == Integer.MAX_VALUE) {
					System.out.println("-1");
				} else {
					System.out.println(dist[i]);
				}
			}
		}

	}
	static class Edge{
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		// 모든 간선 다 돌아야하기 때문에 comparable 사용 안 함.
	}
	
	public static void bellmanFord() {
		dist[1] = 0;
		for (int i = 1; i <= N; i++) { // 탐색 사이클 횟수
			for(int j = 1; j <= N; j++) { // 모든 정점에서 갈 수 있는 간선 탐색
				for(Edge next : adjList[j]) {
					if(dist[next.to] > dist[j] + next.cost && dist[j] != Integer.MAX_VALUE) { // 최단 경로 비교
						dist[next.to] = dist[j] + next.cost;
					}
				}
			}
		}
		

		for(int j = 1; j <= N; j++) { // 모든 정점에서 갈 수 있는 간선 탐색
			for(Edge next : adjList[j]) {
				if(dist[next.to] > dist[j] + next.cost && dist[j] != Integer.MAX_VALUE) { // 최단 경로 비교
					minusCycle = true;
					return;
				}
			}
		}
	}
}
