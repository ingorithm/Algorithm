package problem2101;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2234 {
	private static int N, M;
	private static int cnt, maxSize, twoMaxSize;	// cnt : 방의 개수, maxSize : 가장 넓은 방, twoMaxSize : 가장 넓은 합친 방
	private static int[][] map, check;				// map : 벽의 정보를 담고있는 map, check : 각 구역의 방의 번호 + visited
	private static int[] roomSize;					// 각 방의 크기
	private static Queue<Point> q;
	
	private static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		check = new int[N][M];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		cnt = 0;
		q = new LinkedList<>();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (check[i][j] == 0) {
					cnt++;
					q.offer(new Point(i, j));
					check[i][j] = cnt;
					bfs(i, j);
				}
		
		roomSize = new int[cnt + 1];
		
		maxSize = scan1();
		twoMaxSize = scan2();
		
		System.out.println(cnt);
		System.out.println(maxSize);
		System.out.println(twoMaxSize == 0 ? maxSize : twoMaxSize);
		sc.close();
	}

	// check 배열을 채우는 BFS
	private static void bfs(int i, int j) {
		while (!q.isEmpty()) {
			Point p = q.poll();
			int d = map[p.i][p.j];
			
			if ((d & 1) == 0) {			// 서쪽
				int ni = p.i;
				int nj = p.j - 1;
				
				if (ni >= 0 && ni < N && nj >= 0 && nj < M)
					if (check[ni][nj] == 0) {
						check[ni][nj] = cnt;
						q.offer(new Point(ni, nj));
					}
			}
			
			if ((d >> 1 & 1) == 0) {	// 북쪽
				int ni = p.i - 1;
				int nj = p.j;
				
				if (ni >= 0 && ni < N && nj >= 0 && nj < M)
					if (check[ni][nj] == 0) {
						check[ni][nj] = cnt;
						q.offer(new Point(ni, nj));
					}
			}
			
			if ((d >> 2 & 1) == 0) {	// 동쪽
				int ni = p.i;
				int nj = p.j + 1;
				
				if (ni >= 0 && ni < N && nj >= 0 && nj < M)
					if (check[ni][nj] == 0) {
						check[ni][nj] = cnt;
						q.offer(new Point(ni, nj));
					}
			}
			
			if ((d >> 3 & 1) == 0) {	// 남쪽
				int ni = p.i + 1;
				int nj = p.j;
				
				if (ni >= 0 && ni < N && nj >= 0 && nj < M)
					if (check[ni][nj] == 0) {
						check[ni][nj] = cnt;
						q.offer(new Point(ni, nj));
					}
			}
		}
	}
	
	// roomSize 배열을 채우면서 최댓값을 return
	private static int scan1() {
		int ret = 0;
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				roomSize[check[i][j]]++;
		
		for (int i = 1; i <= cnt; i++)
			ret = Math.max(ret, roomSize[i]);
		return ret;
	}
	
	// 벽을 하나 허물었을 때의 최댓값을 return
	private static int scan2() {
		int ret = 0;
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M - 1; j++)
				if (check[i][j] != check[i][j + 1])
					ret = Math.max(ret, roomSize[check[i][j]] + roomSize[check[i][j + 1]]);
		
		for (int i = 0; i < N - 1; i++)
			for (int j = 0; j < M; j++)
				if (check[i][j] != check[i + 1][j])
					ret = Math.max(ret, roomSize[check[i][j]] + roomSize[check[i + 1][j]]);
		
		return ret;
	}
}
