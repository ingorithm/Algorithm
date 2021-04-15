package problem2012;

import java.util.Scanner;

public class Q11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[][] result = new int[tc + 1][2];
		
		for (int i = 1; i <= tc; i++) {
			result[i][0] = sc.nextInt();
			result[i][1] = sc.nextInt();
		}
		
		for (int i = 1; i <= tc; i++)
			System.out.println("Case #" + i + ": " + result[i][0] + " + " + result[i][1] + " = " + (result[i][0] + result[i][1]));
	}
}