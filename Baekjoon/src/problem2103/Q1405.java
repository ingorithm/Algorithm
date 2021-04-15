package problem2103;

import java.util.Scanner;

public class Q1405 {
	private static int N;
	private static double result;
	private static double[] dirPer;
	private static boolean[][] check;
	private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result = 0;
		dirPer = new double[4];
		check = new boolean[29][29];
		
		for (int i = 0; i < 4; i++)
			dirPer[i] = sc.nextDouble() * 0.01;
		
		check[14][14] = true;
		dfs(14, 14, 0, 1.0);
		
		System.out.println(result);
	}
	
	private static void dfs(int r, int c, int cnt, double per) {
		if (cnt == N) {
			result += per;
			return;
		}
		
		for (int i = 0; i < dir.length; i++)
			if (dirPer[i] > 0) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				
				if (!check[nr][nc]) {
					check[nr][nc] = true;
					dfs(nr, nc, cnt + 1, per * dirPer[i]);
					check[nr][nc] = false;
				}
			}
	}
}
