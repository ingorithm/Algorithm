package problem2103;

public class Solution_주식가격 {
	
	public static void main(String[] args) {
		int[] answer = solution(new int[]{1, 2, 3, 2, 3});
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}
	
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        
        return answer;
    }
	
}
