package problem2009;

import java.util.Scanner;

public class Q2578 {
	static int[][] map;
	static boolean[][] checked;
	static int[] number;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		checked = new boolean[5][5];
		number = new int[25];
		
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				map[i][j] = sc.nextInt();
		
		for (int i = 0; i < 25; i++)
			number[i] = sc.nextInt();
		
		int answer = 0;
		for (int i = 0; i < 25; i++) {
			checkNum(number[i]);
			if (checkBingo()) {
				answer = i + 1;
				break;
			}
		}
		System.out.println(answer);
	}
	
	private static void checkNum(int num) {
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				if (map[i][j] == num) {
					checked[i][j] = true;
					return;
				}
	}
	
	private static boolean checkBingo() {
		int bingo = 0;
		boolean flag;

		for (int i = 0; i < 5; i++) {
			flag = true;
			for (int j = 0; j < 5; j++) {
				if (flag && checked[i][j] == true)
					continue;
				else
					flag = false;
			}
			if (flag)
				bingo++;
		}
		
		for (int i = 0; i < 5; i++) {
			flag = true;
			for (int j = 0; j < 5; j++) {
				if (flag && checked[j][i] == true)
					continue;
				else
					flag = false;
			}
			if (flag)
				bingo++;
		}
		
		flag = true;
		for (int i = 0; i < 5; i++) {
			if (flag && checked[i][i] == true)
				continue;
			else
				flag = false;
		}
		if (flag)
			bingo++;
		
		flag = true;
		for (int i = 0; i < 5; i++) {
			if (flag && checked[i][4 - i] == true)
				continue;
			else
				flag = false;
		}
		if (flag)
			bingo++;
		
		if (bingo >= 3)
			return true;
		else
			return false;
	}

}
