package paiza_skillchecktraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class NumberSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		Iterator<Integer> iterator = list.iterator();
		int sum = 0;
		while(iterator.hasNext()) {
			int j = iterator.next();
			//System.out.println(j);
			sum += j;
		}
		System.out.println(sum);*/

		int times = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < times; i++) {
			String str = sc.next();
			int n = sc.nextInt();
			if (map.isEmpty()) {
				map.put(str, n);
			} else {

				Set<String> keySet = map.keySet();
				Iterator<String> iterator = keySet.iterator();
				int flag = 0;
				while (iterator.hasNext()) {
					String tmp = iterator.next();
					if (tmp.equals(str)) {
						int sum = map.get(tmp) + n;
						map.put(tmp, sum);
						flag = 1;
					} /*else {
						map.put(str, n);
						}*/
				}
				if(flag == 0) {
					map.put(str, n);
				}
			}

		}

		//map.get(key)

		// 2.Map.Entryのリストを作成する
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
		 // 6. 比較関数Comparatorを使用してMap.Entryの値を比較する（降順）
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            //compareを使用して値を比較する
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                //降順
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        //System.out.println("降順でのソート");
        // 7. ループで要素順に値を取得する
        for(Entry<String, Integer> entry : list_entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
	}
}
