package paiza_skillchecktraining;

import java.util.Scanner;

public class Shinkeisuizyaku {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tate = sc.nextInt();
		int yoko = sc.nextInt();
		//参加者情報
		int[] peaple = new int[sc.nextInt()];

		int[][] haiti = new int[tate][yoko];
		//トランプの配置取り込み
		for (int i = 0; i < tate; i++) {
			for (int j = 0; j < yoko; j++) {
				haiti[i][j] = sc.nextInt();
			}
		}

		int times = sc.nextInt();
		int teban = 0;
		for (int i = 0; i < times; i++) {
			int tate1 = sc.nextInt() - 1;
			int yoko1 = sc.nextInt() - 1;
			int tate2 = sc.nextInt() - 1;
			int yoko2 = sc.nextInt() - 1;

			int pic1 = haiti[tate1][yoko1];
			int pic2 = haiti[tate2][yoko2];

			//トランプ値比較
			if (pic1 == pic2) {
				peaple[teban] += 2;
			} else {
				teban++;
				if (teban == peaple.length) {//一周したら最初の人の手番へ
					teban = 0;
				}
			}
		}

		for (int hito : peaple) {
			System.out.println(hito);
		}
	}
}

class Trump {
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}