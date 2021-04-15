package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5653 {
	private static int testCase, result[];
	private static int N, M, K;

	private static int[][] map;
	private static boolean[][] check;
	private static PriorityQueue<Cell> pq;
	
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[650][650];	// 300 + 50 + 300
			check = new boolean[650][650];
			pq = new PriorityQueue<>();
			
			// input
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[300 + i][300 + j] = Integer.parseInt(st.nextToken());
					if (map[300 + i][300 + j] != 0) {
						pq.offer(new Cell(300 + i, 300 + j, map[300 + i][300 + j], 0, 0));
						check[300 + i][300 + j] = true;
					}
				}
			}
			
			for (int time = 0; time < K; time++) {
				Queue<Cell> q = new LinkedList<>();
				
				while (!pq.isEmpty()) {
					Cell c = pq.poll();
					
					if (c.v == c.ba) {	// activated
						if (c.aa == 0) {
							for (int d = 0; d < dir.length; d++) {
								int ni = c.i + dir[d][0];
								int nj = c.j + dir[d][1];
								
								if (!check[ni][nj]) {
									q.offer(new Cell(ni, nj, c.v, 0, 0));
									check[ni][nj] = true;
								}
							}
						}
						
						c.aa++;
						if (c.v != c.aa)
							q.offer(c);
						
					} else {
						c.ba++;
						q.offer(c);
					}
				}
				
				while(!q.isEmpty()) {
					Cell c = q.poll();
					pq.offer(c);
				}
			}
			
			result[tc] = pq.size();
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
	}

	private static class Cell implements Comparable<Cell> {
		int i;
		int j;
		int v;	// vitality
		int ba;	// before activation
		int aa;	// after activation
//		boolean dead;
		
		public Cell(int i, int j, int v, int ba, int aa) {
			this.i = i;
			this.j = j;
			this.v = v;
			this.ba = ba;
			this.aa = aa;
		}

		@Override
		public int compareTo(Cell o) {
			return o.v - this.v;
		}
	}
	
}
