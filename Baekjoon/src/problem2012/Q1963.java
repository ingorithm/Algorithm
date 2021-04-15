package problem2012;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1963 {
	private static int testCase, result[];
	private static int start, end;
	private static boolean[] prime, check;
	private static Queue<Number> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new int[testCase];
		prime = new boolean[10000];
		
		eratos();
		
		for (int tc = 0; tc < testCase; tc++) {
			q = new LinkedList<>();
			check = new boolean[10000];

			start = sc.nextInt();
			end = sc.nextInt();
			result[tc] = Integer.MAX_VALUE;
			
			q.offer(new Number(start, 0));
			check[start] = true;
			while (!q.isEmpty()) {
				Number cur = q.poll();
				
				if (cur.num == end) {
					result[tc] = Math.min(result[tc], cur.c);
					continue;
				}
				
				// 1000
				for (int i = 1; i <= 9; i++) {
					int n = (cur.num % 1000) + (i * 1000);
					if (prime[n] && !check[n]) {
						check[n] = true;
						q.offer(new Number(n, cur.c + 1));
					}
				}
				
				// 100
				for (int i = 0; i <= 9; i++) {
					int n = (cur.num / 1000) * 1000 + (cur.num % 100) + (i * 100);
					if (prime[n] && !check[n]) {
						check[n] = true;
						q.offer(new Number(n, cur.c + 1));
					}
				}
				
				// 10
				for (int i = 0; i <= 9; i++) {
					int n = (cur.num / 100) * 100 + (cur.num % 10) + (i * 10);
					if (prime[n] && !check[n]) {
						check[n] = true;
						q.offer(new Number(n, cur.c + 1));
					}
				}
				
				// 1
				for (int i = 0; i <= 9; i++) {
					int n = (cur.num / 10) * 10 + i;
					if (prime[n] && !check[n]) {
						check[n] = true;
						q.offer(new Number(n, cur.c + 1));
					}
				}
			}
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc] == Integer.MAX_VALUE ? "Impossible" : result[tc]);
	}
	
	private static void eratos() {
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for (int i = 2; i * i <= 9999; i++)
			if (prime[i])
				for (int j = i * i; j <= 9999; j += i)
					prime[j] = false;
	}
	
	private static class Number {
		int num, c;	// changed

		public Number(int num, int c) {
			this.num = num;
			this.c = c;
		}
	}
}
