package problem2008;	// P

import java.util.Scanner;

public class D4_1210 {
	static int N = 100, answer = 0, ladder[][] = new int[N][N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[11];
		
		// test case
		for (int tc = 0; tc < 10; tc++) {
			int testCase = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ladder[i][j] = sc.nextInt();
					if (ladder[i][j] == 2) answer = j;
				}
			}
			for (int i = N - 1; i > 0; i--) {
				int dir = getDirection(ladder, i, answer);
				switch (dir) {
				case 0:	// up
					break;
				case 1:	// left
					while(answer - 1 >= 0 && ladder[i][answer - 1] == 1) {
						answer--;
					}
					break;
				case 2:	// right
					while(answer + 1 <= N - 1 && ladder[i][answer + 1] == 1) {
						answer++;
					}
					break;
				}
			}
			result[testCase] = answer;
		}
		
		// output
		for (int tc = 1; tc <= 10; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
	private static int getDirection(int[][] ladder, int x, int y) {
		if (y - 1 >= 0 && ladder[x][y - 1] == 1)
			return 1;
		else if (y + 1 <= N - 1 && ladder[x][y + 1] == 1)
			return 2;
		else
			return 0;
	}
}
