package racingcar;

public class ConsoleInput {

    private String CarNames;
    private String TryingNumber;

    public String getCarNames() {
        return CarNames;
    }

    public void setCarNames(String carNames) {
        CarNames = carNames;
    }

    public String getTryingNumber() {
        return TryingNumber;
    }

    public void setTryingNumber(String tryingNumber) {
        TryingNumber = tryingNumber;
    }

    public int getTryingNumberToInt() {
        return Integer.parseInt(this.getTryingNumber());
    }
}
