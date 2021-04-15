package problem2101;

import java.util.Scanner;

public class Q4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		double[] result = new double[TC];
		
		for (int tc = 0; tc < TC; tc++) {
			int N = sc.nextInt();
			int[] score = new int[N];
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				sum += score[i];
			}
			
			double avg = (double)sum / (double)N;
			int cnt = 0;
			for (int i = 0; i < N; i++)
				if (score[i] > avg)
					cnt++;
			
			result[tc] = (double)cnt / (double)N * 100;
		}
		
		for (int tc = 0; tc < TC; tc++)
			System.out.println(String.format("%.3f", result[tc]) + "%");
	}
}
