package problem2008;	// P

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class D4_3124 {
	static int testCase, V, E, parents[];
	static Edge edge[];
	static long result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		
		for (int tc = 1; tc <= testCase; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			parents = new int[V + 1];
			edge = new Edge[E];
			
			for (int i = 1; i <= V; i++)
				parents[i] = i;
			
			for (int i = 0; i < E; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int w = sc.nextInt();
				edge[i] = new Edge(s, e, w);
			}
			
			Arrays.sort(edge, new Comparator<Edge>(){
				@Override
				public int compare(Edge o1, Edge o2) {
					return o1.weight - o2.weight;
				}
	        });
			
			int cnt = 0;
			result = 0;
			for (int i = 0; i < E; i++) {
				if (union(edge[i].start, edge[i].end)) {
					result += edge[i].weight;
					cnt++;
					if (cnt == V - 1)
						break;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int find(int num) {
		if (parents[num] == num)
			return num;
		else
			return parents[num] = find(parents[num]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB)
			return false;
		else {
			parents[rootB] = rootA;
			return true;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;
		
		Edge(int s, int e, int w) {
			start = s;
			end = e;
			weight = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
