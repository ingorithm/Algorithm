package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<People> pq = new PriorityQueue<>();
		
		StringTokenizer st;
		int age;
		String name;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			age = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			pq.offer(new People(i, age, name));
		}
		
		for (int i = 0; i < N; i++) {
			People p = pq.poll();
			System.out.println(p.age + " " + p.name);
		}
	}
	
	static class People implements Comparable<People> {
		int no;
		int age;
		String name;
		
		public People(int no, int age, String name) {
			super();
			this.no = no;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(People o) {
			if (this.age == o.age)
				return this.no - o.no;
			return this.age - o.age;
		}
	}
}
