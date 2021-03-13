package paiza_skillchecktraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class NumberSort2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int times = sc.nextInt();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < times; i++) {
			char c = sc.next().charAt(0);
			int n = sc.nextInt();
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + n);

			} else {

				map.put(c, n);
			}

		}

		List<Integer> list_value = new ArrayList<Integer>(map.values());
		Collections.sort(list_value);
		Collections.reverse(list_value);

		for (int i : list_value) {
			for (Character c : map.keySet())
				if (map.get(c) == i) {
					System.out.println(c + " " + i);
				}
		}

	}
}
