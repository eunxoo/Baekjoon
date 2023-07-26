package DAY02.timeComplexity;

import java.util.Scanner;

public class Main1072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long X = sc.nextLong();
		long Y = sc.nextLong();
		
		long z = 100 * Y / X;
		
		if(z >= 99) {
			System.out.println(-1);
		} else {
			long s = 1;
			long e = X;
			while(true) {
				long mid = (s + e) /2;
				long temp = 100 * (Y + mid) / (X + mid);
				if(temp == z) {
					s = mid + 1;
				}else { // temp > z
					e = mid;
				}
				
				if(s == e) {
					break;
				}
			}
			System.out.println(e);
		}

	}

}
