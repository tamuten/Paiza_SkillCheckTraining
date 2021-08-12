package paiza_skillchecktraining.a;

import java.util.Scanner;

public class PincerAttack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int H = sc.nextInt();
		final int W = sc.nextInt();
		final int N = sc.nextInt();
		final int n = sc.nextInt();

		// 盤面を読み取る
		char[][] field = new char[H][W];
		for (int i = 0; i < H; i++) {
			field[i] = sc.next()
				.toCharArray();
		}

		// 石をおいていく
		for (int i = 0; i < n; i++) {
			final char player = (char) ('0' + sc.nextInt());
			final int Y = sc.nextInt();
			final int X = sc.nextInt();

			field[Y][X] = player;

			// 上
			int y = Y - 1;
			while (true) {
				if (y < 0 || field[y][X] == '#') {
					break;
				}

				if (field[y][X] == player) {
					for (int j = Y; j >= y; j--) {
						field[j][X] = player;
					}
					break;
				}
				y--;
			}

			// 右
			int x = X + 1;
			while (true) {
				if (x >= W || field[Y][x] == '#') {
					break;
				}

				if (field[Y][x] == player) {
					for (int k = X; k <= x; k++) {
						field[Y][k] = player;
					}
					break;
				}
				x++;
			}

			// 下
			y = Y + 1;
			while (true) {
				if (y >= H || field[y][X] == '#') {
					break;
				}

				if (field[y][X] == player) {
					for (int j = Y; j <= y; j++) {
						field[j][X] = player;
					}
					break;
				}
				y++;
			}

			// 左
			x = X - 1;
			while (true) {
				if (x < 0 || field[Y][x] == '#') {
					break;
				}

				if (field[Y][x] == player) {
					for (int k = X; k >= x; k--) {
						field[Y][k] = player;
					}
					break;
				}
				x--;
			}

			// 右上
			y = Y - 1;
			x = X + 1;
			while (true) {
				if (y < 0 || x >= W || field[y][x] == '#') {
					break;
				}

				if (field[y][x] == player) {
					int j = Y;
					int k = X;
					while (j >= y || k <= x) {
						field[j][k] = player;
						j--;
						k++;
					}
					break;
				}
				y--;
				x++;
			}

			// 右下
			y = Y + 1;
			x = X + 1;
			while (true) {
				if (y >= H || x >= W || field[y][x] == '#') {
					break;
				}

				if (field[y][x] == player) {
					int j = Y;
					int k = X;
					while (j <= y || k <= x) {
						field[j][k] = player;
						j++;
						k++;
					}
					break;
				}
				y++;
				x++;
			}

			// 左下
			y = Y + 1;
			x = X - 1;
			while (true) {
				if (y >= H || x < 0 || field[y][x] == '#') {
					break;
				}

				if (field[y][x] == player) {
					int j = Y;
					int k = X;
					while (j <= y || k >= x) {
						field[j][k] = player;
						j++;
						k--;
					}
					break;
				}
				y++;
				x--;
			}

			// 左上
			y = Y - 1;
			x = X - 1;
			while (true) {
				if (y < 0 || x < 0 || field[y][x] == '#') {
					break;
				}

				if (field[y][x] == player) {
					int j = Y;
					int k = X;
					while (j >= y || k >= x) {
						field[j][k] = player;
						j--;
						k--;
					}
					break;
				}
				y--;
				x--;
			}

		}
		sc.close();

		// 盤面を出力する
		for (int i = 0; i < H; i++) {
			System.out.println(String.valueOf(field[i]));
		}

	}
}
