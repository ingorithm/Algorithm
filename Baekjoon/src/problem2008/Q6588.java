package problem2008;	// P

import java.util.Arrays;
import java.util.Scanner;

public class Q6588 {
	static int N, max = 1000000;
	static boolean isPrime[] = new boolean[max + 1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		eratos();
		
		while (true) {
			N = sc.nextInt();
			if (N == 0) break;
			
			int front = 3;
			int back = N - 3;
			while (true) {
				if (isPrime[front] == true && isPrime[back] == true) {
					System.out.println(N + " = " + front + " + " + back);
					break;
				}
				front++;
				back--;
			}
		}
	}
	
	static void eratos() {
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; i * i <= max; i++)
			if (isPrime[i])
				for (int j = i * i; j <= max; j += i)
					isPrime[j] = false;
	}
}
