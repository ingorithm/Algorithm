package problem2009;	// P

import java.util.Scanner;

public class Q10250 {
	static int testCase, H, W, N, result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		testCase = sc.nextInt();
		result = new int[testCase];
		
		for (int tc = 0; tc < testCase; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			int num = 0;
			
			if (N % H == 0) {
				num += H * 100;
				num += N / H;
			} else {
				num += (N % H) * 100;
				num += N / H + 1;
			}
			result[tc] = num;
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}
}

/* 

2
6 12 10
30 50 72

402
1203

10
2 10 2
2 10 4
2 10 6
2 10 8
2 10 10
2 10 12
2 10 14
2 10 16
2 10 18
2 10 20

201
202
203
204
205
206
207
208
209
210

*/