package problem2008;	// P

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D3_1225 {
	private static int testCase, num, answer[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = 10;
		answer = new int[testCase + 1][8];
		
		// test case
		for (int tc = 1; tc <= testCase; tc++) {
			Queue<Integer> q = new LinkedList<Integer>();
			sc.nextInt();
			
			for (int i = 0; i < 8; i++)
				q.offer(sc.nextInt());
			
			num = 1;	// init
			while (num != 0) {
				for (int i = 1; i <= 5; i++) {
					num = q.poll();
					num -= i;
					if (num < 0)
						num = 0;
					q.offer(num);
					if (num == 0)
						break;
				}
			}
			
			for (int i = 0; i < 8; i++)
				answer[tc][i] = q.poll();
		}
		
		// output
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++)
				System.out.print(answer[tc][i] + " ");
			System.out.println();
		}
	}
}
