package problem2012;

import java.util.Scanner;

public class D3_4615 {
	private static int testCase, result[][];
	private static int N, M, board[][];
	private static final int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase + 1][2];
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			init(N);
			
			for (int i = 0; i < M; i++) {
				int c = sc.nextInt() - 1;
				int r = sc.nextInt() - 1;
				int s = sc.nextInt();
				
				board[r][c] = s;
				
				for (int d = 0; d < dir.length; d++) {
					int nr = r + dir[d][0];
					int nc = c + dir[d][1];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					
					if (board[nr][nc] != 0 && board[nr][nc] != s) {
						switch (d) {
						case 0:
							up(nr, nc, s);
							break;
						case 1:
							upRight(nr, nc, s);
							break;
						case 2:
							right(nr, nc, s);
							break;
						case 3:
							downRight(nr, nc, s);
							break;
						case 4:
							down(nr, nc, s);
							break;
						case 5:
							downLeft(nr, nc, s);
							break;
						case 6:
							left(nr, nc, s);
							break;
						case 7:
							upLeft(nr, nc, s);
							break;
						}
					}
				}
			}
			
			count(tc);
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc][0] + " " + result[tc][1]);
	}
	
	private static void init(int n) {
		int w = n / 2;
		board = new int[n][n];
		
		board[w][w] = 2;
		board[w - 1][w] = 1;
		board[w][w - 1] = 1;
		board[w - 1][w - 1] = 2;
	}
	
	private static boolean up(int i, int j, int s) {
		if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
			return false;
		
		if (board[i][j] == s)
			return true;
		
		if (up(i + dir[0][0], j + dir[0][1], s)) {
			board[i][j] = s;
			return true;
		}
		
		return false;
	}
	
	private static boolean upRight(int i, int j, int s) {
		if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
			return false;
		
		if (board[i][j] == s)
			return true;
		
		if (upRight(i + dir[1][0], j + dir[1][1], s)) {
			board[i][j] = s;
			return true;
		}
		
		return false;
	}
	
	private static boolean right(int i, int j, int s) {
		if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
			return false;
		
		if (board[i][j] == s)
			return true;
		
		if (right(i + dir[2][0], j + dir[2][1], s)) {
			board[i][j] = s;
			return true;
		}
		
		return false;
	}
	
	private static boolean downRight(int i, int j, int s) {
		if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
			return false;
		
		if (board[i][j] == s)
			return true;
		
		if (downRight(i + dir[3][0], j + dir[3][1], s)) {
			board[i][j] = s;
			return true;
		}
		
		return false;
	}
	
	private static boolean down(int i, int j, int s) {
		if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
			return false;
		
		if (board[i][j] == s)
			return true;
		
		if (down(i + dir[4][0], j + dir[4][1], s)) {
			board[i][j] = s;
			return true;
		}
		
		return false;
	}
	
	private static boolean downLeft(int i, int j, int s) {
		if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
			return false;
		
		if (board[i][j] == s)
			return true;
		
		if (downLeft(i + dir[5][0], j + dir[5][1], s)) {
			board[i][j] = s;
			return true;
		}
		
		return false;
	}
	
	private static boolean left(int i, int j, int s) {
		if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
			return false;
		
		if (board[i][j] == s)
			return true;
		
		if (left(i + dir[6][0], j + dir[6][1], s)) {
			board[i][j] = s;
			return true;
		}
		
		return false;
	}
	
	private static boolean upLeft(int i, int j, int s) {
		if (i < 0 || i >= N || j < 0 || j >= N || board[i][j] == 0)
			return false;
		
		if (board[i][j] == s)
			return true;
		
		if (upLeft(i + dir[7][0], j + dir[7][1], s)) {
			board[i][j] = s;
			return true;
		}
		
		return false;
	}
	
	private static void count(int tc) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1)
					result[tc][0]++;
				else if (board[i][j] == 2)
					result[tc][1]++;
			}
	}
}
