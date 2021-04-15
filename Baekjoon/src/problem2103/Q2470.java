package problem2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int left = 0, right = N - 1;
		int acid = 0, alkali = 0, diff = Integer.MAX_VALUE;
		
		if (arr[left] > 0)
			System.out.println(arr[0] + " " + arr[1]);
		else if (arr[right] < 0)
			System.out.println(arr[N - 2] + " " + arr[N - 1]);
		else {
			while (left < right) {
				int temp = arr[left] + arr[right];
				
				if (diff > Math.abs(temp)) {
					diff = Math.abs(temp);
					alkali = arr[left];
					acid = arr[right];
				}
				
				if (temp == 0)
					break;
				else if (temp > 0)
					right--;
				else
					left++;
			}
			System.out.println(alkali + " " + acid);
		}
	}

}
