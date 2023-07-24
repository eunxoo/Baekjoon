package DAY01.DFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1062 {
	static int N, K;
	static String[] words;
	static boolean[] visited;
	static int selectedCount = 0;
	static int max = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("src//DAY01//DFS//input.txt"));

		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.next());
		K = Integer.parseInt(sc.next());
		
		words = new String[N];
        visited = new boolean[26]; 
        
		for(int i = 0; i < N; i++) {
			words[i] = sc.next().replaceAll("[antic]", "");

		}
		
        if(K < 5) { 
            System.out.println("0");
            return;
        } else if(K == 26) { 
            System.out.println(N);
            return;
        }
        
//		System.out.println(Arrays.toString(words)); 
		
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        selectedCount = 5;
        
        for(int i = 0; i < 26; i++) {
        	if(visited[i] == false) {
        		dfs(i);
        	}
        }
        
        System.out.println(max);
        
        sc.close();
        
	}
	
	static void dfs(int index) {
//		1. 체크인 : 글자 사용, 배운 글자 수
		visited[index] = true;
		selectedCount++;
		
//		2. 목적지인가 : 배운 글자 수 == K
		if(selectedCount == K) {
			// 답 확인
			max = Math.max(countWords(), max);
		} else {
//			3. 연결된 곳을 순회 : index (나 자신) + 1 ~ z
			for(int i = index + 1; i < 26; i++) {
//				4. 갈 수 있는가 : 선택되지 않은 글자 (방문체크하지 않은 곳)
				if(visited[i] == false) {
//				5. 간다
					dfs(i);
				}
			}
		}

//			6. 체크아웃 : 글자 사용, 배운 글자 수 
		visited[index] = false;
		selectedCount--;
	}
	
	static int countWords() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			boolean isReadable = true;
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				if(visited[word.charAt(j) - 'a'] == false) {
					isReadable = false;
					break;
				};
			}
			if(isReadable == true) {
				count++;
			}
		}
		
		return count;
	}

}
