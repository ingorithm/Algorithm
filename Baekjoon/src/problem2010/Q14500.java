package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
소요시간 : 약 1시간 30분

1. 모든 도형모양과 회전, 대칭의 칸을 배열로 저장
2. 모든 칸을 돌면서 테트로미노를 놓을 수 있으면 그 값의 최댓값을 저장

!특징 : 노가다로 풀어서 힘들었음 ㅠ
 */
public class Q14500 {
	private static int N, M, result;
	private static int map[][];
	private static final int tet[][][][] = {
			{ {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, {{0, 0}, {1, 0}, {2, 0}, {3, 0}} },	// I
			{ {{0, 0}, {0, 1}, {1, 0}, {1, 1}} },	// O
			{ {{0, 0}, {-2, -1}, {-1, -1}, {0, -1}}, {{0, 0}, {-1, 0}, {-1, 1}, {-1, 2}}, {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, {{0, 0}, {1, -2}, {1, -1}, {1, 0}},
				{{0, 0}, {0, 1}, {-1, 1}, {-2, 1}}, {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, {{0, 0}, {0, -1}, {1, -1}, {2, -1}}, {{0, 0}, {-1, 0}, {-1, -1}, {-1, -2}} },	// L
			{ {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
				{{0, 0}, {1, 0}, {1, -1}, {2, -1}}, {{0, 0}, {0, -1}, {-1, -1}, {-1, -2}} },	// S
			{ {{0, 0}, {-1, -1}, {-1, 0}, {-1, 1}}, {{0, 0}, {-1, 1}, {0, 1}, {1, 1}}, {{0, 0}, {1, -1}, {1, 0}, {1, 1}}, {{0, 0}, {-1, -1}, {0, -1}, {1, -1}} }	// T
	};
	// [도형모양][회전][칸][row, col]
	// 도형모양 : I, O, L, S, T
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				tetromino(i, j);
		
		System.out.println(result);
	}
	
	// 현재 위치(i, j)에서 다양한 모양과 회전을 적용시키는 함수
	private static void tetromino(int i, int j) {
		for (int s = 0; s < tet.length; s++)	// shape 결정
			for (int r = 0; r < tet[s].length; r++)	// rotate 결정
				result = Math.max(result, sumFour(s, r, i, j));
	}
	
	// 도형의 모양과 회전이 결정 되었을 때, 4칸의 합을 구하는 함수
	private static int sumFour(int s, int r, int i, int j) {
		int sum = 0;
		
		for (int p = 0; p < tet[s][r].length; p++) {	// point 결정
			int ni = i + tet[s][r][p][0];
			int nj = j + tet[s][r][p][1];
			
			if (ni < 0 || ni >= N || nj < 0 || nj >= M)
				return 0;
			
			sum += map[ni][nj];
		}
		
		return sum;
	}

}
