package sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSample {
	public static void main(String[] args) {
		Something target = new Something();

		Class<? extends Something> clazz = target.getClass();
		try {
			Method method = clazz.getDeclaredMethod("hoge", null);
			method.setAccessible(true);
			String result = (String) method.invoke(target, null);
			System.out.println(result);
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
