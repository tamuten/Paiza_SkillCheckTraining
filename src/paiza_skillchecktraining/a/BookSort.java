package paiza_skillchecktraining.a;

import java.util.Scanner;

public class BookSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		int[] booksId = new int[n];
		for (int i = 0; i < n; i++) {
			booksId[i] = sc.nextInt();
		}
		sc.close();

		int swapTimes = 0;
		for (int i = 0; i < n; i++) {
			int minIdx = searchMinIdx(booksId, i);
			if (minIdx != i) {
				swap(booksId, i, minIdx);
				swapTimes++;
			}
		}

		System.out.println(swapTimes);

	}

	static int searchMinIdx(int[] booksId, int left) {
		int min = booksId.length + 1;
		int idx = -1;
		for (int i = left; i < booksId.length; i++) {
			if (booksId[i] < min) {
				min = booksId[i];
				idx = i;
			}
		}
		return idx;
	}

	static void swap(int[] booksId, int targetId1, int targetId2) {
		int tmp = booksId[targetId1];
		booksId[targetId1] = booksId[targetId2];
		booksId[targetId2] = tmp;
	}
}
