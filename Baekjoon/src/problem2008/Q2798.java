package problem2008;

import java.util.Scanner;

public class Q2798 {
	static int N, M, result;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for (int i = 0; i < N - 2; i++)
			for (int j = i + 1; j < N - 1; j++)
				for (int k = j + 1; k < N; k++) {
					if (arr[i] + arr[j] + arr[k] == M) {
						System.out.println(M);
						return;
					}
					if (arr[i] + arr[j] + arr[k] < M)
						result = Math.max(result, arr[i] + arr[j] + arr[k]);
				}
		System.out.println(result);
	}
}
