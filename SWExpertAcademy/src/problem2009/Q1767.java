package problem2009;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 부분집합
public class Q1767 {
	static int testCase;
	static int N, circuit[][];
	static int max, min, totalCnt;	// 최대 코어수, 최소 전선길이, 처리할 코어 수
	static List<int[]> list;		// 처리해야할 가장자리가 아닌 코어들을 저장할 리스트
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			circuit = new int[N][N];
			list = new ArrayList<>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					circuit[i][j] = Integer.parseInt(st.nextToken());
					if ((i == 0 || j == 0 || i == N - 1 || j == N -1) && circuit[i][j] == 1)	// 가장자리에 있는 코어는 리스트에 추가하지 않음
						continue;
					// 가장자리에 있지 않은 코어 리스트에 추가
					if (circuit[i][j] == 1) {
						list.add(new int[] {i, j});
						totalCnt++;
					}
				}
			}	// end input
			
			go(0, 0);
			System.out.println("#" + tc + " " + min);
		}	// end testCase
	}	// end main
	
	// index : 처리할 코어의 index, cCnt : 직전까지 포함된 코어 수
	private static void go(int index, int cCnt) {
		// 기저조건
		if (index == totalCnt) {
			int res = getLength();	// 놓아진 전선의 길이를 계산
			if (max < cCnt) {
				max = cCnt;
				min = res;
			} else if (max == cCnt) {	// 최대 코어 개수가 같다면 최소 길이의 전선으로
				if (min > res)
					min = res;
			}
			return;
		}
		
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		
		// 해당 코어 선택
		for (int d = 0; d < dir.length; d++) {	// 4방향의 직선으로 전선 놓아보는 시도
			if (isAvailable(r, c, d)) {			// 해당 방향으로 전선 놓는게 가능한지 체크
				setStatus(r, c, d, 2);			// 가능하다면 전선 놓기 : 2로 세팅
				go(index + 1, cCnt + 1);		// 다음 코어로 넘어가기
				setStatus(r, c, d, 0);			// 놓았던 전선 지우기(되돌리기)
			}
		}
		
		// 해당 코어 비선택
		go(index + 1, cCnt); // 아무런 전선도 놓지 않고 다음 코어로 넘어가기
	}
	
	// 현 코어의 위치에서 해당 방향으로 전선을 놓는게 가능한지 체크
	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		
		while (true) {
			nr += dir[d][0];
			nc += dir[d][1];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				break;
			if (circuit[nr][nc] != 0)
				return false;
		}
		return true;
	}
	
	// 현 코어의 위치에서 해당 방향으로 전선을 놓거나(2) 지우는(0) 세팅
	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		
		while (true) {
			nr += dir[d][0];
			nc += dir[d][1];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				break;
			circuit[nr][nc] = s;
		}
	}
	
	private static int getLength() {
		int cnt = 0;
		
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++)
				if (circuit[r][c] == 2)
					cnt++;
		return cnt;
	}
}

/*

3
7
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0
9
0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0 0
0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 1
11
0 0 1 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 1
0 0 0 1 0 0 0 0 1 0 0
0 1 0 1 1 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0

#1 12
#2 10
#3 24

*/
