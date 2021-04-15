package problem2012;

import java.util.Scanner;

public class Q5904 {
	private static int N, s[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		s = new int[29];
		
		s[0] = 3;
		for (int i = 1; i <= 28; i++)
			s[i] = s[i - 1] * 2 + i + 3;
		
		dfs(N);
	}
	
	private static void dfs(int n) {
		int idx = 0;
		
		if (n <= 10) {
			if (n == 1 || n == 4 || n == 8)
				System.out.println("m");
			else
				System.out.println("o");
			return;
		}
		
		for (int i = 28; i >= 1; i--)
			if (s[i] < n) {
				idx = i + 1;
				break;
			}
		
		if (n > s[idx - 1] + idx + 3)
			dfs(n - (s[idx - 1] + idx + 3));
		else {
			if (n == s[idx - 1] + 1)
				System.out.println("m");
			else
				System.out.println("o");
		}
	}
}

// m o o m o o o m o o  m  o  o  o  o  m  o  o  m  o  o  o  m  o  o  m  o  o  o  o  o  m  o  o  m  o  o  o  m  o  o  m  o  o  o  o  m  o  o  m  o  o  o  m  o  o
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56
// 1     4       8      11             16       19          23       26                32       35          39       42             47       50          54
// 1             8                     16                                              32
//       4              11                                           26

