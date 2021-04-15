package problem2010;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q17471 {
	private static int N, people[], adj[][];
	private static boolean check[];
	private static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int[N + 1];
		adj = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++)
			people[i] = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				int target = sc.nextInt();
				adj[i][target] = 1;
			}
		}
		
		subset(1);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	private static void subset(int idx) {
		if (idx == N + 1) {
			if (check()) {
				int areaA = 0, areaB = 0;
				for (int i = 1; i <= N; i++)
					if (check[i])
						areaA += people[i];
					else
						areaB += people[i];
				result = Math.min(result, Math.abs(areaA - areaB));
			}
			return;
		}
		
		check[idx] = true;
		subset(idx + 1);
		check[idx] = false;
		subset(idx + 1);
	}
	
	private static boolean check() {
		boolean isOK = true;
		List<Integer> listA = new LinkedList<>();
		List<Integer> listB = new LinkedList<>();
		boolean[] include = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			if (check[i] == true)
				listA.add(i);
			else
				listB.add(i);
		}
		
		if (!listA.isEmpty()) {
			Queue<Integer> qA = new LinkedList<>();
			int first = listA.get(0);
			
			include[first] = true;
			qA.add(first);
			
			while (!qA.isEmpty()) {
				int cur = qA.poll();
				for (int i = 1; i <= N; i++)
					if (check[i] && !include[i] && adj[cur][i] == 1) {
						include[i] = true;
						qA.offer(i);
					}
			}
		}
		
		if (!listB.isEmpty()) {
			Queue<Integer> qB = new LinkedList<>();
			int first = listB.get(0);
			
			include[first] = true;
			qB.add(first);
			
			while (!qB.isEmpty()) {
				int cur = qB.poll();
				for (int i = 1; i <= N; i++)
					if (!check[i] && !include[i] && adj[cur][i] == 1) {
						include[i] = true;
						qB.offer(i);
					}
			}
		}
			
		for(int i = 1; i <= N; i++)
			if(!include[i])
				isOK = false;
		
		return isOK;
	}
}
