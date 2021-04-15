package problem2008;	// P

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2675 {
	static int testCase;
	static String result[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = Integer.parseInt(sc.nextLine());
		result = new String[testCase];

		for (int tc = 0; tc < testCase; tc++) {
			int n;
			String str;
			StringBuffer sb = new StringBuffer();
			
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			n = Integer.parseInt(st.nextToken());
			str = st.nextToken();
			
			for (int i = 0; i < str.length(); i++)
				for (int j = 0; j < n; j++)
					sb.append(str.charAt(i));
			
			result[tc] = sb.toString();
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}
}
