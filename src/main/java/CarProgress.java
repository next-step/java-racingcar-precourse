public class CarProgress {
    private String carName;
    private int progress;

    public CarProgress(String carName) {
        this.carName = carName;
        this.progress = 0;
    }

    @Override
    public String toString() {
        return carName + " : "
                + "-".repeat(progress);
    }

    public void move() {
        progress++;
    }

    public int getProgress() {
        return progress;
    }

    public String getCarName() {
        return carName;
    }
}
