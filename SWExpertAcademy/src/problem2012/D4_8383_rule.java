package problem2012;

import java.util.Scanner;

// 방향전환규칙
public class D4_8383_rule {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int sR = sc.nextInt();
			int sC = sc.nextInt();
			int dR = sc.nextInt();
			int dC = sc.nextInt();

			int a = Math.abs(sR - dR);// 행 거리
			int b = Math.abs(sC - dC);// 열 거리

			int sh = Math.min(a, b);
			int lo = Math.max(a, b);
			int dif = lo - sh;
			int ans = sh * 2 + dif * 2 - (dif % 2);
			System.out.println("#" + tc + " " + ans);
		}
	}
}
