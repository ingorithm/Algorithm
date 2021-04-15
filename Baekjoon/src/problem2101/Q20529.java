package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q20529 {
	private static int testCase, result[];
	private static int N;
	private static int[][][] mbti;
	private static int[] people, selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// initialization
		mbti = new int[16][16][16];
		mbtiCalc();
		
		testCase = Integer.parseInt(br.readLine());
		result = new int[testCase];
		Arrays.fill(result, Integer.MAX_VALUE);
		
		for (int tc = 0; tc < testCase; tc++) {
			people = new int[16];
			selected = new int[3];
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			// input
			for(int i = 0; i < N; i++) {
				String str = st.nextToken();
				int mbtiNum = 0;
				
				if (str.charAt(0) == 'I')
					mbtiNum += 1;
				
				mbtiNum = mbtiNum<<1;
				if (str.charAt(1) == 'N')
					mbtiNum += 1;
				
				mbtiNum = mbtiNum<<1;
				if (str.charAt(2) == 'F')
					mbtiNum += 1;
				
				mbtiNum = mbtiNum<<1;
				if (str.charAt(3) == 'P')
					mbtiNum += 1;
				
				people[mbtiNum]++;
			}
			
			comb(tc, 0, 0);
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}
	
	private static void mbtiCalc() {
		for (int i = 0; i < 16; i++)
			for (int j = 0; j < 16; j++)
				for (int k = 0; k < 16; k++)
					mbti[i][j][k] = compareMBTI(i, j, k);
	}
	
	private static int compareMBTI(int i, int j, int k) {
		int ret = 0;
		
		for (int idx = 0; idx < 4; idx++) {
			if ((i>>idx & 1) != (j>>idx & 1))
				ret++;
			if ((i>>idx & 1) != (k>>idx & 1))
				ret++;
			if ((j>>idx & 1) != (k>>idx & 1))
				ret++;
		}
		
		return ret;
	}
	
	// 중복조합
	private static void comb(int tc, int idx, int cnt) {
		if (cnt == 3) {
			result[tc] = Math.min(result[tc], mbti[selected[0]][selected[1]][selected[2]]);
			return;
		}
		
		for (int i = idx; i < 16; i++)
			if (people[i] > 0) {
				people[i]--;
				selected[cnt] = i;
				comb(tc, i, cnt + 1);
				people[i]++;
			}
	}
}
