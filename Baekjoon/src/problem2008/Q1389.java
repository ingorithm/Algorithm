package problem2008;	// P

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1389 {
	static int N, M, cnt, result[];	// 케빈 베이컨 수, 결과값
	static boolean isChecked[], graph[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<People> q = new LinkedList<>();
		
		// input
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[N + 1];
		isChecked = new boolean[N + 1];
		graph = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		// vertex : 1 ~ N
		for (int i = 1; i <= N; i++) {
			// init
			cnt = 0;
			Arrays.fill(isChecked, false);
			isChecked[i] = true;
			
			for (int j = 1; j <= N; j++)
				if (graph[i][j] == true)
					q.offer(new People(i, 0));
			
			// bfs()
			while (!q.isEmpty()) {
				People p = q.poll();
				int v = p.vertex;
				int d = p.depth;
				cnt += d;
				
				d++;
				for (int next = 1; next <= N; next++)
					if (graph[v][next] == true && isChecked[next] == false) {
						isChecked[next] = true;
						q.offer(new People(next, d));
					}
			}
			result[i] = cnt;
		}
		
		// output
		int minIdx = 0;
		int minResult = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++)
			if (minResult > result[i]) {
				minResult = result[i];
				minIdx = i;
			}
		System.out.println(minIdx);
	}
	
	private static class People {
		int vertex;
		int depth;
		
		public People(int vertex, int depth) {
			this.vertex = vertex;
			this.depth = depth;
		}
	}
}
