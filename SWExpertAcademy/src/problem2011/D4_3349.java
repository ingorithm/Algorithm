package problem2011;

//import java.util.LinkedList;
//import java.util.Queue;
import java.util.Scanner;

public class D4_3349 {
	private static int testCase, result[];
	private static int W, H, N;
	private static Point[] cr;	// cross road
//	private static Queue<Point> q;
//	private static boolean check[][];
//	private static final int[][] dir = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			W = sc.nextInt();
			H = sc.nextInt();
			N = sc.nextInt();
			cr = new Point[N];
			
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				cr[i] = new Point(x, y);
			}
			
			if (N == 1)
				continue;
			
			for (int i = 1; i < N; i++)
				result[tc] += distance(cr[i - 1].x, cr[i - 1].y, cr[i].x, cr[i].y);
//				result[tc] += bfs(cr[i - 1].x, cr[i - 1].y, cr[i].x, cr[i].y);
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
		
		sc.close();
	}
	
	private static int distance(int i, int j, int m, int n) {
		int x = m - i;
		int y = n - j;
		
		if (x == 0)
			return Math.abs(y);
		else if (y == 0)
			return Math.abs(x);
		else if ((x > 0 && y > 0) || (x < 0 && y < 0))
			return Math.max(Math.abs(x), Math.abs(y));
		else if ((x > 0 && y < 0) || (x < 0 && y > 0))
			return Math.abs(x) + Math.abs(y);
		
		return 0;
	}
	
//	private static int bfs(int i, int j, int m, int n) {
//		int cnt = 0;
//		boolean flag = false;
//		q = new LinkedList<>();
//		check = new boolean[W + 1][H + 1];
//		
//		check[i][j] = true;
//		q.offer(new Point(i, j, 0));
//		while(!q.isEmpty()) {
//			Point p = q.poll();
//			
//			if (p.x == m && p.y == n) {
//				cnt = p.cnt;
//				flag = true;
//			}
//			
//			if (flag)
//				continue;
//			
//			for (int d = 0; d < dir.length; d++) {
//				int nx = p.x + dir[d][0];
//				int ny = p.y + dir[d][1];
//				
//				if (nx < 1 || nx > W || ny < 1 || ny > H)
//					continue;
//				
//				if (!check[nx][ny]) {
//					check[nx][ny] = true;
//					q.offer(new Point(nx, ny, p.cnt + 1));
//				}
//			}
//		}
//		
//		return cnt;
//	}
	
	private static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

//		public Point(int x, int y, int cnt) {
//			this.x = x;
//			this.y = y;
//			this.cnt = cnt;
//		}
	}
	
}
