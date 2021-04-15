package problem2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2529 {
	private static int N;
	private static long max = 0, min = Long.MAX_VALUE;
	private static boolean[] check;
	private static int[] num;
	private static char[] sign;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		check = new boolean[10];
		num = new int[N + 1];
		sign = new char[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			sign[i] = st.nextToken().charAt(0);
		
		for (int idx = 0; idx < 10; idx++) {
			num[0] = idx;
			check[idx] = true;
			dfs(1);
			check[idx] = false;
		}
		
		String format = "%0" + (N + 1) + "d";
		System.out.println(String.format(format, max));
		System.out.println(String.format(format, min));
	}
	
	private static void dfs(int cnt) {
		if (cnt == N + 1) {
			Long temp = 0L;
			for (int i = 0; i <= N; i++)
				temp = temp * 10 + num[i];
			
			max = Math.max(temp, max);
			min = Math.min(temp, min);
			return;
		}
		
		for (int idx = 0; idx < 10; idx++)
			if (!check[idx])
				if ((sign[cnt - 1] == '<' && num[cnt - 1] < idx) ||
						(sign[cnt - 1] == '>' && num[cnt - 1] > idx)) {
					num[cnt] = idx;
					check[idx] = true;
					dfs(cnt + 1);
					check[idx] = false;
				}
	}
}
