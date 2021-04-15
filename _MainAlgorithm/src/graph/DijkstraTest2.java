package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int start = 5;
		int end = 1;
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V];		// 출발지에서 자신까지 오는 최단거리
		boolean[] visited = new boolean[V];	// 처리한 정점 여부 관리
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		
		int min = 0, current = 0;
		for (int i = 0; i < V; i++) {
			min = INFINITY;
			// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			if (current == end) break;
			
			// 2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update
			for (int j = 0; j < V; j++) {
				// min -> distance[current]
				if (!visited[j] && matrix[current][j] != 0 && distance[j] > min + matrix[current][j]) {
					distance[j] = min + matrix[current][j];
				}
			}
		}
		
		System.out.println("출발지[0]부터 도착지[" + (V-1) + "]까지의 최단거리 : " + distance[end]);
	}
}

/*

7
0 0 0 0 0 0 0
0 0 0 41 10 24 25
0 0 0 22 66 0 0
0 41 22 0 0 24 0
0 10 66 0 0 0 50
0 24 0 24 0 0 2
0 25 0 0 50 2 0

5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

output==> 8


4
0 94 53 16
79 0 24 18
91 80 0 98
26 51 92 0

output==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

output==> 14

 */