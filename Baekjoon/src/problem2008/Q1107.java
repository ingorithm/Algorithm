package problem2008;

import java.util.Scanner;

public class Q1107 {
	static int N, M, result;
	static boolean broken[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		broken = new boolean[10];
		
		for (int i = 0; i < M; i++) {
			int temp = sc.nextInt();
			broken[temp] = true;
		}
		
		result = Math.abs(N - 100);
		for (int i = 0; i < 1000000; i++)	// 500,000 주의
			result = Math.min(result, distance(i));
		
		System.out.println(result);
	}
	
	static int distance(int i) {
		int num = i;
		int click = 0;
		
		if (num == 0 && broken[num] == true)
			return Integer.MAX_VALUE;
		else if (num == 0 && broken[num] == false)
			return N + 1;
		
		while (num > 0) {
			if (broken[num % 10] == true)
				return Integer.MAX_VALUE;
			num = num / 10;
			click++;
		}
		click += Math.abs(i - N);
		
		return click;
	}
}
