package problem2012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1900 {
	private static int N;
	private static ArrayList<Player> players;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		players = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			int strength = sc.nextInt();
			int ring = sc.nextInt();
			players.add(new Player(i, strength, ring));
		}
		
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j <= N - 1; j++)
				fight(players.get(i), players.get(j));
		
		Collections.sort(players);

		for (int i = 0; i < N; i++)
			System.out.println(players.get(i).n);
	}
	
	private static void fight(Player a, Player b) {
		int aSum = a.s + b.s * a.r;
		int bSum = b.s + a.s * b.r;
		
		if (aSum > bSum)
			a.w++;
		if (aSum < bSum)
			b.w++;
	}

	private static class Player implements Comparable<Player> {
		int n, s, r, w;	// number, strength, ring, win

		public Player(int n, int s, int r) {
			this.n = n;
			this.s = s;
			this.r = r;
			this.w = 0;
		}

		@Override
		public int compareTo(Player o) {
			return o.w - this.w;
		}
	}
}
