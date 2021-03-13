package paiza_skillchecktraining;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Sort1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int[] keys = new int[times];
		for(int i = 0;i < times;i++) {
			String value = sc.next();
			int key = sc.nextInt();
			map.put(key, value);
			keys[i] = key;
		}

		Arrays.sort(keys);
		for(int k : keys) {
			System.out.println(map.get(k));
			
		}
	}
}
