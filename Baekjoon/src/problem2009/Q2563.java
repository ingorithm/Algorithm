package problem2009;

import java.util.Scanner;

public class Q2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] board = new boolean[100][100];
		int num = sc.nextInt();
		
		for (int n = 0; n < num; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					board[y + i][x + j] = true;
		}
		
		int answer = 0;
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				if (board[i][j] == true)
					answer++;
		System.out.println(answer);
	}

}
