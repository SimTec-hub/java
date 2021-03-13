package geekbrain;

public class Main {

    public static void main(String[] args) {
	int a = 13;
	int b = 8;
	System.out.println(summ(a, b));
    }
    public static boolean summ (int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20)
            return true;
        else
            return false;
    }
}
