package problem2012;

import java.util.Scanner;

public class Q1074 {
	private static int N, R, C, result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		area(N, R, C);
		
		System.out.println(result);
	}
	
	private static void area(int n, int r, int c) {
		if (n == 1) {
			if (r == 0 && c == 0)
				result += 0;
			else if (r == 0 && c == 1)
				result += 1;
			else if (r == 1 && c == 0)
				result += 2;
			else if (r == 1 && c == 1)
				result += 3;
			return;
		}
		
		// area 0
		if (r < Math.pow(2, n - 1) && c < Math.pow(2, n - 1))
			result += Math.pow(Math.pow(2, n - 1), 2) * 0;
		
		// area 1
		if (r < Math.pow(2, n - 1) && c >= Math.pow(2, n - 1))
			result += Math.pow(Math.pow(2, n - 1), 2) * 1;
		
		// area 2
		if (r >= Math.pow(2, n - 1) && c < Math.pow(2, n - 1))
			result += Math.pow(Math.pow(2, n - 1), 2) * 2;
		
		// area 3
		if (r >= Math.pow(2, n - 1) && c >= Math.pow(2, n - 1))
			result += Math.pow(Math.pow(2, n - 1), 2) * 3;
		
		area(n - 1, r % (int)Math.pow(2, n - 1), c % (int)Math.pow(2, n - 1));
	}
}
