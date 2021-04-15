package problem2103;

import java.util.*;

public class Solution_기능개발 {

	public static void main(String[] args) {
		int[] answer = solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
		System.out.println();
		
		answer = solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1});
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
		System.out.println();
	}

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int last = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int cur = remain / speeds[i];
            
            if (remain % speeds[i] != 0)
                cur++;
            if (last < cur)
                last = cur;
            list.add(last);
        }
        
        Collections.sort(list);
        
        int cnt = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != list.get(i - 1)) {
                temp.add(cnt);
                cnt = 1;
            } else
                cnt++;
        }
        temp.add(cnt);
        
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++)
            answer[i] = temp.get(i);
        return answer;
    }
}
