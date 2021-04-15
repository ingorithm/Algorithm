package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Q2493 {
	static private int N, top[], index, stack[][], answer[];
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
		try {
			N = Integer.parseInt(bf.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		top = new int[N + 1];
		stack = new int[N + 1][2];	// data, index
		answer = new int[N + 1];
		
		// input
		try {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 1; i <= N; i++)
				top[i] = Integer.parseInt(st.nextToken());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		// init
		index = 0;
		stack[index][0] = 200000000;
		stack[index][1] = 0;
		
		// search
		for (int i = 1; i <= N; i++) {
			int temp = index;
			for (int j = temp; j >= 0; j--) {
				if (stack[j][0] > top[i]) {
					answer[i] = stack[j][1];
					index = j + 1;
					stack[index][0] = top[i];
					stack[index][1] = i;
					break;
				}
			}
		}
		
		for (int i = 1; i <= N; i++)
			System.out.print(answer[i] + " ");
	}
}
