package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Q2751 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[2000001];
		
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(br.readLine());
			arr[temp + 1000000] = true;
		}
		
		for (int i = 0; i <= 2000000; i++)
			if (arr[i])
				System.out.println(i - 1000000);
	}
}
