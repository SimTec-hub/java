package geekbrain;

import java.util.Random;
import java.util.Scanner;

public class Main {

	private static final Random RANDOM = new Random();
	private static final Scanner SCANNER = new Scanner(System.in);
	private static char[][]field;
	private static char DOT_PLAYER;
	private static char DOT_COMP;
	private static final char EMPTY = '.';
	private static String choice;
	private static int sizeX;
	private static int sizeY;
	private static String name;
	private static String yes;
	private static int scorePlayer = 0;
	private static int scoreComp = 0;


    public static void main(String[] args) {
			System.out.print("Представьтесь пожалуйста >>> ");
			name = SCANNER.nextLine();
			System.out.println(name + ", сыграем в крестики-нолики? (нажмите \"Y\" - да или любую другую, если нет)");
			yes = SCANNER.nextLine();
			if (!yes.equals("y")) {
				System.out.println("Как жаль!");
				System.out.println("GAME OVER");
				System.exit(0);
			}
			else choice();
			choice2();
			game();

		//}

    }

	private static void game() {
		initField();
		printField();
    	while (true) {
			if (DOT_PLAYER == 'x') {playerTurn(); printField();}
			if (gameCheck(DOT_PLAYER, String.format("%s, вы великолепны! Победа!", name))) break;
			CompTurn();
			printField();
			if (gameCheck(DOT_COMP, "Компьютер победил!")) break;
			if (DOT_PLAYER == '0') {playerTurn(); printField();}
		}
		System.out.printf("SCORE IS:\n%s: %d || Computer: %d\n", name, scorePlayer, scoreComp);
		System.out.println("Ещё раз? >>> Y or N >>");
		if (!SCANNER.next().toLowerCase().equals("y")) System.out.println("GAME OVER");
		else game();
	}
	private static boolean isCellEmpty(int x, int y) {
		return field[y][x] == EMPTY;
	}
	private static void easyCompTurn() {
		int x, y;
		do {
			x = RANDOM.nextInt(sizeX);
			y = RANDOM.nextInt(sizeY);
		} while (!isCellEmpty(x, y));

		field[y][x] = DOT_COMP;
	}

	private static int CompTurn() {
		int x = 0;
		int y = 0;
		for (int i = 1; i <= field.length && i < 5; i++) {
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			for (int j = 1; j < field.length && j < 5; j++) {
				if (field[field.length - (i - 1) - 1][j-1] == field[field.length - (i - 1) - 1][j] && field[field.length - (i - 1) - 1][j-1] != '.') a++;
				if (field[j-1][j-1] == field[j][j] && field[j-1][j-1] != '.') b++;
				if (field[j-1][field.length-j] == field[j][field.length-j-1] && field[j-1][field.length-j] != '.') c++;
				if (field[j-1][field.length - (i - 1) - 1] == field[j][field.length - (i - 1) - 1] && field[j-1][field.length - (i - 1) - 1] != '.') d++;
				if (a == field.length - 2) {y = field.length - (i - 1) - 1; x = RANDOM.nextInt(sizeX); break;}
				if (b == field.length - 2) {y = RANDOM.nextInt(sizeY); x = y; break;}
				if (c == field.length - 2) {y = RANDOM.nextInt(sizeY); x = RANDOM.nextInt(sizeX); break;}
				if (d == field.length - 2) {x = field.length - (i - 1) - 1; y = RANDOM.nextInt(sizeY); break;}
			}
		}
		if (field[y][x] == '.')
			field[y][x] = DOT_COMP;

		else easyCompTurn();
		return DOT_COMP;
	}
	private static boolean checkDraw() {
		for (int y = 0; y < sizeY; y++) {
			for (int x = 0; x < sizeX; x++) {
				if (isCellEmpty(x, y)) return false;
			}
		}
		return true;
	}
	private static boolean checkWin(char z) {

    	for (int i = 1; i <= field.length && i < 5; i++) {
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			for (int j = 1; j < field.length && j < 5; j++) {
				if (field[field.length - (i - 1) - 1][j-1] == field[field.length - (i - 1) - 1][j] && field[field.length - (i - 1) - 1][j-1] != '.') a++;
				if (field[j-1][j-1] == field[j][j] && field[j-1][j-1] != '.') b++;
				if (field[j-1][field.length-j] == field[j][field.length-j-1] && field[j-1][field.length-j] != '.') c++;
				if (field[j-1][field.length - (i - 1) - 1] == field[j][field.length - (i - 1) - 1] && field[j-1][field.length - (i - 1) - 1] != '.') d++;
				if (a == field.length - 1 || a == 3) return true;
				if (b == field.length - 1 || b == 3) return true;
				if (c == field.length - 1 || c == 3) return true;
				if (d == field.length - 1 || d == 3) return true;
			}
		}
		return false;
	}

	private static boolean gameCheck(char dot, String s) {
		if (checkWin(dot)) {
			if (dot == DOT_PLAYER) {
				scorePlayer++;
			} else {
				scoreComp++;
			}
			System.out.println(s);
			return true;
		}
		if (checkDraw()) {
			System.out.println("Ничья!!!");
			return true;
		}
		return false;
	}

	private static void choice2() {
		System.out.println(name + ", вы за крестики (х) или за нолики (0)?");
		choice = SCANNER.nextLine();
		if (choice.equals("x")) {
			DOT_PLAYER = 'x';
			DOT_COMP = '0';
		}
		else if (choice.equals("0")) {
			DOT_PLAYER = '0';
			DOT_COMP = 'x';
		}
		else {
			System.out.println("Выбор не ясен.");
			choice2();
		}
	}

	private static void playerTurn() {
		int x, y;
		do {
			System.out.printf("%s введите координаты х и у через пробел >>>>>", name);
			x = SCANNER.nextInt() - 1;
			y = SCANNER.nextInt() - 1;
		} while (!isCellValid(x, y) || !isCellEmpty(x, y));

		field[y][x] = DOT_PLAYER;
	}
	private static boolean isCellValid(int x, int y) {
		return x >= 0 && y >= 0 && x < sizeX && y < sizeY;
	}

	private static void printField() {
		System.out.print("+");
		for (int i = 0; i < sizeX * 2 + 1; i++)
			System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
		System.out.println();

		for (int i = 0; i < sizeY; i++) {
			System.out.print(i + 1 + "|");
			for (int j = 0; j < sizeX; j++)
				System.out.print(field[i][j] + "|");
			System.out.println();
		}

		for (int i = 0; i <= sizeX * 2 + 1; i++)
			System.out.print("-");
		System.out.println();
	}

	private static void initField() {
		field = new char[sizeY][sizeX];
		for (int y = 0; y < sizeY; y++) {
			for (int x = 0; x < sizeX; x++) {
				field[y][x] = EMPTY;
			}
		}
	}

	private static void choice() {
		System.out.println(name + ", выберите размер игрового поля, введите 1 или 2:");
		System.out.println("1. 3х3 - классические крестики-нолики.");
		System.out.println("2. 5х5 - версия крестиков-ноликов на 25 клеток, выигрывает тот, кто первым заполнил подряд 4 клетки.");
		choice = SCANNER.nextLine();
		if (choice.equals("1")) {
			sizeX = 3;
			sizeY = 3;
		}
		else if (choice.equals("2")) {
			sizeX = 5;
			sizeY = 5;
		}
		else {
			System.out.println("Размер поля не выбран.");
			choice();
		}
	}

}
