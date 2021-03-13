package geekbrain;

public class Main {

    public static void main(String[] args) {
		int a = 3;
		int b = 7;
		int c = 21;
		int d = 44;
		float result = method(a, b, c, d);
	}
	public static float method(int a, int b, int c, int d) {
	    float f = a * (b + (c / d));
	    return f;
        }
}
