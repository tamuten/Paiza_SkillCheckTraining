package paiza_skillchecktraining.a;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MaxRangeLargeWriter {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:\\pleiades\\workspace\\paiza_skillCheckTraining\\test.txt", false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			//			pw.println("今日の最高気温は");
			//			pw.println(10);
			//			pw.println("度です");
			println(pw);

			pw.close();
			System.out.println("書き込みが完了しました。");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	static void println(PrintWriter pw) {
		final int n = 300000;
		final int k = 3;
		pw.println(n + " " + k);
		for (int i = 0; i < 60000; i++) {
			pw.print("1 2 3 2 1");
			if (i != 59999) {
				pw.print(" ");
			}
		}
		pw.println();
	}
}
