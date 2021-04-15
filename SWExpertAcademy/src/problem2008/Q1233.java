package problem2008;	// P

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1233 {
	static int testCase = 10, N, result[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = new int[testCase + 1];
		
		// test case
		for (int tc = 1; tc <= testCase; tc++) {
			int isCalculate = 1;
			N = sc.nextInt();
			sc.nextLine();
			
			char[] arr = new char[N + 1];
			for (int i = 1; i <= N; i++) {
//				StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
//				arr[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
				arr[i] = sc.nextLine().split(" ")[1].charAt(0);
			}
			
			int index = N;
			if (N % 2 == 0)	// 노드가 짝수일 때는 실패
				isCalculate = 0;
			else {
				while (index != 1) {
					if (arr[index / 2] >= '0' && arr[index / 2] <= '9') {
						isCalculate = 0;
						break;
					}
					else {
						switch (arr[index / 2]) {
						case '+':
							arr[index / 2] = (char)((arr[index - 1] - '0') + (arr[index] - '0'));
						case '-':
							arr[index / 2] = (char)((arr[index - 1] - '0') - (arr[index] - '0'));
						case '*':
							arr[index / 2] = (char)((arr[index - 1] - '0') * (arr[index] - '0'));
						case '/':
							if ((arr[index] - '0') == 0)
								arr[index / 2] = (char)((arr[index - 1] - '0') / 1);
							else
								arr[index / 2] = (char)((arr[index - 1] - '0') / (arr[index] - '0'));
						default:
							index -= 2;
							break;
						}
					}
				}
			}
			
			result[tc] = isCalculate;
		}
		
		// output
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
}
