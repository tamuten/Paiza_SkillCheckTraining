package paiza_skillchecktraining.a;

import java.util.Scanner;

public class MaxRangeLarge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		final int k = sc.nextInt();
		int[] log = new int[n];
		for (int i = 0; i < n; i++) {
			log[i] = sc.nextInt();
		}
		sc.close();

		long startTime = System.currentTimeMillis();

		int[] visitorNumArr = new int[n - k + 1];
		int visitorNum = 0;
		for (int i = 0; i < n - k + 1; i++) {

			if (i == 0) {
				// i が 0の時は合計を計算
				for (int j = i; j < i + k; j++) {
					visitorNum += log[j];
				}
			} else {
				// iが0以外の時は先頭を引いて、新たな1箇所を足す
				visitorNum = visitorNum - log[i - 1] + log[i + k - 1];
			}

			visitorNumArr[i] = visitorNum;
		}

		int maxVisitors = 0;
		for (int i = 0; i < n - k + 1; i++) {
			if (visitorNumArr[i] > maxVisitors) {
				maxVisitors = visitorNumArr[i];
			}
		}

		int count = 0;
		int startDate = 0;
		for (int i = 0; i < n - k + 1; i++) {
			if (visitorNumArr[i] == maxVisitors) {
				if (count == 0) {
					startDate = i + 1;
				}
				count++;
			}
		}

		System.out.println(count + " " + startDate);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("経過時間：" + totalTime);
	}
}
