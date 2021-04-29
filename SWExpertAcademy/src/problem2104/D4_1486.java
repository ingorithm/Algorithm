package problem2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_1486 {
	static int testCase, result[];
	static int N, B;
	static int[] clerks, selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		testCase = Integer.parseInt(st.nextToken());
		result = new int[testCase + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			clerks = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				clerks[i] = Integer.parseInt(st.nextToken());
			
			for (int num = 1; num <= N; num++) {
				selected = new int[num];
				comb(0, 0, num, tc);
			}
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
	}

	static void comb(int cnt, int idx, int num, int tc) {
		if (cnt == num) {
			int sum = 0;
			
			for (int i = 0; i < num; i++)
				sum += selected[i];
			
			if (sum >= B)
				result[tc] = Math.min(result[tc], sum - B);
			return;
		}
		
		for (int i = idx; i < N; i++) {
			selected[cnt] = clerks[i];
			comb(cnt + 1, i + 1, num, tc);
		}
	}
}
