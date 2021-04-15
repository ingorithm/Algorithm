package problem2010;

import java.util.Scanner;

/*
소요시간 : 약 30분

dp[i]는 i까지 고려했을 때, 가질 수 있는 금액의 합의 최댓값

!특징 : 문제에 먼저 손을 대기보다, 문제를 읽고 손으로 먼저 푸는데 중점을 둠
!특징 : 코딩은 5분 내로 작성
 */
public class Q14501 {
	private static int N;
	private static int[] t, p, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		t = new int[N];
		p = new int[N];
		dp = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			int cur = 0;
			for (int j = 0; j < i; j++) {
				if (i - j == t[j])
					cur = Math.max(cur, dp[j] + p[j]);
				
				dp[i] = Math.max(dp[i - 1], cur);
			}
		}
		
		System.out.println(dp[N]);
	}

}
