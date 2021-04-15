package problem2101;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를지나는트럭 {
	
	public static void main(String[] args) {
		int bl = 2, w = 10, tw[] = {7, 4, 5, 6};
//		int bl = 100, w = 100, tw[] = {10};
//		int bl = 100, w = 100, tw[] = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.println(solution(bl, w, tw));
	}

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	int L = bridge_length, W = weight, T[] = truck_weights;
    	Queue<Truck> q = new LinkedList<>();
        
        int idx = 0;
        int time = 0;
        while (idx < T.length) {
        	int totalWeight = 0;	// 다리 위 트럭의 총 무게
        	
        	// 비었을 때
        	if (q.isEmpty()) {
        		q.offer(new Truck(T[idx], 0));
        		idx++;
        		time++;
        		continue;
        	}
        	
        	// 꺼내면서 확인
        	int tempSize = q.size();
        	for (int i = 0; i < tempSize; i++) {
        		Truck truck = q.poll();
        		
        		if (++truck.t == L)
        			continue;
        		else {
        			totalWeight += truck.w;
        			q.offer(truck);
        		}
        	}
        	
        	// 다음 트럭 진입 여부 확인
        	if (totalWeight + T[idx] <= W) {
        		q.offer(new Truck(T[idx], 0));
        		idx++;
        	}
        	
        	time++;
        }
        
        // 마지막으로 큐에 남아있는 트럭 확인
        int tempSize = q.size();
        for (int i = 0; i < tempSize - 1; i++)
        	q.poll();
        Truck truck = q.poll();
        time += L - truck.t;
        
        return time;
    }
	
    public static class Truck {
    	int w;	// weight
    	int t;	// time
		
    	public Truck(int w, int t) {
			this.w = w;
			this.t = t;
		}
    }
}
