package problem2008;	// P, 재검토 필요

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 2차원 배열을 순회하지 않는다.
// 조합으로 선택한 것들과 어떤 것들의 거리 관계 --> 거리를 배열 순회로 찾지 말고, 처음부터 ArrayList 나 2차원 배열을 이용하여 위치 저장
// 치킨가계를 조합으로 선택 후, 각 조합이 완성되면 치킨 거리를 계산 최저값을 찾는다.
// 치킨 거리를 계산할 때는 집을 기준으로 치킨 거리를 계산하여 가장 적은 값을 찾는다.
// 반대로 치킨가계를 기준으로 계산하면 늘 가장 가까운 치킨가계를 선택하게 되어 오류
// comb recursive for way
public class Q15686 {
	static int N, M;
	static int min = Integer.MAX_VALUE;
	public static List<int[]> house, chicken, choice;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		house = new ArrayList<int[]>();
		chicken = new ArrayList<int[]>();
		choice = new ArrayList<int[]>();

		N = sc.nextInt(); // 도시크기, 2 <= N <= 50
		M = sc.nextInt(); // 치킨집 선택 최대값, 1 <= M <= 13
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt(); // 0:빈집, 1:집, 2:치킨집
				if (temp == 1)
					house.add(new int[] { i, j });
				else if (temp == 2)
					chicken.add(new int[] { i, j });
			}
		}
		
		comb(0, 0);
		System.out.println(min);
	}

	static void comb(int start, int cnt) {
		if (cnt == M) {
			int sum = 0;
			
			for (int i = 0; i < house.size(); i++) {
				int dist = Integer.MAX_VALUE;
				for (int j = 0; j < choice.size(); j++) {
					dist = Math.min(dist, Math.abs(house.get(i)[0] - choice.get(j)[0])
							+ Math.abs(house.get(i)[1] - choice.get(j)[1]));
				}
				sum += dist;
			}
			min = Math.min(min, sum);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			choice.add(chicken.get(i));
			comb(i + 1, cnt + 1);
			choice.remove(choice.size() - 1);
		}
	}
}
