package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
	static int M, N, H, box[][][], result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<Pair> q = new LinkedList<>();
		
		int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1)
						q.offer(new Pair(i, j, k));
				}
			}
		}
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int z = p.z, y = p.y, x = p.x;
			
			for(int i = 0; i < dir.length; i++) {
				int nz = z + dir[i][0];
				int ny = y + dir[i][1];
				int nx = x + dir[i][2];
				
				if( nz < 0 || ny < 0 || nx < 0 ||
						nz >= H || ny >= N || nx >= M) continue;
				
				if( box[nz][ny][nx] == 0 ) {
					box[nz][ny][nx] = box[z][y][x] + 1;	// 하루가 지난 토마토는 2, 3, .. 으로 마킹
					q.offer(new Pair(nz, ny, nx));
				}
			}
		}
		
		result = 0;
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(box[i][j][k] == 0) {
						System.out.println("-1");
						return;
					}
					result = Math.max(result, box[i][j][k]);
				}
			}
		}
		System.out.println(--result);
		
	}
	
	static class Pair {
		private int z;
		private int y;
		private int x;
		Pair(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}

