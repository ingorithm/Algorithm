package problem2008;	// P

import java.util.Scanner;

public class Q2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		boolean isAsc = true, isDes = true;
		
		for (int i = 0; i < 8; i++)
			arr[i] = sc.nextInt();
		
		for (int i = 1; i < 8; i++) {
			if (arr[i] != arr[i - 1] + 1)
				isAsc = false;
			if (arr[i] != arr[i - 1] - 1)
				isDes = false;
		}
		
		if (isAsc)
			System.out.println("ascending");
		else if (isDes)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
