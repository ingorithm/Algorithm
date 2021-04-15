package problem2103;

import java.util.*;

public class Solution_N으로표현 {
	
	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		System.out.println(solution(2, 11));
	}
	
    public static int solution(int N, int number) {
        if (N == number)
            return 1;
        
        Set<Integer>[] set = new HashSet[9]; // 8보다 크면 -1 return
        for (int i = 1; i <= 8; i++)
            set[i] = new HashSet<>();
        set[1].add(N);
        
        for (int i = 2; i <= 8; i++) {
            int fir = 1;
            int sec = i - 1;
            
            while (fir < i) {
                Iterator<Integer> iterF = set[fir].iterator();
                while (iterF.hasNext()) {
                    int firNum = iterF.next();
                    Iterator<Integer> iterS = set[sec].iterator();
                    while (iterS.hasNext()) {
                        int secNum = iterS.next();
                        set[i].add(firNum + secNum);
                        set[i].add(firNum - secNum);
                        set[i].add(firNum * secNum);
                        if (secNum != 0)
                            set[i].add(firNum / secNum);
                    }
                }
                
                fir++;
                sec--;
            }
            
            int sequenceNum = N;
            for (int j = 2; j <= i; j++)
                sequenceNum = sequenceNum * 10 + N;
            set[i].add(sequenceNum);
            
            if (set[i].contains(number))
                return i;
        }
        return -1;
    }
    
}
