package problem2011;	// needs refactoring

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 시뮬레이션
// BFS
public class Q16236 {

	static int N;
	static int[][] map;
	static int[][] check; // 아기상어의 위치로부터 이동한 거리 관리
	static int sx, sy;
	static int sSize = 2;
	static int result = 0;
	static int minX, minY;
	static final int MIN_VALUE = 21;
	static int minDist;
	static int eatCnt = 0;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		check = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sx = j;
					sy = i;
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			// 배열 등 초기화
			init();
			// 물고기 찾기
			bfs(sx, sy);

			// minX minY 가 초기값이 아닌 경우는 물고기를 잡아 먹었음.
			if (minX != MIN_VALUE && minY != MIN_VALUE) {
				// 결과값 갱신
				result = result + check[minY][minX];
				eatCnt++;
				if (eatCnt == sSize) {
					sSize++;
					eatCnt = 0;
				}
				map[minY][minX] = 0;
				sx = minX;
				sy = minY;
			} else {
				break;
			}
		}

		System.out.println(result);
		sc.close();
	}

// 항상 아기상어의 위치에서 시작
// 배열에서 먹을 수 있는 물고기가 여러 군데 있을 수 있다.
// bfs 로 최단 거리의 물고기를 먹도록 탐색
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		check[y][x] = 0; // 상어가 이동되면 0으로 변경하기
		Point p = new Point(x, y);
		q.offer(p);

		// 한칸씩 이동하면서 그 방문이 유효하면 queue 에 넣는다.
		// 이동하면서 check 배열에 이동하는 횟수를 계속 갱신 ( +1 )
		// 이동하려는 좌표에 먹을 물고기가 있으면 거리를 확인해야 한다. (최소 거리에서 )
		// queue 에 있는 모든 방문이 끝나면, 그 중 물고기를 먹은 방문 중에서 최소 거리 및 해당 좌표가 계산된다.
		while (!q.isEmpty()) {

			p = q.poll();
			x = p.x;
			y = p.y;

			for (int i = 0; i < 4; i++) {

				int ny = y + dy[i];
				int nx = x + dx[i];

				if (nx < 1 || nx > N || ny < 1 || ny > N)
					continue; // 이동했던 적이 있으면 안가기
				if (check[ny][nx] != -1)
					continue; // 이동했던 적이 있으면 안가기
				if (map[ny][nx] > sSize)
					continue; // 물고기가 상어보다 크면 이동 안함

				// 방문
				check[ny][nx] = check[y][x] + 1; // 기존에 있던 이동횟수에 1 증가하기

				// bfs 를 통한 너비 우선 탐색의 다양한 방문 중 먹을 수 있는 물고기를 만나면
				// 이전 동일한 방문으로 인해 현재 유지되는 최소거리 및 그 시점의 좌표와 비교하여 조건에 맞게 갱신
				if (map[ny][nx] != 0 && map[ny][nx] < sSize) { // 물고기가 있고, 그 물고기가 상어 사이즈보다 작은 경우

					// 현재 ny, nx 방문이 최소 거리(단계) 이면
					if (minDist > check[ny][nx]) { // 현재 물고기의 거리가 작으면 최소좌표 및 최소거리 갱신
						minY = ny;
						minX = nx;
						minDist = check[ny][nx];
					} else if (minDist == check[ny][nx]) { // 현재 물고기의 거리가 최소거리와 같으면 위쪽,왼쪽 순으로 최소좌표 갱신
						if (minY == ny) {
							if (minX > nx) {
								minX = nx;
							}
						} else if (minY > ny) {
							minX = nx;
							minY = ny;
						}
					}
				}

				q.offer(new Point(nx, ny));
			}
		}
	}

	static void init() {
		for (int i = 0; i < check.length; i++) {
			Arrays.fill(check[i], -1);
		}
		minX = minY = MIN_VALUE;
		minDist = Integer.MAX_VALUE;
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}