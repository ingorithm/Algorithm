package problem2012;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q14235 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Gift> q = new PriorityQueue<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (num == 0) {
				if (q.isEmpty())
					result.add(-1);
				else {
					int temp = q.poll().price;
					result.add(temp);
				}
			} else
				for (int j = 0; j < num; j++) {
					int giftPrice = sc.nextInt();
					q.offer(new Gift(giftPrice));
				}
		}
		
		for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
	
	private static class Gift implements Comparable<Gift>{
		int price;

		public Gift(int price) {
			this.price = price;
		}

		@Override
		public int compareTo(Gift o) {
			return o.price - this.price;
		}
	}
}
