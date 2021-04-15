package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3187 {
	private static int R, C;
	private static int tempV, tempK, sumV, sumK;	// V : 늑대, K : 양
	private static char[][] map;
	private static boolean[][] check;
	private static Queue<Point> q;
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		check = new boolean[R][C];
		q = new LinkedList<>();
		
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] != '#' && !check[i][j]) {
					tempV = 0;
					tempK = 0;
					q.offer(new Point(i, j));
					check[i][j] = true;
					
					while (!q.isEmpty()) {
						Point p = q.poll();
						
						if (map[p.i][p.j] == 'k')
							tempK++;
						if (map[p.i][p.j] == 'v')
							tempV++;
						
						for (int d = 0; d < dir.length; d++) {
							int ni = p.i + dir[d][0];
							int nj = p.j + dir[d][1];
							
							if (ni < 0 || ni >= R || nj < 0 || nj >= C)
								continue;
							
							if (map[ni][nj] != '#' && !check[ni][nj]) {
								q.offer(new Point(ni, nj));
								check[ni][nj] = true;
							}
						}
					}
					
					if (tempK > tempV)
						sumK += tempK;
					else
						sumV += tempV;
				}
		
		System.out.println(sumK + " " + sumV);
	}

	private static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
