package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7699 {
	private static int r, c, result;
	private static char[][] map;
	private static boolean[] check;
	private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r][];
			check = new boolean[26];
			
			for (int i = 0; i < r; i++)
				map[i] = br.readLine().toCharArray();
			
			check[map[0][0]-'A'] = true;
			result = 0;
			dfs(0, 0, 1);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	private static void dfs(int i, int j, int cnt) {
		result = Math.max(result, cnt);
		
		if (result == 26)
			return;
		
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if (ni < 0 || ni >= r || nj < 0 || nj >= c)
				continue;
			
			if (check[map[ni][nj]-'A'])
				continue;
			
			check[map[ni][nj]-'A'] = true;
			dfs(ni, nj, cnt + 1);
			check[map[ni][nj]-'A'] = false;
		}
	}

}
