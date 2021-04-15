package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780 {
	static int N, paper[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Num n = cut(0, 0, N);
		System.out.println(n.minusOne);
		System.out.println(n.zero);
		System.out.println(n.one);
	}
	
	static Num cut(int i, int j, int n) {
		int minusOne = 0;
		int zero = 0;
		int one = 0;
		
		if (n == 3) {
			for (int r = i; r < i + n; r++)
				for (int c = j; c < j + n; c++) {
					if (paper[r][c] == -1)
						minusOne++;
					else if (paper[r][c] == 0)
						zero++;
					else if (paper[r][c] == 1)
						one++;
				}
		} else {
			for (int r = 0; r < 3; r++)
				for (int c = 0; c < 3; c++) {
					Num num = cut(i + r * n / 3, j + c * n / 3, n / 3);
					
					minusOne += num.minusOne;
					zero += num.zero;
					one += num.one;
				}
		}
		
		if (zero == 0 && one == 0)
			minusOne = 1;
		if (minusOne == 0 && one == 0)
			zero = 1;
		if (minusOne == 0 && zero == 0)
			one = 1;
		
		return new Num(minusOne, zero, one);
	}
	
	private static class Num {
		int minusOne;
		int zero;
		int one;
		
		public Num(int minusOne, int zero, int one) {
			this.minusOne = minusOne;
			this.zero = zero;
			this.one = one;
		}
	}
}
