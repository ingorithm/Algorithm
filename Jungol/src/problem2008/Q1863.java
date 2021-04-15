package problem2008;	// P

import java.util.Scanner;
 
public class Q1863 {
    static int N, M, parents[], result;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parents[i] = i;
         
        for (int i = 1; i <= M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            union(first, second);
        }
         
        result = 0;
        for (int i = 1; i <= N; i++)
            if (parents[i] == i)
                result++;
        
        System.out.println(result);
    }
     
    static int find(int a) {
        if(parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }
     
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;
 
        if (a > b)
        	parents[a] = b;
		else
			parents[b] = a;
    }
}
