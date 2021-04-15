package dp;

import java.util.Scanner;

public class FibonacciTest1 {
	private static long[] memo;
	private static long[] call1, call2;
	private static long totalCnt1, totalCnt2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		memo = new long[N + 1];
		memo[0] = 0;
		memo[1] = 1;
		
		call1 = new long[N + 1];
		call2 = new long[N + 1];
		
		System.out.println("fibo1(N) : " + fibo1(N));
		for (int i = 0; i <= N; i++)
			System.out.println("fibo2(" + i + ") : " + call1[i]);
		System.out.println("비메모버전 수행횟수 : " + totalCnt1);
		System.out.println();
		
		System.out.println("fibo2(N) : " + fibo2(N));
		for (int i = 0; i <= N; i++)
			System.out.println("fibo2(" + i + ") : " + call2[i]);
		System.out.println("메모버전 수행횟수 : " + totalCnt2);
		System.out.println();
	}
	
	// 비메모버전
	private static long fibo1(int n) {
		call1[n]++;
		totalCnt1++;
		if (n < 2)
			return n;
		return fibo1(n - 1) + fibo1(n - 2);
	}
	
	// 메모버전
	private static long fibo2(int n) {
		call2[n]++;
		totalCnt2++;
		if (n >= 2 && memo[n] == 0)
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		return memo[n];
	}
}
