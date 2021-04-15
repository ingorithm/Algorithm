package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
소요시간 : 약 1시간 10분(두 번째 품)

1. comb() : column 중 궁수가 위치한 세 곳을 선정
2. game()
	2-1 : 적들의 위치를 리스트로 저장
	2-2 : 궁수 3명이 모두 화살을 쏘고 적이 움직이는 것을 한 턴으로 while문을 실행
	2-3 : 궁수 한 명씩 각각의 적과의 거리를 PriorityQueue를 이용해서 정렬 후 거리 안의 적을 죽음 표시
	2-4 : Iterator를 사용해 죽거나 map을 벗어사는 적 처리 후 아래로 한 칸 이동

!주의 : Enemy class에 Comparable 인터페이스를 상속(PriorityQueue의 정렬에 사용)
!주의 : game() 함수의 주석부분은 틀리고, iterator를 사용해야 맞는다..ㅠ (왜 그런지는 대충 알겠는데 공부를 좀 해야될 것 같다..)
 */
public class Q17135_2 {
	private static int N, M, D, result;
	private static int[][] map;
	private static int[] archers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		archers = new int[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		System.out.println(result);
	}
	
	// 궁수 3명의 위치를 저장 후 game() 호출
	private static void comb(int idx, int cnt) {
		if (cnt == 3) {
			game();
			return;
		}
		
		for (int i = idx; i < M; i++) {
			archers[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}
	
	// 현재 지정된 3명의 궁수의 위치에서 게임을 진행 후 최댓값 저장
	private static void game() {
		int cnt = 0;
		List<Enemy> enemies = new ArrayList<>();
		
		// map에서 적의 위치를 List에 저장
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 1)
					enemies.add(new Enemy(i, j));
		
		// 적이 모두 없어질 때까지 진행
		while (!enemies.isEmpty()) {
			// 궁수 한 명씩 활을 쏨
			for (int a = 0; a < 3; a++) {
				PriorityQueue<Enemy> pq = new PriorityQueue<>();
				
				for (int e = 0; e < enemies.size(); e++) {
					Enemy cur = enemies.get(e);
					cur.d = Math.abs(cur.r - N) + Math.abs(cur.c - archers[a]);	// 현재 궁수와 적의 거리를 저장
					pq.offer(cur);
				}
				
				// 적이 현재 궁수의 범위 안에 들면 죽임
				Enemy target = pq.poll();
				if (target.d <= D)
					target.dead = true;
			}
			
			Iterator<Enemy> iter = enemies.iterator();
            while(iter.hasNext()) {
            	Enemy enemy = iter.next();
            	if (enemy.dead) {				// 사망자 처리
            		iter.remove();
            		cnt++;
            	} else if (enemy.r == N - 1) {	// 맨 아래 적 제외
            		iter.remove();
                } else {						// 남은 적 아래로 한 칸 이동
                    enemy.r++;
                }
            }
            
//			for (int e = 0; e < enemies.size(); e++) {
//				Enemy enemy = enemies.get(e);
//				if (enemy.dead) {
//					cnt++;
//					enemies.remove(e);
//				} else if (enemy.r == N - 1)
//					enemies.remove(e);
//				else
//					enemy.r++;
//			}
		}
		
		result = Math.max(result, cnt);
	}

	private static class Enemy implements Comparable<Enemy> {
		int r;
		int c;
		int d;
		boolean dead;
		
		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Enemy o) {
			if (this.d == o.d)
				return this.c - o.c;
			return this.d - o.d;
		}
	}
}
