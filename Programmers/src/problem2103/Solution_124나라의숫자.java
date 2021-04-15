package problem2103;

import java.util.*;

public class Solution_124나라의숫자 {
	
	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(7));
		System.out.println(solution(8));
		System.out.println(solution(9));
		System.out.println(solution(10));
	}
	
	public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            int mod = n % 3;
            n = n / 3;
            
            if (mod == 0) {
                n--;
                answer.insert(0, "4");
            }
            if (mod == 1)
                answer.insert(0, "1");
            if (mod == 2)
                answer.insert(0, "2");
        }
        
        return answer.toString();
    }
	
}
