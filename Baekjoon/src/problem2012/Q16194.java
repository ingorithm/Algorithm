package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16194 {
	private static int N, P[], dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = new int[N + 1];
		dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			P[i] = Integer.parseInt(st.nextToken());
		
		// initialization
		dp[1] = P[1];
		dp[2] = Math.min(P[1] * 2, P[2]);
		
		for (int i = 3; i <= N; i++) {
			dp[i] = P[i];
			
			for (int j = 1; j < i; j++)
				dp[i] = Math.min(dp[i], P[j] + dp[i - j]);
		}
		
		System.out.println(dp[N]);
	}

}
