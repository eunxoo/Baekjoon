package DAY02.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main1713 {
	static int N, K;
	static Person[] people;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();

		people = new Person[101];
		
		List<Person> list = new ArrayList<>();
		
		for(int i = 0; i < K; i++) {
			int num = sc.nextInt();
			
			if(people[num] == null) {
				people[num] = new Person(num, 0, 0);
			}
			
			if(people[num].count != 0) {
				people[num].count++;
			} else {
				if(list.size() == N) {
					Collections.sort(list);
					Person removedPerson = list.remove(N - 1);
					removedPerson.count = 0;
					removedPerson.timeStamp = 0;
				}
				people[num].count = 1;
				people[num].timeStamp = i;
				list.add(people[num]);
			}
			
		}
		
		Collections.sort(list,(o1, o2)-> o1.num - o2.num);
		
		for (Person person : list) {
	        System.out.print(person.num + " ");
	    }
	}
}

class Person implements Comparable<Person> {
	int num;
	int count;
	int timeStamp;
	
	public Person(int num, int count, int timeStamp) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
	}

	@Override
	public int compareTo(Person o2) {
		int result = o2.count - count;
		if(result == 0) {
			return o2.timeStamp - timeStamp;
		}
		return result;
	}

	@Override
	public String toString() {
		return "[num=" + num + ", count=" + count + ", timeStamp=" + timeStamp + "]";
	}
	
}