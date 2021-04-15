package problem2008;	// P

import java.util.Scanner;

public class Q15961 {
	static int N, D, K, C, result;
	static int[] sushi, selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 접시의 수(2<=N<=3,000,000)
		D = sc.nextInt();	// 초밥의 가짓수(2<=D<=3000)
		K = sc.nextInt();	// 연속해서 먹는 접시의 수(2<=K<=3000 / K<=N)
		C = sc.nextInt();	// 쿠폰 번호(1<=C<=D)
		sushi = new int[N];
		selected = new int[D + 1];
		
		for (int i = 0; i < N; i++)
			sushi[i] = sc.nextInt();
		
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			if (selected[sushi[i]] == 0)
				cnt++;
			selected[sushi[i]]++;
		}
		result = cnt;
		
		for (int start = 0; start < N; start++) {
			int end = (start + K) % N;
			
			if (selected[sushi[start]] == 1)
				cnt--;
			selected[sushi[start]]--;
			
			if (selected[sushi[end]] == 0)
				cnt++;
			selected[sushi[end]]++;
			
			if (selected[C] == 0)
				result = Math.max(result, cnt + 1);
			else
				result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}
}
