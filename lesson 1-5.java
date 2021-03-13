package geekbrain;

public class Main {

    public static void main(String[] args) {
	int year = 200;
	String result = leapyear(year);
    System.out.println(result);
    }
    public static String leapyear(int a) {
        String lpy;
        if (a%4 == 0 && a%100 != 0)
            lpy = a + " является високосным годом";
        else if (a%400 == 0)
            lpy = a + " является високосным годом";
        else
            lpy = a + " не является високосным годом";
        return lpy;
    }
}
