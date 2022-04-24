package racingcar.model;

public class GameRule {

    private static final int BASE_VALE_FOR_FORWARD = 4;
    private RandomNumber randomNumber;
    private TryCount tryCount;

    public GameRule(TryCount inputTryCount) {
        randomNumber = new RandomNumber();
        tryCount = inputTryCount;
    }

    public int getTryCount() {
        return this.tryCount.getTryCount();
    }

    public boolean canGoForward() {
        return randomNumber.getRandomNumber() >= BASE_VALE_FOR_FORWARD;
    }


}
