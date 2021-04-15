package problem2009;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> d = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push_front":
				d.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				d.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (d.isEmpty())
					result.add(-1);
				else
					result.add(d.pollFirst());
				break;
			case "pop_back":
				if (d.isEmpty())
					result.add(-1);
				else
					result.add(d.pollLast());
				break;
			case "size":
				result.add(d.size());
				break;
			case "empty":
				if (d.isEmpty())
					result.add(1);
				else
					result.add(0);
				break;
			case "front":
				if (d.isEmpty())
					result.add(-1);
				else
					result.add(d.getFirst());
				break;
			case "back":
				if (d.isEmpty())
					result.add(-1);
				else
					result.add(d.getLast());
				break;
			}
		}
		
		for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
}
