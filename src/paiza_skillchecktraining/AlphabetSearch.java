package paiza_skillchecktraining;

import java.util.Scanner;

public class AlphabetSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char x = sc.next().charAt(0);
		char y = sc.next().charAt(0);
		char c = sc.next().charAt(0);
		
		if(y < x) {
			System.out.println("false");
		} else {
			if(x <= c && c <= y) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
	}
}
