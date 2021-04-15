package dp;

import java.util.Scanner;

//배낭채우기 : 보석개수 1개 버전
/*
Input Data
5 675
331 4015
120 8001
265 9209
13 6705
359 809

Result
23915

Input Data
4
10
5 10
4 40
6 30
3 50

Result
90

Input Data
4 
16
2 40
5 30
10 50
5 10

Result
90
 */
public class KnapsackTest2 {
 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];

		int[] D = new int[W+1];
		
		// i=0은 0으로 그대로 둠.
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		// 모든 아이템에 대해서 반복
		for (int i = 1; i <= N; i++) {
			
			// 가방의 최대 무게부터 자신의 무게까지 시도 : 가방에 넣을 수 있는 무게만 시도
			for (int w = W; w >= weights[i]; w--) {
				if (D[w] < profits[i] + D[w-weights[i]])
					D[w] = profits[i] + D[w-weights[i]];
			}
		}
		
		// 마지막 아이템까지 고려한 W 무게를 만족하는 최대가치
		System.out.println(D[W]);
	}

}
