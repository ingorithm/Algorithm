package problem2008;	// P

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {
	static int N, K, map[], result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Node> q = new LinkedList<>();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[100001];
		map[K] = -1;	// 빈칸과 구분
		
		q.offer(new Node(0, K));
		while (!q.isEmpty()) {
			Node n = q.poll();
			int d = n.depth;
			int i = n.index;
			
			if (i == N) {
				result = Math.min(result, d);
				break;
			}
			
			if (map[i] == 0)
				map[i] = d;
			
			if (i - 1 >= 0 && map[i - 1] == 0)
				q.offer(new Node(d + 1, i - 1));
			if (i + 1 <= 100000 && map[i + 1] == 0)
				q.offer(new Node(d + 1, i + 1));
			if (i % 2 == 0 && map[i / 2] == 0)
				q.offer(new Node(d + 1, i / 2));
		}
		System.out.println(result);
	}
	
	static class Node {
		int depth;
		int index;
		
		Node(int d, int i) {
			depth = d;
			index = i;
		}
	}
}
