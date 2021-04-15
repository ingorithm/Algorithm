package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
소요시간 : 약 1시간

1. 시간 증가
2. 뱀 앞으로 전진
3. map에서 뱀의 머리가 있는 곳의 상태 확인
4. snake Queue 조작
5. turns 배열 확인

!주의 : 문제에 나와있는 규칙의 순서를 따른다.
 */
public class Q3190 {
	private static int N, K, L, map[][], time;
	private static int r, c, d;	// Current Snake's row, column, direction
	private static final int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};	// right, down, left, up
	
	private static Queue<Point> snake;	// 뱀의 위치
	private static char[] turns;		// 뱀의 방향 전환 정보
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 2][N + 2];	// 0: 빈공간, 1: 뱀, 2: 사과, 3: 벽
		
		init();
		
		// input
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2;
		}
		
		L = Integer.parseInt(br.readLine());
		turns = new char[10000 + 1];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			turns[t] = d;
		}
		
		snake = new LinkedList<>();
		snake.offer(new Point(1, 1));
		while (true) {
			// 시간 증가
			time++;
			
			// 뱀 앞으로 전진
			r += dir[d][0];
			c += dir[d][1];
			
			// map에서 뱀의 머리가 있는 곳의 상태 확인
			if (map[r][c] == 1 || map[r][c] == 3)
				break;
			
			// snake Queue 조작
			if (map[r][c] == 0) {
				Point p = snake.poll();
				map[p.r][p.c] = 0;
			}
			map[r][c] = 1;
			snake.offer(new Point(r, c));
			
			// turns 배열 확인
			if (time >= 1 && time <= 10001) {
				if (turns[time] == 'L')
					d = (d + 3) % 4;
				else if (turns[time] == 'D')
					d = (d + 1) % 4;
			}
		}
		
		System.out.println(time);
	}
	
	private static void init() {
		for (int i = 0; i <= N + 1; i++) {
			map[0][i] = 3;
			map[N + 1][i] = 3;
			map[i][0] = 3;
			map[i][N + 1] = 3;
		}
		
		r = 1;
		c = 1;
		d = 0;
	}
	
	// 뱀의 위치를 나타내는 클래스
	private static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
