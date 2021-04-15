package problem2102;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7562 {
	private static int testCase, result[];
	private static int N;
	private static Queue<Point> q;
	private static boolean[][] check;
	private static final int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	
	private static class Point {
		int i, j, cnt;

		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase];
		
		for (int tc = 0; tc < testCase; tc++) {
			N = sc.nextInt();
			q = new LinkedList<>();
			check = new boolean[N][N];
			
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			q.offer(new Point(startR, startC, 0));
			check[startR][startC] = true;
			
			int endR = sc.nextInt();
			int endC = sc.nextInt();
			
			while (!q.isEmpty()) {
				Point p = q.poll();
				
				if (p.i == endR && p.j == endC) {
					result[tc] = p.cnt;
					break;
				}
				
				for (int d = 0; d < dir.length; d++) {
					int ni = p.i + dir[d][0];
					int nj = p.j + dir[d][1];
					
					if (ni < 0 || ni >= N || nj < 0 || nj >= N)
						continue;
					
					if (!check[ni][nj]) {
						check[ni][nj] = true;
						q.offer(new Point(ni, nj, p.cnt + 1));
					}
				}
			}
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}

}
