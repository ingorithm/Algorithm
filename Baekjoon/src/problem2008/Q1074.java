package problem2008;	// P

import java.util.Scanner;

public class Q1074 {
	static int N, r, c, result;
	static boolean flag;	// 해를 구했는지 여부를 판단하는 flag
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int si = 0, sj = 0, ei = (int)Math.pow(2, N), ej = (int)Math.pow(2, N);
		result = 0;
		dp(si, sj, ei, ej);
		System.out.println(result);
	}
	
	static void dp(int si, int sj, int ei, int ej) {
		if (flag == true)
			return;
		
		if (ei - si == 2) {
			if (si == r && sj == c) {
				flag = true;
			}
			else if (si == r && sj + 1 == c) {
				result += 1;
				flag = true;
			}
			else if (si + 1 == r && sj == c) {
				result += 2;
				flag = true;
			}
			else if (si + 1 == r && sj + 1 == c) {
				result += 3;
				flag = true;
			}
			else
				result += 4;
		} else {
			dp(si, sj, (si + ei) / 2, (sj + ej) / 2);	// 좌상
			dp(si, (sj + ej) / 2, (si + ei) / 2, ej);	// 우상
			dp((si + ei) / 2, sj, ei, (sj + ej) / 2);	// 좌하
			dp((si + ei) / 2, (sj + ej) / 2, ei, ej);	// 우하
		}
	}
}
