package problem2012;

import java.util.Scanner;

public class Q2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		
		for (int i = 1; i < N; i++) {
			int sum = i;
			
			for (int j = 0; j < 7; j++)	// 자릿수  1 <= N <= 1,000,000
				sum += (i / Math.pow(10, j)) % 10;
			
			if (sum == N) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
