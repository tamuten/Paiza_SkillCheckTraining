package paiza_skillchecktraining.a;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Hanoi {
	public static void main(String[] args) {
		Deque<Integer> aTower = new ArrayDeque<Integer>();
		Deque<Integer> bTower = new ArrayDeque<Integer>();
		Deque<Integer> cTower = new ArrayDeque<Integer>();

		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		final int t = sc.nextInt();
		sc.close();

		// Aに円盤を詰める
		for (int i = 0; i < n; i++) {
			aTower.push(n - i);
		}

		Integer one = aTower.pop();
		// 1を置く場所を決める
		if (n % 2 == 0) {
			bTower.push(one);
		} else {
			cTower.push(one);
		}

		// Aからpopする期間
		Integer disk = aTower.pop();
		if (disk % 2 == 0) {
			bTower.push(disk);
		} else {
			cTower.push(disk);
		}

	}
}
