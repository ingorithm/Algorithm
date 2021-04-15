package problem2008;	// P

import java.util.Scanner;

public class D1_2071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		double[] result = new double[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			double avg = 0;
			
			for (int i = 0; i < 10; i++) {
				avg += sc.nextInt();
			}
			result[tc] = Math.round(avg / 10);
		}
		
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("#" + tc + " " + Math.round(result[tc]));
		}
	}
}
