package sample;

import java.util.Calendar;
import java.util.Date;

public class DateSample {
	public static void main(String[] args) {
		System.out.println("Dateクラスで日時を表示します。");
		Date dt = new Date();
		System.out.println(dt.toString());
		
		System.out.println();
		System.out.println("Calendarクラスで年月日を取得します。");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE) + "日");
		
		
		int rnd = (int) Math.floor(Math.random() * 4);
		System.out.println(rnd);
	}
}
