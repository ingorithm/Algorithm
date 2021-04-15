package problem2012;

import java.util.Scanner;

public class Q2156 {
	private static int N;
	private static int[] wine, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		wine = new int[N];
		dp = new int[N];
		
		for (int i = 0; i < N; i++)
			wine[i] = sc.nextInt();
		
		if (N == 1) {
			System.out.println(wine[0]);
			System.exit(0);
		}
		if (N == 2) {
			System.out.println(wine[0] + wine[1]);
			System.exit(0);
		}
		
		// initialization
		dp[0] = wine[0];
		dp[1] = wine[0] + wine[1];
		dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));

		if (N == 3) {
			System.out.println(dp[2]);
			System.exit(0);
		}
		
		for (int i = 3; i < N; i++) {
			dp[i] = dp[i - 3] + wine[i - 1] + wine[i];
			dp[i] = Math.max(dp[i], dp[i - 2] + wine[i]);
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}
		
		System.out.println(dp[N - 1]);
	}

}
