package problem2008;	// P

import java.util.Scanner;

public class D1_2070 {
	private static int testCase; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		char[] result = new char[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			if (first > second)
				result[tc] = '>';
			else if (first < second)
				result[tc] = '<';
			else
				result[tc] = '=';
		}
		
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
}
