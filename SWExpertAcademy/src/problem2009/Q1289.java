package problem2009;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1289 {
	static int testCase, result[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		result = new int[testCase + 1];
		
		for (int tc = 1; tc <= testCase; tc++) {
			char[] memory = br.readLine().toCharArray();
			int cnt = 0;
			
			for (int i = 0; i < memory.length; i++)
				if (memory[i] == '1') {
					for (int j = i; j < memory.length; j++)
						if (memory[j] == '1')
							memory[j] = '0';
						else
							memory[j] = '1';
					cnt++;
				}
			result[tc] = cnt;
		}
		
		for (int tc = 1; tc <= testCase; tc++)
			System.out.println("#" + tc + " " + result[tc]);
	}

}
