package problem2008;	// P

import java.util.Scanner;

public class Q11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int n = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();
		
		for (int i = 0; i < s.length(); i++)
			result += (int)s.charAt(i) - '0';
		System.out.println(result);
	}
}
