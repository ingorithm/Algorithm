package problem2008;	// P

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2580 {
	static int[][] sudoku;
	static List<Point> zero;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sudoku = new int[9][9];
		zero = new ArrayList<>();
		
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = sc.nextInt();
				if (sudoku[i][j] == 0)
					zero.add(new Point(i, j));
			}
		
		search(0);
	}

	static void search(int idx) {
		if (idx == zero.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					System.out.print(sudoku[i][j] + " ");
				System.out.println();
			}
			System.exit(0);
		} else {
			Point p = zero.get(idx);
			for (int num = 1; num <= 9; num++)
				if (isPromising(p.i, p.j, num)) {
					sudoku[p.i][p.j] = num;
					search(idx + 1);
					sudoku[p.i][p.j] = 0;
				}
		}
	}
	
	static boolean isPromising(int i, int j, int num) {
		for (int n = 0; n < 9; n++)	// same row or column check
			if (sudoku[n][j] == num || sudoku[i][n] == num)
				return false;
		
		switch (whereAt(i, j)) {
		case 1:
			if (sudoku[i + 1][j + 1] == num || sudoku[i + 1][j + 2] == num || sudoku[i + 2][j + 1] == num || sudoku[i + 2][j + 2] == num)
				return false;
			break;
		case 2:
			if (sudoku[i + 1][j - 1] == num || sudoku[i + 1][j + 1] == num || sudoku[i + 2][j - 1] == num || sudoku[i + 2][j + 1] == num)
				return false;
			break;
		case 3:
			if (sudoku[i + 1][j - 2] == num || sudoku[i + 1][j - 1] == num || sudoku[i + 2][j - 2] == num || sudoku[i + 2][j - 1] == num)
				return false;
			break;
		case 4:
			if (sudoku[i - 1][j + 1] == num || sudoku[i - 1][j + 2] == num || sudoku[i + 1][j + 1] == num || sudoku[i + 1][j + 2] == num)
				return false;
			break;
		case 5:
			if (sudoku[i - 1][j - 1] == num || sudoku[i - 1][j + 1] == num || sudoku[i + 1][j - 1] == num || sudoku[i + 1][j + 1] == num)
				return false;
			break;
		case 6:
			if (sudoku[i - 1][j - 2] == num || sudoku[i - 1][j - 1] == num || sudoku[i + 1][j - 2] == num || sudoku[i + 1][j - 1] == num)
				return false;
			break;
		case 7:
			if (sudoku[i - 2][j + 1] == num || sudoku[i - 2][j + 2] == num || sudoku[i - 1][j + 1] == num || sudoku[i - 1][j + 2] == num)
				return false;
			break;
		case 8:
			if (sudoku[i - 2][j - 1] == num || sudoku[i - 2][j + 1] == num || sudoku[i - 1][j - 1] == num || sudoku[i - 1][j + 1] == num)
				return false;
			break;
		case 9:
			if (sudoku[i - 2][j - 2] == num || sudoku[i - 2][j - 1] == num || sudoku[i - 1][j - 2] == num || sudoku[i - 1][j - 1] == num)
				return false;
			break;
		}
		
		return true;
	}
	
	// 1 2 3
	// 4 5 6
	// 7 8 9
	static int whereAt(int i, int j) {
		if (i % 3 == 0 && j % 3 == 0)
			return 1;
		
		if (i % 3 == 0 && j % 3 == 1)
			return 2;
		
		if (i % 3 == 0 && j % 3 == 2)
			return 3;
		
		if (i % 3 == 1 && j % 3 == 0)
			return 4;
		
		if (i % 3 == 1 && j % 3 == 1)
			return 5;
		
		if (i % 3 == 1 && j % 3 == 2)
			return 6;
		
		if (i % 3 == 2 && j % 3 == 0)
			return 7;
		
		if (i % 3 == 2 && j % 3 == 1)
			return 8;
		
		if (i % 3 == 2 && j % 3 == 2)
			return 9;
		
		return 0;
	}
	
	static class Point {
		int i;
		int j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}

/*
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

0 6 0 0 0 0 2 0 9
0 0 0 8 2 0 5 0 0
0 1 0 9 0 3 0 0 0
3 7 0 0 9 0 0 0 6
1 0 0 0 0 0 0 0 8
2 0 0 0 4 0 0 5 1
0 0 0 5 0 4 0 9 0
0 0 3 0 7 9 0 0 0
5 0 9 0 0 0 0 6 0
*/