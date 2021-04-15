package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1600 {
	private static int K, W, H, map[][], result = Integer.MAX_VALUE;
	private static Queue<Monkey> q;
	private static boolean[][][] check;
	private static final int mdir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static final int hdir[][] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		q = new LinkedList<>();
		check = new boolean[H][W][K + 1];	// [i][j][K일때 방문한 i, j]
		
		q.offer(new Monkey(0, 0, K, 0));
		check[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Monkey m = q.poll();
			
			if (m.i == H - 1 && m.j == W - 1) {
				result = Math.min(result, m.cnt);
				continue;
			}
			
			// horse
			for (int d = 0; d < hdir.length; d++) {
				int ni = m.i + hdir[d][0];
				int nj = m.j + hdir[d][1];
				
				if (ni < 0 || ni >= H || nj < 0 || nj >= W)
					continue;
				
				if (m.k <= 0 || check[ni][nj][m.k - 1] || map[ni][nj] == 1)
					continue;
				
				check[ni][nj][m.k - 1] = true;
				q.offer(new Monkey(ni, nj, m.k - 1, m.cnt + 1));
			}
			
			// monkey
			for (int d = 0; d < mdir.length; d++) {
				int ni = m.i + mdir[d][0];
				int nj = m.j + mdir[d][1];
				
				if (ni < 0 || ni >= H || nj < 0 || nj >= W)
					continue;
				
				if (check[ni][nj][m.k] || map[ni][nj] == 1)
					continue;
				
				check[ni][nj][m.k] = true;
				q.offer(new Monkey(ni, nj, m.k, m.cnt + 1));
			}
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	private static class Monkey implements Comparable<Monkey> {
		int i;
		int j;
		int k;
		int cnt;

		public Monkey(int i, int j, int k, int cnt) {
			this.i = i;
			this.j = j;
			this.k = k;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Monkey o) {
			if (o.cnt == this.cnt)
				return o.k - this.k;
			return this.cnt - o.cnt;
		}
	}
}


/*

INPUT : 
4
6 10
0 0 1 1 1 1
0 1 1 0 1 1
0 1 1 1 1 0
0 1 1 1 1 0
0 1 1 1 1 0
0 1 1 1 1 0
0 1 1 0 1 1
0 1 1 1 1 1
1 1 1 1 0 0
1 0 0 1 1 0

OUTPUT : 10 

INPUT : 
1
4 4
0 1 1 1
0 0 1 1
1 0 1 1
1 1 1 0

OUTPUT : 4

 */
