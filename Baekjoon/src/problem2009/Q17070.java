package problem2009;

import java.util.Scanner;

public class Q17070 {
	static int N, map[][], answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		
		dfs(0, 1, 0);
		System.out.println(answer);
	}

	private static void dfs(int i, int j, int d) {
		if (i == N - 1 && j == N - 1)
			answer++;
		
		switch (d) {
		case 0:	// horizontal
			if (j + 1 < N && map[i][j + 1] == 0)
				dfs(i, j + 1, 0);
			if (i + 1 < N && j + 1 < N &&
					map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0)
				dfs(i + 1, j + 1, 1);
			break;
		case 1:	// diagonal
			if (j + 1 < N && map[i][j + 1] == 0)
				dfs(i, j + 1, 0);
			if (i + 1 < N && j + 1 < N &&
					map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0)
				dfs(i + 1, j + 1, 1);
			if (i + 1 < N && map[i + 1][j] == 0)
				dfs(i + 1, j, 2);
			break;
		case 2:	// vertical
			if (i + 1 < N && j + 1 < N &&
					map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0)
				dfs(i + 1, j + 1, 1);
			if (i + 1 < N && map[i + 1][j] == 0)
				dfs(i + 1, j, 2);
			break;
		}
	}
}

