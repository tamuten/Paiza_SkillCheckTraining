package paiza_skillchecktraining.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Paizaスキルチェック練習問題：陣取りゲーム
 *
 * @author
 *
 */
public class CampingGame {
	public static void main(String[] args) {
		new CampingGame().execute();
	}

	private enum Player {
		A('A', 0), B('B', 0);

		Player next() {
			return values()[(ordinal() + 1) % Player.values().length];
		}

		private final char key;
		private int score;

		private Player(final char key, final int score) {
			this.key = key;
			this.score = score;
		}

		private char getKey() {
			return this.key;
		}

		private int getScore() {
			return this.score;
		}

		private static Player getValue(char key) {
			return Arrays.stream(Player.values())
				.filter(data -> data.getKey() == key)
				.findFirst()
				.orElse(null);
		}

	}

	char[][] field;
	List<List<Point>> aPoints = new ArrayList<>();
	List<List<Point>> bPoints = new ArrayList<>();
	int height;
	int width;
	Player player;
	/** 陣地取得処理用のコピーフィールド */
	private char[][] clone;

	boolean aCanCamp() {
		return aPoints.size() > 0;
	}

	boolean bCanCamp() {
		return bPoints.size() > 0;
	}

	void pointsDelete() {
		aPoints.clear();
		bPoints.clear();
	}

	void execute() {

		// 標準入力を読み込む
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		field = new char[height][width];
		clone = new char[height][width];
		sc.nextLine();

		char firstPlayer = sc.nextLine()
			.charAt(0);

		player = Arrays.stream(Player.values())
			.filter(p -> p.getKey() == firstPlayer)
			.findFirst()
			.orElse(null);

		for (int i = 0; i < height; i++) {
			field[i] = sc.next()
				.toCharArray();
		}

		sc.close();

		// 処理を開始する
		int cannotCampCnt = 0;
		int turnCnt = 0;
		int turn = 0;
		while (true) {
			turnCnt++;
			List<Point> pointList = player == Player.A ? aPoints.get(turn) : bPoints.get(turn);
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
			//			pointsDelete();

			camp(pointList, turn);

			if (turnCnt == 2) {
				turn++;
				turnCnt = 0;
			}
			player = player.next();
			//			for (int i = 0; i < height; i++) {
			//				System.out.println(String.valueOf(field[i]));
			//			}
			//			System.out.println();

		}

		int a = 0;
		int b = 0;
		for (int i = 0; i < height; i++) {
			//			System.out.println(String.valueOf(field[i]));
			for (int j = 0; j < width; j++) {
				//				Player p = Player.getValue(field[i][j]);
				//				if (p == null) {
				//					continue;
				//				}
				//				switch (p) {
				//				case A:
				//					a++;
				//					break;
				//				case B:
				//					b++;
				//					break;
				//				default:
				//					break;
				//				}
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
	void camp(List<Point> pointList, int turn) {
		//		boolean couldCamp = false;
		//		deepCopy(field, clone);
		//		for (int i = 0; i < height; i++) {
		//			for (int j = 0; j < width; j++) {
		//				if (field[i][j] == player.getKey()) {
		//					if (canGetCamp(i - 1, j)) {
		//						couldCamp = true; // 上
		//						getCamp(i - 1, j);
		//					}
		//
		//					if (canGetCamp(i, j + 1)) {
		//						couldCamp = true; // 右
		//						getCamp(i, j + 1);
		//					}
		//
		//					if (canGetCamp(i + 1, j)) {
		//						couldCamp = true; // 下
		//						getCamp(i + 1, j);
		//					}
		//
		//					if (canGetCamp(i, j - 1)) {
		//						couldCamp = true; // 左
		//						getCamp(i, j - 1);
		//					}

		//				}
		//			}
		//		List<Point> pointList = player == Player.A ? aPoints : bPoints;
		pointList.forEach(p -> {
			int i = p.x;
			int j = p.y;
			getCamp(i - 1, j, turn);
			getCamp(i, j + 1, turn);
			getCamp(i + 1, j, turn);
			getCamp(i, j - 1, turn);
		});

	}
	//		deepCopy(clone, field);

	/**
	 * フィールドの2次元配列をディープコピーする
	 *
	 * @param original
	 * @param replica
	 */
	private void deepCopy(char[][] original, char[][] replica) {
		for (int i = 0; i < height; i++) {
			replica[i] = Arrays.copyOf(original[i], original[i].length);
		}
	}

	/**
	 * 陣地が取れるかどうか真偽値を返却
	 *
	 * @param line 縦の座標
	 * @param col 横の座標
	 * @return
	 */
	boolean canGetCamp(int line, int col) {
		if (line < 0 ||
				line >= height ||
				col < 0 ||
				col >= width ||
				field[line][col] != '.') {
			return false;
		}
		return true;
	}

	/**
	 * 指定した座標を現プレイヤーの陣地とする
	 *
	 * @param line 縦の座標
	 * @param col 横の座標
	 */
	void getCamp(int line, int col, int turn) {
		if (line < 0 ||
				line >= height ||
				col < 0 ||
				col >= width ||
				field[line][col] != '.') {
			return;
		}
		field[line][col] = player.getKey();
		List<List<Point>> pointList = player == Player.A ? aPoints : bPoints;

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
