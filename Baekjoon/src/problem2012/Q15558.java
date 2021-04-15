package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15558 {
	private static int N, K, result = 0;
	private static char[][] map;
	private static Queue<Point> q;
	private static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[2][];
		check = new boolean[2][N];
		q = new LinkedList<>();
		
		for (int i = 0; i < 2; i++)
			map[i] = br.readLine().toCharArray();
		
		q.offer(new Point(0, 0, 0));
		check[0][0] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.i >= N) {
				result = 1;
				break;
			}
			
			int ni = p.i, nl = p.l, nt = p.t + 1;
			
			// 한 칸 앞으로
			ni = p.i + 1;
			
			if (ni >= N) {
				result = 1;
				break;
			}
			
			if (!check[nl][ni] && map[nl][ni] == '1') {
				check[nl][ni] = true;
				q.offer(new Point(ni, nl, nt));
			}
			
			// 한 칸 뒤로
			ni = p.i - 1;
			if (ni >= 0 && !check[nl][ni] && map[nl][ni] == '1' && ni >= nt) {
				check[nl][ni] = true;
				q.offer(new Point(ni, nl, nt));
			}
			
			// 반대편으로
			ni = p.i + K;
			nl = (p.l == 0 ? 1 : 0);
			
			if (ni >= N) {
				result = 1;
				break;
			}
			
			if (!check[nl][ni] && map[nl][ni] == '1') {
				check[nl][ni] = true;
				q.offer(new Point(ni, nl, nt));
			}
		}
		
		System.out.println(result);
	}

	private static class Point {
		int i, l, t;	// index, line, time

		public Point(int i, int l, int t) {
			this.i = i;
			this.l = l;
			this.t = t;
		}
	}
}
