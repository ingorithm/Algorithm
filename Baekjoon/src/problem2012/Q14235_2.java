package problem2012;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q14235_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder result = new StringBuilder();
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (num == 0) {
				if (pq.isEmpty())
					result.append("-1\n");
				else {
					int temp = pq.poll();
					result.append(temp + "\n");
				}
			} else
				for (int j = 0; j < num; j++) {
					int giftPrice = sc.nextInt();
					pq.offer(giftPrice);
				}
		}
		
		System.out.println(result);
	}
}
