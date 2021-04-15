package problem2009;	// P

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i = 1; i <= N; i++)
			q.offer(i);
		
		while (!q.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				int temp = q.poll();
				q.offer(temp);
			}
			result.add(q.poll());
		}
		
		System.out.print("<");
		for (int i = 0; i < N - 1; i++)
			System.out.print(result.get(i) + ", ");
		System.out.print(result.get(N - 1) + ">");
	}
}
