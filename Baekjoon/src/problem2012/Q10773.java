package problem2012;

import java.util.Scanner;

public class Q10773 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K, idx = 0, arr[], result = 0;
		
		K = sc.nextInt();
		arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
			
			if (num == 0) {
				idx--;
				continue;
			} else {
				arr[idx] = num;
				idx++;
			}
		}
		
		for (int i = 0; i < idx; i++)
			result += arr[i];
		
		System.out.println(result);
	}

}
