package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String word = br.readLine();
		
		int idx = 0;
		int cnt = 0;
		while (idx < str.length()) {
			if (str.charAt(idx) == word.charAt(0)) {
				if (str.length() - idx < word.length())
					break;
				
				boolean same = true;
				for (int i = 0; i < word.length(); i++) {
					if (!same)
						break;
					
					if (str.charAt(idx + i) != word.charAt(i))
						same = false;
				}
				
				if (same) {
					cnt++;
					idx += word.length();
				} else
					idx++;
			} else
				idx++;
		}
		System.out.println(cnt);
	}
}
