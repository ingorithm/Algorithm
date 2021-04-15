package problem2010;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
소요시간 : 약 50분(두 번째 품)

1. subset으로 지역을 나눈다.
2. A와 B로 나뉜 구역이 올바른 선거구인지 판단한다.
3. A와 B의 인구수의 차이를 구한다.

!주의 : N(2~10)이 작기 때문에 isOK() 함수에서 반복문을 많이 돌려도 괜찮다.
!주의 : isOK() 함수에서 확인해야하는 부분이 많고 그로 인해 사용하는 자료구조나 변수가 많다.
 */
public class Q17471_2 {
	private static int N, result = Integer.MAX_VALUE;
	private static int[] people;	// 도시의 사람 수
	private static boolean[][] adj;	// 인접행렬
	private static boolean[] check;	// 도시 선택 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		people = new int[N + 1];
		adj = new boolean[N + 1][N + 1];
		check = new boolean[N + 1];
		
		// input
		for (int i = 1; i <= N; i++)
			people[i] = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			for (int j = 1; j <= num; j++) {
				int end = sc.nextInt();
				adj[i][end] = true;
			}
		}
		
		subset(1);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	// 부분집합
	private static void subset(int idx) {
		if (idx == N + 1) {
			if (isOK()) {
				int sumA = 0;
				int sumB = 0;

				for (int i = 1; i <= N; i++)
					if (check[i])	// check가 되어있으면 A에
						sumA += people[i];
					else			// 아니면 B에
						sumB += people[i];
				
				result = Math.min(result, Math.abs(sumA - sumB));
			}
			return;
		}
		
		check[idx] = true;
		subset(idx + 1);
		check[idx] = false;
		subset(idx + 1);
	}

	// 현재 나뉘어진 선거구가 올바를 때
	private static boolean isOK() {
		Queue<Integer> qA = new LinkedList<>();
		Queue<Integer> qB = new LinkedList<>();
		List<Integer> listA = new LinkedList<>();
		List<Integer> listB = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++)
			if (check[i])	// check가 되어있으면 A에
				listA.add(i);
			else			// 아니면 B에
				listB.add(i);
		
		if (listA.isEmpty() || listB.isEmpty())
			return false;
		
		// groupA에 대한 BFS
		int first = listA.get(0);
		qA.offer(first);
		visited[first] = true;
		while (!qA.isEmpty()) {
			int start = qA.poll();
			for (int i = 1; i <= N; i++)
				if (check[i] && adj[start][i] && !visited[i]) {
					visited[i] = true;
					qA.offer(i);
				}
		}
		
		// groupB에 대한 BFS		
		first = listB.get(0);
		qB.offer(first);
		visited[first] = true;
		while (!qB.isEmpty()) {
			int start = qB.poll();
			for (int i = 1; i <= N; i++)
				if (!check[i] && adj[start][i] && !visited[i]) {
					visited[i] = true;					
					qB.offer(i);
				}
		}
		
		// BFS 탐색에서 방문하지 않았으면
		for (int i = 1; i <= N; i++)
			if (!visited[i])
				return false;
		
		return true;
	}
}
