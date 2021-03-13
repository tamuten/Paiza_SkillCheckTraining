package paiza_skillchecktraining;

import java.util.Scanner;

public class BloodTypeUranai {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String trgKey = sc.next();
		while(sc.hasNext()) {
			String bloodType = sc.next();
			String result = sc.next();
			System.out.println(bloodType + " " + result);
			if(bloodType.equals(trgKey)) {
				System.out.println(result);
			}
		}
	}
}
