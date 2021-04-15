package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
	private static int N, house[][], dp[][], result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		house = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = house[0][0];
		dp[0][1] = house[0][1];
		dp[0][2] = house[0][2];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
		}
		
		for (int i = 0; i < 3; i++)
			result = Math.min(result, dp[N - 1][i]);
		
		System.out.println(result);
	}
	
}
