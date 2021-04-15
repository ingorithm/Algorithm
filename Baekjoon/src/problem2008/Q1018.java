package problem2008;	// P

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1018 {
	static int N, M, result = Integer.MAX_VALUE;
	static char chess[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chess = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < M; j++)
				chess[i][j] = s.charAt(j);
		}
		
		for (int i = 0; i <= N - 8; i++)
			for (int j = 0; j <= M - 8; j++)
				result = Math.min(result, search(i, j));
		
		System.out.println(result);
	}
	
	static int search(int i, int j) {
		int B = 0;
		int W = 0;
		for (int y = 0; y < 8; y++)
			for (int x = 0; x < 8; x++) {
				if ((y + x) % 2 == 0) {
					if (chess[i + y][j + x] == 'W')
						B++;
					else
						W++;
				} else {
					if (chess[i + y][j + x] == 'B')
						B++;
					else
						W++;
				}
			}
		
		return Math.min(B, W);
	}
}
