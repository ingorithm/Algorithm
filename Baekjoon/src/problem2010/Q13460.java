package problem2010;	// 구슬 탈출 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
풀이시간 : 대략 3시간 반

map을 저장하고 R, B를 4방향으로 이동 후 공이 더이상 굴러가지 않는 곳의 위치를 visit 배열에 저장해 bfs 탐색을 한다.
result에 max value를 저장해놓고, B가 구멍에 들어가지 않고 R만 구명에 들어갔을 때의 이동횟수의 최소값을 찾는다.

!주의 : visit[rr][rc][br][bc]의 경우, 4차원 배열을 통해 2개의 공의 row, column 값을 계산할 수 있다.
		(N, M의 크기가 10 이하이기 때문에 4차원 boolean 배열이여도 10000bit ~= 1kb 정도 밖에 되지 않는다.)
!주의 : PointRB 클래스에 R과 B의 위치를 함께 저장해야지 정상적인 visit처리를 할 수 있다.
 */
public class Q13460 {
	private static int N, M, result = Integer.MAX_VALUE;
	private static char board[][];
	private static int or, oc;			// Hole's row, column
	private static final int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// up, down, left, right
	
	// for BFS
	private static Queue<PointRB> q;	// R&B's Point for BFS
	private static boolean visit[][][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(buf.readLine());
		
		// input
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		q = new LinkedList<>();
		visit = new boolean[N][M][N][M];	// RR, RC, BR, BC
		
		int rr = 0, rc = 0, br = 0, bc = 0;	// R&B's first row, column
		for (int i = 0; i < N; i++) {
			String str = buf.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
				
				// R, B, O 위치 저장
				if (board[i][j] == 'R') {
					rr = i;
					rc = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'B') {
					br = i;
					bc = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'O') {
					or = i;
					oc = j;
				}
			}
		}
		
		q.offer(new PointRB(rr, rc, br, bc, 0));	// first Queue insert
		visit[rr][rc][br][bc] = true;				// 큐에 넣음과 동시에 visit 처리
		
		while (!q.isEmpty()) {
			PointRB cur = q.poll();
			
			// 이미 이동횟수가 10회를 넘어간 경우
			if (cur.cnt >= 10)
				break;
			
			for (int d = 0; d < dir.length; d++) {
				int holeIn = 0;		// 0 : 아무것도 안들어감, 1 : R만 들어감, 2 : B가 들어감
				int nrr = cur.rr;	// next R row
				int nrc = cur.rc;
				// R Move
				while (board[nrr + dir[d][0]][nrc + dir[d][1]] != '#') {
					nrr += dir[d][0];
					nrc += dir[d][1];
					if (nrr == or && nrc == oc)
						holeIn = 1;
				}
				
				int nbr = cur.br;
				int nbc = cur.bc;
				// B Move
				while (board[nbr + dir[d][0]][nbc + dir[d][1]] != '#') {
					nbr += dir[d][0];
					nbc += dir[d][1];
					if (nbr == or && nbc == oc)
						holeIn = 2;	// B가 R보다 항상 늦게 움직이므로 R, B 같이 들어갔을 때 무조건 2로 세팅된다.
				}
				
				// 두 공 다 움직이지 않았을 때
				if (nrr == cur.rr && nrc == cur.rc && nbr == cur.br && nbc == cur.bc)
					continue;
				
				// 두 공이 겹쳤을 때
				if (nrr == nbr && nrc == nbc) {
					switch (d) {
					case 0:	// up
						if (cur.rr < cur.br)	// R이 B보다 위에 있었을 때
							nbr++;
						else
							nrr++;
						break;
					case 1:	// down
						if (cur.rr > cur.br)	// R이 B보다 밑에 있었을 때
							nbr--;
						else
							nrr--;
						break;
					case 2:	// left
						if (cur.rc < cur.bc)	// R이 B보다 왼쪽에 있었을 때
							nbc++;
						else
							nrc++;
						break;
					case 3:	// right
						if (cur.rc > cur.bc)	// R이 B보다 오른쪽에 있었을 때
							nbc--;
						else
							nrc--;
						break;
					}
				}
				
				// 공의 위치가 탐색되지 않았거나 구멍에 아무 공도 들어가지 않았을 때, 움직인 위치를 Queue에 저장
				if (!visit[nrr][nrc][nbr][nbc] && holeIn == 0) {
					visit[nrr][nrc][nbr][nbc] = true;
					q.offer(new PointRB(nrr, nrc, nbr, nbc, cur.cnt + 1));
				}
				
				if (holeIn == 1)	// B가 들어가지 않고 R만 들어갔을 때
					result = Math.min(result, cur.cnt + 1);	// 초기에 R이나 B가 O일 수 없으므로 cur.cnt + 1(무조건 한 번은 움직임)
			}	// end for
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	// R, B, O의 위치를 파악하기 위한 클래스
	private static class PointRB {
		int rr;
		int rc;
		int br;
		int bc;
		int cnt;	// for BFS
		
		public PointRB(int rr, int rc, int br, int bc, int cnt) {
			this.rr = rr;
			this.rc = rc;
			this.br = br;
			this.bc = bc;
			this.cnt = cnt;
		}
	}
	
}
