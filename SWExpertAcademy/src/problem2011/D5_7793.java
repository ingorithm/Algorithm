package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D5_7793 {
	private static int testCase, result[];
	private static int N, M;
	private static char[][] map;
	private static Queue<Point> q, devil;	// soo, devil
	private static boolean[][] check;
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		testCase = Integer.parseInt(st.nextToken());
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][];
			q = new LinkedList<>();
			devil = new LinkedList<>();
			check = new boolean[N][M];
			for (int i = 0; i < N; i++)
				map[i] = br.readLine().toCharArray();
			
			// init
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S') {
						check[i][j] = true;
						q.offer(new Point(i, j));
						map[i][j] = '.';
					} else if (map[i][j] == '*')
						devil.offer(new Point(i, j));
				}
			
			int time = 1;
			exit_while:
			while (!q.isEmpty()) {
				
				// soo move
				int sooSize = q.size();
				for (int size = 0; size < sooSize; size++) {
					Point p = q.poll();
					
					if (map[p.i][p.j] == '*')
						continue;
					
					for (int d = 0; d < dir.length; d++) {
						int ni = p.i + dir[d][0];
						int nj = p.j + dir[d][1];
						
						if (ni < 0 || ni >= N || nj < 0 || nj >= M)
							continue;
						
						if (map[ni][nj] == 'D') {
							result[tc] = time;
							break exit_while;
						}
						
						if (map[ni][nj] == '.' && !check[ni][nj]) {
							check[ni][nj] = true;
							q.offer(new Point(ni, nj));
						}
					}
				}
				
				// devil move
				int devilSize = devil.size();
				for (int size = 0; size < devilSize; size++) {
					Point p = devil.poll();
					
					for (int d = 0; d < dir.length; d++) {
						int ni = p.i + dir[d][0];
						int nj = p.j + dir[d][1];
						
						if (ni < 0 || ni >= N || nj < 0 || nj >= M)
							continue;
						
						if (map[ni][nj] == '.') {
							map[ni][nj] = '*';
							devil.offer(new Point(ni, nj));
						}
					}
				}
				
				time++;
			}
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + (result[tc] == 0 ? "GAME OVER" : result[tc]));
	}

	private static class Point {
		int i;
		int j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
