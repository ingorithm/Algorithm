package problem2008;	// P

import java.util.Scanner;

public class Q1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		if (a < b)
			System.out.println("<");
		else if (a > b)
			System.out.println(">");
		else if (a == b)
			System.out.println("==");
	}
}
