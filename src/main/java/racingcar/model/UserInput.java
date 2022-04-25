package racingcar.model;

public class UserInput {
    private String[] carNames;
    private int tryCount;

    public UserInput(String[] carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
}
