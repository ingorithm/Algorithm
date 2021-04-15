package problem2104;

import java.util.*;

public class Solution_모의고사 {

	public static void main(String[] args) {
		int[] list = solution(new int[] {1, 2, 3, 4, 5});
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
		
		list = solution(new int[] {1, 3, 2, 4, 2});
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}

    public static int[] solution(int[] answers) {
        int N = answers.length;
        int fN = 0, sN = 0, tN = 0;
        int[] fir = new int[N];
        int[] sec = new int[N];
        int[] thr = new int[N];
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            fir[i] = (i % 5) + 1;
            
            if (i % 2 == 0)
                sec[i] = 2;
            else if (i % 8 == 1)
                sec[i] = 1;
            else if (i % 8 == 3)
                sec[i] = 3;
            else if (i % 8 == 5)
                sec[i] = 4;
            else if (i % 8 == 7)
                sec[i] = 5;
            
            if (i % 10 == 0 || i % 10 == 1)
                thr[i] = 3;
            if (i % 10 == 2 || i % 10 == 3)
                thr[i] = 1;
            if (i % 10 == 4 || i % 10 == 5)
                thr[i] = 2;
            if (i % 10 == 6 || i % 10 == 7)
                thr[i] = 4;
            if (i % 10 == 8 || i % 10 == 9)
                thr[i] = 5;
        }
        
        for (int i = 0; i < N; i++) {
            if (answers[i] == fir[i])
                fN++;
            if (answers[i] == sec[i])
                sN++;
            if (answers[i] == thr[i])
                tN++;
        }
        
        if (fN >= sN && fN >= tN)
            result.add(1);
        if (sN >= fN && sN >= tN)
            result.add(2);
        if (tN >= fN && tN >= sN)
            result.add(3);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        return answer;
    }
}
