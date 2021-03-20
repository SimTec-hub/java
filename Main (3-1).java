package geekbrain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

		public static void main (String[]args) throws IOException {
			method();
		}

	private static void repeat() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Повторить игру ещё раз?  1 – да / 0 – нет");
		int choice = Integer.parseInt(reader.readLine());
		if (choice == 1)
		{method();}
		if (choice == 0)
			System.out.println("GAME OVER");
	}

	public static void method()throws IOException {
		System.out.println("Угадайте число от 0 до 9, у вас есть три попытки");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int number;
		int x = (int) (Math.random() * 10 - 1);
		for (int i = 2; i >= 0; i--) {
			number = Integer.parseInt(reader.readLine());
			if (x == number) {
				System.out.println("Вы угадали, загаданное число " + x + "!");
				break;
			} else if (x < number) {
				System.out.println("Загаданное число меньше, количество попыток: " + i);
			} else if (x > number) {
				System.out.println("Загаданное число больше, количество попыток: " + i);
			}
		}
		repeat();
	}
}
