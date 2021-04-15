package problem2101;

import java.util.Scanner;

public class Q3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[42];
		
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			arr[num % 42] = true;
		}
		
		int cnt = 0;
		for (int i = 0; i < 42; i++)
			if (arr[i])
				cnt++;
		System.out.println(cnt);
	}
}
