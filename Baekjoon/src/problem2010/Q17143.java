package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
소요시간 : 대략 3시간...

1. 낚시꾼을 이동시킴
2. map 만들어서 상어를 전부 다 탐색해서 해당 맵에 배치
	(이 과정에서 상어가 겹칠 경우, 몸집이 작은 상어는 죽인다.ㅠ)
3. 낚시꾼이 있는 column에 상어가 존재한다면 가장 가까운 상어를 잡는다.
4. 상어들이 이동

!주의 : 그냥 문제에서 시키는 순서대로 풀면 편합니다.
!주의 : 죽은 상어는 모든 경우의 수(낚시꾼이 잡거나 옮기거나 등등)에서 제외
	(속도향상에 유리!, 하나하나 검사할 것이 많아서 가지치기 중요!)
 */
public class Q17143 {
	private static int R, C, M, result;
	private static Shark[] shark;
	private static final int dir[][] = {{0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shark = new Shark[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark[i] = new Shark(r, c, s, d, z, false);
		}
		
		for (int j = 1; j <= C; j++) {	// 낚시꾼 이동
			boolean map[][] = new boolean[R + 1][C + 1];	// 그 위치에 상어가 있나 없나 검사하기 위한 배열
			
			for (int m = 0; m < M; m++) {
				if (shark[m].dead)	// 상어가 잡히거나 잡아먹히면 건너뛰기(이후 자주 등장)
					continue;
				
				if (!map[shark[m].r][shark[m].c]) {	// 자리에 상어가 없으면 배치
					map[shark[m].r][shark[m].c] = true;
				} else {
					for (int mm = 0; mm < m; mm++)	// 1, 2, ... , mm, ... , m, ... , M
						if (!shark[mm].dead && shark[m].r == shark[mm].r && shark[m].c == shark[mm].c)
							if (shark[mm].z < shark[m].z)	// 크기가 작은 놈을 죽임
								shark[mm].dead = true;
							else
								shark[m].dead = true;
				}
			}
			
			// row를 1부터 R까지 내려가보면서 상어가 있으면 잡기
			for (int i = 1; i <= R; i++) {
				if (map[i][j]) {
					catchShark(i, j);
					break;
				}
			}
			
			move();
		}
		
		System.out.println(result);
	}
	
	// 해당 row, column에 상어가 있으면 잡는 함수
	private static void catchShark(int r, int c) {
		for (int m = 0; m < M; m++) {
			if (shark[m].dead)
				continue;
			
			if (shark[m].r == r && shark[m].c == c) {
				result += shark[m].z;
				shark[m].dead = true;
			}
		}
	}
	
	// 상어들이 움직이는 함수
	private static void move() {
		for (int m = 0; m < M; m++) {
			if (shark[m].dead)
				continue;

			// 상어의 속도가 매우 빠를 경우, 한 바퀴를 돌아 자신의 원래 자리로 돌아오는 속도로 나눠 속도를 하향 조정(가지치기)
			if ((shark[m].d == 1 || shark[m].d == 2) && shark[m].s >= 2 * R - 2)
				shark[m].s = shark[m].s % (2 * R - 2);
			else if ((shark[m].d == 3 || shark[m].d == 4) && shark[m].s >= 2 * C - 2)
				shark[m].s = shark[m].s % (2 * C - 2);
			
			Shark cur = shark[m];
			int curSpeed = cur.s;	// cur.s를 이용할 것이기 때문에 임시저장(Line 132에서 복원)
			while (cur.s > 0) {	// 상어의 속도만큼 이동
				cur.r += dir[cur.d][0];
				cur.c += dir[cur.d][1];
				
				if (cur.r == 0 || cur.r == R + 1 || cur.c == 0 || cur.c == C + 1) {
					switch (cur.d) {
					case 1:	// up
						cur.r = 2;
						cur.d = 2;	// to down
						break;
					case 2:	// down
						cur.r = R - 1;
						cur.d = 1;	// to up
						break;
					case 3:	// right
						cur.c = C - 1;
						cur.d = 4;	// to left
						break;
					case 4:	// left
						cur.c = 2;
						cur.d = 3;	// to right
						break;
					}
				}
				cur.s--;
			}
			cur.s = curSpeed;
			shark[m] = cur;
		}
	}
	
	// 상어의 row, column, speed, direction, z(크기), dead(상어의 죽음 여부)를 담는 클래스
	private static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		boolean dead;	// 죽거나 잡혔을 때 true
		
		public Shark(int r, int c, int s, int d, int z, boolean dead) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.dead = dead;
		}
	}
}
