package problem2008;	// P

import java.util.Scanner;

public class D3_1873 {
	static int testCase, H, W, N, dir, x, y, resultHW[][];	// , , , , direction, tank's x, tank's y, H/W
	static char move[], map[][], result[][][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		result = new char[testCase + 1][][];
		resultHW = new int[testCase + 1][2];
		
		for (int tc = 1; tc <= testCase; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			sc.nextLine();
			map = new char[H][W];
			resultHW[tc][0] = H;
			resultHW[tc][1] = W;
			
			// input map
			for (int i = 0; i < H; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (str.charAt(j) == '^') {
						dir = 1;	// up
						x = j; y = i;
					}
					else if (str.charAt(j) == 'v') {
						dir = 2;	// down
						x = j; y = i;
					}
					else if (str.charAt(j) == '<') {
						dir = 3;	// left
						x = j; y = i;
					}
					else if (str.charAt(j) == '>') {
						dir = 4;	// right
						x = j; y = i;
					}
				}
			}
			
			// input move
			N = sc.nextInt();
			sc.nextLine();
			move = new char[N];
			
			String str = sc.nextLine();
			for (int i = 0; i < N; i++)
				move[i] = str.charAt(i);
			
			for (int m = 0; m < N; m++) {
				switch (move[m]) {
				case 'U':
					dir = 1;
					map[y][x] = '^';
					if (y - 1 >= 0 && map[y - 1][x] == '.') {
						map[y][x] = '.';
						y = y - 1;
						map[y][x] = '^';
					}
					break;
				case 'D':
					dir = 2;
					map[y][x] = 'v';
					if (y + 1 < H && map[y + 1][x] == '.') {
						map[y][x] = '.';
						y = y + 1;
						map[y][x] = 'v';
					}
					break;
				case 'L':
					dir = 3;
					map[y][x] = '<';
					if (x - 1 >= 0 && map[y][x - 1] == '.') {
						map[y][x] = '.';
						x = x - 1;
						map[y][x] = '<';
					}
					break;
				case 'R':
					dir = 4;
					map[y][x] = '>';
					if (x + 1 < W && map[y][x + 1] == '.') {
						map[y][x] = '.';
						x = x + 1;
						map[y][x] = '>';
					}
					break;
				case 'S':
					if (dir == 1 && y - 1 >= 0)
						shoot(y - 1, x, dir);
					else if (dir == 2 && y + 1 < H)
						shoot(y + 1, x, dir);
					else if (dir == 3 && x - 1 >= 0)
						shoot(y, x - 1, dir);
					else if (dir == 4 && x + 1 < W)
						shoot(y, x + 1, dir);
					break;
				}
			}
			result[tc] = map;
		}
			
		// output
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.print("#" + tc + " ");
			for (int i = 0; i < resultHW[tc][0]; i++) {
				for (int j = 0; j < resultHW[tc][1]; j++) {
					System.out.print(result[tc][i][j]);
				}
				System.out.println();
			}
		}
	}
	
	private static void shoot(int sY, int sX, int dir) {
		if (map[sY][sX] == '*')
			map[sY][sX] = '.';
		else if (map[sY][sX] == '#')
			return;
		else {
			if (dir == 1 && sY - 1 >= 0)
				shoot(sY - 1, sX, dir);
			else if (dir == 2 && sY + 1 < H)
				shoot(sY + 1, sX, dir);
			else if (dir == 3 && sX - 1 >= 0)
				shoot(sY, sX - 1, dir);
			else if (dir == 4 && sX + 1 < W)
				shoot(sY, sX + 1, dir);
		}
	}
}

