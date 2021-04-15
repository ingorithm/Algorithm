package problem2008;	// P

import java.util.Arrays;
import java.util.Scanner;

public class Q1920 {
	static int N, M;
	static int[] arrN, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arrN = new int[N];
		for (int i = 0; i < N; i++)
			arrN[i] = sc.nextInt();
		Arrays.sort(arrN);
		
		M = sc.nextInt();
		result = new int[M];
		for (int j = 0; j < M; j++) {
			int temp = sc.nextInt();
			for (int i = 0; i < N; i++)
				if (arrN[i] == temp) {
					result[j] = 1;
					break;
				}
		}
		
		for (int i = 0; i < M; i++)
			System.out.println(result[i]);
	}
}
