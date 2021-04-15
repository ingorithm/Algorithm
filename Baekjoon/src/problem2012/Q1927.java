package problem2012;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder result = new StringBuilder();
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (num == 0) {
				if (pq.isEmpty())
					result.append("0\n");
				else {
					int temp = pq.poll();
					result.append(temp + "\n");
				}
			} else
				pq.offer(num);
		}
		
		System.out.println(result);
	}
}
