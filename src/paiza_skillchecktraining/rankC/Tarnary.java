package paiza_skillchecktraining.rankC;

import java.util.Scanner;

/**
 * @author takashi
 *
 */
public class Tarnary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println(a > 0 ? "plus" : a);
		String b = sc.next();
		System.out.println(b.equals("hoge") ? "yes" : b);
		String c = sc.next();
		System.out.println(c.length() == 10 ? "ten" : c);
		String d = sc.next();
		System.out.println(d.contains("x") ? d.indexOf("x") : "nothing");
		String e = sc.next();
		System.out.println(e.length() == 5 ? "five" : e.charAt(0));
		sc.close();
	}
}
