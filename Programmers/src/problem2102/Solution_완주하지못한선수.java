package problem2102;

import java.util.*;

public class Solution_완주하지못한선수 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
	}

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            String cur = participant[i];
            if (map.containsKey(cur))
                map.put(cur, map.get(cur) + 1);
            else
                map.put(cur, 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            String cur = completion[i];
            map.put(cur, map.get(cur) - 1);
        }
        
        String answer = "";
        for (String cur : map.keySet())
            if (map.get(cur) == 1) {
                answer = cur;
                break;
            }
        return answer;
    }
    
}
