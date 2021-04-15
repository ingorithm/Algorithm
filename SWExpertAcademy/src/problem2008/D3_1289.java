package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Scanner;

public class D3_1289 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		int[] result = new int[testCase + 1];
		
		// test case
		for (int tc = 1; tc <= testCase; tc++) {
			String str = sc.nextLine();
			int[] memory = new int[str.length()];
			int answer = 0;
			
			for (int i = 0; i < str.length(); i++)
				memory[i] = (char)str.charAt(i) - 48;
			
			for (int i = 0; i < memory.length; i++) {
				if (memory[i] != 0) {
					for (int j = i; j < memory.length; j++) {
						if (memory[j] == 1)
							memory[j] = 0;
						else
							memory[j] = 1;
					}
					answer++;
				}
			}
			
			result[tc] = answer;
		}
		
		// output
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("#" + tc + " " + result[tc]);
		}
	}
}
