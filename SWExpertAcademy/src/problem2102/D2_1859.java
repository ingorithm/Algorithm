package problem2102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1859 {
	private static int testCase; 
	private static long result[];
	private static int N, prices[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		testCase = Integer.parseInt(st.nextToken());
		result = new long[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			prices = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				prices[i] = Integer.parseInt(st.nextToken());
			
			int start = 0;
			long sum = 0;
			while (start < N) {
				int target = 0, value = 0;
				
				for (int i = start; i < N; i++)
					if (value <= prices[i]) {
						target = i;
						value = prices[i];
					}
				
				for (int i = start; i < target; i++)
					sum += value - prices[i];
				
				start = target + 1;
			}
			
			result[tc] = sum;
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
		
	}
	
}
