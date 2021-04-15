package problem2008;	// P

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2178 {
	static int N, M, map[][], moveCnt = Integer.MAX_VALUE;
	static boolean isChecked[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		Queue<Node> q = new LinkedList<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isChecked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (int)str.charAt(j) - '0';
			}
		}
		
		q.offer(new Node(0, 0, 1));
		isChecked[0][0] = true;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.y == N - 1 && n.x == M - 1)
				moveCnt = n.d;
			
			for(int d = 0; d < dir.length; d++) {
				int ny = n.y + dir[d][0];
				int nx = n.x + dir[d][1];
				int nd = n.d + 1;
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < M)
					if (map[ny][nx] == 1 && isChecked[ny][nx] == false) {
						isChecked[ny][nx] = true;
						q.offer(new Node(ny, nx, nd));
					}
			}
		}
//		dfs(0, 0, 0);
		System.out.println(moveCnt);
	}
	
//	static void dfs(int i, int j, int m) {
//		m++;
//		isChecked[i][j] = true;
//		
//		if (i == N - 1 && j == M - 1) {
//			moveCnt = Math.min(moveCnt, m);
//			isChecked[i][j] = false;
//			return;
//		}
//		
//		for (int d = 0; d < dir.length; d++) {
//			int ni = i + dir[d][0];
//			int nj = j + dir[d][1];
//			
//			if (ni >= 0 && ni < N && nj >= 0 && nj < M)
//				if (map[ni][nj] == 1 && isChecked[ni][nj] == false)
//					dfs(ni, nj, m);
//		}
//		isChecked[i][j] = false;
//	}
	
	static class Node {
		int y;
		int x;
		int d;
		
		public Node(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
