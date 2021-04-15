package problem2008;	// P

import java.util.Scanner;

public class Q2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int lcm = 1, gcd = 0;
		int f = sc.nextInt();	// First Number
		int s = sc.nextInt();	// Second Number

		gcd = gcd(f, s);
		System.out.println(gcd);
		
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
		System.out.println(lcm);
	}
	
	private static int gcd(int i, int j) {
		int temp;
		
		// 항상 i가 더 크게
		if (i < j) {
			temp = j;
			j = i;
			i = temp;
		}
		
		while (j != 0) {
			temp = i % j;
			i = j;
			j = temp;
		}
		
		return i;
	}
}
