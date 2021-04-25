package geekbrain;

public class Wall implements Hurdle {
    private String title;
    private int heigth;

    public Wall(String title, int heigth) {
        this.title = title;
        this.heigth = heigth;
    }

    @Override
    public void complete (Player player) {
        player.jump(heigth);
    }
    public void jumpedover() {
        System.out.print(" успешно перепрыгнул препятствие ");
    }
    public void lose() {
        System.out.print(" не смог перепрыгнуть препятствие ");
    }
    public int getHeigth() {
        return heigth;
    }



}
