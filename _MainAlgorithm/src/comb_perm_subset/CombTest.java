// comb(int cnt, int idx) - 매개변수가 2개
// cnt - 여태까지 몇 개나 뽑았는지, idx - 이제 몇 번부터 뽑아야하는지
// for문은 i부터

package comb_perm_subset;

public class CombTest {
	static int N, R, ans[], arr[] = {1, 2, 3, 4, 5};
	
	public static void main(String[] args) {
		N = 5;
		R = 3;
		ans = new int[R];
		
		comb(0, 0);
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == R) {
			for (int i = 0; i < R; i++)
				System.out.print(ans[i] + " ");
			System.out.println();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			ans[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
}
