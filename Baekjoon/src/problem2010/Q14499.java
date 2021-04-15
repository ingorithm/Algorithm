package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
소요시간 : 약 45분

1. boundary 검사
2. x, y 위치변경
3. 주사위 굴리기
4. 바닥 상태 검사
5. 주사위 위면 정답 복사

!주의 : 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
	(이 조건을 못봐서 10분 헤맴ㅠ)
 */
public class Q14499 {
	private static int N, M, x, y, K;
	private static int up, down, left, right, over, under;	// 주사위의 상태
	private static int[][] map;
	private static int[] move;
	private static List<Integer> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// input
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		move = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++)
			move[i] = Integer.parseInt(st.nextToken());
		
		int temp;	// up, down, left, right, over, under 값의 switching을 위한 변수
		answer = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			switch (move[i]) {
			case 1:	// East
				
				// 1. boundary 검사
				if (y + 1 == M)
					break;
				
				// 2. x, y 위치변경
				y++;
				
				// 3. 주사위 굴리기
				temp = over;
				over = left;
				left = under;
				under = right;
				right = temp;
				
				// 4. 바닥 상태 검사
				if (map[x][y] == 0)
					map[x][y] = under;
				else {
					under = map[x][y];
					map[x][y] = 0;
				}
				
				// 5. 주사위 위면 정답 복사
				answer.add(over);
				break;
				
			case 2:	// West
				if (y - 1 < 0)
					break;
				y--;
				
				temp = over;
				over = right;
				right = under;
				under = left;
				left = temp;
				
				if (map[x][y] == 0)
					map[x][y] = under;
				else {
					under = map[x][y];
					map[x][y] = 0;
				}
				
				answer.add(over);
				break;
				
			case 3:	// North
				if (x - 1 < 0)
					break;
				x--;
				
				temp = over;
				over = down;
				down = under;
				under = up;
				up = temp;
				
				if (map[x][y] == 0)
					map[x][y] = under;
				else {
					under = map[x][y];
					map[x][y] = 0;					
				}
				
				answer.add(over);
				break;
				
			case 4:	// South
				if (x + 1 == N)
					break;
				x++;
				
				temp = over;
				over = up;
				up = under;
				under = down;
				down = temp;
				
				if (map[x][y] == 0)
					map[x][y] = under;
				else {
					under = map[x][y];
					map[x][y] = 0;					
				}
				
				answer.add(over);
				break;
			}
		}
		
		for (int i = 0; i < answer.size(); i++)
			System.out.println(answer.get(i));
	}
	
}
