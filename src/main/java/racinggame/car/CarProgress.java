package racinggame.car;

public class CarProgress {
    int progress;

    public CarProgress(){
        progress = 0;
    }

    public void set(int progress) {
        this.progress = progress;
    }

    public int get() {
        return progress;
    }

    public int plus() {
        return progress++;
    }
}
