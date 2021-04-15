package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5643 {
	private static int testCase, result[];
	private static int N, M;
	private static boolean[][] forward, backward;
	private static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine().trim());
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			forward = new boolean[N + 1][N + 1];
			backward = new boolean[N + 1][N + 1];
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				forward[a][b] = true;
				backward[b][a] = true;
			}
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				Queue<Integer> q = new LinkedList<>();
				check = new boolean[N + 1];
				
				// forward
				q.offer(i);
				check[i] = true;
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int j = 1; j <= N; j++)
						if (forward[cur][j] == true && check[j] == false) {
							q.offer(j);
							check[j] = true;
						}
				}
				
				// backward
				q.offer(i);
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int j = 1; j <= N; j++)
						if (backward[cur][j] == true && check[j] == false) {
							q.offer(j);
							check[j] = true;
						}
				}
				
				// check
				boolean flag = true;
				for (int j = 1; j <= N; j++)
					if (check[j] == false)
						flag = false;
				if (flag)
					cnt++;
			}
			
			result[tc] = cnt;
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
	}

}
