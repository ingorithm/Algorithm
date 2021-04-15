package problem2101;

import java.util.Arrays;
import java.util.Scanner;

public class Q2503 {
	private static int N, result;
	private static int[][] questions;	// number, strike, ball
	private static boolean[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		questions = new int[N][3];
		numbers = new boolean[1000];
		Arrays.fill(numbers, true);
		
		// input
		for (int i = 0; i < N; i++) {
			questions[i][0] = sc.nextInt();
			questions[i][1] = sc.nextInt();
			questions[i][2] = sc.nextInt();
		}
		
		// initialization
		for (int i = 123; i <= 987; i++) {
			int h = i / 100;		// hundred
			int t = (i / 10) % 10;	// ten
			int o = i % 10;			// one
			
			if (h == 0 || t == 0 || o == 0)
				numbers[i] = false;
			
			if (h == t || h == o || t == o)
				numbers[i] = false;
		}

		for (int i = 123; i <= 987; i++) {
			if (!numbers[i])
				continue;
			
			for (int j = 0; j < N; j++) {
				int s = 0, b = 0;

				// current i
				int h = i / 100;
				int t = (i / 10) % 10;
				int o = i % 10;
				
				// target
				int th = questions[j][0] / 100;
				int tt = (questions[j][0] / 10) % 10;
				int to = questions[j][0] % 10;
				
				if (h == th)
					s++;
				if (t == tt)
					s++;
				if (o == to)
					s++;
				
				if (h == tt || h == to)
					b++;
				if (t == th || t == to)
					b++;
				if (o == th || o == tt)
					b++;
				
				if (s != questions[j][1] || b != questions[j][2])
					numbers[i] = false;
			}
		}
		
		for (int i = 123; i <= 987; i++)
			if (numbers[i])
				result++;
		System.out.println(result);
	}
}
