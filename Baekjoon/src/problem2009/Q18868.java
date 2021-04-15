package problem2009;	// P

import java.util.Scanner;

public class Q18868 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input M, N
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] score = new int[M][N];
		
		// input score[i][j]
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				score[i][j] = sc.nextInt();
		
		int result = 0;
		for (int firstClass = 0; firstClass < M - 1; firstClass++)	// 첫번째 반과 두번째 반을 비교
			for (int secondClass = firstClass + 1; secondClass < M; secondClass++) {
				boolean sameScore = true;	// 두 반이 비슷한 실력임을 나타내는 boolean형 변수
				for (int firstPerson = 0; firstPerson < N - 1; firstPerson++)	// 각각의 반의 첫번째 사람과 두번째 사람을 비교
					for (int secondPerson = 0; secondPerson < N; secondPerson++) {
						// 첫번째 반의 [첫번째 사람 > 두번째 사람]일때, 두번째 반의 [첫번째 사람 > 두번째 사람]이 아닐경우
						if (score[firstClass][firstPerson] > score[firstClass][secondPerson] && score[secondClass][firstPerson] <= score[secondClass][secondPerson])
							sameScore = false;	// 두 반은 비슷한 실력이 아니다.
						// 첫번째 반의 [첫번째 사람 == 두번째 사람]일때, 두번째 반의 [첫번째 사람 == 두번째 사람]이 아닐경우
						if (score[firstClass][firstPerson] == score[firstClass][secondPerson] && score[secondClass][firstPerson] != score[secondClass][secondPerson])
							sameScore = false;	// 두 반은 비슷한 실력이 아니다.
						// 첫번째 반의 [첫번째 사람 < 두번째 사람]일때, 두번째 반의 [첫번째 사람 < 두번째 사람]이 아닐경우
						if (score[firstClass][firstPerson] < score[firstClass][secondPerson] && score[secondClass][firstPerson] >= score[secondClass][secondPerson])
							sameScore = false;	// 두 반은 비슷한 실력이 아니다.
					}
				if (sameScore)	// 만약 두 반이 비슷한 실력이라면
					result++;	// 결과 + 1
			}
		
		// output
		System.out.println(result);
	}
}

