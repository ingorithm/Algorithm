package problem2101;

import java.util.Scanner;

public class Q1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		int[] scoreInt = new int[N];
		double[] scoreDouble = new double[N];
		
		for (int i = 0; i < N; i++) {
			scoreInt[i] = sc.nextInt();
			max = scoreInt[i] > max ? scoreInt[i] : max;
		}
		
		for (int i = 0; i < N; i++) {
			scoreDouble[i] = (double)scoreInt[i] / (double)max * 100;
		}
		
		double sum = 0;
		for (int i = 0; i < N; i++)
			sum += scoreDouble[i];
		System.out.println(sum / N);
	}
}
