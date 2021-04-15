package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11000 {
	private static int N;
	private static PriorityQueue<Class> pq;
	private static PriorityQueue<Integer> list;
	
	private static class Class implements Comparable<Class> {
		int s, e;

		public Class(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Class o) {
			if (this.s == o.s)
				return this.e - o.e;
			return this.s - o.s;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		list = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Class(start, end));
		}
		
		while (!pq.isEmpty()) {
			Class c = pq.poll();
			
			if (list.isEmpty()) {
				list.offer(c.e);
				continue;
			}
			
			int num = list.poll();
			if (num > c.s)
				list.offer(num);
			list.offer(c.e);
		}
		
		System.out.println(list.size());
	}

}
