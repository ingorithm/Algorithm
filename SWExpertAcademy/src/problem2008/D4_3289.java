package problem2008;	// P

import java.util.Scanner;

public class D4_3289 {
	static int testCase, N, M, parents[]; 
	static StringBuffer result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		
		// test case
		for (int tc = 1; tc <= testCase; tc++) {
			int op, first, second;
			N = sc.nextInt();
			M = sc.nextInt();
			parents = new int[N + 1];
			result = new StringBuffer();
			result.append("#" + tc + " ");
			for (int i = 1; i <= N; i++)
				parents[i] = i;
			
			for (int i = 1; i <= M; i++) {
				op = sc.nextInt();
				first = sc.nextInt();
				second = sc.nextInt();
				
				if (op == 0)
					union(first, second);
				else if (op == 1) {
					if (find(first) == find(second))
						result.append("1");
					else
						result.append("0");
				}
			}
			System.out.println(result);
		}
	}
	
	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a > b)
			parents[a] = b;
		else
			parents[b] = a;
	}
}
