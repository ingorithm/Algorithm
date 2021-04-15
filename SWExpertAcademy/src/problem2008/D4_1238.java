package problem2008;	// P

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D4_1238 {
	static int testCase, N, start, result[];
	static boolean adj[][], isVisited[];
	static Queue<Node> q, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = 10;
		result = new int[testCase + 1];
		
		for(int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			start = sc.nextInt();
			adj = new boolean[101][101];
			isVisited = new boolean[101];
			q = new LinkedList<>();
			ans = new LinkedList<>();
			
			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adj[from][to] = true;
			}
			
			q.add(new Node(1, start));
			ans.add(new Node(1, start));
			isVisited[start] = true;
			
			int maxDepth = 0;
			while(!q.isEmpty()) {
				Node node = q.poll();
				int depth = node.depth;
				int index = node.index;
				
				for(int i = 1; i <= 100; i++) {
					if(adj[index][i] == true && isVisited[i] == false) {
						isVisited[i] = true;
						q.add(new Node(depth + 1, i));
						ans.add(new Node(depth + 1, i));
					}
				}
				maxDepth = Math.max(maxDepth, depth);
			}
			
			int maxValue = 0;
			while (!ans.isEmpty()) {
				Node node = ans.poll();
				int depth = node.depth;
				int index = node.index;
				
				if (maxDepth == depth)
					maxValue = Math.max(maxValue, index);
			}
			result[tc] = maxValue;
		}
		
		for(int tc = 1; tc <= testCase; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
	
	static class Node{
		int depth;
		int index;
		
		Node(int d, int i) {
			depth = d;
			index = i;
		}
	}
}

