package problem2102;

public class Solution_카펫 {
	
	public static void main(String[] args) {
		int[] result = solution(10, 2);
		System.out.println(result[0] + ", " + result[1]);
		result = solution(8, 1);
		System.out.println(result[0] + ", " + result[1]);
		result = solution(24, 24);
		System.out.println(result[0] + ", " + result[1]);
	}
	
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int N = (int)Math.sqrt(yellow);
        
        for (int i = 1; i <= N; i++)
            if (yellow % i == 0) {  // yellow의 소인수
                int row = i;            // 행의 수
                int col = yellow / i;   // 열의 수
                
                if (row * 2 + col * 2 + 4 == brown) {
                    answer[0] = col + 2;
                    answer[1] = row + 2;
                    break;
                }
            }
        
        return answer;
    }
    
}
