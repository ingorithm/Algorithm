package problem2010;

import java.util.Scanner;

public class Q1003 {
	private static int testCase, result[][];
	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase][2];
		
		for (int tc = 0; tc < testCase; tc++) {
			N = sc.nextInt();
			
			if (N == 0)
				result[tc][0] = 1;
			else if (N == 1)
				result[tc][1] = 1;
			else {
				int[] fibo = new int[N + 1];
				fibo[N] = 1;
				
				for (int i = N; i >= 2; i--) {
					fibo[i - 2] += fibo[i];
					fibo[i - 1] += fibo[i];
				}
				
				result[tc][0] = fibo[0];
				result[tc][1] = fibo[1];
			}
				
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc][0] + " " + result[tc][1]);
		
	}
	
}
