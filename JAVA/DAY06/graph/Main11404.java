package DAY06.graph;

import java.io.*;
import java.util.*;

public class Main11404 {
	public static int N, M;
	public static int[][] dist;
	public static final int INF = 987654321;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N + 1][N + 1];
		
		// dist 배열 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = INF;
				}
			}
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[s][e] = Math.min(dist[s][e], c); // 도시 사이에 간선 여러 개 존재하므로
		}
		
		floydRun();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(dist[i][j] == INF) {
					dist[i][j] = 0;
				}
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void floydRun() {
		for (int k = 1; k <= N; k++) { // 경유지에 따른 사이클
			for (int i = 1; i <= N; i++) { // 출발지에 따른 사이클
				for (int j = 1; j <= N; j++) { //목적지에 따른 사이클
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}

}
