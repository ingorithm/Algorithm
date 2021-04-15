package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16235 {
	private static int N, M, K;
	private static int[][] map, A;
	private static PriorityQueue<Tree> pq;
	private static final int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		A = new int[N + 1][N + 1];
		pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq.offer(new Tree(x, y, z));
		}
		
		for (int year = 0; year < K; year++) {
			Queue<Tree> q = new LinkedList<>();
			int[][] temp = new int[N + 1][N + 1];
			
			while (!pq.isEmpty()) {
				Tree t = pq.poll();
				
				// spring
				if (map[t.r][t.c] >= t.y) {
					map[t.r][t.c] -= t.y;
					t.y++;
					q.offer(t);
				} else
					temp[t.r][t.c] += t.y / 2;
			}
			
			// summer
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					if (temp[i][j] > 0) {
						map[i][j] += temp[i][j];
						temp[i][j] = 0;
					}
			
			// fall
			while (!q.isEmpty()) {
				Tree t = q.poll();
				
				if (t.y % 5 == 0) {
					for (int d = 0; d < dir.length; d++) {
						int nr = t.r + dir[d][0];
						int nc = t.c + dir[d][1];
						
						if (nr >= 1 && nr <= N && nc >= 1 && nc <= N)
							pq.offer(new Tree(nr, nc, 1));
					}
				}
				pq.offer(t);
			}
			
			// winter
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					map[i][j] += A[i][j];
		}
		
		System.out.println(pq.size());
	}
	
	private static class Tree implements Comparable<Tree> {
		int r;
		int c;
		int y;	// years
		
		public Tree(int r, int c, int y) {
			this.r = r;
			this.c = c;
			this.y = y;
		}

		@Override
		public int compareTo(Tree o) {
			return this.y - o.y;
		}
	}
}
