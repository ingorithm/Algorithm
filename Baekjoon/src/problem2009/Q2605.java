package problem2009;

import java.util.Scanner;
import java.util.Stack;

public class Q2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] number = new int[n];
		Stack<Integer> s = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		
		for (int i = 0; i < n; i++)
			number[i] = sc.nextInt();
		
		int t = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < number[i]; j++) {
				t = s.pop();
				temp.push(t);
			}
			s.push(i + 1);
			for (int j = 0; j < number[i]; j++) {
				t = temp.pop();
				s.push(t);
			}
		}

		while (!s.isEmpty()) {
			t = s.pop();
			temp.push(t);
		}

		while (!temp.isEmpty())
			System.out.print(temp.pop() + " ");
	}
}
