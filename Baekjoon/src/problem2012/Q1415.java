package problem2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 1. 소수와 관계없이, 사탕의 가격에 대해서 만들 수 있는 모든 경우의 수를 먼저 계산한다.
 * 2. 이후 소수일 경우, 그 값을 더해준다.
 * 3. 주의할 점 몇가지
 */
public class Q1415 {
	private static int N, MAX;					// MAX = N * 10000 : 사탕의 개수로 만들 수 있는 최대 금액
	private static boolean[] prime;				// 소수
	private static ArrayList<Integer> candies;	// 중복을 포함하지 않는 사탕 가격의 List
	private static int[] cnt;					// 해당 가격의 사탕의 개수
	private static long[] dp;					// 해당 금액으로 만들 수 있는 사탕의 가짓수, 주의 : long형!!
	private static int zero = 1;				// 가격이 0인 사탕의 수, 주의 : 1부터 시작!!
	private static long result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		MAX = N * 10000;
		prime = new boolean[MAX + 1];
		candies = new ArrayList<>();
		cnt = new int[10001];
		dp = new long[MAX + 1];
		
		eratos();
		
		// input
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			if (temp == 0) {
				zero++;
				continue;
			}
			if (cnt[temp] == 0)
				candies.add(temp);
			cnt[temp]++;
		}
		
		int maxI = 0;	// 지금까지 계산된 가장 큰 금액
		dp[0] = 1;		// initialization, 이 값을 통해 dp를 불려나간다.
		for (int i = 0; i < candies.size(); i++) {	// 사탕의 가격(중복X)을 하나씩 탐색한다.
			for (int j = maxI; j >= 0; j--)			// 뒤에서부터 탐색해야 값의 이중 덧셈을 피할 수 있다.
				for (int k = 1; k <= cnt[candies.get(i)]; k++) {	// 사탕의 개수를 계산해야하기 때문에 1~cnt까지
					if (j + candies.get(i) * k > MAX)	break;		// 계산 가능한 범위를 넘어갔을 때
					dp[j + candies.get(i) * k] += dp[j];			// 현재 금액 + 사탕의 가격 * 사탕의 갯수
				}
			maxI = Math.min(maxI + candies.get(i) * cnt[candies.get(i)], MAX);	// 금액의 한계치 재계산
		}
		
		// output
		for (int i = 2; i <= MAX; i++)
			if (prime[i])
				result += dp[i];
		result = result * zero;
		System.out.println(result);
		sc.close();
	}

	// 에라토스테네스의 체
	private static void eratos() {
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for (int i = 2; i * i <= MAX; i++)
			if (prime[i])
				for (int j = i * i; j <= MAX; j += i)
					prime[j] = false;
	}
}
