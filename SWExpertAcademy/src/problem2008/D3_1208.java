package problem2008;	// P

import java.util.Arrays;
import java.util.Scanner;

public class D3_1208 {
	static int N = 100, testCase = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result = new int[testCase + 1];
		
		// test case
		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int[] boxes = new int[N];
			
			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				boxes[i] = temp;
			}
			
			int high = N - 1, low = 0;
			for (int i = 0; i < dump; i++) {
				Arrays.sort(boxes);
				boxes[high]--;
				boxes[low]++;
			}
			Arrays.sort(boxes);
			result[tc] = boxes[high] - boxes[low];
		}
		
		// output
		for (int tc = 1; tc <= 10; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
}
