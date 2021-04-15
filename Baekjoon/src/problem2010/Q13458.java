package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
소요시간 : 약 20분

!주의 : result는 int형 범위(약 21억)를 넘어갈 수 있으므로 long형으로 선언
!주의 : 반례
input
1
5
6 1
result
1
 */
public class Q13458 {
	private static int N, B, C;
	private static int A[];
	private static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			result++;
			if (A[i] > 0) {
				result += A[i] / C;
				if (A[i] % C != 0)
					result++;
			}
		}
		
		System.out.println(result);
	}

}
