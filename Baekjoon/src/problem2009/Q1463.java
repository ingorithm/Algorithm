package problem2009;

import java.util.Scanner;

public class Q1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] d = new int[x + 1];
		
		if (x == 1)
			System.out.println("0");
		else if (x == 2 || x == 3)
			System.out.println("1");
		else {
			d[1] = 0;
			d[2] = 1;
			d[3] = 1;
			
			for (int i = 4; i <= x; i++) {
				int first = i % 3 == 0 ? d[i / 3] + 1 : Integer.MAX_VALUE;
				int second = i % 2 == 0 ? d[i / 2] + 1 : Integer.MAX_VALUE;
				int third = d[i - 1] + 1;
				
				int cur = Math.min(first, second);
				cur = Math.min(cur, third);
				d[i] = cur;
			}
			System.out.println(d[x]);	
		}
		
	}

}
