package problem2008;

import java.util.Scanner;

public class Q1992 {
	static int N, map[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < N; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		
		String result = dp(0, 0, N);
		System.out.println(result);
	}
	
	private static String dp(int i, int j, int n) {
		StringBuilder sb = new StringBuilder();
		
		if (n == 2) {
			if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1)
				return "1";
			else if (map[i][j] == 0 && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0)
				return "0";
			else {
				sb.append("(");
				sb.append(map[i][j]);
				sb.append(map[i][j + 1]);
				sb.append(map[i + 1][j]);
				sb.append(map[i + 1][j + 1]);
				sb.append(")");
			} 
		} else {
			String str1 = dp(i, j, n / 2);
			String str2 = dp(i, j + n / 2, n / 2);
			String str3 = dp(i + n / 2, j, n / 2);
			String str4 = dp(i + n / 2, j + n / 2, n / 2);
			
			if (str1.equals("1") && str2.equals("1") && str3.equals("1") && str4.equals("1"))
				return "1";
			else if (str1.equals("0") && str2.equals("0") && str3.equals("0") && str4.equals("0"))
				return "0";
			else {
				sb.append("(");
				sb.append(str1);
				sb.append(str2);
				sb.append(str3);
				sb.append(str4);
				sb.append(")");
			}
		}
		
		return sb.toString();
	}
}
