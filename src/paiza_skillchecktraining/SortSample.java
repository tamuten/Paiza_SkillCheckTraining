package paiza_skillchecktraining;

import java.util.Arrays;
import java.util.Scanner;

public class SortSample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
		int[] numbers = new int[times];
		for(int i = 0;i < times;i++) {
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers);
		
		for(int i : numbers) {
			System.out.println(i);
		}
	}
}
