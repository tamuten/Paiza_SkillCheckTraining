package sample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest1 {
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface TestA1{
		int version() default 1;
		//String author();
	}

	@TestA1(version = 3)
	public static void print1() {
		System.out.println("test1");
	}

	@TestA1(version = 1)
	public static void print2() {
		System.out.println("test2");
	}

	@TestA1(version = 4)
	public static void print3() {
		System.out.println("test3");
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Class<AnnotationTest1> a1 = AnnotationTest1.class;
		Object o = null;
		try {
			o = a1.newInstance();
		} catch (InstantiationException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		try {
			Method m1 = a1.getMethod("print1");
			TestA1 b1 = m1.getAnnotation(TestA1.class);
			Method m2 = a1.getMethod("print2");
			TestA1 b2 = m2.getAnnotation(TestA1.class);
			Method m3 = a1.getMethod("print3");
			TestA1 b3 = m3.getAnnotation(TestA1.class);
			if(b1.version() > 1) {
				m1.invoke(o);
				//System.out.println(o);
				//m3.invoke(o);
			}
			if(b2.version() > 1) {
				m2.invoke(o);
			}
			if(b3.version() > 1) {
				m3.invoke(o);
			}
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
