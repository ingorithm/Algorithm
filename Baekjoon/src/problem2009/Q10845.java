package problem2009;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push":
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (q.isEmpty())
					result.add(-1);
				else
					result.add(q.poll());
				break;
			case "size":
				result.add(q.size());
				break;
			case "empty":
				if (q.isEmpty())
					result.add(1);
				else
					result.add(0);
				break;
			case "front":
				if (q.isEmpty())
					result.add(-1);
				else
					result.add(q.peek());
				break;
			case "back":
				if (q.isEmpty())
					result.add(-1);
				else {
					for (int j = 0; j < q.size() - 1; j++) {
						int temp = q.poll();
						q.offer(temp);
					}
					int temp = q.poll();
					result.add(temp);
					q.offer(temp);
				}
				break;
			}
		}
		for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
}
