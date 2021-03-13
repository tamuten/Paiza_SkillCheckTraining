package paiza_skillchecktraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CountWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("hello");
		
		List<String> wordsList = new ArrayList<String>();
		
		
		while(sc.hasNext()) {
			//System.out.println("hello");
			String str = sc.next();
			wordsList.add(str);
			//System.out.println(str);
		}
		
		//System.out.println("hello");
		LinkedHashSet<String> wordsSet = new LinkedHashSet<String>(wordsList);
		//Set<String> wordsSet = new HashSet<String>(wordsList);
		
		for(String tmp : wordsSet) {
			System.out.println(tmp + " " + Collections.frequency(wordsList, tmp));
		}
	}
}
