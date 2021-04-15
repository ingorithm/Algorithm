package problem2008;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++)
			q.offer(i);
		
		while (q.size() > 1) {
			q.poll();
			int second = q.poll();
			q.offer(second);
		}
		
		System.out.println(q.poll());
	}
}
