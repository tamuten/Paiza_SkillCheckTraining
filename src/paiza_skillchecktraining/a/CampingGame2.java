package paiza_skillchecktraining.a;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CampingGame2 {

	public static void main(String[] args) {

	}

	static int H;
	static int W;
	char[][] field;

	void execute() {
		Scanner sc = new Scanner(System.in);
		// 高さ
		H = sc.nextInt();
		// 幅
		W = sc.nextInt();
		// 盤面を定義
		field = new char[H][W];
		// プレイヤー
		String player = sc.next();

		Deque<XY> q = new ArrayDeque<>();

		// AとBの初期位置
		XY aPosi = null;
		XY bPosi = null;

		// 盤面を読み込む
		for (int i = 0; i < H; i++) {
			String line = sc.next();
			for (int j = 0; j < W; j++) {
				char c = line.charAt(j);
				//				if (c == 'A') aPosi = new XY(i, j);
				if (c == 'A') Player.A.setDeque(new XY(j, j));
				//				if (c == 'B') bPosi = new XY(i, j);
				if (c == 'B') Player.B.setDeque(new XY(i, j));
				field[i][j] = c;
			}
		}
	}

	enum Player {
		A, B;

		// キュー
		Deque<XY> q = new ArrayDeque<>();

		void search(char[][] field) {
			XY first = q.poll();
			field[first.x][first.y] =
			if (field[first.x + 1][first.y] == '.') q.add(new XY(first.x + 1, first.y));
			if (field[first.x][first.y + 1] == '.') q.add(new XY(first.x + 1, first.y));
			if (field[first.x - 1][first.y] == '.') q.add(new XY(first.x + 1, first.y));
			if (field[first.x][first.y - 1] == '.') q.add(new XY(first.x + 1, first.y));
		}

		void setDeque(XY xy) {
			this.q.add(xy);
		}

		Player next() {
			return values()[(ordinal() + 1) % Player.values().length];
		}

		//		char getChar() {
		//			if(Player.A) 'A';
		//		}

		void camp(char[][] field, int x, int y) {
			if (x < 0
					|| y < 0
					|| x >= W
					|| y >= H
					|| field[x][y] != '.') {
				return;
			}
			if (field[x][y] == '.') q.add(new XY(x, y));
		}
	}

}

class XY {
	int x;
	int y;

	XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
