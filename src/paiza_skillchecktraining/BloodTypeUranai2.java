package paiza_skillchecktraining;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BloodTypeUranai2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//入力部分
		String user = sc.next();
		int times1 = sc.nextInt();
		Map<String, String> bloodType = new HashMap<String, String>();
		for(int i= 0;i < times1;i++) {
			String name = sc.next();
			String blood = sc.next();
			bloodType.put(name, blood);
		}

		int times2 = sc.nextInt();
		Map<String, String> uranai = new HashMap<String, String>();
		for(int i = 0;i < times2;i++) {
			String blood = sc.next();
			String result = sc.next();
			uranai.put(blood, result);
		}

		//結果を出力
		System.out.println(uranai.get(bloodType.get(user)));

		sc.close();
	}
}
