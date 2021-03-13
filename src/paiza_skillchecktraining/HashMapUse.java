package paiza_skillchecktraining;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapUse {
	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("Kyoko", "B");
		map.put("Rio", "O");
		map.put("Tsubame", "AB");
		map.put("KurodaSensei", "A");
		map.put("NekoSensei", "A");

		//String[] users = {"Kyoko","Rio","Tsubame","KurodaSensei","NekoSensei"};

		for(String user : map.keySet()) {
			System.out.println(user + " " + map.get(user));
		}
	}
}
