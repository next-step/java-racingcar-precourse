package racingcar.model.cars.factory;

public class MoveEventAnalyzer {
    private final int minNumber;
    private final int maxNumber;

    private MoveEventAnalyzer(int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public static MoveEventAnalyzer getInstance() {
        return new MoveEventAnalyzer(0, 9);
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
