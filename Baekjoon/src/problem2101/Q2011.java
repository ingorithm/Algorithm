package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for (int i = 0; i < N; i++)
			arr[i + 1] = str.charAt(i) - '0';
		
		dp[0] = 1;
		for (int i = 1; i <= N; i++) {
			int temp = arr[i - 1] * 10 + arr[i];
			
			if (arr[i] != 0)
				dp[i] += dp[i - 1] % 1000000;
			
			if (temp >= 10 && temp <= 26)
				dp[i] += dp[i - 2] % 1000000;
		}
		
		System.out.println(dp[N] % 1000000);
	}
}
