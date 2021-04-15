package problem2008;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1043 {
	static int N, M, parent[];
	static List<Integer> party[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		parent = new int[N + 1];	// 0 true, 1 ~ N people
		party = new ArrayList[M];
		
		// parent & party array initialization
		for (int i = 1; i <= N; i++)
			parent[i] = 0;
		for (int i = 0; i < M; i++)
			party[i] = new ArrayList<>();
		
		// true-known people
		int truthPeopleNum = sc.nextInt();
//		for (int i = 0; i < sc.nextInt(); i++) {	// 아 이게 안되네
		for (int i = 0; i < truthPeopleNum; i++) {
			int truthPeople = sc.nextInt();
			parent[truthPeople] = truthPeople;
		}
		
		// party people input
		for (int i = 0; i < M; i++) {
			int partyPeopleNum = sc.nextInt();
			for (int j = 0; j < partyPeopleNum; j++) {
				int partyPeople = sc.nextInt();
				party[i].add(partyPeople);
			}
			if (party[i].size() >= 2) {	//	more than 2 people
				int first = party[i].get(0);
				for (int j = 1; j < party[i].size(); j++)
					union(first, party[i].get(j));
			}
		}
		
		// output
		int result = 0;
		for (int i = 0; i < M; i++) {
			boolean flag = true;
			for (int j = 0; j < party[i].size(); j++)
				if (parent[find(party[i].get(j))] == find(party[i].get(j)))	// exist truth
					flag = false;
			if (flag)
				result++;
		}
		System.out.println(result);
	}
	
	public static int find(int x) {
		if (parent[x] == 0 || parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX != rootY) {
			if (rootX == parent[rootX])
				parent[rootY] = rootX;
			else
				parent[rootX] = rootY;
		}
	}
}
