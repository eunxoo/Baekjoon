package DAY02.sort;

import java.util.Arrays;
import java.util.*;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Integer[] nums = {4, 3, 2, 1, 5};
//		System.out.println(Arrays.toString(nums));
//		
////		Arrays.sort(nums);
//		
////		System.out.println(Arrays.toString(nums));
//		
//		Arrays.sort(nums, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2-o1;
//			}
//			
//		});
//		
//		Arrays.sort(nums, (o1, o2)-> o2-o1);
//		
//		Arrays.sort(nums, Comparator.naturalOrder()); //reverseOrder()
//		
//		System.out.println(Arrays.toString(nums));
		
		Item[] items = new Item[5];
		items[0] = new Item(1,5);
		items[1] = new Item(2,2);
		items[2] = new Item(3,2);
		items[3] = new Item(4,2);
		items[4] = new Item(5,4);
		
		System.out.println(Arrays.toString(items));
		
		Arrays.sort(items, (o1,o2)->{ 
			int resultOfB = o1.b-o2.b;
			if(resultOfB ==0) {
				return o1.a-o2.a;
			} else {
				return resultOfB;
			}
			});
		System.out.println(Arrays.toString(items));
		
		Arrays.sort(items);
		System.out.println(Arrays.toString(items));
	}

}

class Item implements Comparable<Item>{
	int a;
	int b;
	
	public Item(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "Item [a=" + a + ", b=" + b + "]";
	}

	@Override
	public int compareTo(Item o2) {
		return b-o2.b;
	}
	
}
