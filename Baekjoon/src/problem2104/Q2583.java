package problem2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2583 {
	static int N, M, K;
	static int[][] map;
	static Queue<Point> q;
	static boolean[][] check;
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static ArrayList<Integer> list;
	
	static class Point {
		int i, j, cnt;
		
		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int idx = 0; idx < K; idx++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for (int i = x1; i < x2; i++)
				for (int j = y1; j < y2; j++)
					map[i][j] = 1;
		}
		
		check = new boolean[N][M];
		q = new LinkedList<>();
		list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) 
				if (map[i][j] == 0 && !check[i][j]) {
					q.offer(new Point(i, j, 1));
					check[i][j] = true;
					int area = 0;
					
					while (!q.isEmpty()) {
						Point p = q.poll();
						area++;
						
						for (int d = 0; d < dir.length; d++) {
							int ni = p.i + dir[d][0];
							int nj = p.j + dir[d][1];
							
							if (ni < 0 || ni >= N || nj < 0 || nj >= M)
								continue;
							
							if (map[ni][nj] == 0 && !check[ni][nj]) {
								q.offer(new Point(ni, nj, p.cnt + 1));
								check[ni][nj] = true;
							}
						}
					}
					
					list.add(area);
				}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}

}
