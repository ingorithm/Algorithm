package problem2009;

import java.util.Scanner;

public class Q2491 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		if (N == 1) {
			System.out.println("1");
			System.exit(0);
		}
		
		int result = 0, cnt = 2;
		boolean up = arr[0] <= arr[1] ? true : false;
		for (int i = 2; i < N; i++) {
			if (up) {
				if (arr[i - 1] <= arr[i])
					cnt++;
				else {
					result = Math.max(result, cnt);
					up = false;
					cnt = 2;
					int temp = i - 1;
					while(true) {
						if (temp == 0 || arr[temp - 1] != arr[temp])
							break;
						else {
							temp--;
							cnt++;
						}
					}
				}
			} else {
				if (arr[i - 1] >= arr[i])
					cnt++;
				else {
					result = Math.max(result, cnt);
					up = true;
					cnt = 2;
					int temp = i - 1;
					while(true) {
						if (temp == 0 || arr[temp - 1] != arr[temp])
							break;
						else {
							temp--;
							cnt++;
						}
					}
				}
			}
		}
		result = Math.max(result, cnt);
		System.out.println(result);
	}

}
