package paiza_skillchecktraining;

import java.util.Scanner;

public class AlphabetOrder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char first = str.charAt(0);
		char last = str.charAt(str.length() - 1);
		for(char c = first;c <= 'Z';c++) {
			if(c == last) {
				System.out.println("true");
			}
		}
		
		for(char c = first;c >= 'A';c--) {
			if(c == last) {
				System.out.println("false");
			}
		}
		
		if(first <last) {
			System.out.println("true");
		} else  if (last < first){
			System.out.println("false");
		}
	}
}
