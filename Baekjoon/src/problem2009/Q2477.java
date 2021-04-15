package problem2009;

import java.util.Scanner;

public class Q2477 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] area = new int[6];
		
		int num = sc.nextInt();
		for (int i = 0; i < 6; i++) {
			int temp = sc.nextInt();
			area[i] = sc.nextInt();
		}
		
		while (!(area[0] + area[2] == area[4] && area[1] + area[3] == area[5])) {
			int temp = area[0];
			for (int i = 1; i < 6; i++)
				area[i - 1] = area[i];
			area[5] = temp;
		}
		
		System.out.println(num * (area[4] * area[5] - area[1] * area[2]));
	}
	
}
