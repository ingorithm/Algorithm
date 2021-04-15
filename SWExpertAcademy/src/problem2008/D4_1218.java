package problem2008;	// P

import java.util.Scanner;
import java.util.Stack;

public class D4_1218 {
	static private int N, isPair, testCase, result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = 10;
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			sc.nextLine();
			isPair = 1;
			Stack<Character> st = new Stack<Character>();
			
			String str = sc.nextLine();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				switch (c) {
				case '(': case '[': case '{': case '<':
					st.push(c);
					break;
					
				case ')':
					if (st.peek() == '(')
						st.pop();
					else
						isPair = 0;
					break;
					
				case ']':
					if (st.peek() == '[')
						st.pop();
					else
						isPair = 0;
					break;
					
				case '}':
					if (st.peek() == '{')
						st.pop();
					else
						isPair = 0;
					break;
					
				case '>':
					if (st.peek() == '<')
						st.pop();
					else
						isPair = 0;
					break;
				}
			}
			if (!st.isEmpty())
				isPair = 0;
			result[tc] = isPair;
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
	}
}
