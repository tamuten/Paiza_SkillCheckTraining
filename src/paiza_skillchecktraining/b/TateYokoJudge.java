package paiza_skillchecktraining.b;

import java.util.Scanner;

public class TateYokoJudge {
	public static void main(String[] args) {
		new TateYokoJudgeImpl().execute();
	}
}

class TateYokoJudgeImpl {
	private static char SHARP = '#';
	private Board[][] board;
	private int line;
	private int column;

	public void execute() {
		Scanner sc = new Scanner(System.in);
		line = sc.nextInt();
		column = sc.nextInt();
		sc.nextLine();

		board = new Board[line][column];

		readBoard(sc);

		judgeMap();

		printMap();

	}

	private void readBoard(Scanner sc) {
		for (int i = 0; i < line; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < column; j++) {
				char sign = line.charAt(j);
				board[i][j] = new Board(sign);
			}
		}
	}

	private void judgeMap() {
		for (int i = 0; i < line; i++) {
			for (int j = 0; i < column; j++) {
				if (aboveIsSharp(i, j) && rightIsSharp(i, j) && belowIsSharp(i, j) && leftIsSharp(i, j)) {
					board[i][j].isMap = true;
				}
			}
		}
	}

	private void printMap() {
		for (int i = 0; i < line; i++) {
			for (int j = 0; i < column; j++) {
				if (board[i][j].isMap) {
					System.out.println(i + " " + j);
				}
			}
		}
	}

	private boolean aboveIsSharp(int line, int column) {
		if (line <= 0) {
			return true;
		}

		char above = board[line - 1][column].sign;
		if (above == SHARP) {
			return true;
		}

		return false;
	}

	private boolean rightIsSharp(int line, int column) {
		if (column >= this.column - 1) {
			return true;
		}

		char right = board[line][column + 1].sign;
		if (right == SHARP) {
			return true;
		}
		return false;
	}

	private boolean belowIsSharp(int line, int column) {
		if (line >= this.line - 1) {
			return true;
		}

		char below = board[line + 1][column].sign;
		if (below == SHARP) {
			return true;
		}
		return false;
	}

	private boolean leftIsSharp(int line, int column) {
		if (column <= 0) {
			return true;
		}

		char left = board[line][column - 1].sign;
		if (left == SHARP) {
			return true;
		}
		return false;
	}

	class Board {
		char sign;
		boolean isMap;

		public Board(char sign) {
			super();
			this.sign = sign;
		}

	}
}