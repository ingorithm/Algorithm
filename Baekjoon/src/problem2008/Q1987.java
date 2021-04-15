package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1987 {
	static int R, C, result;
	static char[][] board;
	static boolean[][] isChecked;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static List<Character> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		isChecked = new boolean[R][C];
		list = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++)
				board[i][j] = str.charAt(j);
		}
		
		dfs(0, 0);
		System.out.println(result);
	}
	
	private static void dfs(int i, int j) {
		list.add(board[i][j]);
		isChecked[i][j] = true;
		
		for (int d = 0; d < dir.length; d++) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if (isPromising(ni, nj))
				dfs(ni, nj);
		}
		result = Math.max(result, list.size());
		list.remove(list.size() - 1);
		isChecked[i][j] = false;
	}
	
	private static boolean isPromising(int i, int j) {
		if (i < 0 || i >= R || j < 0 || j >= C)
			return false;
		if (list.contains(board[i][j]) || isChecked[i][j])
			return false;
			
		return true;
	}
}

/*
2 4
CAAB
ADCB

3
*/
