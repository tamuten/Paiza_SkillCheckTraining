package paiza_skillchecktraining;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DuplicateCheck {
	public static void main(String[] args) {
		//String[] wordList = {"HND", "NRT", "KIX", "NGO", "NGO"};
		List<String> wordList = new ArrayList<String>();
		wordList.add("HND");
		wordList.add("NRT");
		wordList.add("KIX");
		wordList.add("NGO");
		wordList.add("NGO");
		wordList.add("NGO");
		wordList.add("NGO");
		wordList.add("NGO");
		HashSet<String> wordSet = new HashSet<String>(wordList);
		//boolean ans = (wordList.size() != wordSet.size());
		System.out.println(wordList.size() - wordSet.size() + 1);
	}
}
