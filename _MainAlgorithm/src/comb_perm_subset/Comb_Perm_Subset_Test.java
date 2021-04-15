package comb_perm_subset;

import java.util.Scanner;

public class Comb_Perm_Subset_Test {
	private static int N, R, combCnt, permCnt, subsetCnt;
	private static int[] arr, result;
	private static boolean[] permCheck;
	private static boolean[] subsetCheck;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N];
		permCheck = new boolean[N];
		subsetCheck = new boolean[N];
		result = new int[R];
		
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;
		
		System.out.println("Combination");
		comb(0, 0);
		System.out.println("comb total : " + combCnt);
		System.out.println();
		
		System.out.println("Permutation");
		perm(0);
		System.out.println("perm total : " + permCnt);
		System.out.println();
		
		System.out.println("Subset");
		subset(0);
		System.out.println("subset total : " + subsetCnt);
		System.out.println();
	}

	private static void comb(int idx, int cnt) {
		if (cnt == R) {
			printAns();
			combCnt++;
			return;
		}
		
		for (int i = idx; i < N; i++) {
			result[cnt] = arr[i];
			comb(i + 1, cnt + 1);
		}
	}
	
	private static void perm(int cnt) {
		if (cnt == R) {
			printAns();
			permCnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!permCheck[i]) {
				permCheck[i] = true;
				result[cnt] = arr[i];
				perm(cnt + 1);
				permCheck[i] = false;
			}
		}
	}
	
	private static void subset(int cnt) {
		if (cnt == N) {
			printSubset();
			subsetCnt++;
			return;
		}
		
		subsetCheck[cnt] = false;
		subset(cnt + 1);
		subsetCheck[cnt] = true;
		subset(cnt + 1);
	}
	
	private static void printAns() {
		for (int i = 0; i < R; i++)
			System.out.print(result[i] + " ");
		System.out.println();
	}
	
	private static void printSubset() {
		for (int i = 0; i < N; i++)
			if (subsetCheck[i])
				System.out.print(arr[i] + " ");
		System.out.println();
	}
}
