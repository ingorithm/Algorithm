package problem2009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q10816 {
	static int N, M, card[], result[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		card = new int[20000001];	// -10,000,000 ~ 10,000,000 -> 0 ~ 20,000,000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
				card[Integer.parseInt(st.nextToken()) + 10000000]++;
		
		M = Integer.parseInt(br.readLine());
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			result[i] = card[Integer.parseInt(st.nextToken()) + 10000000];
		
		for (int i = 0; i < M; i++)
			System.out.print(result[i] + " ");
	}
}
