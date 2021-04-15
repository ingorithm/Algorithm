package problem2012;

import java.util.Arrays;
import java.util.Scanner;

public class Q2250 {
	private static int N, colNum = 1, resultRow, resultCol;
	private static int[] minCol, maxCol;
	private static Node[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		minCol = new int[N + 1];
		maxCol = new int[N + 1];
		tree = new Node[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new Node(-1, -1, -1);
		
		// input
		for (int i = 1; i <= N; i++) {
			int tempI = sc.nextInt();
			int tempL = sc.nextInt();
			int tempR = sc.nextInt();
			
			tree[tempI].l = tempL;
			tree[tempI].r = tempR;
			
			if (tempL != -1)
				tree[tempL].p = tempI;
			if (tempR != -1)
				tree[tempR].p = tempI;
		}
		
		Arrays.fill(minCol, Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++)
			if (tree[i].p == -1) {
				inorder(i, 1);
				break;
			}
		
		calc();
		System.out.println(resultRow + " " + resultCol);
		sc.close();
	}
	
	private static void inorder(int num, int level) {
		// left
		if (tree[num].l != -1)
			inorder(tree[num].l, level + 1);
		
		// current
		minCol[level] = Math.min(minCol[level], colNum);
		maxCol[level] = Math.max(maxCol[level], colNum);
		colNum++;
		
		// right
		if (tree[num].r != -1)
			inorder(tree[num].r, level + 1);
	}
	
	private static void calc() {
		for (int i = 1; i <= N; i++) {
			if (minCol[i] == Integer.MAX_VALUE)
				return;
			
			int gap = maxCol[i] - minCol[i] + 1;
			if (resultCol < gap) {
				resultCol = gap;
				resultRow = i;
			}
		}
	}
	
	private static class Node {
		int p, l, r;	// parent, left, right

		public Node(int p, int l, int r) {
			this.p = -1;
			this.l = l;
			this.r = r;
		}
	}
}
