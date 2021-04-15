package problem2008;

import java.util.Arrays;
import java.util.Scanner;

public class Q11399 {
	static int N, people[], result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		people = new int[N];
		
		for (int i = 0; i < N; i++)
			people[i] = sc.nextInt();
		
		Arrays.sort(people);

		for (int i = 0; i < N; i++)
			for (int j = 0; j <= i; j++)
				result += people[j];
		System.out.println(result);
	}
}
