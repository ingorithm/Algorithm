package problem2101;

import java.util.Scanner;

public class Q1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		
		int cnt = 0;
		int temp = first;
		while (true) {
			int ten = temp % 10;
			int one = (temp / 10 + temp % 10) % 10;
			
			temp = ten * 10 + one;
			cnt++;
			
			if (temp == first)
				break;
		}
		
		System.out.println(cnt);
	}
}
