package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1922 {
	static int N, M, result;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (s != e)
				pq.offer(new Edge(s, e, d));
		}
		
		init();
		
		int cnt = 1;
		while (true) {
			Edge edge = pq.poll();
			
			if (union(edge.s, edge.e)) {
				cnt++;
				result += edge.d;
			}
			
			if(cnt == N)
				break;
		}
		System.out.println(result);
	}
	
	static void init() {
		for (int i = 1; i <= N; i++)
			parent[i] = i;
	}
	
	static int find(int a) {
		if (parent[a] == a)
			return a;
		
		parent[a] = find(parent[a]);
		return parent[a];
	}

	static boolean union(int a, int b) {
		int rA = find(a);
		int rB = find(b);
		
		if (rA == rB)
			return false;
		
		parent[rA] = rB;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		int s, e, d;

		public Edge(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return this.d - o.d;
		}
	}
}
