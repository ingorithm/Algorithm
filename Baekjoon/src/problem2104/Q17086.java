package problem2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17086 {
	static int N, M;
	static int[][] map, dist;
	static Queue<Shark> q;
	static boolean[][] check;
	static final int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	
	static class Shark {
		int i, j, cnt;

		public Shark(int i, int j, int cnt) {
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
		map = new int[N][M];
		dist = new int[N][M];
		
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 1)
					bfs(i, j);
		
		int result = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				result = Math.max(result, dist[i][j]);
		
		System.out.println(result);
	}
	
	static void bfs(int i, int j) {
		q = new LinkedList<>();
		check = new boolean[N][M];
		
		q.offer(new Shark(i, j, 0));
		check[i][j] = true;
		
		while (!q.isEmpty()) {
			Shark s = q.poll();
			
			if (dist[s.i][s.j] > s.cnt)
				dist[s.i][s.j] = s.cnt;
			
			for (int d = 0; d < dir.length; d++) {
				int ni = s.i + dir[d][0];
				int nj = s.j + dir[d][1];
				
				if (ni < 0 || ni >= N || nj < 0 || nj >= M)
					continue;
				
				if (!check[ni][nj]) {
					q.offer(new Shark(ni, nj, s.cnt + 1));
					check[ni][nj] = true;
				}
			}
		}
	}
}
