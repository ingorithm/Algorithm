package problem2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525 {
	static int N, M, result;
	static char[] ios;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		ios = br.readLine().toCharArray();
		
		int cur = 0;
		for (int i = 0; i < M - (N * 2 + 1); i++)
			if (ios[i] == 'I') {
				boolean isOK = true;
				
				if (i > cur)
					cur = i;
				
				while (cur < i + (N * 2 + 1)) {
					if (((i + cur) % 2 == 0 && ios[cur] == 'O') ||
							((i + cur) % 2 == 1 && ios[cur] == 'I')) {
						isOK = false;
						break;
					}
					
					cur++;
				}
				
				if (isOK)
					result++;
			}
		
		System.out.println(result);
	}
	
}
