package problem2008;	// P, 재검토 필요

import java.util.Scanner;

public class D5_1247 {
	static int T, N, min;
	static int[][] customer;
	static int[] idxArray;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			min = Integer.MAX_VALUE;

			N = sc.nextInt(); // 고객수

			customer = new int[N][2];

			int comY = sc.nextInt();
			int comX = sc.nextInt();
			int homeY = sc.nextInt();
			int homeX = sc.nextInt();

			for (int i = 0; i < N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
			}

			idxArray = new int[N];
			for (int i = 0; i < idxArray.length; i++) {
				idxArray[i] = i;
			}

			while (true) {

				int distSum = distance(comY, comX, customer[idxArray[0]][0], customer[idxArray[0]][1]);

				for (int i = 0; i < N - 1; i++) {
					distSum += distance(customer[idxArray[i]][0], customer[idxArray[i]][1],
							customer[idxArray[i + 1]][0], customer[idxArray[i + 1]][1]);
				}

				distSum += distance(customer[idxArray[N - 1]][0], customer[idxArray[N - 1]][1], homeY, homeX);

				min = Math.min(min, distSum);

				if (!np(idxArray))
					break;
			}

			System.out.println("#" + tc + " " + min);
		}

		sc.close();

	}

	static int distance(int fy, int fx, int ty, int tx) {
		return Math.abs(fy - ty) + Math.abs(fx - tx);
	}

	static boolean np(int array[]) {

		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;

		if (i == 0)
			return false;

		int j = array.length - 1;
		while (array[i - 1] >= array[j])
			j--;

		swap(array, i - 1, j);

		int k = array.length - 1;
		while (i < k)
			swap(array, i++, k--);

		return true;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}