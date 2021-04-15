package problem2104;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753 {
	private static int V, E;
	private static int[] dist;
	private static boolean[] check;
	private static PriorityQueue<Vertex> vertices;
	private static ArrayList<Edge>[] edges;
	private static final int INF = 999999;	// Integer.MAX_VALUE로 지정하면 나중에 더했을 때 정수 값을 넘어버림(아마도 V의 최댓값 * 10은 되어야할 듯)
	
	private static class Vertex implements Comparable<Vertex> {
		int num, dist;

		public Vertex(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.dist - o.dist;
		}
	}
	
	private static class Edge {
		int e, d;

		public Edge(int e, int d) {
			this.e = e;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V + 1];
		check = new boolean[V + 1];
		vertices = new PriorityQueue<>();
		edges = new ArrayList[V + 1];
		
		// input
		st = new StringTokenizer(br.readLine());
		int startVertex = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= V; i++)
			edges[i] = new ArrayList<>();
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edges[s].add(new Edge(e, d));
		}
		
		// initialization
		Arrays.fill(dist, INF);
		dist[startVertex] = 0;
		vertices.offer(new Vertex(startVertex, 0));
		
		while (!vertices.isEmpty()) {
			Vertex v = vertices.poll();
			int cur = v.num;	// 현재 Vertex
			
			if (check[cur])
				continue;
			check[cur] = true;
			
			// search
			for (Edge edge : edges[cur]) {
				int next = edge.e;		// 다음 Vertex
				int nextDist = edge.d;	// 다음 Vertex로 가는 가중치
				
				if (dist[next] > dist[cur] + nextDist) {
					dist[next] = dist[cur] + nextDist;
					vertices.offer(new Vertex(next, dist[next]));
				}
			}
		}
		
		// output
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
}
