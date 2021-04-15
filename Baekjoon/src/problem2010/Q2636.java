package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2636 {
	private static int R, C, map[][];
	private static int time, last, cur;
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] == 1)
					cur++;
		
		while(cur > 0) {
			boolean[][] check = new boolean[R][C];
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(0, 0));
			check[0][0] = true;
			
			while (!q.isEmpty()) {
				Point p = q.poll();
				
				for (int d = 0; d < dir.length; d++) {
					int ni = p.r + dir[d][0];
					int nj = p.c + dir[d][1];
					
					if (ni < 0 || ni >= R || nj < 0 || nj >= C)
						continue;
					
					if (!check[ni][nj] && map[ni][nj] == 1) {
						map[ni][nj] = 2;
						check[ni][nj] = true;
					} else if (!check[ni][nj] && map[ni][nj] == 0) {
						q.offer(new Point(ni, nj));
						check[ni][nj] = true;
					}
				}
			}
			
			melt();
			time++;
		}
		
		System.out.println(time);
		System.out.println(last);
	}
	
	private static void melt() {
		int curCheese = 0;
		
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] == 1)
					curCheese++;
				else if (map[i][j] == 2)
					map[i][j] = 0;
		
		last = cur;
		cur = curCheese;
	}
	
	private static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
