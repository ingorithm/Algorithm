package problem2103;

public class Solution_2xn타일링 {
	
	public static void main(String[] args) {
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
	}
	
    public static int solution(int n) {
        int answer[] = new int[n + 1];
        
        answer[1] = 1;
        answer[2] = 2;
        for (int i = 3; i <= n; i++)
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1000000007;
        
        return answer[n];
    }
	
}
