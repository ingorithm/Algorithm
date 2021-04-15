package problem2008;	// P

import java.util.Scanner;

public class Q2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxNum = 0, maxIdx = 0;
		int[] arr = new int[10];
		
		for (int i = 1; i <= 9; i++)
			arr[i] = sc.nextInt();
		
		for (int i = 1; i <= 9; i++)
			if (arr[i] > maxNum) {
				maxNum = arr[i];
				maxIdx = i;
			}
		
		System.out.println(maxNum);
		System.out.println(maxIdx);
	}
}
