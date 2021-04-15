package problem2008;	// P

import java.util.Scanner;

public class Q1476 {
	static int E, S, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		
		int year = 1;
		while (!(E == 1 && S == 1 && M == 1)) {
			E--; S--; M--;
			if (E == 0)
				E = 15;
			if (S == 0)
				S = 28;
			if (M == 0)
				M = 19;
			year++;
				
		}
		System.out.println(year);
	}
}
