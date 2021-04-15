package problem2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q9375 {
	private static int testCase, result[];
	private static int N;
	private static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		testCase = Integer.parseInt(br.readLine());
		result = new int[testCase];
		for (int tc = 0; tc < testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String kinds = st.nextToken();
				
				if (map.containsKey(kinds))
					map.put(kinds, map.get(kinds) + 1);
				else
					map.put(kinds, 1);
			}
			
			result[tc] = 1;
			for (String key : map.keySet())
				result[tc] *= map.get(key) + 1;
		}
		
		for (int tc = 0; tc < testCase; tc++)
			System.out.println(result[tc] - 1);
	}

}
