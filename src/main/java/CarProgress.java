public class CarProgress {

    private String carProgress;
    private final String STEP = "-";

    public CarProgress() {
        carProgress = "";
    }

    public void moveForward(int num) {
        validInputNumber(num);
        if (num >= 4) {
            carProgress += STEP;
        }
    }

    public int getProgressNumber() {
        return carProgress.length();
    }

    public String toString() {
        return this.carProgress;
    }

    private void validInputNumber(int num) {
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException();
        }
    }

}
