package problem2102;

import java.util.*;

public class Solution_디스크컨트롤러 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0, 3}, {2, 6}, {1, 9}})); // 9
		System.out.println(solution(new int[][]{{9, 10}, {2, 10}, {0, 10}, {15, 2}})); // 14
		System.out.println(solution(new int[][]{{0, 10}, {2, 12}, {9, 19}, {15, 17}})); // 25
		System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}})); // 9
		System.out.println(solution(new int[][]{{0, 1}})); // 1
		System.out.println(solution(new int[][]{{1000, 1000}})); // 1000
		System.out.println(solution(new int[][]{{0, 1}, {0, 1}, {0, 1}})); // 2
		System.out.println(solution(new int[][]{{0, 1}, {0, 1}, {0, 1}, {0, 1}})); // 2
		System.out.println(solution(new int[][]{{0, 1}, {1000, 1000}})); // 500
		System.out.println(solution(new int[][]{{100, 100}, {1000, 1000}})); // 550
	}

    private static class Job implements Comparable<Job> {
        int r, t;   // request, time
        
        public Job(int r, int t) {
            this.r = r;
            this.t = t;
        }
        
        @Override
        public int compareTo(Job o) {
            if (this.t == o.t)
                return this.r - o.r;
            return this.t - o.t;
        }
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int answer = 0;
        
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        
        int idx = 0;    // index of jobs
        int cur = 0;    // current time
        while (true) {
        	if (idx == jobs.length && pq.isEmpty())
        		break;
        	
            for (; idx < jobs.length; idx++) {
                if (jobs[idx][0] <= cur)
                    pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
                else
                    break;
            }
            
            if (pq.isEmpty()) {
                cur++;
            } else {
                Job j = pq.poll();
                cur += j.t;
                answer += cur - j.r;
            }
        }
        
        return answer / jobs.length;
    }
    
}
