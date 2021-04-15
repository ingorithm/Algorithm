package etc;

import java.util.Scanner;

public class PascalTriangle {
	private static int testCase, result[];
	private static int N, M;
	private static int pascal[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase];
		
		pascal = new int[30][30];
		init();
		
		for (int tc = 0; tc < testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			result[tc] = pascal[N][M];
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}
	
	private static void init() {
		for (int i = 0; i < 30; i++)
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					pascal[i][j] = 1;
				else if (i == j)
					pascal[i][j] = 1;
				else
					pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
			}
	}
}
