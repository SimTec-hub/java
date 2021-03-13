package geekbrain;

public class Main {

    public static void main(String[] args) {
	int a = -10;
    System.out.println(pmumber(a));
    }
    public static String pmumber(int a) {
        String number;
        if (a >= 0)
            number = a +" - положительное число";
        else
            number = a +" - отрицательное число";
        return number;
    }
}
