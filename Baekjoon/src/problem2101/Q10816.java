package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;
		int[] cards = new int[20000001];
		StringBuilder result = new StringBuilder();
		
		// input
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken()) + 10000000;
			cards[card]++;
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken()) + 10000000;
			result.append(cards[card] + " ");
		}
		
		System.out.println(result.toString());
	}

}
