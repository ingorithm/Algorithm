package problem2009;

import java.util.Scanner;

public class Q17069 {
	private static int N, map[][];
	private static long dp[][][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		dp = new long[3][N][N];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		
		dp[0][0][1] = 1;
		for (int i = 0; i < N; i++)
			for (int j = 1; j < N; j++) {
				// horizontal : dp[0]
				if (j + 1 < N && map[i][j + 1] == 0) {
					dp[0][i][j + 1] += dp[0][i][j];
					dp[0][i][j + 1] += dp[1][i][j];
				}
				
				// diagonal : dp[1]
				if (i + 1 < N && j + 1 < N &&
						map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i + 1][j + 1] == 0) {
					dp[1][i + 1][j + 1] += dp[0][i][j];
					dp[1][i + 1][j + 1] += dp[1][i][j];
					dp[1][i + 1][j + 1] += dp[2][i][j];
				}
				
				// vertical : dp[2]
				if (i + 1 < N && map[i + 1][j] == 0) {
					dp[2][i + 1][j] += dp[1][i][j];
					dp[2][i + 1][j] += dp[2][i][j];
				}
			}
		System.out.println(dp[0][N - 1][N - 1] + dp[1][N - 1][N - 1] + dp[2][N - 1][N - 1]);
	}

}
