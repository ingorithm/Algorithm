package problem2008;	// P

import java.util.Scanner;

public class D3_9229 {
	static int testCase, N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		int[] result = new int[testCase + 1];
		
		// test case
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int weight = -1, snack[] = new int[N];
			
			for (int i = 0; i < N; i++)
				snack[i] = sc.nextInt();
			
			int first, second;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					first = snack[i];
					second = snack[j];
					
					if (first + second > M)
						continue;
					else
						weight = first + second > weight ? first + second : weight;
				}
			}
			result[tc] = weight;
		}
		
		// output
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
}
