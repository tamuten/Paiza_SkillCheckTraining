package paiza_skillchecktraining;

import java.util.Scanner;

public class EelShop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int seat = sc.nextInt();

		//座席の配列を宣言
		int array[] = new int[seat];
		//座れる→0、座れない→1、とする。


		//System.out.println(array[0]);
		int group = sc.nextInt();

		//グループごとに処理
		label1: for(int i = 0;i < group;i++) {
			int customer = sc.nextInt();
			int wantSit = sc.nextInt() - 1;
			
			//座りたい座席がすべて座れるか調べる
			int ws = wantSit;
			for(int j = 0;j < customer;j++) {
				if(ws == seat) {
					ws = 0;
				}
				
				//座れない場合はループを抜け、次のグループの処理に移る
				if(array[ws] != 0) {
					continue label1;
				}
				ws++;
			}

			//グループメンバーが座る席に「1」を代入していく
			ws = wantSit;
			for(int j = 0;j < customer;j++) {
				if(ws == seat) {
					ws = 0;
				}
				
				array[ws] = 1;
				ws++;
			}
		}
		
		//「1」の座席数をカウントする
		int cnt = 0;
		for(int i : array) {
			if(i == 1) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
