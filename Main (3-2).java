package geekbrain;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean z = false;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String[] simbol = new String[15];
        Arrays.fill(simbol, "#");
        String riddle = words[(int)(Math.random() * (words.length - 1))];
        System.out.println("Угадайте загаданное слово!");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < riddle.length(); i++) {
            String answ = scanner.nextLine();
            if (riddle.equals(answ)) {
                System.out.println("Всё верно, загаданное слово: " + riddle);
                z = true;
                break;
            }
            else if (answ != riddle && i == riddle.length() - 1) {
                System.out.println("Неверно");
            }
            else {
                System.out.println("Неверно, подсказка:");
                simbol[i] = String.valueOf(riddle.charAt(i));
                for (int y = 0; y < simbol.length; y++) {
                    System.out.print(simbol[y]);
                }
                System.out.println();
            }
        }
        if (z == false)
            System.out.println("Вы не угадали слово!!! Верный вариант: " + riddle);

    }
}
