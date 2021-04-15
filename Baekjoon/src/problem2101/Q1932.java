package problem2101;

import java.util.Scanner;

public class Q1932 {
	private static int N, result;
	private static int[][] map, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j <= i; j++)
				map[i][j] = sc.nextInt();
		
		dp[0][0] = map[0][0];
		for (int i = 1; i < N; i++)
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					dp[i][j] = dp[i - 1][j] + map[i][j];
				else if (i == j)
					dp[i][j] = dp[i - 1][j - 1] + map[i][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
			}

		for (int j = 0; j < N; j++)
			result = Math.max(result, dp[N - 1][j]);
		
		System.out.println(result);
	}
}
