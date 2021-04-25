package geekbrain;

public class Cat implements Player{
    private String name;
    private int jump;
    private int run;
    private boolean champ;

    public Cat(String name, int jump, int run) {
        this.name = name;
        this.jump = jump;
        this.run = run;
        this.champ = true;
    }


    @Override
    public void run(int dist) {
        if (dist <= run) {
            System.out.println(name + " успешно преодолел " + dist + " метров.");
        } else {
            System.out.println(name + " не смог преодолеть " + dist + " метров и выбывает из соревнований.");
            champ = false;
        }
    }
    @Override
    public void jump(int heigth){
        if (heigth <= jump) {
            System.out.println(name + " успешно перепрыгнул " + heigth + " см.");
        } else {
            System.out.println(name + " не смог перепрыгнуть " + heigth + " см и выбывает из соревнований.");
            champ = false;
        }
    }
    @Override
    public boolean isChamp() {
        return champ;
    }
}
