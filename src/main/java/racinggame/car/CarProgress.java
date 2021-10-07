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

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < progress; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
