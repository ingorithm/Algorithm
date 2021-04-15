package problem2009;	// P

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Point> result = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			result.offer(new Point(x, y));
		}
		
		for (int i = 0; i < N; i++) {
			Point p = result.poll();
			System.out.println(p.x + " " + p.y);
		}
	}
	
	private static class Point implements Comparable<Point>{
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}
}
