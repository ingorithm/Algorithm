package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int result = 0;
		int temp = 0;
		boolean minus = false;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+') {
				if (minus) {
					result -= temp;
					temp = 0;
				} else {
					result += temp;
					temp = 0;
				}
			} else if (str.charAt(i) == '-') {
				if (minus) {
					result -= temp;
					temp = 0;
				} else {
					minus = true;
					result += temp;
					temp = 0;
				}
			} else {
				temp = temp * 10;
				temp += str.charAt(i) - '0';
			}
		}
		if (minus)
			result -= temp;
		else
			result += temp;
		
		System.out.println(result);
	}

}
