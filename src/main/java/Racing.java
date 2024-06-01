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

    public String[] judgeWinners() {
        int maxProgress = computeMaxProgress();

        int cntOfWinners = cntCarsOn(maxProgress);
        String[] winners = new String[cntOfWinners];

        int i = 0;
        for (CarProgress car : carProgresses) {
            if (car.getProgress() == maxProgress) {
                winners[i++] = car.getCarName();
            }
        }

        return winners;
    }

    private int computeMaxProgress() {
        int maxProgress = 0;

        for (CarProgress car : carProgresses) {
            if (car.getProgress() > maxProgress) {
                maxProgress = car.getProgress();
            }
        }

        return maxProgress;
    }

    private int cntCarsOn(int progress) {
        int cnt = 0;

        for (CarProgress car : carProgresses) {
            if (car.getProgress() == progress) {
                cnt++;
            }
        }

        return cnt;
    }
}
