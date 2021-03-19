package paiza_skillchecktraining.a;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Paizaスキルチェック練習問題：陣取りゲーム
 *
 * @author
 *
 */
public class CampingGame {
	public static void main(String[] args) {
		new CampingGame().executeCampingGame();
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

	private char[][] field;
	private int height;
	private int width;
	private Player player;
	/** 陣地取得処理用のコピーフィールド */
	private char[][] clone;

	/**
	 * 処理開始
	 */
	public void executeCampingGame() {

		// 標準入力を読み込む
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		field = new char[height][width];
		clone = new char[height][width];
		sc.nextLine();

		char firstPlayer = sc.nextLine().charAt(0);

		player = Arrays.stream(Player.values()).filter(p -> p.getKey() == firstPlayer).findFirst().orElse(null);

		for (int i = 0; i < height; i++) {
			field[i] = sc.next().toCharArray();
		}

		sc.close();

		// 処理を開始する
		int cannotCampCnt = 0;
		while (true) {
			boolean couldCamp = camp();
			if (!couldCamp) {
				cannotCampCnt++;
				// 2人とも陣が取れなくなったら終了
				if (cannotCampCnt == Player.values().length) {
					break;
				}
			} else {
				cannotCampCnt = 0;
			}
			player = player.next();
			for (int i = 0; i < height; i++) {
				System.out.println(String.valueOf(field[i]));
			}
			System.out.println();
		}

		int a = 0;
		int b = 0;
		for (int i = 0; i < height; i++) {
			System.out.println(String.valueOf(field[i]));
			for (int j = 0; j < width; j++) {
				Player p = Player.getValue(field[i][j]);
				if (p == null) {
					continue;
				}
				switch (p) {
				case A:
					a++;
					break;
				case B:
					b++;
					break;
				default:
					break;
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
	private boolean camp() {
		boolean couldCamp = false;
		deepCopy(field, clone);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (field[i][j] == player.getKey()) {
					if (canGetCamp(i - 1, j)) {
						couldCamp = true; // 上
						getCamp(i - 1, j);
					}

					if (canGetCamp(i, j + 1)) {
						couldCamp = true; // 右
						getCamp(i, j + 1);
					}

					if (canGetCamp(i + 1, j)) {
						couldCamp = true; // 下
						getCamp(i + 1, j);
					}

					if (canGetCamp(i, j - 1)) {
						couldCamp = true; // 左
						getCamp(i, j - 1);
					}

				}
			}
		}
		deepCopy(clone, field);
		return couldCamp;
	}

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
	private boolean canGetCamp(int line, int col) {
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
	private void getCamp(int line, int col) {
		clone[line][col] = player.getKey();
	}
}
