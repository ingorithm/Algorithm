package problem2008;	// P

import java.util.Scanner;

public class Q8958 {
	static int testCase, result[];
	static String str;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = Integer.parseInt(sc.nextLine());
		result = new int[testCase];
		
		for (int tc = 0; tc < testCase; tc++) {
			str = sc.nextLine();
			int score = 0;
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O')
					score++;
				else
					score = 0;
				result[tc] += score;
			}
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}
}
