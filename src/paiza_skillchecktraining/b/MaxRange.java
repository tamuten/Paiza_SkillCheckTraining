package paiza_skillchecktraining.b;

import java.util.Scanner;

public class MaxRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		final int k = sc.nextInt();
		int[] log = new int[n];
		for (int i = 0; i < n; i++) {
			log[i] = sc.nextInt();
		}
		sc.close();

		int[] visitorNumArr = new int[n - k + 1];
		for (int i = 0; i < n - k + 1; i++) {
			int visitorNum = 0;
			for (int j = i; j < i + k; j++) {
				visitorNum += log[j];
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
	}
}
