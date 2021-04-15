package problem2101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1436 {
	private static StringBuilder sb;
	private static int[] selected;
	private static ArrayList<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		selected = new int[4];
		list = new ArrayList<>();
		
		perm(0);
		
		Collections.sort(list);
		
		int idx = 0;
		int prev = 0;
		int result = 0;
		while (cnt > 0) {
			prev = result;
			result = list.get(idx);
			
			if (prev == result)
				cnt++;
			
			idx++;
			cnt--;
		}
		System.out.println(result);
	}

	private static void perm(int cnt) {
		if (cnt == 4) {
			for (int i = 0; i < 4; i++) {	// ^#^#^#^# : ^(666), #(0~9)
				sb = new StringBuilder();
				for (int j = 0; j < i; j++)
					sb.append(selected[j]);
				sb.append("666");
				for (int j = i; j < 4; j++)
					sb.append(selected[j]);
				
				list.add(Integer.parseInt(sb.toString().trim()));
			}
			
			sb = new StringBuilder();	// ####^
			for (int i = 0; i < 4; i++)
				sb.append(selected[i]);
			sb.append("666");
			
			list.add(Integer.parseInt(sb.toString().trim()));
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			selected[cnt] = i;
			perm(cnt + 1);
		}
	}
	
}
