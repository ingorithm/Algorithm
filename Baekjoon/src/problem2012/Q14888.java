package problem2012;

import java.util.Scanner;

public class Q14888 {
	private static int N, operand[], operator[];
	private static int[] selected;
	private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		operand = new int[N];
		operator = new int[5];	// , +, -, *, /
		selected = new int[N];
		
		for (int i = 0; i < N; i++)
			operand[i] = sc.nextInt();
		
		for (int i = 1; i <= 4; i++)
			operator[i] = sc.nextInt();
		
		comb(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void comb(int cnt) {
		if (cnt == N - 1) {
			int result = operand[0];
			
			for (int i = 0; i < N - 1; i++) {
				switch (selected[i]) {
				case 1:
					result = result + operand[i + 1];
					break;
				case 2:
					result = result - operand[i + 1];
					break;
				case 3:
					result = result * operand[i + 1];
					break;
				case 4:
					result = result / operand[i + 1];
					break;
				}
			}
			
			max = Math.max(max, result);
			min = Math.min(min, result);
			
			return;
		}
		
		for (int i = 1; i <= 4; i++)
			if (operator[i] > 0) {
				operator[i]--;
				selected[cnt] = i;
				comb(cnt + 1);
				operator[i]++;
			}
	}
	
}
