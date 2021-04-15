package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1717 {
	private static int N, M;
	private static int[] parent;
//	private static List<String> result;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		sb = new StringBuilder();
		
		for (int i = 0; i <= N; i++)
			parent[i] = i;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (oper == 0)
				union(a, b);
			else
				findAnswer(a, b);
		}
		
		System.out.println(sb.toString());
	}
	
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		parent[rootB] = rootA;
	}
	
	private static int find(int a) {
		if (parent[a] == a)
			return a;
		
		return parent[a] = find(parent[a]);
	}
	
	private static void findAnswer(int a, int b) {
		if (find(a) == find(b))
			sb.append("YES\n");
		else
			sb.append("NO\n");
	}
}
