package problem2009;

import java.util.Scanner;

public class Q10157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int r = sc.nextInt();
		int k = sc.nextInt();
		int map[][] = new int[r][c];
		final int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		if (k > r * c) {
			System.out.println("0");
			System.exit(0);
		}
		
		int i = 0, j = 0, d = 0, cnt = 1;
		map[i][j] = cnt;
		while (cnt < k) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			if (ni >= 0 && nj >= 0 && ni < r && nj < c && map[ni][nj] == 0) {
				i = ni;
				j = nj;
				cnt++;
				map[i][j] = cnt;
			} else {
				d = (d + 1) % 4;
				continue;
			}
		}
		System.out.println((j + 1) + " " + (i + 1));
	}

}
