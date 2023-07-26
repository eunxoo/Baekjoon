package DAY03.dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1927 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		MinHeap mh = new MinHeap();
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				System.out.println(mh.delete());
			} else {
				mh.insert(input);
			}
		}
		
	}

}

class MinHeap{
	List<Integer> list;
	
	public MinHeap() {
		list = new ArrayList<>();
		list.add(0);
	}
	
	public void insert(int val) {
		// 1. 트리의 마지막에 값을 삽입
		list.add(val);
		int current = list.size() - 1;
		int parent = current / 2;
		while(true) {
			// 2. 부모와 현재 노드의 조건이 만족하는지 확인
			// 3-1. root에 도달했거나, 만족하면 stop
			if(parent == 0 || list.get(parent) <= list.get(current)) {
				break;
			}
			// 3-2. 만족하지 않으면 부모-자식 교체 후 2번부터 다시 진행	
			int temp = list.get(parent);
			list.set(parent, list.get(current));
			list.set(current, temp);
			
			current = parent;
			parent = current / 2;
		}
	}
	
	public int delete() {
	    if (list.size() <= 1) {
	        return 0;
	    }
		int top = list.get(1);
		list.set(1, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentPos = 1;
		while(true) {
			int leftPos = currentPos * 2;
			int rightPos = currentPos * 2 + 1;
			// 1. Leaf에 도달했거나
			if(leftPos >= list.size()) {
				break;
			}
			
			// 2. 조건을 만족시키기 위한 자식을 선택
			int minValue = list.get(leftPos);
			int minPos = leftPos;
			
			if(rightPos < list.size() && minValue > list.get(rightPos)) {
				minValue = list.get(rightPos);
				minPos = rightPos;
			}
			
			// 이미 힙 조건을 만족하면 stop
			// 3. 스왑
			if(list.get(currentPos) > minValue) {
				int temp = list.get(currentPos);
				list.set(currentPos, list.get(minPos));
				list.set(minPos, temp);
				currentPos = minPos;
			}else {
				break;
			}
		}
		return top;
	}
}
