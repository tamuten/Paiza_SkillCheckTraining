package sample;

public class AddSample {
	public static void main(String[] args) {
		// x + y の結果を返す
		System.out.println(add(5, 3));
	}

	static int add(int a, int b) {
		if (b < 1) {
			return a;
		}
		return add(a + 1, b - 1);
	}
}
