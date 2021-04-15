package problem2008;	// P

import java.util.Scanner;

public class D1_2072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] result = new int[testCase];
		
		// test case
		for (int tc = 0; tc < testCase; tc++) {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				if ((num % 2) == 1)
					sum += num;
			}
			result[tc] = sum;
		}
		
		// output
		for (int tc = 0; tc < testCase; tc++) {
			System.out.println("#" + (tc + 1) + " " + result[tc]);
		}
	}
}
