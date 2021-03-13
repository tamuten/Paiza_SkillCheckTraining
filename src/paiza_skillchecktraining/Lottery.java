package paiza_skillchecktraining;

import java.util.Scanner;

public class Lottery {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//当選番号を変数に格納
		int hitNum = sc.nextInt();

		//その他等賞マッチングのための変数を定義
		String h = String.valueOf(hitNum);
		int a1 = hitNum + 1;
		int a2 = hitNum - 1;
		String adjacent1 = String.valueOf(a1);
		String adjacent2 = String.valueOf(a2);
		String second = h.substring(h.length() - 4);
		String third = h.substring(h.length() - 3);

		//System.out.println(s);
		//System.out.println(t);

		int num = sc.nextInt();
		sc.nextLine();
		for(int i = 0;i < num;i++) {
			String line = sc.nextLine();
			String line4 = line.substring(line.length() - 4);
			String line3 = line.substring(line.length() - 3);

			if(line.equals(h)) {
				System.out.println("first");
			} else if(line.equals(adjacent1) || line.equals(adjacent2)) {
				System.out.println("adjacent");
			} else if(line4.equals(second)) {
				System.out.println("second");
			} else if(line3.equals(third)) {
				System.out.println("third");
			} else {
				System.out.println("blank");
			}
		}
	}
}
