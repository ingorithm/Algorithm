package problem2008;

import java.util.Scanner;

public class Q2961 {
	static int N, answer = Integer.MAX_VALUE;	// int type MAX
	static Pair p[];
	static boolean isChecked[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		p = new Pair[N];
		isChecked = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int b = sc.nextInt();
			p[i] = new Pair(s, b);
		}
		
		choose(0, 0, 1, 0);
		System.out.println(answer);
	}
	
	static void choose(int cnt, int num, int s, int b) {
		if (cnt >= 1) {
			int temp = Math.abs(s - b);
			answer = answer > temp ? temp : answer;
		}
		
		for (int i = num; i < N; i++) {
			if (isChecked[i] == false) {
				isChecked[i] = true;
				choose(cnt + 1, i, s * p[i].s, b + p[i].b);
				isChecked[i] = false;
			}
		}
	}
	
	public static class Pair {
		int s;
		int b;
		
		Pair(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}
}
