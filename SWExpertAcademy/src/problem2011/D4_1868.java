package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1868 {
	private static int testCase, result[];
	private static int N;
	private static char map[][];
	private static boolean check[][];
	private static final int dir[][] = {{-1, -1}, {-1, 0}, {-1, 1}, 
										{0, -1}, {0, 0}, {0, 1}, 
										{1, -1}, {1, 0}, {1, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine().trim());
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new char[N][];
			check = new boolean[N][N];
			
			for (int i = 0; i < N; i++)
				map[i] = br.readLine().toCharArray();
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (!check[i][j] && isZero(i, j)) {
						
						Queue<Point> q = new LinkedList<>();
						q.offer(new Point(i, j));
						check[i][j] = true;
						result[tc]++;
						
						while (!q.isEmpty()) {
							Point p = q.poll();
							
							if (isZero(p.i, p.j)) {
								for (int d = 0; d < dir.length; d++) {
									int ni = p.i + dir[d][0];
									int nj = p.j + dir[d][1];
									
									if (ni < 0 || ni >= N || nj < 0 || nj >= N)
										continue;
									
									if (!check[ni][nj]) {
										q.offer(new Point(ni, nj));
										check[ni][nj] = true;
									}
								}
							}
						}
					}
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (check[i][j] == false && map[i][j] == '.')
						result[tc]++;
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
	}
	
	private static boolean isZero(int i, int j) {
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if (ni < 0 || ni >= N || nj < 0 || nj >= N)
				continue;
			
			if (map[ni][nj] != '.')
				return false;
		}
		
		return true;
	}

	private static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
