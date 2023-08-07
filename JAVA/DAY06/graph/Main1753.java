package DAY06.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 구현
// 1. 출발 노드를 설정한다.
// 2. 최단 거리 테이블을 초기화한다.
// 3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
// 4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다. 
public class Main1753 {
	public static int V,E,start;
	public static List<Edge>[] adjList;
	public static int[] dist;
	public static StringTokenizer st;
	public static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[s].add(new Edge(e, c));
		}
		
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Dijkstra();
		
		for (int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static void Dijkstra() {
		pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll(); // 최소 비용을 가진 간선 정보를 꺼냄
			
			if(dist[now.to] < now.cost) { // 거리 갱신이 필요 없으면 무시
				continue;
			}
			
			for(Edge next : adjList[now.to]) {
				if(dist[next.to] > dist[now.to] + next.cost) {
					dist[next.to] = dist[now.to] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
	}

}
