package problem2008;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1181 {
	static String arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		arr = new String[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextLine();
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() > s2.length())
					return 1;
				else if (s1.length() == s2.length()) {
					if (s1.compareTo(s2) > 0)
						return 1;
				}
				return -1;
			}
		});
		
		String s = "";
		for (int i = 0; i < N; i++)
			if (s.equals(arr[i]))
				continue;
			else {
				s = arr[i];
				System.out.println(arr[i]);
			}
	}
}
