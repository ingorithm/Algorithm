package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5212 {
	private static int R, C;
	private static char[][] map;
	private static boolean[][] change;
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		change = new boolean[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] == 'X')
					check(i, j);
		
		afterFifty();
		print();
	}
	
	private static void check(int i, int j) {
		int sea = 0;
		
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if (ni < 0 || ni >= R || nj < 0 || nj >= C) {
				sea++;
				continue;
			}
			
			if (map[ni][nj] == '.')
				sea++;
		}
		
		if (sea >= 3)
			change[i][j] = true;
	}
	
	private static void afterFifty() {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (change[i][j])
					map[i][j] = '.';
	}
	
	private static void print() {
		int up = 0, down = 0, left = 0, right = 0;
		
		uplimit:
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] == 'X') {
					up = i;
					break uplimit;
				}
		
		downlimit:
		for (int i = R - 1; i >= 0; i--)
			for (int j = 0; j < C; j++)
				if (map[i][j] == 'X') {
					down = i;
					break downlimit;
				}
				
		leftlimit:
		for (int j = 0; j < C; j++)
			for (int i = 0; i < R; i++)
				if (map[i][j] == 'X') {
					left = j;
					break leftlimit;
				}
		
		rightlimit:
		for (int j = C - 1; j >= 0; j--)
			for (int i = 0; i < R; i++)
				if (map[i][j] == 'X') {
					right = j;
					break rightlimit;
				}
		
		for (int i = up; i <= down; i++) {
			for (int j = left; j <= right; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
}
