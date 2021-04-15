package problem2008;	// P

import java.util.Scanner;

public class Q1085 {
	static int X, Y, W, H;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		Y = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		
		System.out.println(Math.min(Math.min(X, W - X), Math.min(Y, H - Y)));
	}
}
