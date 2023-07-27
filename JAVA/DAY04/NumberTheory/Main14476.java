package DAY04.NumberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14476 {
	static int N;
	static int[] nums;
	static int[] gcdLtoR;
	static int[] gcdRtoL;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		gcdLtoR = new int[N];
		gcdRtoL = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		gcdLtoR[0] = nums[0];
		for (int i = 1; i < N; i++) {
			gcdLtoR[i] = gcd(gcdLtoR[i - 1], nums[i]);
		}
		
		gcdRtoL[N -1] = nums[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			gcdRtoL[i] = gcd(gcdRtoL[i + 1], nums[i]);
		}
		
		int max = 0;
		int maxIndex = 0;
		boolean found = false;
		
		for (int k = 0; k < N; k++) {
			int gcd = 0;
			if(k == 0) { // nums[0] 일 때
				gcd = gcdRtoL[1];
			} else if(k == N - 1) { // nums[N - 1] 일 때
				gcd = gcdLtoR[N - 2];
			} else { // nums[중간] 일 때
				gcd = gcd(gcdLtoR[k - 1], gcdRtoL[k + 1]);
			}
			
			if(nums[k] % gcd != 0 && gcd > max) {
				max = gcd;
				maxIndex = k;
				found = true;
			}
		}
		
		 if (found) {
	            System.out.println(max + " " + nums[maxIndex]);
	        } else {
	            System.out.println(-1);
	        }
		
	}
	
	// gcd(a,b) == gcd(b, a % b), a % b == 0 이면 b가 gcd
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
