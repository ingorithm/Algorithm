package problem2012;

import java.util.Scanner;

public class Q1904 {
	private static int N;
	private static long dp[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N + 1];
		
		if (N == 1) {
			System.out.println("1");
			System.exit(0);
		}
		
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++)
			dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
		
		System.out.println(dp[N] % 15746);
	}
}
