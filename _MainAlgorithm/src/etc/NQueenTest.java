package etc;

import java.util.Scanner;

public class NQueenTest {
	static int N, answer;
	static int[] col;	// 각 행의 퀸의 위치를 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
		
		setQueens(1);
		System.out.println("가능한 가짓수 : " + answer);
	}
	
	// Queen을 현재 행에 놓기
	public static void setQueens(int rowNo) {
		if (rowNo > N) {
			answer++;
			return;
		}
		
		// 가능한 선택지
		for (int j = 1; j <= N; j++) {
			col[rowNo] = j;
			if (checking(rowNo))	// 현제 퀸의 열위치가 가능하다면 다음 퀸으로
				setQueens(rowNo + 1);
			// 일차원 배열로 퀸의 위치를 관리하므로 시도했던 선택지 열 값을 되돌릴 필요가 없다.
		}
	}
	
	// rowNo행의 퀸을 놓는게 가능한지 체크 : 놓을 수 있다면 true
	private static boolean checking(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			// col[rowNo] == col[i] : 같은열 체크
			// Math.abs(col[rowNo] - col[i]) == rowNo - i : 대각선 체크
			if (col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == rowNo - i)
				return false;
		}
		return true;
	}
}
