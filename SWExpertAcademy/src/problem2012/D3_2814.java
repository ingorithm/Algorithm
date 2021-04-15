package problem2012;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 최장거리
public class D3_2814 {
	private static int N; // 정점의 수
	private static int M; // 간선의 수
	private static List<Integer>[] adj;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			adj = new LinkedList[N + 1];

			for (int i = 1; i <= N; i++)
				adj[i] = new LinkedList<>();
			visited = new boolean[N + 1];

			// 간선 정보(무향(양방향)그래프)를 입력받자...
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}

			ans = 0;
			// 모든 정점에서부터 출발해보자.
			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				solve(i, 1);
				visited[i] = false;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static int ans;

	// 상태공간트리의 각 상태는 어느 정점에 몇번 밟고 왔는지.
	static void solve(int v, int cnt) {
		ans = Math.max(ans, cnt);
		// v와 연결된 정점들에 대해서
		for (int nV : adj[v]) {
			// 이미 경로 중 방문한 정점이라면 패스.
			if (visited[nV])
				continue;
			// 아니라면. 방문체크하고
			visited[nV] = true;
			// 해당 정점으로 이동했다가(상태전이)
			solve(nV, cnt + 1);
			// 다시 원복.
			visited[nV] = false;
		}
	}
}
