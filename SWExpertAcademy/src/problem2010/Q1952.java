package problem2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1952 {
	private static int moneys[], days[], min;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        
        for (int tc = 1; tc <= testCase; tc++) {
        	moneys = new int[4];
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < 4; i++)
        		moneys[i] = Integer.parseInt(st.nextToken());
        	
        	days = new int[12];
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < 12; i++)
        		days[i] = Integer.parseInt(st.nextToken());
        	plan();
        	System.out.println("#" + tc + " " + min);
        	
//        	days = new int[13];
//        	st = new StringTokenizer(br.readLine());
//        	for (int i = 1; i <= 12; i++)
//        		days[i] = Integer.parseInt(st.nextToken());
//        	
//        	System.out.println("#" + tc + " " + planDP());
        }
    }
    
    private static void plan() {
    	// 1년
    	min = moneys[3];
    	
    	calc(0, 0);
    }
    
    // 매달의 이용가능한 경우를 고려하여 계산
    private static void calc(int m, int sum) {
    	if (m >= 12) {
    		if (min > sum)
    			min = sum;
    		return;
    	}
    	
    	// 1일
    	calc(m + 1, sum + days[m] * moneys[0]);
    	
    	// 1달
    	calc(m + 1, sum + (days[m] > 0 ? moneys[1] : 0));
    	
    	// 3달
    	if (days[m] > 0)
    		calc(m + 3, sum + moneys[2]);
    	else
    		calc(m + 1, sum);
    }
    
    private static int planDP() {
    	int dp[] = new int[13];
    	
    	for (int i = 1; i <= 12; i++) {
    		// 1일
    		dp[i] = dp[i - 1] + days[i] * moneys[0];
    		
    		// 1달
    		if (days[i] > 0)
    			dp[i] = Math.min(dp[i], dp[i - 1] + moneys[1]);
    		
    		// 3달
    		if (i >= 3)
    			dp[i] = Math.min(dp[i], dp[i - 3] + moneys[2]);
    	}
    	return Math.min(dp[12], moneys[3]);
    }
}
