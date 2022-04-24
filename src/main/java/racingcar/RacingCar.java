package racingcar;

import racingcar.model.CarName;

public class RacingCar {
    private static final int INIT_GAME_POSITION_NUM = 0;
    private final CarName name;
    private int gamePosition;

    public RacingCar(String name) {
        this(name, INIT_GAME_POSITION_NUM);
    }

    public RacingCar(String name, int gamePosition) {
        this.name = new CarName(name);
        this.gamePosition = gamePosition;
    }

    public CarName getName() {
        return name;
    }

    public int getGamePosition() {
        return gamePosition;
    }

    public void move(int randomValue) {
        if (randomValue >= RacingCarConstants.MIN_CAR_MOVE_CONDITION) {
            gamePosition++;
        }
    }

    public boolean isWinner(int winnerPosition) {
        return gamePosition == winnerPosition;
    }
}
