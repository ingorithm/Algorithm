package problem2012;

import java.util.Scanner;

public class Q1719 {
	private static int N, M, adj[][], result[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adj = new int[N + 1][N + 1];
		result = new int[N + 1][N + 1];
		
		// initialization
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				if (i == j)
					adj[i][j] = 0;
				else
					adj[i][j] = 10000;
		
		// input
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int dist = sc.nextInt();
			
			adj[a][b] = dist;
			adj[b][a] = dist;
			
			result[a][b] = b;
			result[b][a] = a;
		}
		
		// Floyd Warshall
		for (int k = 1; k <= N; k++)
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					if (adj[i][j] > adj[i][k] + adj[k][j]) {
						adj[i][j] = adj[i][k] + adj[k][j];
						result[i][j] = result[i][k];
					}
		
		// output
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					System.out.print("- ");
				else
					System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
