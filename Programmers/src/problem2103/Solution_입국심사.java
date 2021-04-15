package problem2103;

import java.util.*;

public class Solution_입국심사 {
	
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {7, 10}));
	}

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long low = 1;
        long high = (long)n * (long)times[times.length - 1];
        long mid = 0;
        long answer = Long.MAX_VALUE;
        
        while (low <= high) {
            mid = (low + high) / 2;
            
            long sum = 0;
            for (int i = 0; i < times.length; i++)
                sum += mid / times[i];
            
            if (sum >= n) {
                answer = Math.min(answer, mid);
                high = mid - 1;
            } else
                low = mid + 1;
        }
        
        return answer;
    }
    
}
