package problem2008;	// P

import java.util.Scanner;

public class D4_4301 {
	static int testCase, N, M, map[][], result;
	static int[][] dir = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[M][N];
			
			result = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					boolean isOK = true;
					for (int k = 0; k < dir.length; k++) {
						int ni = i + dir[k][0];
						int nj = j + dir[k][1];
						if (ni >= 0 && ni < M && nj >= 0 && nj < N && map[ni][nj] == 1) {
							isOK = false;
							break;
						}
					}
					if (isOK) {
						map[i][j] = 1;
						result++;
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
