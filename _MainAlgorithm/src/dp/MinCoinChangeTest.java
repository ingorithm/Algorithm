package dp;

import java.util.Scanner;

/*
1원, 4원, 6원 동전을 가지고 최소한의 거스름돈 동전을 주는 경우

!주의 : 동전 1, 4, 6 : 배수의 성질 불만족
!주의 : 갯수제한 X
 */
public class MinCoinChangeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money + 1];	// 동적 테이블
		
		// 각 금액의 최적 교환 동전개수를 구함
		// 1원 시도 : D[i - 1] + 1
		// 4원 시도 : D[i - 4] + 1
		// 6원 시도 : D[i - 6] + 1
		
		// 가장 최적값 저장
		int min;
		for (int i = 1; i <= money; i++) {
			min = Integer.MAX_VALUE;
			if (i >= 1 && D[i - 1] + 1 < min)
				min = D[i - 1] + 1;
			if (i >= 4 && D[i - 4] + 1 < min)
				min = D[i - 4] + 1;
			if (i >= 6 && D[i - 6] + 1 < min)
				min = D[i - 6] + 1;
			
			D[i] = min;
		}
		System.out.println(money + "원의 최적값 : " + D[money] + "개");
	}

}
