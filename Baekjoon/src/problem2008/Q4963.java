package problem2008;	// P

import java.io.IOException;
import java.util.Scanner;

public class Q4963 {
	static int W, H, island[][], testCase, result;
	static boolean isChecked[][];
	static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if (W == 0 && H == 0)
				break;
			island = new int[H][W];
			isChecked = new boolean[H][W];
			
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					island[i][j] = sc.nextInt();
			
			result = 0;
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					if (isChecked[i][j] == false && island[i][j] == 1) {
						result++;
						countIsland(i, j, result);
					}
			System.out.println(result);
		}
	}
	
	static void countIsland(int i, int j, int n) {
		isChecked[i][j] = true;
		island[i][j] = n;
		
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if (ni >= 0 && nj >= 0 && ni < H && nj < W)
				if (isChecked[ni][nj] == false && island[ni][nj] == 1)
					countIsland(ni, nj, n);
		}
	}
}

