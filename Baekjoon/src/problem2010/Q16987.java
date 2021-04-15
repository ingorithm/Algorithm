package problem2010;

import java.util.Scanner;

public class Q16987 {
	private static int N, S[], W[], result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = new int[N];
		W = new int[N];
		
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			W[i] = sc.nextInt();
		}
		
		dfs(0);
		
		System.out.println(result);
	}
	
	private static void dfs(int idx) {
		int cnt = 0;
		for (int i = 0; i < N; i++)
			if (S[i] <= 0)
				cnt++;
		result = Math.max(result, cnt);

		if (idx == N) {
			return;
		}
		
		if (S[idx] <= 0) {
			dfs(idx + 1);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (idx == i)
				continue;
			
			if (S[i] > 0) {
				S[i] -= W[idx];
				S[idx] -= W[i];
				dfs(idx + 1);
				S[i] += W[idx];
				S[idx] += W[i];
			}
		}
	}
}
