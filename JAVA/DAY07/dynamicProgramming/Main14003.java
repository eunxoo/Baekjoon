package DAY07.dynamicProgramming;

import java.io.*;
import java.util.*;

public class Main14003 {
	public static int N;
	public static int[] arr;
	public static int[] index;
	public static ArrayList<Integer> lis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		index = new int[N];
		lis =  new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1. LIS의 마지막 숫자보다 크면 새로 추가
		// 2. LIS의 마지막 숫자보다 작으면 적절한 위치에 삽입 > 이분탐색
		// 3. 위 과정을 진행하면서 인덱스 정보도 기록한다.
		for (int i = 0; i < N; i++) {
			if(lis.isEmpty() || arr[i] > lis.get(lis.size() - 1)) {
				lis.add(arr[i]);
				index[i] = lis.size() - 1 ;
			} else {
				binarySearch(0, lis.size() - 1, arr[i], i);
			}
		}
		System.out.println(lis.size());
		
		int temp = lis.size() - 1;
		Stack<Integer> stack = new Stack<>();
		for(int i = N - 1; i >= 0; i--) {
			if(index[i] == temp) {
				temp--;
				stack.push(arr[i]);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}
	
	// LIS 업데이트할 적절한 위치를 찾기 위한 이분 탐색
	// LIS 값을 업데이트하면서 index 정보도 추가
	public static void binarySearch(int left, int right, int num, int now) {
		int mid = 0;
		while(left < right) {
			mid = (left + right) / 2;
			if(num > lis.get(mid)) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		lis.set(right, num);
		index[now] = right;
	}
}
