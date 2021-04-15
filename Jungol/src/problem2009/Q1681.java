package problem2009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1681 {
	static int N, graph[][], result = Integer.MAX_VALUE;
	static boolean visited[];
	static int selected[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];	// directed graph
		visited = new boolean[N];
		selected = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				graph[i][j] = Integer.parseInt(st.nextToken());
		}
		
		visited[0] = true;
		perm(0);
		System.out.println(result);
	}

	private static void perm(int cnt) {
		if (cnt == N - 1) {	// 회사 제외
			if (graph[selected[cnt - 1]][0] == 0)
				return;
			
			int res = graph[0][selected[0]];
			for (int i = 1; i < cnt; i++) {
				res += graph[selected[i - 1]][selected[i]];
			}
			res += graph[selected[cnt - 1]][0];
			
			result = Math.min(result, res);
			return;
		}
		
		for (int i = 1; i < N; i++)
			if (!visited[i]) {
				if (cnt == 0 && graph[0][i] == 0)
					continue;
				if (cnt > 0 && graph[selected[cnt - 1]][i] == 0)
					continue;
				selected[cnt] = i;
				visited[i] = true;
				perm(cnt + 1);
				visited[i] = false;
			}
	}
}
