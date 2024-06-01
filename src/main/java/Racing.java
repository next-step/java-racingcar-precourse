import java.util.Random;

public class Racing {
    private CarProgress[] carProgresses;
    private int leftTries;

    private Random random = new Random();

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

    public boolean nextMove() {
        if (leftTries <= 0) {
            return false;
        }

        leftTries--;

        for (CarProgress car : carProgresses) {
            if (random.nextInt(10) >= 4) {
                car.move();
            }
        }

        return true;
    }
}
