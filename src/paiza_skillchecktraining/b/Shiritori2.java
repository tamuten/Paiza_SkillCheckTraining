package paiza_skillchecktraining.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Shiritori2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int peopleNum = sc.nextInt();
		final int wordNum = sc.nextInt();
		final int remarkNum = sc.nextInt();

		List<String> wordList = new ArrayList<>();
		for (int i = 0; i < wordNum; i++) {
			wordList.add(sc.next());
		}

		List<String> remarkedWordList = new ArrayList<>();
		boolean[] dropOutPeople = new boolean[peopleNum];

		int peoplePointer = 0;
		boolean firstPeopleRemark = true;
		for (int i = 0; i < remarkNum; i++) {
			String remark = sc.next();
			if (!accordingToRules(remark, remarkedWordList, wordList, firstPeopleRemark)) {
				dropOutPeople[peoplePointer] = true;
				firstPeopleRemark = true;
				peoplePointer = nextPeople(peoplePointer, dropOutPeople, peopleNum);
				continue;
			}
			remarkedWordList.add(remark);
			peoplePointer = nextPeople(peoplePointer, dropOutPeople, peopleNum);
		}
		sc.close();

		System.out.println(booleanArrayToStream(dropOutPeople).filter(d -> !d).count());
		for (int i = 0; i < peopleNum; i++) {
			if (!dropOutPeople[i]) {
				System.out.println(i + 1);
			}
		}

	}

	static boolean accordingToRules(String remark, List<String> remarkedWordList, List<String> wordList,
			boolean firstPeopleRemark) {
		if (!wordList.contains(remark)) {
			return false;
		}

		if (remarkedWordList.contains(remark)) {
			return false;
		}

		if (remark.endsWith("z")) {
			return false;
		}

		if (!firstPeopleRemark && !remarkedWordList.get(remarkedWordList.size() - 1).endsWith(remark.substring(0, 1))) {
			return false;
		}
		return true;
	}

	static int nextPeople(int peoplePointer, boolean[] dropOutPeople, int peopleNum) {
		peoplePointer = nextPoint(peoplePointer, peopleNum);
		while (dropOutPeople[peoplePointer]) {
			peoplePointer = nextPoint(peoplePointer, peopleNum);
		}
		return peoplePointer;

	}

	static int nextPoint(int peoplePointer, int peopleNum) {
		return ++peoplePointer % peopleNum;
	}

	static Stream<Boolean> booleanArrayToStream(boolean[] a) {
		return new AbstractList<Boolean>() {
			@Override
			public Boolean get(int index) {
				return a[index];
			}

			@Override
			public int size() {
				return a.length;
			}
		}.stream();
	}
}
