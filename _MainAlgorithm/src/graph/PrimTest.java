package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] input = new int[N][N];
		int[] minEdge = new int[N];
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}	// i노드에서 j노드까지의 비용을 모두 배열에 저장
		
		int minVertex, min, result = 0;
		
		// Vertex 0부터 시작
		minEdge[0] = 0;	// 시작점 최소 간선비용은 0
		
		for (int c = 0; c < N; c++) {
			// 신장트리에 포함되지 않은 정점 중 최소 간선비용의 정점 찾기
			min = Integer.MAX_VALUE;
			minVertex = 0;
			
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			result += min;				// 신장트리 비용 누적
			visited[minVertex] = true;	// 신장트리에 포함
			
			// 선택된 최소비용 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 비용 계산하여 최소값 갱신
			for (int i = 0; i < N; i++) {
				if (!visited[i] && input[minVertex][i] != 0 && minEdge[i] > input[minVertex][i]) {
					minEdge[i] = input[minVertex][i];
				}
			}
		}
		
		System.out.println(result);
	}
}

/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
*/