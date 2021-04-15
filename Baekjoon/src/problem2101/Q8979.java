package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q8979 {
	private static int N, K;
	private static PriorityQueue<Country> pq;
	
	private static class Country implements Comparable<Country> {
		int num, g, s, b;	// gold, silver, bronze

		public Country(int num, int g, int s, int b) {
			this.num = num;
			this.g = g;
			this.s = s;
			this.b = b;
		}
		
		@Override
		public int compareTo(Country o) {
			if (this.g == o.g && this.s == o.s)
				return o.b - this.b;
			if (this.g == o.g)
				return o.s - this.s;
			return o.g - this.g;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.offer(new Country(num, g, s, b));
		}
		
		int curG = 0, curS = 0, curB = 0;
		int result = 0, cnt = 1;
		while (!pq.isEmpty()) {
			Country c = pq.poll();
			
			if (curG != c.g || curS != c.s || curB != c.b) {
				result = cnt;
				curG = c.g;
				curS = c.s;
				curB = c.b;
			}
			
			if (c.num == K)
				break;
			
			cnt++;
		}
		
		System.out.println(result);
	}

}
