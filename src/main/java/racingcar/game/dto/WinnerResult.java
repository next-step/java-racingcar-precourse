package racingcar.game.dto;

public class WinnerResult {

    private final String carName;

    public WinnerResult(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
