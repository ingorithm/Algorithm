package problem2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q21608 {
	static int N, result;
	static int[][] map, check;
	static int[][] like;
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken().trim());
		map = new int[N][N];			// 학생들이 앉는 좌석
		like = new int[N * N + 1][4];	// index 학생들이 좋아하는 학생 배열
		
		for (int idx = 0; idx < N * N; idx++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			for (int k = 0; k < 4; k++)
				like[num][k] = Integer.parseInt(st.nextToken());
			
			check = new int[N][N];	// 자리를 정하기 위한 점수 배열
			for (int i = 0; i < N; i++)
				Arrays.fill(check[i], -1);
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					
					// 이미 자리에 배정되어있으면 Pass
					if (map[i][j] != 0)
						continue;
					
					check[i][j] = 0;
					
					// 상하좌우 탐색
					for (int d = 0; d < dir.length; d++) {
						int ni = i + dir[d][0];
						int nj = j + dir[d][1];
						
						if (ni < 0 || ni >= N || nj < 0 || nj >= N)
							continue;
						
						// 인접한 칸에 좋아하는 친구가 있으면 10점 부여
						for (int k = 0; k < 4; k++)
							if (map[ni][nj] == like[num][k])
								check[i][j] += 10;
						
						// 인접한 칸이 비어있으면 1점 부여
						if (map[ni][nj] == 0)
							check[i][j] += 1;
					}
				}
			
			// 위쪽, 왼쪽부터 탐색하면서 큰 값이 나오면 갱신
			int r = 0, c = 0, max = -1;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (max < check[i][j]) {
						r = i;
						c = j;
						max = check[i][j];
					}
			map[r][c] = num;
		}
		
		// 만족도 조사
		result = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int num = map[i][j];
				int cnt = 0;	// 인접한 칸에 좋아하는 학생의 수
				
				for (int d = 0; d < dir.length; d++) {
					int ni = i + dir[d][0];
					int nj = j + dir[d][1];

					if (ni < 0 || ni >= N || nj < 0 || nj >= N)
						continue;
					
					for (int k = 0; k < 4; k++)
						if (map[ni][nj] == like[num][k])
							cnt++;
					}
				
				// 학생 수에 따라 만족도 부여
				switch (cnt) {
				case 1:
					result += 1;
					break;
				case 2:
					result += 10;
					break;
				case 3:
					result += 100;
					break;
				case 4:
					result += 1000;
					break;
				}
			}
		System.out.println(result);
	}

}
