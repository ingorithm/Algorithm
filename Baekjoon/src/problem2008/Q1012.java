package problem2008;

import java.util.Scanner;

public class Q1012 {
	static int testCase, M, N, K, map[][], result[];
	static boolean isChecked[][];
	static final int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase];
		
		for (int tc = 0; tc < testCase; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][M];
			isChecked = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if (map[i][j] == 1 && isChecked[i][j] == false) {
						cnt++;
						dfs(i, j, cnt);
					}
			result[tc] = cnt;
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}
	
	static void dfs(int i, int j, int cnt) {
		isChecked[i][j] = true;
		map[i][j] = cnt;
		
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if (ni >= 0 && ni < N && nj >= 0 && nj < M)
				if (map[ni][nj] == 1 && isChecked[ni][nj] == false)
					dfs(ni, nj, cnt);
		}
	}
}
