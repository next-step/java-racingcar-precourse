public class Racing {
    private CarProgress[] carProgresses;
    private int leftTries;

    public Racing(String[] carNames, int tryCount) {
        this.carProgresses = new CarProgress[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            carProgresses[i] = new CarProgress(carNames[i]);
        }

        this.leftTries = tryCount;
    }

    public CarProgress[] getCarProgresses() {
        return carProgresses;
    }
}
