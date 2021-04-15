package problem2008;	// P

import java.util.Scanner;

public class Q10950 {
	static int tc, result[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		result = new int[tc];
		
		for (int i = 0; i < tc; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			result[i] = a + b;
		}
		
		for (int i = 0; i < tc; i++)
			System.out.println(result[i]);
	}
}
