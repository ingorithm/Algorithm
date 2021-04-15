package problem2008;	// P

import java.util.Scanner;

public class Q10818 {
	static int N, max, min;
	
	public static void main(String[] args) {
		// StringBuilder 사용하면 시간 많이 줄 듯
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		int temp;
		for (int i = 0; i < N; i++) {
			temp = sc.nextInt();
			max = Math.max(max, temp);
			min = Math.min(min, temp);
		}
		
		System.out.println(min + " " + max);
	}
}
