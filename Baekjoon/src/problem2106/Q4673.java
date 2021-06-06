package problem2106;

import java.util.Arrays;

public class Q4673 {
	static boolean[] isSelfNumber;
	
	public static void main(String[] args) {
		isSelfNumber = new boolean[10001];
		Arrays.fill(isSelfNumber, true);
		
		for (int i = 1; i <= 10000; i++) {
			int num = findNumber(i);
			
			if (num <= 10000)
				isSelfNumber[num] = false;
		}
		
		for (int i = 1; i <= 10000; i++)
			if (isSelfNumber[i])
				System.out.println(i);
	}
	
	private static int findNumber(int num) {
		int ret = num;
		
		while (num != 0) {
			ret += num % 10;
			num = num / 10;
		}
		
		return ret;
	}
}
