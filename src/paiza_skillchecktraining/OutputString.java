package paiza_skillchecktraining;

import java.util.Scanner;

public class OutputString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if(str.length() == 1) {
			System.out.println(str);
		} else {
			char first = str.charAt(0);
			char last = str.charAt(str.length() - 1);
			char c = first;
			while(c != last) {
				System.out.println(c);
				c++;
			}
			System.out.println(last);
		}
	}
}
