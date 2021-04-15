package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2667 {
	static int N, map[][], result[];
	static boolean isChecked[][];
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isChecked = new boolean[N][N];
		result = new int[N * N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		
		int count = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (isChecked[i][j] == false && map[i][j] == 1) {
					count++;
					countMap(i, j, count);
				}
		
		System.out.println(count);
		Arrays.sort(result);
		for (int i = 0; i < N * N; i++)
			if (result[i] != 0)
				System.out.println(result[i]);
		
	}
	
	static void countMap(int i, int j, int n) {
		isChecked[i][j] = true;
		map[i][j] = n;
		result[n]++;
		
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if (ni >= 0 && nj >= 0 && ni < N && nj < N)
				if (isChecked[ni][nj] == false && map[ni][nj] == 1)
					countMap(ni, nj, n);
		}
	}
}

