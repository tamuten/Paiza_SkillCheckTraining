package paiza_skillchecktraining.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CampingGame {
	public static void main(String[] args) {
		new CampingGame().execute();
	}

	private enum Player {
		A('A'), B('B');

		Player next() {
			return values()[(ordinal() + 1) % Player.values().length];
		}

		private final char key;

		private Player(final char key) {
			this.key = key;
		}

		private char getKey() {
			return this.key;
		}

	}

	char[][] field;
	int height;
	int width;
	Player player;

	List<List<Point>> aPoints;
	int aPointsPointer;
	List<List<Point>> bPoints;
	int bPointsPointer;

	void execute() {

		// 標準入力を読み込む
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		field = new char[height][width];
		sc.nextLine();

		char firstPlayer = sc.nextLine()
			.charAt(0);

		player = Arrays.stream(Player.values())
			.filter(p -> p.getKey() == firstPlayer)
			.findFirst()
			.orElse(null);

		Point firstAPoint = null;
		Point firstBPoint = null;
		for (int i = 0; i < height; i++) {
			field[i] = sc.next()
				.toCharArray();
			for (int j = 0; j < width; j++) {
				if (field[i][j] == 'A') {
					firstAPoint = new Point(i, j);
				} else if (field[i][j] == 'B') {
					firstBPoint = new Point(i, j);
				}
			}
		}

		sc.close();
		aPoints = new ArrayList<>();
		aPoints.add(new LinkedList<>());
		aPoints.add(new LinkedList<>());
		aPointsPointer = 0;
		aPoints.get(aPointsPointer)
			.add(firstAPoint);
		bPoints = new ArrayList<>();
		bPoints.add(new LinkedList<>());
		bPoints.add(new LinkedList<>());
		bPointsPointer = 0;
		bPoints.get(bPointsPointer)
			.add(firstBPoint);

		// 処理を開始する
		int cannotCampCnt = 0;
		while (true) {
			List<Point> pointList = player == Player.A ? aPoints.get(aPointsPointer) : bPoints.get(bPointsPointer);
			boolean couldCamp = pointList.size() > 0;
			if (!couldCamp) {
				cannotCampCnt++;
				// 2人とも陣が取れなくなったら終了
				if (cannotCampCnt == Player.values().length) {
					break;
				}
			} else {
				cannotCampCnt = 0;
			}

			incrementPointer();
			camp(pointList);

			player = player.next();
		}

		int a = 0;
		int b = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				char camp = field[i][j];
				if (camp == 'A') {
					a++;
				} else if (camp == 'B') {
					b++;
				}
			}
		}
		System.out.println(a + " " + b);
		System.out.println(a > b ? "A" : "B");
	}

	/**
	 * 陣地取得処理
	 * 取れたかどうかの真偽値を返却
	 *
	 * @return
	 */
	void camp(List<Point> pointList) {
		pointList.forEach(p -> {
			int i = p.x;
			int j = p.y;
			getCamp(i - 1, j);
			getCamp(i, j + 1);
			getCamp(i + 1, j);
			getCamp(i, j - 1);
		});
		pointList.clear();
	}

	/**
	 * 指定した座標を現プレイヤーの陣地とする
	 *
	 * @param line 縦の座標
	 * @param col 横の座標
	 */
	void getCamp(int line, int col) {
		if (line < 0 ||
				line >= height ||
				col < 0 ||
				col >= width ||
				field[line][col] != '.') {
			return;
		}
		field[line][col] = player.getKey();

		List<Point> pointList = player == Player.A ? aPoints.get(aPointsPointer) : bPoints.get(bPointsPointer);
		pointList.add(new Point(line, col));

	}

	void incrementPointer() {
		if (player == Player.A) {
			aPointsPointer = (aPointsPointer + 1) % 2;
		} else {
			bPointsPointer = (bPointsPointer + 1) % 2;
		}
	}

	class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
