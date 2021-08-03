package paiza_skillchecktraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shiritori {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int peapleNum = sc.nextInt();
		int wordsNum = sc.nextInt();
		int sayTimes = sc.nextInt();

		//単語リストを作成
		List<String> wordList = new ArrayList<String>();
		for (int i = 0; i < wordsNum; i++) {
			wordList.add(sc.next());
		}

		//参加者リストの作成
		boolean[] dropoutPeople = new boolean[peapleNum];

		//		boolean[] sample = new boolean[2];
		//		System.out.println(sample[0]);
		//		System.out.println(sample[1]);

		//ここから発言
		int nowTime = 1;
		int nowPeaple = 0;
		int successCount = 0;

		//発言された単語リスト
		List<String> remarkedWordList = new ArrayList<String>();

		while (nowTime <= sayTimes) {

			if (!dropoutPeople[nowPeaple]) {

				//発言を取得
				String remark = sc.next();

				//単語リストに載っていない単語だった場合、falseにする
				if (!wordList.contains(remark)) {
					dropoutPeople[nowPeaple] = true;
					// 次の人間へ
					nowPeaple++;
					if (nowPeaple == peapleNum) {
						nowPeaple = 0;
					}
					successCount = 0;
					nowTime++;
					continue;
				}

				//最初の人以外の発言の頭文字が、
				//直前の人の発言の最後の文字と一緒でない場合、falseにする。
				if (successCount != 0 && remarkedWordList.size() > 0) {
					//remark.charAt(0)
					String lastRemark = remarkedWordList.get(remarkedWordList.size() - 1);

					if (remark.charAt(0) != lastRemark.charAt(lastRemark.length() - 1)) {
						dropoutPeople[nowPeaple] = false;
						nowPeaple++;
						if (nowPeaple == peapleNum + 1) {
							nowPeaple = 1;
						}
						successCount = 0;
						nowTime++;
						continue;
					}
				}

				//今までに発言された単語を発言した場合、falseにする
				if (remarkedWordList.contains(remark)) {
					dropoutPeople[nowPeaple] = false;
					nowPeaple++;
					if (nowPeaple == peapleNum + 1) {
						nowPeaple = 1;
					}
					successCount = 0;
					nowTime++;
					continue;
				}

				//zで終わる単語を発言した場合、falseにする
				if (remark.charAt(remark.length() - 1) == 'z') {
					dropoutPeople[nowPeaple] = false;
					nowPeaple++;
					if (nowPeaple == peapleNum + 1) {
						nowPeaple = 1;
					}
					successCount = 0;
					nowTime++;
					continue;
				}

				//発言されたらプラスする
				nowTime++;

				//条件を満たした場合、発言された単語リストに追加する
				remarkedWordList.add(remark);

			}

			nowPeaple++;

			if (nowPeaple == peapleNum + 1) {
				nowPeaple = 1;
			}
			successCount++;
		}

		List<Integer> indexList = new ArrayList<Integer>();
		for (int i = 1; i < dropoutPeople.length; i++) {
			if (dropoutPeople[i] == true) {
				indexList.add(i);
			}
		}

		System.out.println(indexList.size());
		for (int i : indexList) {
			System.out.println(i);
		}

		sc.close();
	}
}
