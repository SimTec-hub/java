package geekbrain;

public class Treadmill implements Hurdle{
    private String title;
    private int dist;

    public Treadmill(String title, int dist) {
        this.title = title;
        this.dist = dist;
    }

    @Override
    public void complete (Player player) {
        player.run(dist);

    }
    public void victory() {
        System.out.print(" успешно преодолел ");
    }
    public void lose() {
        System.out.print(" не смог преодолеть ");
    }
    public int getDist() {
        return dist;
    }
    public String getTitle() {
        return title;
    }
}

