package paiza_skillchecktraining;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class BloodType {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int TIMES = sc.nextInt();
		Map<String, String> bloodMap = new LinkedHashMap<String, String>();
		for(int i = 0;i < TIMES;i++) {
			String name = sc.next();
			String bloodType = sc.next();
			
			bloodMap.put(name, bloodType);
		}
		
		for(Entry<String, String> entry : bloodMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
