package problem2101;

import java.util.Scanner;

public class Q2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[10];
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int mul = a * b * c;
		
		String str = Integer.toString(mul);
		for (int i = 0; i < str.length(); i++)
			cnt[str.charAt(i) - '0']++;
		
		for (int i = 0; i <= 9; i++)
			System.out.println(cnt[i]);
	}
}
