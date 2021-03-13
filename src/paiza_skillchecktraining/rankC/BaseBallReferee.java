package paiza_skillchecktraining.rankC;

import java.util.Scanner;

public class BaseBallReferee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Referee referee = new Referee();

		int cnt = 1;
		while (sc.hasNext()) {

			String pitch = sc.nextLine();
			if (cnt++ == 1) {
				continue;
			}

			referee.judge(pitch);
		}
		sc.close();
	}

}

class Referee {

	//	private int strike;
	//	private int ball;
	Strike strike;
	Ball ball;

	public Referee() {
		strike = new Strike();
		ball = new Ball();
	}

	/**
	 * 審判が判定をします。
	 *
	 * @param pitch
	 */
	public void judge(String pitch) {
		if (pitch.equals("strike")) {
			strike.addCount();
			//			strike++;
			//
			//			if (strike >= 3) {
			//				System.out.println("out!");
			//				return;
			//			}
			//
			//			System.out.println("strike!");
		} else if (pitch.equals("ball")) {

			//			ball++;
			//
			//			if (ball >= 4) {
			//				System.out.println("fourball!");
			//				return;
			//			}
			//
			//			System.out.println("ball!");
		} else {
			System.out.println("invalid pitch!");
		}
	}
}

interface Count {
	abstract void addCount();
}

class Strike implements Count {
	private int strike;

	public void addCount() {
		strike++;
		if (strike > 2) {
			System.out.println("out!");
			return;
		}
		System.out.println("strike!");
	}
}

class Ball implements Count {
	private int ball;

	public void addCount() {
		ball++;
		if (ball > 3) {
			System.out.println("fourball!");
			return;
		}
		System.out.println("ball!");
	}
}