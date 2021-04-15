package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1946 {
	private static int testCase, result[];
	private static int N;
	private static PriorityQueue<Score> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine().trim());
		result = new int[testCase];
		
		for (int tc = 0; tc < testCase; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				pq.offer(new Score(f, s));
			}
			
			int min = Integer.MAX_VALUE;
			while (!pq.isEmpty()) {
				Score s = pq.poll();
				
				if (min > s.s) {
					min = s.s;
					result[tc]++;
				}
			}
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}

	private static class Score implements Comparable<Score> {
		int f;	// first
		int s;	// second
		
		@Override
		public int compareTo(Score o) {
			return this.f - o.f;
		}

		public Score(int f, int s) {
			this.f = f;
			this.s = s;
		}
	}
}
