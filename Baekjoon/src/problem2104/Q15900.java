package problem2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15900 {
	static int N;
	static ArrayList[] edges;
	static boolean[] check;
	static Queue<Node> q;
	
	static class Node {
		int num, cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N + 1];
		check = new boolean[N + 1];
		q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++)
			edges[i] = new ArrayList<>();
		
		for (int idx = 0; idx < N - 1; idx++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
		
		q.offer(new Node(1, 0));
		check[1] = true;
		
		int sum = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			boolean leaf = true;
			
			for (int i = 0; i < edges[cur.num].size(); i++) {
				int next = (int) edges[cur.num].get(i);
				if (check[next])
					continue;
				else {
					leaf = false;
					check[next] = true;
					q.offer(new Node(next, cur.cnt + 1));
				}
			}
			
			if (leaf)
				sum += cur.cnt % 2;
		}
		
		if (sum % 2 == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
