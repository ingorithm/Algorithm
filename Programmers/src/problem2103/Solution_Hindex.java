package problem2103;

import java.util.*;

public class Solution_Hindex {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
	}

    static int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = new Integer[citations.length];
        
        for (int i = 0; i < citations.length; i++)
            arr[i] = citations[i];
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        answer = arr[0];
        
        while (answer > 0) {
            int cnt = 0;
            
            for (int i = 0; i < arr.length; i++)
                if (arr[i] >= answer)
                    cnt++;
            
            if (cnt >= answer)
                break;
            
            answer--;
        }
        
        return answer;
    }
	
}
