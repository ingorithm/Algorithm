package problem2008;	// P

import java.util.Scanner;

public class Q2468 {
	static int N, maxHeight, island[][], newIsland[][], result;
	static boolean isChecked[][];
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		island = new int[N][N];
		
		maxHeight = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				island[i][j] = sc.nextInt();
				maxHeight = Math.max(maxHeight, island[i][j]);
			}
		}
		
		result = 0;
		for (int h = 0; h <= maxHeight; h++) {
			newIsland = new int[N][N];
			isChecked = new boolean[N][N];
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (island[i][j] <= h)
						newIsland[i][j] = 0;
					else
						newIsland[i][j] = 1;
			
			int tempResult = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (isChecked[i][j] == false && newIsland[i][j] == 1) {
						tempResult++;
						countIsland(i, j, tempResult);
					}
			result = Math.max(result, tempResult);
		}
		System.out.println(result);
	}
	
	static void countIsland(int i, int j, int n) {
		isChecked[i][j] = true;
		newIsland[i][j] = n;
		
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if (ni >= 0 && nj >= 0 && ni < N && nj < N)
				if (isChecked[ni][nj] == false && newIsland[ni][nj] == 1)
					countIsland(ni, nj, n);
		}
	}
}

