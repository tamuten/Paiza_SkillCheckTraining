package paiza_skillchecktraining.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Janken {
	public static void main(String[] args) {
		new Janken().execute();
	}

	private enum Hand {
		/** グー 0ポイント */
		GOO("G", 0)//
		/** チョキ 2ポイント */
		,CHOKI("C", 2)//
		/** パー 5ポイント */
		,PAR("P", 5);//

		private String hand;

		private Hand(final String hand, final int score) {
			this.hand = hand;
		}

		private static Hand winHand(Hand oppHand) {
			switch (oppHand) {
			case GOO:
				return PAR;
			case CHOKI:
				return GOO;
			case PAR:
				return CHOKI;
			default:
				throw new IllegalArgumentException("不正な引数");
			}
		}

		public String getHand() {
			return this.hand;
		}

		private static Hand getValue(String handStr) {
			return Arrays.stream(Hand.values())
					.filter(data -> data.getHand().equals(handStr))
					.findFirst()
					.orElse(null);
		}
	}

	private int markScore;
	private int jankenNum;
	private List<Hand> oppHands;

	public void execute() {
		// 標準入力をインプット
		input();

		// 目標点数となる手の出し方のパターン作成
		List<Map<Hand, Integer>> handPatterns = makeHandPatterns();

		//パターンごとに勝ち数を計算
		List<Integer> winNums = cntWinNums(handPatterns);

		// 最高勝ち数を出力
		printMaxWinNum(winNums);
	}

	private void input() {
		Scanner sc = new Scanner(System.in);
		jankenNum = sc.nextInt();
		markScore = sc.nextInt();
		String[] oppHandsInput = sc.next().split("");
		oppHands = Arrays.stream(oppHandsInput)
				.map(s -> Hand.getValue(s))
				.collect(Collectors.toList());
		sc.close();
	}

	private int fiveMax() {

		switch (markScore % 10) {
		case 1:
		case 3:
		case 6:
		case 8:
			return (markScore - 5) / 5;
		case 2:
		case 4:
		case 5:
		case 0:
		case 7:
		case 9:
			return markScore / 5;
		default:
			throw new RuntimeException();
		}
	}

	/**
	 *	手の出し方のパターンごとに勝ち数をカウント
	 *
	 * @param pattern 手の出し方のパターン
	 * @return 勝ち数
	 */
	private Integer cntWinNum(Map<Hand, Integer> pattern) {
		Integer goo = pattern.get(Hand.GOO);
		Integer choki = pattern.get(Hand.CHOKI);
		Integer par = pattern.get(Hand.PAR);

		/** 勝ち数 */
		Integer winNum = 0;
		for (Hand oppHand : oppHands) {
			switch (Hand.winHand(oppHand)) {
			case GOO:
				if (goo > 0) {
					goo--;
					winNum++;
				}
				break;
			case CHOKI:
				if (choki > 0) {
					choki--;
					winNum++;
				}
				break;
			case PAR:
				if (par > 0) {
					par--;
					winNum++;
				}
				break;
			}
		}
		return winNum;
	}

	private List<Map<Hand, Integer>> makeHandPatterns() {
		List<Map<Hand, Integer>> handPatterns = new ArrayList<>();
		int fiveNum = fiveMax();

		while (fiveNum >= 0) {
			Map<Hand, Integer> pattern = makePattern(fiveNum);
			if (pattern == null) {
				// パターン作成終了
				break;
			}
			handPatterns.add(pattern);
			fiveNum -= 2;
		}
		return handPatterns;
	}

	private Map<Hand, Integer> makePattern(int fiveNum) {
		Map<Hand, Integer> hands = new HashMap<>();
		Integer goo = 0;
		Integer choki = 0;
		Integer par = 0;

		for (int i = 0; i < fiveNum; i++) {
			par++;
		}
		int twoNum = (markScore - (5 * fiveNum)) / 2;
		for (int i = 0; i < twoNum; i++) {
			choki++;
		}
		int zeroNum = jankenNum - (fiveNum + twoNum);
		// 5と2でじゃんけんの回数を超えた場合はパターン作成を終了する
		if (zeroNum < 0) {
			return null;
		}
		for (int i = 0; i < zeroNum; i++) {
			goo++;
		}
		hands.put(Hand.GOO, goo);
		hands.put(Hand.CHOKI, choki);
		hands.put(Hand.PAR, par);

		return hands;
	}

	private List<Integer> cntWinNums(List<Map<Hand, Integer>> handPatterns) {
		List<Integer> winNums = new ArrayList<>();
		for (Map<Hand, Integer> pattern : handPatterns) {
			Integer winNum = cntWinNum(pattern);
			winNums.add(winNum);
		}
		return winNums;
	}

	private void printMaxWinNum(List<Integer> winNums) {
		System.out.println(winNums.stream().mapToInt(Integer::intValue).max().getAsInt());
	}
}
