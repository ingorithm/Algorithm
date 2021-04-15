package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q4485 {
	private static int N;
	private static int[][] map, dijkstra;
	private static List<Integer> result;
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new ArrayList<>();
		
		while (true) {
			N = Integer.parseInt(br.readLine().trim());
			if (N == 0)
				break;
			
			map = new int[N][N];
			dijkstra = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dijkstra[i][j] = Integer.MAX_VALUE;
				}
			}
			
			result.add(dijkstra());
		}
		
		for (int i = 0; i < result.size(); i++)
			System.out.println("Problem " + (i + 1) + ": " + result.get(i));
	}
	
	private static int dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		dijkstra[0][0] = map[0][0];
		pq.offer(new Point(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Point p = pq.poll();

			for (int d = 0; d < dir.length; d++) {
				int nr = p.r + dir[d][0];
				int nc = p.c + dir[d][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				
				if (dijkstra[nr][nc] > dijkstra[p.r][p.c] + map[nr][nc]) {
					dijkstra[nr][nc] = dijkstra[p.r][p.c] + map[nr][nc];
					pq.offer(new Point(nr, nc, dijkstra[nr][nc]));
				}
			}
		}
		return dijkstra[N - 1][N - 1];
	}
	
	private static class Point implements Comparable<Point> {
		int r, c, cost;
		
		public Point(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}

}
