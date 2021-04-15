package problem2009;

import java.util.Scanner;	// D3_3307

public class D3_3307 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int N, arr[], lis[];
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			lis = new int[N];
			
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++)
					if (arr[j] < arr[i] && lis[i] < lis[j] + 1)
						lis[i] = lis[j] + 1;
				result = result < lis[i] ? lis[i] : result;
			}
			System.out.println("#" + tc + " " + result);
		}
		
	}

}
