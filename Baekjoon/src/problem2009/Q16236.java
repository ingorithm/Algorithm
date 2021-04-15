package problem2009;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16236 {
	private static int N, map[][];
	private static boolean visited[][];
	private final static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static Queue<Shark> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		q = new LinkedList<>();
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					q.offer(new Shark(i, j, 2, 0));
					map[i][j] = 0;
				}
			}
		
		while (true) {
			ArrayList<Shark> list = new ArrayList<>();
			Shark s = q.poll();
			int pi = s.i, pj = s.j, size = s.size, ate = s.ate;
			
			initVisited();
			for (int d = 0; d < dir.length; d++) {
				int ni = s.i + dir[d][0];
				int nj = s.j + dir[d][1];
				
				if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
				if (!visited[ni][nj] && map[ni][nj] < size) {
					visited[ni][nj] = true;
					q.offer(new Shark(ni, nj, size, ate));
					list.add(new Shark(ni, nj, 0, 0));
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				
			}
		}
	}
	
	private static void initVisited() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				visited[i][j] = false;
	}
	
	private static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	private static class Shark {
		int i;
		int j;
		int size;
		int ate;
		
		public Shark(int i, int j, int size, int ate) {
			this.i = i;
			this.j = j;
			this.size = size;
			this.ate = ate;
		}
	}
}
