package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q10026 {
	private static int N, normal, disable;
	private static char[][] map;
	private static boolean[][] visited; 
	private static Queue<Point> q;
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		map = new char[N][];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		normal = bfs();
		change();
		disable = bfs();
		
		System.out.println(normal + " " + disable);
	}
	
	private static int bfs() {
		int ret = 0;
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				char cur = 'Z';	// initialization
				
				if (!visited[i][j] && cur != map[i][j]) {
					cur = map[i][j];
					ret++;
					q.offer(new Point(i, j));
					visited[i][j] = true;
					
					while (!q.isEmpty()) {
						Point p = q.poll();
						
						for (int d = 0; d < dir.length; d++) {
							int ni = p.i + dir[d][0];
							int nj = p.j + dir[d][1];
							
							if (ni < 0 || ni >= N || nj < 0 || nj >= N)
								continue;
							
							if (cur != map[ni][nj])
								continue;
							
							if (!visited[ni][nj]) {
								visited[ni][nj] = true;
								q.offer(new Point(ni, nj));
							}
						}
					}
				}
			}
		
		return ret;
	}
	
	private static void change() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
				if (map[i][j] == 'R')
					map[i][j] = 'G';
			}
	}

	private static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
}
