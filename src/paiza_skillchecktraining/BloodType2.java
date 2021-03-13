package paiza_skillchecktraining;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BloodType2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String user = sc.next();
		final int TIMES = sc.nextInt();
		Map<String, String> bloodMap = new LinkedHashMap<String, String>();
		for(int i = 0;i < TIMES;i++) {
			String name = sc.next();
			String bloodType = sc.next();

			bloodMap.put(name, bloodType);
		}

		/*for(Entry<String, String> entry : bloodMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}*/
		System.out.println(user + " " + bloodMap.get(user));


		sc.close();
	}
}
