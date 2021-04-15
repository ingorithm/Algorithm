package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q19238 {
	private static int N, M, F;				// Fuel
	private static int ti, tj, di, dj;		// Taxi's i/j, temp i/j
	private static int[][] map;
	private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static Person[] people;
	private static PriorityQueue<Person> pq;
	private static boolean[][] check;
	private static boolean cant;	// 연료 바닥 or 이동불가
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		people = new Person[M];
		
		// input
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		ti = Integer.parseInt(st.nextToken());
		tj = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			int ej = Integer.parseInt(st.nextToken());
			map[si][sj] = 2;
			people[i] = new Person(si, sj, ei, ej);
		}
		
		cant = false;
		for (int i = 1; i <= M; i++) {
			if (cant)
				break;
			
			// 손님 찾기
			F -= search();
			if (F < 0) {
				cant = true;
				break;
			}

			// 목적지 찾기
			int d = drive(ti, tj, di, dj);
			if (F - d < 0) {
				cant = true;
				break;
			} else
				F += d;
		}
		
		if (cant)
			System.out.println(-1);
		else
			System.out.println(F);
	}

	// 손님 찾는 함수
	private static int search() {
		int ret = 0;
		pq = new PriorityQueue<>();
		check = new boolean[N + 1][N + 1];
		
		pq.offer(new Person(ti, tj, 0));
		check[ti][tj] = true;
		
		while (!pq.isEmpty()) {
			Person p = pq.poll();
			
			if (map[p.i][p.j] == 2) {
				map[p.i][p.j] = 0;
				ti = p.i;
				tj = p.j;
				for (int i = 0; i < M; i++)
					if (people[i].i == ti && people[i].j == tj) {
						di = people[i].di;
						dj = people[i].dj;
						break;
					}
				return p.d;
			}
			
			for (int d = 0; d < dir.length; d++) {
				int ni = p.i + dir[d][0];
				int nj = p.j + dir[d][1];
				
				if (ni <= 0 || ni > N || nj <= 0 || nj > N)
					continue;
				
				if (map[ni][nj] != 1 && !check[ni][nj]) {
					check[ni][nj] = true;
					pq.offer(new Person(ni, nj, p.d + 1));
				}
			}
		}
		
		cant = true;
		return ret;
	}
	
	// 목적지로 데려가는 함수
	private static int drive(int i, int j, int di, int dj) {
		int ret = 0;
		pq = new PriorityQueue<>();
		check = new boolean[N + 1][N + 1];
		
		pq.offer(new Person(i, j, 0));
		check[i][j] = true;
		
		while (!pq.isEmpty()) {
			Person p = pq.poll();
			
			if (p.i == di && p.j == dj) {
				ti = di;
				tj = dj;
				return p.d;
			}
			
			for (int d = 0; d < dir.length; d++) {
				int ni = p.i + dir[d][0];
				int nj = p.j + dir[d][1];
				
				if (ni <= 0 || ni > N || nj <= 0 || nj > N)
					continue;
				
				if (map[ni][nj] != 1 && !check[ni][nj]) {
					check[ni][nj] = true;
					pq.offer(new Person(ni, nj, p.d + 1));
				}
			}
		}
		
		cant = true;
		return ret;
	}
	
	private static class Person implements Comparable<Person> {
		int i, j, di, dj, d;	// start i/j, destination i/j, distance

		public Person(int i, int j, int di, int dj) {
			this.i = i;
			this.j = j;
			this.di = di;
			this.dj = dj;
			this.d = 0;
		}

		// for BFS
		public Person(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		}

		@Override
		public int compareTo(Person o) {
			if (this.d == o.d && this.i == o.i)
				return this.j - o.j;
			
			if (this.d == o.d)
				return this.i - o.i;
			
			return this.d - o.d;
		}
	}
}
