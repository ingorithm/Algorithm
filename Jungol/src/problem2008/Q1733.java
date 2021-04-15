package problem2008;	// P

import java.util.Scanner;

public class Q1733 {
	static int stone, map[][];
	static int dir[][] = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[20][20];
		
		for (int i = 1; i <= 19; i++)
			for (int j = 1; j <= 19; j++)
				map[i][j] = sc.nextInt();
		
		for (int i = 1; i <= 19; i++)
			for (int j = 1; j <= 19; j++) {
				if (map[i][j] == 1 || map[i][j] == 2) {
					stone = map[i][j];
					if ((search(i, j, 0, 1) && isPrev(i, j, 0)) || (search(i, j, 1, 1) && isPrev(i, j, 1)) ||
							(search(i, j, 2, 1) && isPrev(i, j, 2)) || (search(i, j, 3, 1) && isPrev(i, j, 3))) {
						System.out.println(stone);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		System.out.println(0);
	}
	
	static boolean search(int i, int j, int d, int num) {
		boolean result = false;
		int ni = i + dir[d][0];
		int nj = j + dir[d][1];
		
		if (num == 5) {
			if (ni > 0 && nj > 0 && ni < 20 && nj < 20)
				if (map[ni][nj] != stone)
					return true;
			if (ni <= 0 || nj <= 0 || ni >= 20 || nj >= 20)
				return true;
		}
		
		if (ni > 0 && nj > 0 && ni < 20 && nj < 20)
			if (map[ni][nj] == stone)
				result = search(ni, nj, d, num + 1);
		
		return result;
	}
	
	static boolean isPrev(int i, int j, int d) {
		int pi = i - dir[d][0];
		int pj = j - dir[d][1];
		
		if (pi > 0 && pj > 0 && pi < 20 && pj < 20)
			if (map[i][j] == map[pi][pj])
				return false;
		
		return true;
	}
}

