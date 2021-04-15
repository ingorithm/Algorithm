package problem2009;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q10828 {
	static int N;
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		Stack<Integer> s = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push":
				s.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (s.isEmpty())
					result.add(-1);
				else
					result.add(s.pop());
				break;
			case "size":
				result.add(s.size());
				break;
			case "empty":
				if (s.isEmpty())
					result.add(1);
				else
					result.add(0);
				break;
			case "top":
				if (s.isEmpty())
					result.add(-1);
				else
					result.add(s.peek());
				break;
			}
		}
		
		for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
}
