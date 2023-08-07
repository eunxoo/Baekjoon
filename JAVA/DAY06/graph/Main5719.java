package DAY06.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main5719 {
	public static int N, M, S, D;
	public static List<Edge>[] adjList;
	public static List<Integer>[] shortestPath;
	public static boolean [][] exPath;
	public static int[] dist;
	public static StringTokenizer st;
	public static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		while(!(input = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[N];
			shortestPath = new ArrayList[N];
			dist = new int[N];
			exPath = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<>();
				shortestPath[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adjList[s].add(new Edge(e, c));
			}
			
			// 최단 경로 탐색
			Arrays.fill(dist, Integer.MAX_VALUE);
			Dijkstra();
			
			// 최단 경로 제외
			removeShortestPath(S, D);
			
			// 최단 경로 재탐색
			Arrays.fill(dist, Integer.MAX_VALUE);
			Dijkstra();
			
			if(dist[D] == Integer.MAX_VALUE) {
				System.out.println("-1");
			} else {
				System.out.println(dist[D]);
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
		
		public int compareTo(Edge o) { // 비용(거리)이 작은 것이 높은 우선순위를 가지도록 설정
			return this.cost - o.cost;
		}
	}
	
	public static void Dijkstra() {
		pq = new PriorityQueue<>();
		pq.add(new Edge(S,0));
		dist[S] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll(); // 최소 비용을 가진 간선 정보를 꺼냄
			
			if(dist[now.to] < now.cost) { // 거리 갱신이 필요 없으면 무시
				continue;
			}
			
			for(Edge next : adjList[now.to]) { // 현재 노드와 연결된 다른 인접한 노드들을 확인 
				if(exPath[now.to][next.to]) { // 두번째 탐색 때만 활용
					continue;
				}
				if(dist[next.to] > dist[now.to] + next.cost) { // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
					dist[next.to] = dist[now.to] + next.cost;
					shortestPath[next.to] = new ArrayList<>();
					shortestPath[next.to].add(now.to);
					pq.add(new Edge(next.to, dist[next.to]));
				} else if(dist[next.to] == dist[now.to] + next.cost) {
					shortestPath[next.to].add(now.to);
				}
			}
		}
	}


	public static void removeShortestPath(int start, int end) {
		if(start==end) {
			return;
		}
		for(int next: shortestPath[end]) {
			if(!exPath[next][end]) {
				exPath[next][end] = true;
				removeShortestPath(start, next);
			}
		}
	}
	
}
