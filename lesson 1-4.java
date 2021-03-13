package geekbrain;

public class Main {

    public static void main(String[] args) {
	String name = "Анатолий";
    System.out.println(greeting(name));
    }
    public static String greeting(String a) {
        String grt = "Привет, " + a + "!";
        return grt;
    }
}
