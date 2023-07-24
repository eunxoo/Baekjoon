package DAY01.DFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1759 {
	static int L, C;
	static char[] data;
	static List<String> result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws FileNotFoundException {
		 System.setIn(new FileInputStream("src//DAY01//DFS//input.txt"));

		 Scanner sc = new Scanner(System.in);
			L = Integer.parseInt(sc.next());
			C = Integer.parseInt(sc.next());
			
			data = new char[C];
			sb = new StringBuilder();
			result = new LinkedList<>();
			
			for(int i = 0; i < C; i++) {
				data[i] = sc.next().charAt(0);
			}
			
			Arrays.sort(data);
			
			dfs(-1, 0, 0);
			
			for(String r : result) {
				System.out.println(r);
			}
			
	}
	
	static void dfs(int current, int con, int vow) {
		// 1. 체크인 : 현재까지 만들어진 암호
		if(current >= 0) {
			sb.append(data[current]);
		}
		// 2. 목적지인가 : length == L 
		if(sb.length() == L) {
			// 자음,모음 조건 -> 암호 출력
			if(con >= 2 && vow >=1) {
				result.add(sb.toString());
			}
		} else { // 만약 목적지에 도달해도 더 돌아야한다면 else 붙이지 말고 밑에 코드 이어나가기
			// 3. 연결된 곳 순회 : current + 1 ~ C
			for(int i = current + 1; i < C; i++) {
				// 4. 갈 수 있는가 : 선택한 적이 없는 알파벳
				if(data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
					// 5. 간다 : 모음
					dfs(i, con, vow+1);
				} else {
					// 5. 간다 : 자음
					dfs(i, con+1, vow);
				}
			}
		}
		// 6. 체크아웃 : 현재까지 만들어진 암호
		if(current >= 0) {
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
