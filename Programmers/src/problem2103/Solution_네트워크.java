package problem2103;

import java.util.*;

public class Solution_네트워크 {
	
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}

    public static int solution(int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        boolean check[] = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++)
            if (!check[i]) {
                answer++;
                
                q.offer(i);
                check[i] = true;
                
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int j = 0; j < n; j++)
                        if (!check[j] && computers[cur][j] == 1) {
                            q.offer(j);
                            check[j] = true;
                        }
                }
            }
        
        return answer;
    }
    
}
