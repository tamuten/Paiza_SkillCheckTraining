package paiza_skillchecktraining.a;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Piazaスキルチェック練習問題：陣取りゲーム
 *
 * @author takashi
 *
 */
public class CampingGame {
	public static void main(String[] args) {
		new CampingGame().executeCampingGame();
	}

	/**
	 * プレイヤー定数
	 *
	 * @author takashi
	 *
	 */
	private static enum Player {
		A('A'), B('B');

		/**
		 * プレイヤー交代
		 *
		 * @return
		 */
		Player next() {
			return values()[(ordinal() + 1) % Player.values().length];
		}

		private final char c;

		private Player(final char c) {
			this.c = c;
		}

		private char getchar() {
			return this.c;
		}

		private static Player getValue(char key) {
			return Arrays.stream(Player.values())
					.filter(data -> data.getchar() == key)
					.findFirst()
					.orElse(null);
		}
	}

	private char[][] field;
	private int height;
	private int width;
	private Player player;
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

		String firstPlayer = sc.nextLine();
		player = firstPlayer.equals("A") ? Player.A : Player.B;

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

	private boolean camp() {
		boolean couldCamp = false;
		deepCopy(field, clone);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (field[i][j] == player.getchar()) {
					couldCamp = getCamp(i - 1, j); // 上
					couldCamp = getCamp(i, j + 1); // 右
					couldCamp = getCamp(i + 1, j); // 下
					couldCamp = getCamp(i, j - 1); // 左
				}
			}
		}
		deepCopy(clone, field);
		return couldCamp;
	}

	private void deepCopy(char[][] original, char[][] replica) {
		for (int i = 0; i < height; i++) {
			replica[i] = Arrays.copyOf(original[i], original[i].length);
		}
	}

	private boolean getCamp(int line, int col) {
		if (line < 0 ||
				line >= height ||
				col < 0 ||
				col >= width ||
				field[line][col] != '.') {
			return false;
		}
		clone[line][col] = player.getchar();
		return true;
	}
}
