package DAY01.DFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3055 {
	static final int[] mx = {-1, 1, 0, 0};
	static final int[] my = {0, 0, -1, 1};
	
	static int R,C;
	static char[][] map;
	static int[][] dp;
	static Queue<Point> queue;
	static boolean foundAnswer;
	

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src//DAY01//DFS//input.txt"));
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		dp = new int[R][C];
		queue = new LinkedList<>();
		
		Point st = null;
		
		for(int r = 0; r < R; r++) {
			String line = sc.next();
			for(int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == '*') {
					queue.add(new Point(r, c, '*'));
				} else if(map[r][c] == 'S') {
					st = new Point(r, c, 'S');
				}
			}
		}
		
		queue.add(st);
		
		while (!queue.isEmpty()) {
			// 1. 큐에서 꺼내옴-> S, ., D, *
			Point p = queue.poll();
			
			// 2. 목적지인가? -> D
			if(p.type == 'D') {
				foundAnswer = true;
				System.out.println(dp[p.y][p.x]);
				break;
			}
			// 3. 연결된 곳을 순회 -> 좌, 우. 위, 아래
			for (int i = 0; i < 4; i++) {
				int ty = p.y + my[i];
				int tx = p.x + mx[i];
				
				// 4. 갈수있는가? ( 공통)-> 맵을 벗어나지 않고  0 <= ty < R, 0 <= tx < C
				if(0 <= ty && ty < R && 0 <= tx && tx < C) {
//					if (map[ty][tx] == 'X') {
//			            continue; // 돌인 경우 스킵
//			        }
					if(p.type == '.' || p.type == 'S') { // 고슴도치인가?
						// 4. 갈수있는가? ( 고슴도치 ) -> . or D, 방문하지 않은 곳 
						if((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
							// 5. 체크인 -> dp에 현재 + 1 을 기록 
							dp[ty][tx] = dp[p.y][p.x] + 1; 
							// 6. 큐에 넣음
							queue.add(new Point(ty, tx, map[ty][tx]));
						}
						
					} else if(p.type == '*') { // 물인가?
						// 4. 갈 수 있는가? ( 물 ) ., S
						if(map[ty][tx] == '.' || map[ty][tx] == 'S') {
							// 5. 체크인 -> 지도에 * 표기
							map[ty][tx] = '*';
							// 6. 큐에 넣음
							queue.add(new Point(ty, tx, '*'));		
							
						}
					}
				}				
			}
		}
		if (!foundAnswer) {
			System.out.println("KAKTUS");
		}
	}
}


class Point{
	int y;
	int x;
	char type; // 고슴도치냐 물이냐..
	
	public Point(int y, int x, char type) {
		super();
		this.y = y;
		this.x = x;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Point [y=" + y + ", x=" + x + ", type=" + type + "]";
	}
	
	
}