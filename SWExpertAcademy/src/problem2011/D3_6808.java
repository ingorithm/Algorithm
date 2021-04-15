package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6808 {
	private static int testCase, result[][];
	private static int[] kyuyoung, inyoung;
	private static boolean[] check;
	private static int win, lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine().trim());
		result = new int[testCase + 1][2];
		
		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			kyuyoung = new int[9];
			inyoung = new int[9];
			check = new boolean[19];
			
			// input
			for (int i = 0; i < 9; i++) {
				kyuyoung[i] = Integer.parseInt(st.nextToken());
				check[kyuyoung[i]] = true;
			}
			
			win = 0; lose = 0;
			perm(0);
			result[tc][0] = win;
			result[tc][1] = lose;
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc][0] + " " + result[tc][1]);
	}
	
	private static void perm(int cnt) {
		if (cnt == 9) {
			int kSum = 0, iSum = 0;
			
			for (int i = 0; i < 9; i++)
				if (kyuyoung[i] > inyoung[i])
					kSum += (kyuyoung[i] + inyoung[i]);
				else
					iSum += (kyuyoung[i] + inyoung[i]);
			
			if (kSum > iSum)
				win++;
			else if (iSum > kSum)
				lose++;
			
			return;
		}
		
		for (int i = 1; i <= 18; i++) {
			if (!check[i]) {
				check[i] = true;
				inyoung[cnt] = i;
				perm(cnt + 1);
				check[i] = false;
			}
		}
	}
}
