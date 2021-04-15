package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int result = 0;
		
		char cur = str.charAt(0);
		for (int i = 1; i < str.length(); i++)
			if (cur != str.charAt(i)) {
				cur = str.charAt(i);
				result++;
			}
		
		System.out.println((result + 1) / 2);
	}
}
