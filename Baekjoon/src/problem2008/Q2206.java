package problem2008;	// P, 재검토 필요

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2206 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		
		// 한 좌표의 방문표시는 2 개로 또 나뉜다.
		// 벽을 뚫고 지나온 방문인지 그렇지 않은 방문인지.
		
		boolean[][][] visit = new boolean[N][M][2];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0, 1));
		
		visit[0][0][0] = true;
		
		boolean isok = false;
		
		while (!queue.isEmpty()) {
			
			Node node = queue.poll();
			
			if (node.y == N - 1 && node.x == M - 1) {
				System.out.println(node.cnt);
				isok = true;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				
				int nr = node.y + dy[d];
				int nc = node.x + dx[d];
				int chance = node.chance;
				
				int cnt = node.cnt;
				
				if ( nr < 0 || nc < 0 || nr >= N || nc >= M ) continue;
				
				// 벽이 아니면 , 현재 방문의 벽 뚤은 여부를 그대로 사용하여 visit 확인
				if ( map[nr][nc] == 0 && !visit[nr][nc][chance] ) {
					
					queue.add(new Node(nr, nc, chance, cnt + 1));					
					visit[nr][nc][chance] = true;
					
				// 벽이면, 벽 뚫고 방문 visit && 벽 뚫고 방문하지 않은 경우에만
				} else if ( map[nr][nc] == 1 && !visit[nr][nc][1] && chance == 0 ) {
					
					queue.add(new Node(nr, nc, chance + 1, cnt + 1));
					visit[nr][nc][1] = true;
				}
			}
		}
		if (!isok)
			System.out.println(-1);
		
		sc.close();
	}

	static int[] dy = { -1, 1,  0, 0 };
	static int[] dx = {  0, 0, -1, 1 };

	static class Node {
		int y, x;
		int chance;	// 해당 방문 시 벽 뚫기를 했었는지 여부 0: NO, 1: YES
		int cnt;

		Node(int r, int c, int chance, int cnt) {
			this.y = r;
			this.x = c;
			this.chance = chance;
			this.cnt = cnt;
		}
	}
}
