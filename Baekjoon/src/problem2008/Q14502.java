package problem2008;	// P

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14502 {
	static int N, M, map[][], copyMap[][], result;
	static boolean isChecked[][];	// 불필요
	static final int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Queue<Pair> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copyMap = new int[N][M];
		isChecked = new boolean[N][M];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		// map을 보존하고 copyMap의 빈공간에 하나씩 벽을 놓고 시작
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 0) {
					copy(map, copyMap);
					copyMap[i][j] = 1;
					buildWall(1);
					copyMap[i][j] = 0;
				}
		
		System.out.println(result);
	}
	
	// map copy
	static void copy(int map[][], int copyMap[][]) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				copyMap[i][j] = map[i][j];
	}
	
	// 벽이 3개 될 때까지 배치하고 벽이 3개가 된다면 bfs()
	static void buildWall(int n) {
		if (n == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (copyMap[i][j] == 0) {
					copyMap[i][j] = 1;
					buildWall(n + 1);
					copyMap[i][j] = 0;
				}
	}
	
	// tempMap을 만들어 가스가 퍼져나가는 bfs
	static void bfs() {
		int temp[][] = new int[N][M];
		copy(copyMap, temp);
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				isChecked[i][j] = false;
				if (temp[i][j] == 2) {
					q.offer(new Pair(i, j));
					isChecked[i][j] = true;
				}
			}
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			
			for (int d = 0; d < dir.length; d++) {
				int ni = p.i + dir[d][0];
				int nj = p.j + dir[d][1];
				
				if (ni >= 0 && ni < N && nj >=0 && nj < M)
					if (temp[ni][nj] == 0 && isChecked[ni][nj] == false) {
						temp[ni][nj] = 2;
						isChecked[ni][nj] = true;
						q.offer(new Pair(ni, nj));
					}
			}
		}
		
		int count = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (temp[i][j] == 0)
					count++;
		result = Math.max(result, count);
	}
	
	static class Pair {
		int i;
		int j;
		
		public Pair(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
