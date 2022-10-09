package racingcar.game.dto;

public class RacingResult {

    private final String carName;
    private final int carPosition;

    public RacingResult(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getName() {
        return this.carName;
    }

    public int getPosition() {
        return this.carPosition;
    }

}
