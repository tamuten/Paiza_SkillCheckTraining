package sample;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncordingSample3 {
	public static void main(String[] args) {
		//System.out.println(System.getProperty("file.encoding"));
		
		try {
			String str = "あ";
			
			byte[] byte1 = str.getBytes("UTF-16");
			byte[] byte2 = str.getBytes("UTF-8");
			byte[] byte3 = str.getBytes("SJIS");
			
			System.out.println(Arrays.toString(byte1));
			System.out.println(Arrays.toString(byte2));
			System.out.println(Arrays.toString(byte3));
			
			String newStr1 = new String(byte1, "UTF-16");
			String newStr2 = new String(byte2,"UTF-8");
			String newStr3 = new String(byte3, "SJIS");
			
			System.out.println(newStr1);
			System.out.println(newStr2);
			System.out.println(newStr3);
			
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}
}
