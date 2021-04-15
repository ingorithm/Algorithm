package problem2103;

import java.util.Scanner;

public class Q9095 {
	private static int T, N, result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		result = new int[T + 1];
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			comb(N, tc);
		}
		
		for (int tc = 1; tc <= T; tc++)
			System.out.println(result[tc]);
	}
	
	private static void comb(int remain, int tc) {
		if (remain == 0) {
			result[tc]++;
			return;
		}
		
		if (remain >= 1)
			comb(remain - 1, tc);
		if (remain >= 2)
			comb(remain - 2, tc);
		if (remain >= 3)
			comb(remain - 3, tc);
	}

}
