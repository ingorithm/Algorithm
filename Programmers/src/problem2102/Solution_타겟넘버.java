package problem2102;

import java.util.*;

public class Solution_타겟넘버 {
	private static int answer;

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
	}
    
    public static int solution(int[] numbers, int target) {
        dfs(0, numbers.length, 0, target, numbers);
        return answer;
    }
    
    private static void dfs(int idx, int N, int sum, int T, int[] numbers) {
        if (idx == N) {
            if (sum == T)
                answer++;
            return;
        }
        
        dfs(idx + 1, N, sum + numbers[idx], T, numbers);
        dfs(idx + 1, N, sum - numbers[idx], T, numbers);
    }
}
