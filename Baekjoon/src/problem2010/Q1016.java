package problem2010;

import java.util.Scanner;

public class Q1016 {
	private static long min, max, result;
	private static int maxSqrt;
	private static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		min = sc.nextLong();
		max = sc.nextLong();
		
		int size = (int)(max - min) + 1;
		check = new boolean[size];
		maxSqrt = (int)Math.sqrt(max);	// max의 제곱근
		
		for (long i = 2; i <= maxSqrt; i++) {	// long형 주의! 
			long squared = i * i;
			long start = min % squared == 0 ? min / squared : (min / squared) + 1;
			
			for (long j = start; j * squared <= max; j++)
				check[(int)((j * squared) - min)] = true;
		}
		
		for (int i = 0; i < size; i++)
			if (!check[i])
				result++;
		
		System.out.println(result);
	}

}
