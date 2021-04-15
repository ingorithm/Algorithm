package problem2008;	// P

import java.util.Scanner;

public class D2_1859 {
	static int N, price[];
	static long profit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		long[] result = new long[testCase + 1];
		
		// test case
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			price = new int[N];
			profit = 0;
			
			// input
			for (int i = 0; i < N; i++)
				price[i] = sc.nextInt();
			
			// search
			search(0);
			result[tc] = profit;
		}
		
		// output
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
	
	private static void search(int start) {
		int maxProfit = 0, maxIndex = 0;
		for (int i = start; i < N; i++) {
			if (price[i] > maxProfit) {
				maxProfit = price[i];
				maxIndex = i;
			}
		}
		for (int i = start; i <= maxIndex; i++)
			profit += (maxProfit - price[i]);
		if (maxIndex != 0 && maxIndex + 1 < N)
			search(maxIndex + 1);
	}
}
