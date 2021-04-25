package geekbrain;



public class Main {

    public static void main(String[] args) {
        Player[] playarray = {
                new Human("Иванов", 30, 2000),
                new Human("Петров", 40, 1600),
                new Human("Смирнов", 35, 2000),
                new Human("Абрамов", 10, 7000),
                new Human("Демидов", 70, 5000),
                new Cat("Босс", 50, 400),
                new Cat("Барсик", 70, 600),
                new Cat("Пуш", 30, 300),
                new Cat("Рыжик", 90, 5000),
                new Cat("Маркиз", 40, 100),
                new Robot("T100", 100, 10000),
                new Robot("T1000", 70, 20000),
                new Robot("Федор", 5, 80),
                new Robot("Boston Dynamics", 80, 500),
                new Robot("Пылесос", 0, 10)};


        Hurdle[] hardarray = {
                new Treadmill("500 метров", 500),
                new Treadmill("1500 метров", 1500),
                new Treadmill("5000 метров", 5000),
                new Wall("стена 10 см", 10),
                new Wall("стена 50 см", 50),
                new Wall("стена 70 см", 70)};

        for (Player player : playarray) {
            for (Hurdle hurdle : hardarray) {
                hurdle.complete(player);
                if (!player.isChamp()) {
                    break;
                }

            }

        }


    }
}



