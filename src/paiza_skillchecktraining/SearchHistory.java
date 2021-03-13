package paiza_skillchecktraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchHistory {
	public static void main(String[] args) {
		List<String> wordsList = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        for(int i = 0;i < num ;i++) {
        	String line = sc.nextLine();
        	if(wordsList.contains(line)) {
        		wordsList.remove(line);
            }
        	wordsList.add(line);
        }

        //System.out.println(wordsList.size());


        for(int i = wordsList.size() - 1;i >= 0 ;i--) {
        	System.out.println(wordsList.get(i));
        }




	}

}
