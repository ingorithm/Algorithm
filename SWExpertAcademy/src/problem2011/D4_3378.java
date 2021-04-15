package problem2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D4_3378 {
	private static int testCase;
	private static List<Integer> result;
	private static int p, q;
	private static int r, rNum, c, cNum, s, sNum;	// (, {, [ 칸수/갯수 
	private static char[][] master, mine;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine().trim());
		result = new ArrayList<>();
		
		for (int tc = 1; tc <= testCase; tc++) {
			String temp = br.readLine().trim();
			p = temp.charAt(0);
			q = temp.charAt(2);
			
			for (int i = 0; i < p; i++)
				master[i] = br.readLine().toCharArray();
			for (int i = 0; i < q; i++)
				mine[i] = br.readLine().toCharArray();
			
			r = 0; rNum = 0; c = 0; cNum = 0; s = 0; sNum = 0;
			masterCode();
			myCode();
		}
		
		// output
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.print("#" + tc);
			for (int i = 0; i < result.size(); i++)
				System.out.print(" " + result.get(i));
			System.out.println();
		}
	}
	
	// allocate r, c, s
	private static void masterCode() {
		
	}
	
	private static int dotCount(int[] a) {
		int cnt = 0;
		
		while (true) {
			if (a[cnt] == '.')
				cnt++;
			else
				return cnt;
		}
	}
	
	// make result List
	private static void myCode() {
		
	}
	
}
