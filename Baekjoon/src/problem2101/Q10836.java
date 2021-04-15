package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10836 {
	private static int M, N;
	private static int[] firstCol, firstRow;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		firstCol = new int[M];
		firstRow = new int[M];
		
		Arrays.fill(firstCol, 1);
		Arrays.fill(firstRow, 1);
		for (int idx = 0; idx < N; idx++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			for (int i = M - 1; i >= 0; i--) {
				if (zero > 0) {
					firstCol[i] += 0;
					zero--;
				} else if (zero == 0 && one > 0) {
					firstCol[i] += 1;
					one--;
				} else
					firstCol[i] += 2;
			}
			
			for (int j = 1; j < M; j++) {
				if (zero > 0) {
					firstRow[j] += 0;
					zero--;
				} else if (zero == 0 && one > 0) {
					firstRow[j] += 1;
					one--;
				} else
					firstRow[j] += 2;
			}
		}
		
		// BufferedWriter써도 될 것 같다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(firstCol[i] + " ");
			for (int j = 1; j < M; j++)
				sb.append(firstRow[j] + " ");
			sb.append("\n");
		}
		System.out.println(sb);
		
//		for (int i = 0; i < M; i++) {
//			System.out.print(firstCol[i] + " ");
//			for (int j = 1; j < M; j++)
//				System.out.print(firstRow[j] + " ");
//			System.out.println();
//		}
	}
}
