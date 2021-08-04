package paiza_skillchecktraining.a;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CampingGame2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		String player = sc.next();

		Deque<XY> q = new ArrayDeque<>();

		XY aPosition = null;
		XY bPosition = null;
		char[][] field = new char[height][width];
		for (int i = 0; i < height; i++) {
			String line = sc.next();
			for (int j = 0; j < width; j++) {
				char c = line.charAt(j);
				if (c == 'A') aPosition = new XY(i, j);
				if (c == 'B') bPosition = new XY(i, j);
				field[i][j] = c;
			}
		}

	}

}

enum Player {
	A, B;

	Deque<XY> q = new ArrayDeque<>();

	void setDeque(XY xy) {
		this.q.add(xy);
	}

	Player next() {
		return values()[(ordinal() + 1) % Player.values().length];
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
