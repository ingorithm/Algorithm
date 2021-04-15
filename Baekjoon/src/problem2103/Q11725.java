package problem2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11725 {
	private static int N;
	private static int[] parent;
	private static boolean[] check;
	private static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		check = new boolean[N + 1];
		list = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		check[1] = true;
		dfs(1);

		for (int i = 2; i <= N; i++)
			System.out.println(parent[i]);
	}
	
	private static void dfs(int s) {
		for (int i = 0; i < list[s].size(); i++) {
			int e = list[s].get(i);
			
			if (check[e])
				continue;
			
			check[e] = true;
			parent[e] = s;
			dfs(e);
		}
	}
}
