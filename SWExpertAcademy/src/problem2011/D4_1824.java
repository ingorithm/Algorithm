package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1824 {
	private static int testCase, result[];
	private static int R, C;
	private static char map[][];
	private static Queue<Point> q;
	private static boolean check[][][][];
	private static final int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][];
			
			for (int i = 0; i < R; i++)
				map[i] = br.readLine().toCharArray();
			
			q = new LinkedList<>();
			check = new boolean[R][C][16][4];
			
			switch (map[0][0]) {
			case '<':
				q.offer(new Point(0, C - 1, 0, 2));
				check[0][C - 1][0][2] = true;
				break;
			case '>': case '_': case '.':
				q.offer(new Point(0, 1, 0, 0));
				check[0][1][0][0] = true;
				break;
			case '^':
				q.offer(new Point(R - 1, 0, 0, 3));
				check[R - 1][0][0][3] = true;
				break;
			case 'v': case '|':
				q.offer(new Point(1, 0, 0, 1));
				check[1][0][0][1] = true;
				break;
			case '?':
				q.offer(new Point(0, 1, 0, 0));
				q.offer(new Point(1, 0, 0, 1));
				q.offer(new Point(0, C - 1, 0, 2));
				q.offer(new Point(R - 1, 0, 0, 3));
				check[0][1][0][0] = true;
				check[1][0][0][1] = true;
				check[0][C - 1][0][2] = true;
				check[R - 1][0][0][3] = true;
				break;
			case '@':
				result[tc] = 1;
				break;
			case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				q.offer(new Point(0, 1, map[0][0] - '0', 0));
				check[0][1][map[0][0] - '0'][0] = true;
				break;
			case '+':
				q.offer(new Point(0, 1, 1, 0));
				check[0][1][1][0] = true;
				break;
			case '-':
				q.offer(new Point(0, 1, 15, 0));
				check[0][1][15][0] = true;
				break;
			}
			
			if (result[tc] == 1)
				continue;
			
			while (!q.isEmpty()) {
				Point p = q.poll();
				
				if (map[p.i][p.j] == '@') {
					result[tc] = 1;
					break;
				}
				
				switch (map[p.i][p.j]) {
				case '<':
					if (p.j == 0)
						p.j = C - 1;
					else
						p.j--;
					p.d = 2;
					
					if (!check[p.i][p.j][p.m][p.d]) {
						check[p.i][p.j][p.m][p.d] = true;
						q.offer(p);
					}
					break;
				case '>':
					if (p.j == C - 1)
						p.j = 0;
					else
						p.j++;
					p.d = 0;
					
					if (!check[p.i][p.j][p.m][p.d]) {
						check[p.i][p.j][p.m][p.d] = true;
						q.offer(p);
					}
					break;
				case '^':
					if (p.i == 0)
						p.i = R - 1;
					else
						p.i--;
					p.d = 3;
					
					if (!check[p.i][p.j][p.m][p.d]) {
						check[p.i][p.j][p.m][p.d] = true;
						q.offer(p);
					}
					break;
				case 'v':
					if (p.i == R - 1)
						p.i = 0;
					else
						p.i++;
					p.d = 1;
					
					if (!check[p.i][p.j][p.m][p.d]) {
						check[p.i][p.j][p.m][p.d] = true;
						q.offer(p);
					}
					break;
				case '_':
					if (p.m == 0) {
						if (p.j == C - 1)
							p.j = 0;
						else
							p.j++;
						p.d = 0;
						
						if (!check[p.i][p.j][p.m][p.d]) {
							check[p.i][p.j][p.m][p.d] = true;
							q.offer(p);
						}
					} else {
						if (p.j == 0)
							p.j = C - 1;
						else
							p.j--;
						p.d = 2;
						
						if (!check[p.i][p.j][p.m][p.d]) {
							check[p.i][p.j][p.m][p.d] = true;
							q.offer(p);
						}
					}
					break;
				case '|':
					if (p.m == 0) {
						if (p.i == R - 1)
							p.i = 0;
						else
							p.i++;
						p.d = 1;
						
						if (!check[p.i][p.j][p.m][p.d]) {
							check[p.i][p.j][p.m][p.d] = true;
							q.offer(p);
						}
					} else {
						if (p.i == 0)
							p.i = R - 1;
						else
							p.i--;
						p.d = 3;
						
						if (!check[p.i][p.j][p.m][p.d]) {
							check[p.i][p.j][p.m][p.d] = true;
							q.offer(p);
						}
					}
					break;
				case '?':
					for (int d = 0; d < dir.length; d++) {
						int ni = p.i + dir[d][0];
						int nj = p.j + dir[d][1];
						ni = ni == -1 ? R - 1 : ni;
						ni = ni == R ? 0 : ni;
						nj = nj == -1 ? C - 1 : nj;
						nj = nj == C ? 0 : nj;
						
						if (!check[ni][nj][p.m][d]) {
							check[ni][nj][p.m][d] = true;
							q.offer(new Point(ni, nj, p.m, d));
						}
					}
					break;
				case '.': case '@':
					int ni = p.i + dir[p.d][0];
					int nj = p.j + dir[p.d][1];
					ni = ni == -1 ? R - 1 : ni;
					ni = ni == R ? 0 : ni;
					nj = nj == -1 ? C - 1 : nj;
					nj = nj == C ? 0 : nj;
					
					if (!check[ni][nj][p.m][p.d]) {
						check[ni][nj][p.m][p.d] = true;
						q.offer(new Point(ni, nj, p.m, p.d));
					}
					break;
				case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
					p.m = (map[p.i][p.j] - '0');
					p.i = p.i + dir[p.d][0];
					p.j = p.j + dir[p.d][1];
					p.i = (p.i == -1 ? R - 1 : p.i);
					p.i = (p.i == R ? 0 : p.i);
					p.j = (p.j == -1 ? C - 1 : p.j);
					p.j = (p.j == C ? 0 : p.j);
					
					if (!check[p.i][p.j][p.m][p.d]) {
						check[p.i][p.j][p.m][p.d] = true;
						q.offer(p);
					}
					break;
				case '+':
					p.i = p.i + dir[p.d][0];
					p.j = p.j + dir[p.d][1];
					p.i = p.i == -1 ? R - 1 : p.i;
					p.i = p.i == R ? 0 : p.i;
					p.j = p.j == -1 ? C - 1 : p.j;
					p.j = p.j == C ? 0 : p.j;
					p.m++;
					if (p.m == 16)
						p.m = 0;
					
					if (!check[p.i][p.j][p.m][p.d]) {
						check[p.i][p.j][p.m][p.d] = true;
						q.offer(p);
					}
					break;
				case '-':
					p.i = p.i + dir[p.d][0];
					p.j = p.j + dir[p.d][1];
					p.i = p.i == -1 ? R - 1 : p.i;
					p.i = p.i == R ? 0 : p.i;
					p.j = p.j == -1 ? C - 1 : p.j;
					p.j = p.j == C ? 0 : p.j;
					p.m--;
					if (p.m == -1)
						p.m = 15;
					
					if (!check[p.i][p.j][p.m][p.d]) {
						check[p.i][p.j][p.m][p.d] = true;
						q.offer(p);
					}
					break;
				}
			}
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + (result[tc] == 1 ? "YES" : "NO"));
	}
	
	private static class Point {
		int i, j, m, d;

		public Point(int i, int j, int m, int d) {
			this.i = i;
			this.j = j;
			this.m = m;
			this.d = d;
		}
	}

}
