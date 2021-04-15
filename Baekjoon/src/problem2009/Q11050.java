package problem2009;	// P

import java.util.Scanner;

public class Q11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int result = 1;
		for (int i = 0; i < K; i++)
			result *= (N - i);
		for (int i = K; i > 0; i--)
			result /= i;
		
		System.out.println(result);
	}
}
