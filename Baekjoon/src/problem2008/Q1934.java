package problem2008;	// P

import java.util.Scanner;

public class Q1934 {
	static int testCase, result[];	// Factorization
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase + 1];
		
		// test case
		for (int tc = 1; tc <= testCase; tc++) {
			int lcm = 1;
			int f = sc.nextInt();	// First Number
			int s = sc.nextInt();	// Second Number
			
			// 소인수분해 & LCM
			for (int i = 2; i <= Math.max(f, s); i++) {
				if (f >= i && s >= i) {
					while (f % i == 0 || s % i == 0) {
						if (f % i == 0 && s % i == 0) {
							f = f / i;
							s = s / i;
							lcm *= i;
						} else if (f % i == 0 && s % i != 0) {
							f = f / i;
							lcm *= i;
						} else if (f % i != 0 && s % i == 0) {
							s = s / i;
							lcm *= i;
						}
					}
				} else if (f >= i && s < i) {
					while (f % i == 0) {
						f = f / i;
						lcm *= i;
					}
				} else if (f < i && s >= i) {
					while (s % i == 0) {
						s = s / i;
						lcm *= i;
					}
				}
			}
			result[tc] = lcm;
		}
		
		// output
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println(result[tc]);
		
	}
}
