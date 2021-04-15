package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6087 {
	private static int W, H, result = Integer.MAX_VALUE;
	private static char[][] map;
	private static int[][] check;
	private static Queue<Point> q;
	private static Point start, end;
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		check = new int[H][W];
		q = new LinkedList<>();
		
		for (int i = 0; i < H; i++)
			map[i] = br.readLine().toCharArray();
		
		init();
		for (int d = 0; d < dir.length; d++)
			q.offer(new Point(start.i, start.j, d, 0));
		check[start.i][start.j] = 0;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.i == end.i && p.j == end.j) {
				result = Math.min(result, p.c);
				continue;
			}
			
			for (int d = 0; d < dir.length; d++) {
				int ni = p.i + dir[d][0];
				int nj = p.j + dir[d][1];
				int nc = p.c;
				
				if (ni < 0 || ni >= H || nj < 0 || nj >= W)
					continue;
				
				if (p.d != d)
					nc++;
				
				if (map[ni][nj] == '.' && check[ni][nj] >= nc) {
					check[ni][nj] = nc;
					q.offer(new Point(ni, nj, d, nc));
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void init() {
		boolean flag = false;
		
		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++) {
				check[i][j] = Integer.MAX_VALUE;
				if (map[i][j] == 'C')
					if (!flag) {
						flag = true;
						start = new Point(i, j);
						map[i][j] = '.';
					} else {
						end = new Point(i, j);
						map[i][j] = '.';
					}
			}
	}
	
	private static class Point {
		int i, j, d, c;	// direction, changed

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public Point(int i, int j, int d, int c) {
			this.i = i;
			this.j = j;
			this.d = d;
			this.c = c;
		}
	}
}
