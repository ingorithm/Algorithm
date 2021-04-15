package problem2008;	// P

import java.util.Scanner;

public class D2_1954 {
	static private int N, num, snail[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] result = new int[testCase + 1];
		
		// test case input
		for (int tc = 1; tc <= testCase; tc++)
			result[tc] = sc.nextInt();
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = result[tc];
			snail = new int[N][N];
			int x = 0, y = 0, dir = 1;
			
			N = result[tc];
			num = 1;
			search(x, y, dir);
			
			// output
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					System.out.print(snail[i][j] + " ");
				System.out.println("");
			}
		}
	}
	private static void search(int x, int y, int dir) {
		snail[x][y] = num;
//		System.out.println(num + " " + dir);
		num++;
		
		switch (dir) {
		case 1:	// right
			if (y + 1 < N && snail[x][y + 1] == 0)
				search(x, y + 1, dir);
			else if (x + 1 < N && snail[x + 1][y] == 0) {
				dir = 2;
				search(x + 1, y, dir);
			}
			break;
			
		case 2:	// down
			if (x + 1 < N && snail[x + 1][y] == 0)
				search(x + 1, y, dir);
			else if (y - 1 >= 0 && snail[x][y - 1] == 0) {
				dir = 3;
				search(x, y - 1, dir);
			}
			break;
			
		case 3:	// left
			if (y - 1 >= 0 && snail[x][y - 1] == 0)
				search(x, y - 1, dir);
			else if (x - 1 >= 0 && snail[x - 1][y] == 0) {
				dir = 4;
				search(x - 1, y, dir);
			}
			break;
			
		case 4:	// up
			if (x - 1 >= 0 && snail[x - 1][y] == 0)
				search(x - 1, y, dir);
			else if (y + 1 < N && snail[x][y + 1] == 0) {
				dir = 1;
				search(x, y + 1, dir);
			}
			break;
		}
	}
}
