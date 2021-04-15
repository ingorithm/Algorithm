package problem2009;	// P

import java.util.Scanner;

public class Q18512 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input X, Y, H1, H2
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int H1 = sc.nextInt();
		int H2 = sc.nextInt();
		
		while (H1 < 10000 || H2 < 10000) {	// H1이나 H2가 10000을 넘어갈 때 whlie문을 나옴
			if (H1 == H2)	// 두 사람이 만났을 때 while문을 나옴
				break;
			
			if (H1 > H2) {	// H1이 더 크다면
				H2 += Y;	// H2가 앞으로 움직임
			} else {		// H2가 더 크다면
				H1 += X;	// H1이 앞으로 움직임
			}
		}
		
		int answer = Math.max(H1, H2);	// 두사람이 만났다면 만난지점  
		if (answer >= 10000)			// 두사람이 만나지 못했다면 -1
			answer = -1;
		
		// output answer
		System.out.println(answer);
	}
}
