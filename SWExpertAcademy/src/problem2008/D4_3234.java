package problem2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 추를 놓는 순서가 다르면 방법이 다르다. 순열 문제
// 순열을 만들어 가면서, 추 한 개를 늘려갈 때 마다, 왼쪽과 오른쪽에 추를 놓는 두 가지로 나누어서 진행
// 순열을 만들어 가면서 다른 자료구조에 저장하여 가짓수를 확인하는 것이 아니라, 순열을 만드는 과정에서 
// 왼쪽 오른쪽 파라미터 추가하여 양쪽 저울의 무게를 계속 더해 감
// 왼쪽으로는 조건없이 계속 더하면 되고, 오른쪽은 왼쪽의 무게보다 작은 경우에만 진행함.
// 시간 초과를 해결하기 위해 가지치기 필요. <-- 더 이상 갈 필요가 없는 경우는? 
//   왼쪽 저울 무게 >= 오른쪽 저울 무게 + 남은 추 무게
public class D4_3234 {

	static int[] weight;
	static boolean[] used;
	static int ans;
	static int N; // 추의 갯수

	static int[] facto;
	static int[] pow;
	static int total; // 추의 총 무게

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			used = new boolean[N];

			facto = new int[N + 1];
			pow = new int[N + 1];
			facto[0] = facto[1] = pow[0] = 1;
			total = 0;

			String[] line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(line[i]);
				facto[i + 1] = facto[i] * (i + 1);
				pow[i + 1] = pow[i] * 2;
				total += weight[i];
			}

			ans = 0;
			perm(0, 0, 0, total);

			System.out.println("#" + tc + " " + ans);
		}
	}

// 순열을 위한 idx 말고, 왼쪽, 오른쪽 무게를 더해 나갈 파라미터를 추가
// 추의 총 무게에서 현재 놓는 추 무게를 빼어, 남은 나머지 추의 무게를 전달
	static void perm(int idx, int leftSum, int rightSum, int totalRemain) {

		// 남은 추 전부를 오른쪽에 놔도 지금까지 올려둔 왼쪽 무게보다 무겁지 않음
		// 그러면 굳이 놔보지 말고 남은 추로 만들수 있는 모든 경우의 수를 그냥 계산하도록 하기
		// 예를 들어 9개의 추 중에서 현재 3개를 놓으면서 오른쪽이 무겁지 않은 상태라면,
		// 나머지 6개의 추를 다 오른쪽에 놔도 왼쪽이 더 무거우면 6개의 추를 줄세우는 6!* 왼쪽 오른쪽 경우의수 2^6을 그냥 계산해도 됨.
		if (totalRemain + rightSum <= leftSum) {
			ans += pow[N - idx] * facto[N - idx];
			return;
		}

		if (idx == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {

			if (!used[i]) {
				used[i] = true; // 지금 i번 추를 사용해볼 예정이므로 이 이후의 재귀가 i번 추 못쓰게 하려고.
				perm(idx + 1, leftSum + weight[i], rightSum, totalRemain - weight[i]); // i번 추를 왼쪽에 놔보는건 그냥 해봐도 됨.
				if (rightSum + weight[i] <= leftSum) // 1번 추를 오른쪽에 놓을 때는 혹시 오른쪽이 무거워지지 않는지 검사하고 놔보기.
					perm(idx + 1, leftSum, rightSum + weight[i], totalRemain - weight[i]);
				used[i] = false; // 현재 순서에서 i번추 올려놓고 그 이후 재귀들이 다 돌았으면 이제 현재 순서에 i번추 말고 다른거 놔볼거라 얘는 반납.
			}
		}
	}
}