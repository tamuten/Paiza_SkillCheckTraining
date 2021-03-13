package paiza_skillchecktraining.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Snake {
	public static void main(String[] args) {
		new SnakeMove().execute();
	}

}

class SnakeMove {
	private enum Direction {
		NORTH, EAST, SOUTH, WEST;

		Direction right() {
			return values()[(ordinal() + 1) % 4];
		}

		Direction left() {
			return values()[(ordinal() + 3) % 4];
		}
	}

	private int line;
	private int col;
	private char[][] field;
	private Map<Integer, String> turn = new HashMap<>();
	private int sy;
	private int sx;
	private Direction direction = Direction.NORTH; // はじめは北を向いている
	private int turnNum;

	public void execute() {
		Scanner sc = new Scanner(System.in);
		line = sc.nextInt();
		col = sc.nextInt();
		sy = sc.nextInt();
		sx = sc.nextInt();
		turnNum = sc.nextInt();
		sc.nextLine();

		// フィールドを初期化
		field = new char[line][col];

		// フィールドを読込
		inputField(sc);

		// 方向転換情報を読込マップに格納
		inputTurnInfo(sc);

		// 蛇が移動する
		move();

		// マップを出力する
		printField();

	}

	private void inputField(Scanner sc) {
		for (int i = 0; i < line; i++) {
			String line = sc.nextLine();
			field[i] = line.toCharArray();
		}
	}

	private void inputTurnInfo(Scanner sc) {
		for (int i = 0; i < turnNum; i++) {

			int time = sc.nextInt();
			String direction = sc.next();
			turn.put(time, direction);
		}
	}

	private void move() {
		// 初期位置を蛇の体にする
		field[sy][sx] = '*';
		for (int time = 0; time <= 99; time++) {

			// 向きを変える時間の場合は向きを変える
			if (turn.containsKey(time)) {
				direction = changeDirection(time);
			}

			if (cannotMove()) {
				return;
			}

			advance();
		}
	}

	private Direction changeDirection(int time) {
		String dStr = turn.get(time);
		if (dStr.equals("R")) {
			return direction.right();
		} else if (dStr.equals("L")) {
			return direction.left();
		} else {
			throw new IllegalArgumentException("不正な方角ステートメント");
		}
	}

	private boolean cannotMove() {
		switch (direction) {
		case NORTH:
			return cannotAdvance(sy - 1, sx);
		case EAST:
			return cannotAdvance(sy, sx + 1);
		case SOUTH:
			return cannotAdvance(sy + 1, sx);
		case WEST:
			return cannotAdvance(sy, sx - 1);
		}
		return false;
	}

	private boolean cannotAdvance(int y, int x) {
		if (y < 0 ||
				y >= line ||
				x < 0 ||
				x >= col ||
				field[y][x] != '.') {
			return true;
		}

		return false;
	}

	private void advance() {
		switch (direction) {
		case NORTH:
			sy--;
			break;
		case EAST:
			sx++;
			break;
		case SOUTH:
			sy++;
			break;
		case WEST:
			sx--;
			break;
		}
		// 移動後の位置を蛇の体にする
		field[sy][sx] = '*';
		//		printField();
	}

	private void printField() {
		for (char[] line : field) {
			for (char c : line) {
				System.out.print(c);
			}
			System.out.println();
		}
		//		Stream.of(field).map(l -> l.toString()).forEach(System.out::println);
	}
}