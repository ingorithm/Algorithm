package problem2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q9466 {
	private static int T, result[];
	private static int N, wants[], check[];	// check : 0 미탐색, 1 그룹핑, 2 가망없음
	private static boolean temp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		result = new int[T];
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			wants = new int[N + 1];
			check = new int[N + 1];
			temp = new boolean[N + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				wants[i] = Integer.parseInt(st.nextToken());

				// 자기 자신 그룹핑
				if (wants[i] == i)
					check[i] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				// 이미 그룹핑 되었거나 가망이 없을 때
				if (check[i] != 0)
					continue;
				
				dfs(i);
			}
			
			for (int i = 1; i <= N; i++)
				if (check[i] != 1)
					result[tc]++;
		}
		
		for (int tc = 0; tc < T; tc++)
			System.out.println(result[tc]);
	}

	private static int dfs(int idx) {
		temp[idx] = true;
		
		// 다음 노드가 이미 그룹핑이 되어있거나 가망이 없을 때
		if (check[wants[idx]] != 0) {
			check[idx] = 2;
			temp[idx] = false;	// 시간초과
			return 0;
		}
		
		if (temp[wants[idx]]) {
			check[idx] = 1;
			temp[idx] = false;	// 시간초과
			return wants[idx];
		}
		
		int ret = dfs(wants[idx]);
		
		if (ret == wants[idx]) {
			check[idx] = 2;
			temp[idx] = false;	// 시간초과
			return 0;
		}
		
		if (ret == 0)
			check[idx] = 2;	// 가망없음
		else
			check[idx] = 1;	// 그룹핑하는 과정
		
		temp[idx] = false;	// 시간초과
		return ret;
	}
	
}
