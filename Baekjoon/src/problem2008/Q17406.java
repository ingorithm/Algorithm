package problem2008;	// P, 재검토 필요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 회전 연산이 2개 이상이면 연산 수행 순서에 따라 결과가 달라진다. 
// 회전 연산 순서를 바꿔 가면서 최소값을 구현해야 함.
// 회전 연산을 배열에 넣고 적용할 연산의 순서를 순열로 구현
// while 문에서 순열대로 연산을 적용해 가면서 문제 풀이
// 회전 연산의 순열 적용 <-- next permutation 으로
public class Q17406 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N][M];
		
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		int[][] rcs = new int[K][3];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rcs[i][0] = Integer.parseInt(st.nextToken());
			rcs[i][1] = Integer.parseInt(st.nextToken());
			rcs[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 배열 연산 순열을 위한 배열
		// 정렬되어 있어야 함.
		int[] np = new int[K];
		for (int i = 0; i < K; i++) {
			np[i] = i;
		}
		
		int[][] initArray = new int[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<M;j++) {
				initArray[i][j] = array[i][j];
			}
		}
		
		while(true) {
			
			// 첫 번째 주어진 배열 연산 순서로 실행
			for (int n : np) {

				int r = rcs[n][0]-1;
				int c = rcs[n][1]-1;
				int s = rcs[n][2];
				
				while( s > 0) {
					int a = array[r-s][c-s];
					for(int i = r-s; i+1<=r+s;i++) {
						array[i][c-s] = array[i+1][c-s];
					}
					for(int i = c-s;i+1<=c+s;i++) {
						array[r+s][i] = array[r+s][i+1];
					}
					for(int i = r+s;i-1>=r-s;i--) {
						array[i][c+s] = array[i-1][c+s];
					}
					for(int i = c+s; i-1>=c-s;i--) {
						array[r-s][i] = array[r-s][i-1];
					}
					array[r-s][c-s+1] = a;
					if(--s==0)break;
				}
				
			}
			
			for(int i = 0; i<N;i++) {
				int sum = 0; 
				for (int j = 0; j < M; j++) {
					sum += array[i][j];
				}
				min = Math.min(min, sum);
			}
			
			// 배열 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					array[i][j] = initArray[i][j];
				}
			}
			
			// 다음 배열 연산 순서
			if( ! nextPermutation(np) ) break;

		}
		
		System.out.println(min);

	}
	
	private static boolean nextPermutation(int array[]) {
		
		int i = array.length-1;
		while( i>0 && array[i-1]>=array[i] ) --i;
		
		if( i == 0 ) return false;
		
		int j = array.length-1;
		while(array[i-1]>=array[j])	--j;
		swap(array,i-1,j);
		
		// reverse
		int k = array.length-1;
		while(i<k) {
			swap(array,i++,k--);			
		}
		return true;
	}
	
	private static void swap(int numbers[],int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}

