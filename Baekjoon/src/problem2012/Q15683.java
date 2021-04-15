package problem2012;

import java.util.ArrayList;
import java.util.Scanner;

public class Q15683 {
	private static int N, M, cNum, result = Integer.MAX_VALUE;	// cNum : total camera number
	private static int[][] map;
	private static boolean[][] check;
	private static ArrayList<Point> cameras;
	private static Point[] selected;	// for Combination
	
	private static class Point {
		int i, j, c, d;	// i, j, camera, direction

		// for ArrayList cameras
		public Point(int i, int j, int c) {
			this.i = i;
			this.j = j;
			this.c = c;
		}

		// for Point[] selected
		public Point(int i, int j, int c, int d) {
			this.i = i;
			this.j = j;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) {
		// no BufferedReader : 1 <= N, M <= 8 / initialization
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cameras = new ArrayList<>();
		
		// initialization
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				if (temp == 1 || temp == 2 || temp == 3 || temp == 4 || temp == 5)
					cameras.add(new Point(i, j, temp));
			}
		
		cNum = cameras.size();
		selected = new Point[cNum];
		comb(0);
		
		System.out.println(result);
		sc.close();
	}
	
	// for Combination
	private static void comb(int cnt) {
		if (cnt == cNum) {
			check = new boolean[N][M];
			for (int i = 0; i < cNum; i++)
				scan(selected[i]);
			
			result = Math.min(result, count());
			return;
		}
		
		// current camera number
		int curI = cameras.get(cnt).i;
		int curJ = cameras.get(cnt).j;
		int curC = cameras.get(cnt).c;
		
		switch (curC) {
		case 1: case 3: case 4:
			for (int i = 1; i <= 4; i++) {
				selected[cnt] = new Point(curI, curJ, curC, i);
				comb(cnt + 1);
			}
			break;
		case 2:
			for (int i = 1; i <= 2; i++) {
				selected[cnt] = new Point(curI, curJ, curC, i);
				comb(cnt + 1);
			}
			break;
		case 5:
			selected[cnt] = new Point(curI, curJ, curC, 1);
			comb(cnt + 1);
			break;
		}
	}
	
	// for check camera's scan area
	private static void scan(Point p) {
		switch (p.c) {
		case 1:
			if (p.d == 1)
				scanUp(p.i, p.j);
			else if (p.d == 2)
				scanDown(p.i, p.j);
			else if (p.d == 3)
				scanLeft(p.i, p.j);
			else if (p.d == 4)
				scanRight(p.i, p.j);
			break;
		case 2:
			if (p.d == 1) {
				scanUp(p.i, p.j);
				scanDown(p.i, p.j);
			} else if (p.d == 2) {
				scanLeft(p.i, p.j);
				scanRight(p.i, p.j);
			}
			break;
		case 3:
			if (p.d == 1) {
				scanUp(p.i, p.j);
				scanRight(p.i, p.j);
			} else if (p.d == 2) {
				scanRight(p.i, p.j);
				scanDown(p.i, p.j);
			} else if (p.d == 3) {
				scanDown(p.i, p.j);
				scanLeft(p.i, p.j);
			} else if (p.d == 4) {
				scanLeft(p.i, p.j);
				scanUp(p.i, p.j);
			}
			break;
		case 4:
			if (p.d == 1) {
				scanUp(p.i, p.j);
				scanRight(p.i, p.j);
				scanDown(p.i, p.j);
			} else if (p.d == 2) {
				scanRight(p.i, p.j);
				scanDown(p.i, p.j);
				scanLeft(p.i, p.j);
			} else if (p.d == 3) {
				scanDown(p.i, p.j);
				scanLeft(p.i, p.j);
				scanUp(p.i, p.j);
			} else if (p.d == 4) {
				scanLeft(p.i, p.j);
				scanUp(p.i, p.j);
				scanRight(p.i, p.j);
			}
			break;
		case 5:
			scanUp(p.i, p.j);
			scanDown(p.i, p.j);
			scanLeft(p.i, p.j);
			scanRight(p.i, p.j);
			break;
		}
	}
	
	private static void scanUp(int i, int j) {
		while (i >= 0) {
			check[i][j] = true;
			if (map[i][j] == 6)
				break;
			i--;
		}
	}
	
	private static void scanDown(int i, int j) {
		while (i < N) {
			check[i][j] = true;
			if (map[i][j] == 6)
				break;
			i++;
		}
	}
	
	private static void scanLeft(int i, int j) {
		while (j >= 0) {
			check[i][j] = true;
			if (map[i][j] == 6)
				break;
			j--;
		}
	}
	
	private static void scanRight(int i, int j) {
		while (j < M) {
			check[i][j] = true;
			if (map[i][j] == 6)
				break;
			j++;
		}
	}
	
	// for check blind spot
	private static int count() {
		int ret = N * M;
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (check[i][j] || map[i][j] == 6)
					ret--;
		
		return ret;
	}
}
