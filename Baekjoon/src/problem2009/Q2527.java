package problem2009;

import java.util.Scanner;

public class Q2527 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Box[][] boxes = new Box[4][2];
		char[] answer = new char[4];
		
		for (int i = 0; i < 4; i++)	// line
			for (int j = 0; j < 2; j++) {	// box
				int x = sc.nextInt();
				int y = sc.nextInt();
				int p = sc.nextInt();
				int q = sc.nextInt();
				boxes[i][j] = new Box(x, y, p, q);
			}
		
		for (int i = 0; i < 4; i++) {
			int x1 = boxes[i][0].x;
			int y1 = boxes[i][0].y;
			int p1 = boxes[i][0].p;
			int q1 = boxes[i][0].q;
			int x2 = boxes[i][1].x;
			int y2 = boxes[i][1].y;
			int p2 = boxes[i][1].p;
			int q2 = boxes[i][1].q;
			
			if ((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) || (y1 == q2 && p1 == x2) || (y1 == q2 && x1 == p2))
	            answer[i] = 'c';
	        else if ((p1 == x2 && q1 != y2) || (x1 == p2 && q1 != y2) || (y1 == q2 && p1 != x2) || (y1 == q2 && x1 != p2))
	        	answer[i] = 'b';
	        else if (p1 < x2 || p2 < x1 || q1 < y2 || y1 > q2)
	        	answer[i] = 'd';
	        else
	        	answer[i] = 'a';
		}
			
		for (int i = 0; i < 4; i++)
			System.out.println(answer[i]);
		
	}
	
	private static class Box {
		int x;
		int y;
		int p;
		int q;
		
		public Box(int x, int y, int p, int q) {
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}

}
