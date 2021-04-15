package problem2012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Q4386 {
	private static int N;
	private static int[] parent;
	private static double[][] stars;
	private static List<Edge> edges;
	private static double result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parent = new int[N + 1];
		stars = new double[N + 1][2];
		edges = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			stars[i][0] = sc.nextDouble();
			stars[i][1] = sc.nextDouble();
		}
		
		for (int i = 1; i <= N - 1; i++)
			for (int j = i + 1; j <= N; j++)
				edges.add(new Edge(i, j, dist(stars[i][0], stars[i][1], stars[j][0], stars[j][1])));
		
		for (int i = 0; i < N; i++)
			parent[i] = i;
		
        Collections.sort(edges, new Comparator<Edge>(){
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.dist, o2.dist);
			}
        });
		
		int cnt = 0;
		for (Edge e : edges) {
			if (union(e.s, e.e)) {
				result += e.dist;
				cnt++;
				if (cnt == N - 1)
					break;
			}
		}
		
		System.out.println(result);
		sc.close();
	}
	
	private static double dist(double x1, double y1, double x2, double y2) {
		double x = Math.abs(x1 - x2);
		double y = Math.abs(y1 - y2);
		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			parent[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	
	private static class Edge {
		int s;
		int e;
		double dist;
		
		public Edge(int s, int e, double dist) {
			this.s = s;
			this.e = e;
			this.dist = dist;
		}
	}
}
