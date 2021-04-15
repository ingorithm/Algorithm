package problem2102;

// 혹시나 프로그래머스와 같이 IDE를 사용하지 못하는 경우라면, import java.util.*;를 사용하는 것을 권장한다.
// 문제를 풀면서 사용하게 되는 거의 모든 메소드들이 들어있고, 검정시스템에서는 시간적 차이가 거의 나지 않는다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
<BFS를 이용한 No.1012 유기농 배추>

※ 문제 접근 방법
0. 손으로 문제를 풀어볼 때, 어떤 변수들을 사용하고 어떤 클래스를 구현해야하는지 미리 정해보는 것이 좋다.
1. input을 받는다.
2. 이중 for문으로 배추가 심어졌는지 확인한다.
2-1. 만약 배추가 심어져 있다면 그 지역을 기점으로 BFS 탐색을 진행한다.
3. BFS 탐색을 진행하면서 map에 몇 번째 그룹인지 표시하면, 나중에 map을 이용한 다양한 활용이 가능하다.
	cf) 조금 더 수준이 있는 문제라면, 이 표시해둔 그룹 번호(cnt)를 이용해서 다양한 작업을 해야한다.(이 문제에서는 크게 활용되지 않는다.)
4. 최종적으로 cnt값을 출력한다.

※ 왜 DFS 대신 BFS를 사용했는가?
 -> 통상적으로 DFS와 BFS를 동시에 사용할 수 있는 문제는 BFS를 사용하는 추세이다.
 -> DFS는 스택을 주로 이용하지만, BFS는 큐를 이용하기 때문에 넣은 객체의 순서의 우선순위를 정하기 위해서 PriorityQueue를 사용할 수 있다.(DFS의 경우는 어렵다.)
 -> 조금 수준 높은 탐색 문제에서 PriorityQueue의 활용성은 매우 높다.(출제 빈도수도 높다.)
	cf) PriorityQueue의 경우에는 큐 안에 들어가는 객체의 class를 정의하고, Comparable 인터페이스를 implements해서 사용해야한다.
	-> 잘 모른다면 문의바람!
 -> 따라서, 결론은 반드시 스택을 사용해야 하는 경우가 아니라면 아래와 같은 방법으로 완전탐색 문제를 해결하는 것을 권장한다.

※ 디버깅이나 map의 최종결과를 찍어보면서 이해하라.
 -> 디버깅 방법을 잘 모른다면 문의바람! ex) F5, F6, F8, F11, ctrl + shift + B 등등
 -> 혹시나 해서 하는 말이지만, 자동완성(ctrl + space bar)이나 복사(ctrl + alt + 아래방향키), 이동(alt + 아래방향키), 삭제(ctrl + D) 등등 이클립스 단축키를 손에 익히는 것을 추천!!

※ 본 문제는 BFS의 기본적인 문제로 여러 번 반복학습으로 BFS와 Queue의 활용에 익숙해지는 것을 권장!

※ 아래는 내 코딩 스타일이지, 본인에 맞게 빠르게 개발할 수 있는 코딩 스타일을 찾는 것이 중요!!

※ 주저리주저리 쓰느라 너무 주석이 길어졌지만, 혹시나 코드를 보고 이해가 안될 경우 언제든지 문의바람!
 */
public class Q1012 {
	// private는 그냥 같은 프로젝트 안에 있는 다른 파일에서 접근을 하지 못하게 막아놓은 것이고, static을 사용하면 전역변수처럼 사용이 가능하다.
	// 문제풀이의 경우 static으로 선언하는 것이 좋지만, 변수에 실수로 접근하여 값을 변경하지 않는 것에 주의해야한다.
	// 나의 코딩 스타일은 대략적으로 import, 변수 선언, 클래스 선언, main함수, 메소드 순으로 작성하며, 이것이 최근 젊은 개발자들의 스타일
	private static int testCase, result[];	// 테스트케이스와 그 결과 값들을 저장하는 배열, 문제에 따라 long형 result 배열을 만들어야하는 경우도 있다.(int형의 MAX_VALUE는 대략 21억)
	private static int N, M, K, map[][];	// row, column, 배추의 개수, 배추밭을 나타내는 map
	private static Queue<Point> q;		// BFS를 위한 Queue, 문제에 따라 PriorityQueue를 사용해야하는 경우도 있다.
	private static boolean check[][];	// map에서 방문 여부를 나타내는 2차원 boolean visited 배열, Queue와 거의 항상 세트로 활용된다.
	private static final int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상 하 좌 우, final(상수)은 그냥 내 코딩 스타일
	
	// 배열의 (i, j)값을 담을 class, Queue에 담을 객체
	private static class Point {
		int i, j;	// row, column

		public Point(int i, int j) {	// 이것도 한가지 팁이지만, shift + alt + S 를 이용하여 빠르게 getter, setter나 생성자를 만드는 것도 중요하다!!
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		// Scanner를 사용해도 무방하지만, input의 크기가 커지면(대략적으로 10000이 넘어가면?) 같은 알고리즘으로 푼다고 해도 시간초과 나는 문제들도 더러있다.
		// BufferedReader의 사용을 생활화 하는 것을 권장!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	// br.readLine은 함수에 throws IOException을 붙여야 사용가능하다.(빠른 문제해결(ctrl + 1)로 해결 가능)
		testCase = Integer.parseInt(st.nextToken());
		result = new int[testCase];
		
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			q = new LinkedList<>();
			check = new boolean[N][M];
			
			// input
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			int cnt = 0;	// 배추흰지렁이 개수
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if (map[i][j] == 1 && check[i][j] == false) {
						cnt++;
						bfs(i, j, cnt);
					}
			result[tc] = cnt;
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}
	
	// BFS의 대략적인 진행 순서
	static void bfs(int i, int j, int cnt) {
		
		// initialization
		q.offer(new Point(i, j));
		check[i][j] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.i][p.j] = cnt;
			
			// 상하좌우로 탐색
			for (int d = 0; d < dir.length; d++) {
				int ni = p.i + dir[d][0];
				int nj = p.j + dir[d][1];
				
				// boundary check
				if (ni < 0 || ni >= N || nj < 0 || nj >= M)
					continue;
				
				// 만약 배추가 있고, 방문하지 않은 곳이라면 큐에 넣기
				if (map[ni][nj] == 1 && check[ni][nj] == false) {
					check[ni][nj] = true;
					q.offer(new Point(ni, nj));
				}
			}
		}
	}
	
}
