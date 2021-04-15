package problem2012;

import java.util.Scanner;

public class Q11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] result = new int[T + 1];
		
		for (int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			result[i] = a + b;
		}
		
		for (int i = 1; i <= T; i++)
			System.out.println("Case #" + i + ": " + result[i]);
	}
}
