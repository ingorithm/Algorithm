package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 {
	private static int N, adj[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		adj = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				adj[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 0; k < N; k++)	// k : 거쳐가는 노드
            for (int i = 0; i < N; i++)	// i : 출발 노드
                for (int j = 0; j < N; j++)	// j : 도착 노드
                    if (adj[i][k] == 1 && adj[k][j] == 1)
                    	adj[i][j] = 1;
//					if (adj[i][j] > adj[i][k] + adj[k][j])
//						adj[i][j] = adj[i][k] + adj[k][j];
		
		print();
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(adj[i][j] + " ");
			System.out.println();
		}
	}
}
