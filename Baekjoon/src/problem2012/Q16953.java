package problem2012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16953 {
	private static long a, b, result = -1;
	private static Queue<Number> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		q = new LinkedList<>();
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		q.offer(new Number(a, 1));
		while (!q.isEmpty()) {
			Number number = q.poll();
			long n = number.num;
			long c = number.cnt;
			
			if (n == b) {
				result = c;
				break;
			} else if (n < b) {
				c++;
				q.offer(new Number(n * 2, c));
				q.offer(new Number(n * 10 + 1, c));
			}
		}
		
		System.out.println(result);
	}

	private static class Number {
		long num, cnt;

		public Number(long num, long cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
