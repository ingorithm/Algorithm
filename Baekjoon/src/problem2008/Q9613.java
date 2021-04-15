package problem2008;	// P

import java.util.Scanner;

public class Q9613 {
	static int testCase, N;
	static long gcd, result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new long[testCase];
		
		// test case
		for (int tc = 0; tc < testCase; tc++) {
			N = sc.nextInt(); 
			gcd = 0;
			int[] arr = new int[N];
			
			// input
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			// calculate
			for (int i = 0; i < N - 1; i++)
				for (int j = i + 1; j < N; j++)
					gcd += gcd(arr[i], arr[j]);
			result[tc] = gcd;
		}
		
		// output
		for (int tc = 0; tc < testCase; tc++) {
			System.out.println(result[tc]);
		}
	}
	
	private static int gcd(int i, int j) {
		int temp;
		
		// 항상 i가 더 크게
		if (i < j) {
			temp = j;
			j = i;
			i = temp;
		}
		
		while (j != 0) {
			temp = i % j;
			i = j;
			j = temp;
		}
		
		return i;
	}
}
