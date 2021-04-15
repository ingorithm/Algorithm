package problem2008;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1260 {
	static int N, M, V;
	static boolean gragh[][], isChecked[];
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		q = new LinkedList<>();
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		gragh = new boolean[N + 1][N + 1];
		isChecked = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			gragh[s][e] = true;
			gragh[e][s] = true;
		}
		
		isChecked[V] = true;
		dfs(V);
		System.out.println();
		
		Arrays.fill(isChecked, false);
		q.add(V);
		isChecked[V] = true;
		bfs();
	}
	
	static void dfs(int start) {
		System.out.print(start + " ");
		for (int i = 1; i <= N; i++)
			if (gragh[start][i] == true && isChecked[i] == false) {
				isChecked[i] = true;
				dfs(i);
			}
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			int start = q.poll();
			System.out.print(start + " ");
			for (int i = 1; i <= N; i++)
				if (gragh[start][i] == true && isChecked[i] == false) {
					isChecked[i] = true;
					q.offer(i);
				}
		}
	}
	
//	static class Pair {
//		int start;
//		int end;
//		
//		public Pair(int start, int end) {
//			super();
//			this.start = start;
//			this.end = end;
//		}
//	}
}
