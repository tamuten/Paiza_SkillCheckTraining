package paiza_skillchecktraining;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 6, 3, 2, 5, 23, 2};
		Arrays.sort(array);
		for(int i : array) {
			System.out.println(i);
		}
	}
}
