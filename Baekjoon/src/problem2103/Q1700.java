package problem2103;

import java.util.Scanner;

public class Q1700 {
	private static int N, K, result = Integer.MAX_VALUE;
	private static int arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[K];
		for (int i = 0; i < K; i++)
			arr[i] = sc.nextInt();
		
		int[] initTap = new int[N];
		int tapIdx = 0, arrIdx = 0;
		while (tapIdx < N) {
			boolean exist = false;
			
			for (int i = 0; i <= tapIdx; i++)
				if (initTap[i] == arr[arrIdx])
					exist = true;
			
			if (exist)
				arrIdx++;
			else {
				initTap[tapIdx] = arr[arrIdx];
				tapIdx++;
				arrIdx++;
			}
		}
		
		dfs(initTap, arrIdx, 0);
		
		System.out.println(result);
	}
	
	private static void dfs(int[] tap, int idx, int cnt) {
		if (idx == K) {
			result = Math.min(result, cnt);
			return;
		}
		
		// pruning
		if (cnt >= result)
			return;
		
		int num = arr[idx];
		boolean exist = false;
		for (int i = 0; i < N; i++)
			if (tap[i] == num)
				exist = true;
		
		if (exist)
			dfs(tap, idx + 1, cnt);
		else {
			int[] nextTap = new int[N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						nextTap[j] = num;
					else
						nextTap[j] = tap[j];
				}
				
				dfs(nextTap, idx + 1, cnt + 1);
			}
		}
	}
}
