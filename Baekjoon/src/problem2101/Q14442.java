package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 보통의 [조합 + BFS]로는 시간초과가 발생한다.
// 따라서 2차원의 check 배열이 아닌, 3차원의 check 배열을 사용한다.
// 벽을 부시는 모든 조합을 구하는 것이 아닌, (0, 0)에서부터 벽을 부시면서 가는 이유는 출발지에서부터 길을 뚫지 않으면 어차피 (N-1, M-1)에 도달하지 못하기 때문에 무의미한 연산이다.
public class Q14442 {
	private static int N, M, K, result = Integer.MAX_VALUE;
	private static int[][] map;
	
	// for BFS
	private static Queue<Point> q;
	private static boolean[][][] check;		// [row][col][broken], (row,col)에 벽을 몇 번(broken) 부신 채로 방문했는지 체크
	private static final int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	private static class Point {
		int i, j, b, cnt;	// row, col, 부신 벽 개수, 이동횟수

		public Point(int i, int j, int b, int cnt) {
			this.i = i;
			this.j = j;
			this.b = b;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<>();
		check = new boolean[N][M][K + 1];
		
		// input
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		
		// initialization
		q.offer(new Point(0, 0, 0, 1));
		check[0][0][0] = true;
		
		bfs();
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();	// Queue의 크기만큼 꺼내서 BFS
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				
				if (p.i == N - 1 && p.j == M - 1) {
					result = Math.min(result, p.cnt);
					continue;
				}
				
				for (int d = 0; d < dir.length; d++) {
					int ni = p.i + dir[d][0];
					int nj = p.j + dir[d][1];
					
					if (ni < 0 || ni >= N || nj < 0 || nj >= M)
						continue;
					
					if (map[ni][nj] == 0) {	// 벽이 아닐 때
						if (!check[ni][nj][p.b]) {
							check[ni][nj][p.b] = true;
							q.offer(new Point(ni, nj, p.b, p.cnt + 1));
						}
					} else {	// 벽일 때
						if (p.b == K)	// 이미 K개의 벽을 부셨을 때
							continue;
						
						if (!check[ni][nj][p.b + 1]) {
							check[ni][nj][p.b + 1] = true;
							q.offer(new Point(ni, nj, p.b + 1, p.cnt + 1));
						}
					}
				}
			}
		}
	}
}
