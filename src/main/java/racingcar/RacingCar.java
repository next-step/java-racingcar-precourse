package racingcar;

import racingcar.model.CarName;
import racingcar.model.Position;

public class RacingCar {
    private static final int INIT_GAME_POSITION_NUM = 0;
    private final CarName name;
    private final Position gamePosition;

    public RacingCar(String name) {
        this(name, INIT_GAME_POSITION_NUM);
    }

    public RacingCar(String name, int gamePosition) {
        this.name = new CarName(name);
        this.gamePosition = new Position(gamePosition);
    }

    public CarName getName() {
        return name;
    }

    public Position getGamePosition() {
        return gamePosition;
    }

    public void move(int randomValue) {
        if (randomValue >= RacingCarConstants.MIN_CAR_MOVE_CONDITION) {
            gamePosition.setPosition(1);
        }
    }

    public boolean isWinner(Position winnerPosition) {
        return gamePosition.getPosition() == winnerPosition.getPosition();
    }
}
