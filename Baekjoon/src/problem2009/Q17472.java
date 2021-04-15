package problem2009;

import java.util.Scanner;

public class Q17472 {
	private static int N, M, map[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		// 섬마다 번호 부여(bfs, dfs)
		// 
	}
	
}
