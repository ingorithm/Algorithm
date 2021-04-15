package problem2103;

import java.util.*;

public class Solution_프린터 {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
		System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
	}
	
    public static int solution(int[] priorities, int location) {
        Queue<Document> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++)
            q.offer(new Document(priorities[i], i));
        
        int answer = 0;
        while (!q.isEmpty()) {
            Queue<Document> temp = new LinkedList<>();
            Document d = q.poll();
            boolean isMax = true;
            
            while(!q.isEmpty()) {
                Document cur = q.poll();
                if (d.p < cur.p)
                    isMax = false;
                temp.offer(cur);
            }
            
            if (!isMax)
                temp.offer(d);
            else {
                answer++;
                if (d.idx == location)
                    break;
            }
            
            q = temp;
        }
        return answer;
    }
	
    private static class Document {
        int p;      // priority
        int idx;    // index
        
        public Document(int p, int idx) {
            this.p = p;
            this.idx = idx;
        }
    }
    
}
