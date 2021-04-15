package problem2012;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> first = new PriorityQueue<>();
		PriorityQueue<Integer> second = new PriorityQueue<>(Collections.reverseOrder());
		
		// input
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			first.offer(temp);
		}
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			second.offer(temp);
		}
		
		int result = 0;
		while (!first.isEmpty()) {
			int f = first.poll();
			int s = second.poll();
			result += (f * s);
		}
		
		System.out.println(result);
	}
}
