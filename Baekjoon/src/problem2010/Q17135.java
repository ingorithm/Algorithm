package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q17135 {
	private static int N, M, D, result;
	private static int[][] map;
	private static int[] archers = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		System.out.println(result);
	}

	private static void comb(int idx, int cnt) {
		if (cnt == 3) {
			check();
            return;
		}
		
		for (int i = idx; i < M; i++) {
			archers[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}
	
	private static void check() {
        // 각각의 상황에 맞춰 적군을 복사해서 써야한다.
        List<Enemy> enemies = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 1) {
                    enemies.add(new Enemy(y, x));
                }
            }
        }

        // 시뮬레이션 시작
        // 반복문 한번 수행이 한 턴
        // 적군의 r이 R이 되면 종료하고 카운트
        int deadMan = 0;
        while (true) {
        	
            // 궁수가 한 명씩 발사
            for (int i = 0; i < archers.length; i++) {
            	
                // pq에는 각 궁수가 쏠 수 있는 적이 등록됨
            	// 이중 적군 한명만 제거 대상
            	// 꺼낼 때 자동으로 우선순위에 의해 적이 선택됨
                PriorityQueue<Enemy> pqEnemies = new PriorityQueue<>();
                int archer = archers[i];
                for (int e = 0; e < enemies.size(); e++) {
                    Enemy enemy = enemies.get(e);
                    // 턴 마다 새롭게 d 계산
                    enemy.d = Math.abs(archer - enemy.c) + Math.abs(N - enemy.r);
                    
                    // 사정거리에 있다고 다 죽는 건 아님
                    // 사정거리보다 더 가까워도 살아 남을 수 있음.
                    // 그 모든 대상을 pqEnemies 에 넣는다. 
                    if (enemy.d <= D) {
                        pqEnemies.offer(enemy);
                    }
                }
                // pq 가 비어 있지 않다면 맨 처음 녀석은 사망 표시
                if (!pqEnemies.isEmpty()) {
                    pqEnemies.poll().isTargeted = true;
                }
            }

            // 사망자 정리 및 이동, 종료 체크
//            for (int e = 0; e < enemies.size(); e++) {
//                Enemy enemy = enemies.get(e);
//                if (enemy.isTargeted) {
//                    enemies.remove(e--);	// 하나 지웠다면 인덱스 조절 필요
//                    deadMan++;
//                } else if (enemy.r == R - 1) {//
//                    enemies.remove(e--);	// 끝까지 도달하면 지우고 인덱스 조절
//                } else {
//                    enemy.r++;
//                }
//            }
            
            Iterator<Enemy> iter = enemies.iterator();
            while(iter.hasNext()) {
            	Enemy enemy = iter.next();
            	
            	if (enemy.isTargeted) {			// 사망자 처리
            		iter.remove();
            		deadMan++;
            	} else if (enemy.r == N - 1) {	// 맨 아래 적 제외
            		iter.remove();
                } else {						// 남은 적 아래로 한 칸 이동
                    enemy.r++;
                }
            }
            
            // 모든 병사가 다 사라지면
            if (enemies.size() == 0) break;
        }
        
        result = Math.max(result, deadMan);
    }
	
	private static class Enemy implements Comparable<Enemy> {
		int r, c, d;
		boolean isTargeted;
		
		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Enemy o) {
			if (this.d == o.d)
				return this.c - o.c;
			else
				return this.d - o.d;
		}
		
	}
}
