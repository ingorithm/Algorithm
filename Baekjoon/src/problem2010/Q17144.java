package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
소요시간 : 약 1시간

1. 공기의 확산
2. 공기청정기 작동
3. 1번, 2번이 T초 작동 후, 미세먼지의 총량 계산

!특징 : 어렵지 않은 시뮬레이션 문제로 문제에서 시키는 대로 하면 된다!
!주의 : 공기청정기 가동할 때, index 주의!
!주의 : 공기청정기 가동할 때, 공기청정기에서 나오는 공기는 깨끗한 공기!
!주의 : 미세먼지 총량에서 공기청정기 주의!
 */
public class Q17144 {
	private static int R, C, T, cleaner;
	private static int[][] map, temp;
	private static final int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
//		temp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					cleaner = i;	// 공기청정기의 아래 row
			}
		}
		
		for (int time = 0; time < T; time++) {
			temp = new int[R][C];
			copy(map, temp);
			spread();
			clean();
			copy(temp, map);
		}
		
		// output
		int result = 0;
		
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] > 0)
					result += map[i][j];
		
		System.out.println(result);
	}

	// a배열을 b배열로 복사
	private static void copy(int[][] a, int[][] b) {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				b[i][j] = a[i][j];
	}
	
	// 미세먼지 확산 함수
	private static void spread() {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++) {
				int minus = map[i][j] / 5;
				
				if ((i == cleaner - 1 && j == 0) || (i == cleaner && j == 0))
					continue;
				
				for (int d = 0; d < dir.length; d++) {
					int ni = i + dir[d][0];
					int nj = j + dir[d][1];
					
					if (ni < 0 || ni >= R || nj < 0 || nj >= C ||
							(ni == cleaner - 1 && nj == 0) || (ni == cleaner && nj == 0))
						continue;
					else {
						temp[i][j] -= minus;			// step1 : 자신의 위치에서 퍼지기
						temp[i][j] += map[ni][nj] / 5;	// step2 : 상하좌우에서 들어오기
					}
				}
			}
	}
	
	// 공기청정기 가동 함수
	private static void clean() {
		// 위쪽
		for (int i = cleaner - 3; i >= 0; i--)
			temp[i + 1][0] = temp[i][0];
		for (int j = 1; j < C; j++)
			temp[0][j - 1] = temp[0][j];
		for (int i = 1; i <= cleaner - 1; i++)
			temp[i - 1][C - 1] = temp[i][C - 1];
		for (int j = C - 2; j >= 1; j--)
			temp[cleaner - 1][j + 1] = temp[cleaner - 1][j];
		temp[cleaner - 1][1] = 0;	// 주의!

		// 아래쪽
		for (int i = cleaner + 2; i < R; i++)
			temp[i - 1][0] = temp[i][0];
		for (int j = 1; j < C; j++)
			temp[R - 1][j - 1] = temp[R - 1][j];
		for (int i = R - 2; i >= cleaner; i--)
			temp[i + 1][C - 1] = temp[i][C - 1];
		for (int j = C - 2; j >= 1; j--)
			temp[cleaner][j + 1] = temp[cleaner][j];
		temp[cleaner][1] = 0;	// 주의!
	}
	
}
