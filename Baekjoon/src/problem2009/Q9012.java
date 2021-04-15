package problem2009;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Stack;

public class Q9012 {
	static int testCase;
	static String result[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		result = new String[testCase];
		
		for (int tc = 0; tc < testCase; tc++) {
//			Stack<Character> s = new Stack<>();
			char[] c = br.readLine().toCharArray();
			int num = 0;
			String answer = "YES";
			
			for (int idx = 0; idx < c.length; idx++) {
				if (c[idx] == '(')
					num++;
				else
					num--;
				
				if (num < 0)
					answer = "NO";
			}
			if (num != 0)
				answer = "NO";
			
			result[tc] = answer;
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc]);
	}
}
