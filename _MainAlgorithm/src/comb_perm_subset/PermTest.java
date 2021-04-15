// perm(int cnt) - 매개변수가 1개
// cnt - 여태까지 몇 개나 뽑았는지
// boolean check 배열 필요
// for문은 0부터, check 배열 검사

package comb_perm_subset;

public class PermTest {
	static int N, R, ans[], arr[] = {1, 2, 3, 4, 5};
	static boolean isChecked[];
	
	public static void main(String[] args) {
		N = 5;
		R = 3;
		ans = new int[R];
		isChecked = new boolean[N];
		
		perm(0);
	}
	
	static void perm(int cnt) {
		if (cnt == R) {
			for (int i = 0; i < R; i++)
				System.out.print(ans[i] + " ");
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isChecked[i])
				continue;
			else {
				ans[cnt] = arr[i];
				isChecked[i] = true;
				perm(cnt + 1);
				isChecked[i] = false;
			}
		}
	}
}
