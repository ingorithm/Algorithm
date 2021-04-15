package problem2008;	// P

import java.util.Scanner;

public class D2_2001 {
	private static int N, M, area[][], testCase, result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			area = new int[N][N];
			int answer = 0;
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					area[i][j] = sc.nextInt();
			
			for (int i = 0; i < (N - M + 1); i++)
				for (int j = 0; j < (N - M + 1); j++) {
					int tempMax = flyCatch(i, j);
					if (answer < tempMax)
						answer = tempMax;
				}
			
			result[tc] = answer;
		}
		
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
	
	private static int flyCatch (int y, int x) {
		int max = 0;
		
		for (int i = 0; i < M; i++)
			for (int j = 0; j < M; j++)
				max += area[y + i][x + j];
		
		return max;
	}
}
