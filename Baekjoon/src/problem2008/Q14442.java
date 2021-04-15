package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14442 {
	static int N, M, K, map[][];
	static int result = -1;	// default : 통과 못했을 때
	
	// for bfs
	static Queue<Point> q;
	static boolean visited[][][];	// [벽을 몇개 부셨는지 여부][N][M]
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		q = new LinkedList<>();
		visited = new boolean[K + 1][N][M];	// K : 0 ~ K
		
		// input
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		System.out.println(result);
	}
	
	static void bfs(int i, int j) {
		visited[0][i][j] = true;
		q.offer(new Point(i, j, 1, 0));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.i == N - 1 && p.j == M - 1) {
				result = p.cnt;
				break;
			}
			
			for (int d = 0; d < dir.length; d++) {
				int ni = p.i + dir[d][0];
				int nj = p.j + dir[d][1];
				int c = p.cnt + 1;
				int b = p.broken;
				
				if (ni >= 0 && nj >= 0 && ni < N && nj < M) {
					if (b == K) {	// 벽을 부술 수 있는 기회를 다 썼을 때
						if (map[ni][nj] == 0 && !visited[b][ni][nj]) {
							visited[b][ni][nj] = true;
							q.offer(new Point(ni, nj, c, b));
						}
					} else {
						if (!visited[b][ni][nj]) {
							if (map[ni][nj] == 1)
								b++;
							visited[b][ni][nj] = true;
							q.offer(new Point(ni, nj, c, b));
						}
					}
				}
			}
		}
	}
	
	private static class Point {
		int i;
		int j;
		int cnt;	// move count
		int broken;	// break count
		
		public Point(int i, int j, int cnt, int broken) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.broken = broken;
		}
	}
}


/*

6 4 1
0100
1110
1000
0000
0111
0000

15

6 4 2
0100
1110
1000
0000
0111
0000

9

4 4 3
0111
1111
1111
1110

-1

*/
