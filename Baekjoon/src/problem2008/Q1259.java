package problem2008;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Boolean> result = new LinkedList<>();
		
		while (true) {
			String s = sc.nextLine();
			int head = 0;
			int tail = s.length() - 1;
			boolean isPalindrome = true;

			if (s.equals("0"))
				break;
			
			while (head < tail) {
				if (s.charAt(head) == s.charAt(tail)) {
					head++;
					tail--;
				}
				else {
					isPalindrome = false;
					break;
				}
			}
			
			if (isPalindrome)
				result.offer(true);
			else
				result.offer(false);
		}
		
		while(!result.isEmpty())
			if (result.poll())
				System.out.println("yes");
			else
				System.out.println("no");
	}
}
