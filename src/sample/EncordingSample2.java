package sample;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncordingSample2 {
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
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}
}
