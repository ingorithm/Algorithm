package problem2008;	// P

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파이프가 가능한 방법의 수를 찾는 것이 아니라, 최대 몇 개가 동시에 가능한가를 풀어야 함
// 파이프의 길이는 문제가 되지 않음.
// 다음 탐색의 선택지에 대한 우선 순위가 있음. 위오, 오, 위아래 ( Greedy )
// 다음 탐색의 선택이 성공하면 나머지 탐색은 하지 않음 ( Back tracking )
// visit 는 성공 / 실패와 상관없이 무조건 !! <-- 성공해도 visit, 실패해도 visit
// visit 가 다른 visit 에 계속 영향을 준다. N-Queen 의 Queen 이 하나 놓여지면 그 상황은 변하지 않음과 같음

public class Q3109 {
    static char[][] map;
    static int R, C;
    static int ans;
    static int[] dy = { -1, 0, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        map = new char[R][];

        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        for(int i=0; i<R; i++) {
            if(dfs(i,0)) 
                ans++;
        }
        
        System.out.println(ans);
    }
    
    static boolean dfs(int i, int j) {
        
        for(int d=0; d<3; d++) {
            
            int ny = i + dy[d];
            int nx = j + 1;
    
            if( ny >= 0 && ny<R && map[ny][nx] == '.' ) {
                if(nx == C-1) return true;
                map[ny][nx] = 'X'; 
                if( dfs(ny,nx) ) return true;
            }
        }

        return false;
    }

}
