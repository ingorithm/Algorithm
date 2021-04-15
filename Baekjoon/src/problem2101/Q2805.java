package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2805 {
	private static int N, M, h;
	private static Integer[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			trees[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(trees, Collections.reverseOrder());
		
		h = trees[0];
		int sum = 0;
		int idx = 0;
		for (int i = 1; i < N; i++) {
			sum += (h - trees[i]) * i;
			h = trees[i];
			
			if (sum >= M) {
				idx = i;
				break;
			}
		}
		
		if (sum >= M) {	// break 조건
			while (sum >= M) {
				sum -= idx;
				h++;
			}
			h--;
		} else {		// for문 종료
			while (sum < M) {
				sum += N;
				h--;
			}
		}
		
		System.out.println(h);
	}

}
