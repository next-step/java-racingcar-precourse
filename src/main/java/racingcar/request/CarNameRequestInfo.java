package racingcar.request;

public class CarNameRequestInfo {

    private final String[] carNames;

    public CarNameRequestInfo(String[] carNames) {
        this.carNames = carNames;
    }

    public String[] getCarNames() {
        return carNames;
    }
}
