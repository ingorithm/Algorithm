package problem2009;

import java.util.Scanner;

public class Q2564 {
	private static int w, h, n;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();
        n = sc.nextInt();
        int[][] store = new int[n][2];
        
        for (int i = 0; i < n; i++) {
        	int temp = sc.nextInt();
        	if (temp == 1 || temp == 2)
        		store[i][0] = temp * 10;
        	else
        		store[i][0] = temp;
        	store[i][1] = sc.nextInt();
        }

        int dir = sc.nextInt();
        if (dir == 1 || dir == 2)
        	dir *= 10;
        int dis = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
        	answer += distance(store[i][0], store[i][1], dir, dis);
        }
        System.out.println(answer);
        
    }
    
    private static int distance(int dir, int dis, int ddir, int ddis) {
    	int ans = 0;
    	int dirSum = dir + ddir;
    	
    	switch (dirSum) {
		case 30:	// NS
			ans = Math.min(dis + ddis, (w - dis) + (w - ddis)) + h;
			break;
		case 7:		// EW
			ans = Math.min(dis + ddis, (h - dis) + (h - ddis)) + w;
			break;
		case 13:	// NW
			ans = dis + ddis;
			break;
		case 14:	// NE
			if (ddir == 10)
				ans = w - ddis + dis;
			else
				ans = w - dis + ddis;
			break;
		case 23:	// SW
			if (ddir == 20)
				ans = h - dis + ddis;
			else
				ans = h - ddis + dis;
			break;
		case 24:	// SE
			ans = w + h - dis - ddis;
			break;
		case 20: case 40: case 6: case 8:	// NN SS WW EE
			ans = Math.abs(dis - ddis);
			break;
		}
    	
    	return ans;
    }
    
}
