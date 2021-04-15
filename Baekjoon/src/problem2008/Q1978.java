package problem2008;	// P

import java.util.Scanner;
import java.util.Arrays;

public class Q1978 {
	static int N, MAX = 1000, result = 0;
	static boolean isPrime[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		isPrime = new boolean[MAX + 1];
		
		// 에라토스테네스의 체
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i * i <= MAX; i++)
			if (isPrime[i])
				for (int j = i * i; j <= MAX; j += i)
					isPrime[j] = false;
		
		for (int i = 0; i < N; i++)
			if (isPrime[sc.nextInt()])
				result++;
		
		System.out.println(result);
	}
}
