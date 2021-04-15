package problem2009;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {
	static int[] men;
	static boolean[] checked;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		men = new int[9];
		checked = new boolean[9];
		
		for (int i = 0; i < 9; i++)
			men[i] = sc.nextInt();
		
		Arrays.sort(men);
		
		subset(0);
	}
	
	private static void subset(int idx) {
		int sum = 0, num = 0;
		
		if (flag)
			return;
		
		if (idx == 9) {
			for (int i = 0; i < 9; i++)
				if (checked[i] == true) {
					sum += men[i];
					num++;
				}
			
			if (sum == 100 && num == 7) {
				for (int i = 0; i < 9; i++)
					if (checked[i] == true)
						System.out.println(men[i]);
				flag = true;
			}
			return;
		}
		
		checked[idx] = true;
		subset(idx + 1);
		checked[idx] = false;
		subset(idx + 1);
	}
}
