package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;
 
// 크루스칼 알고리즘이용
/*
정점수 간선수
시작정점 끝정점 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

==>10
----------------------------------

7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14

==>31

 */
/**
 * 
 * @author taeheekim
 *
 */
public class KruskalTest{
	
	static class Edge{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight="
					+ weight + "]";
		}
	}
	static ArrayList<Edge> edgeList = new ArrayList<Edge>();	
	private static int[] parent;
	
	public static void make() {
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}
	public static int find(int a){
		if(parent[a] == a) return a;// 자신이 루트이면 그냥 자신의 번호 리턴
		return parent[a] = find(parent[a]);
	}
	
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot){ // 두 노드의 root가 다르면 합침
			parent[bRoot] = aRoot;
			return true;
		}
		return false;
	}	
	
	static int V,E;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V];
        
        for(int i=0; i<E; ++i){
        	st = new StringTokenizer(br.readLine().trim());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
  
	        edgeList.add(new Edge(from ,to, weight));

        }//간선 저장
        
        // 간선비용이 작은 순서대로 정렬
        Collections.sort(edgeList, new Comparator<Edge>(){
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
        });

        make();
        int result = 0;
        int count=0;// 연결 간선수
	    for(Edge edge : edgeList){
	    	if(union(edge.start,edge.end)){ // 싸이클이 발생하지 않았으면
	    		result += edge.weight;
	    		if(++count == V-1){ // 연결 간선수가 정점수-1이면 다 연결한 것임.
	    			break;
	    		}
	    	}
	    }
        System.out.println(result);
    }
}// end class
