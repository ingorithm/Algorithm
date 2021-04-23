package problem2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class D4_2819 {
	static int testCase, result[];
	static char[][] map;
	static Set<String> set;
	static Queue<Point> q;
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static class Point {
		int i, j;
		String word;

		public Point(int i, int j, String word) {
			this.i = i;
			this.j = j;
			this.word = word;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testCase = Integer.parseInt(br.readLine().trim());
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			map = new char[4][4];
			set = new HashSet<>();
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					map[i][j] = st.nextToken().charAt(0);
			}
			
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					q = new LinkedList<>();
					
					q.offer(new Point(i, j, Character.toString(map[i][j])));
					while (!q.isEmpty()) {
						Point p = q.poll();
						
						if (p.word.length() == 7) {
							set.add(p.word);
							continue;
						}
						
						for (int d = 0; d < dir.length; d++) {
							int ni = p.i + dir[d][0];
							int nj = p.j + dir[d][1];
							
							if (ni < 0 || ni >= 4 || nj < 0 || nj >= 4)
								continue;
							
							q.offer(new Point(ni, nj, p.word + map[ni][nj]));
						}
					}
					
					result[tc] = Math.max(result[tc], set.size());
				}
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
	}
	
}
