package racingcar;

import racingcar.model.CarMoveRule;
import racingcar.model.CarName;
import racingcar.model.Position;

public class RacingCar {
    private static final int INIT_GAME_POSITION_NUM = 0;
    private final CarName name;
    private final Position gamePosition;
    private final CarMoveRule carMoveRule;

    public RacingCar(String name, CarMoveRule carMoveRule) {
        this(name, INIT_GAME_POSITION_NUM, carMoveRule);
    }

    public RacingCar(String name, int gamePosition, CarMoveRule carMoveRule) {
        this.name = new CarName(name);
        this.gamePosition = new Position(gamePosition);
        this.carMoveRule = carMoveRule;
    }

    public CarName getName() {
        return name;
    }

    public Position getGamePosition() {
        return gamePosition;
    }

    public void move(int randomValue) {
        if (randomValue >= carMoveRule.getMoveMinCondition()) {
            gamePosition.setPosition(carMoveRule.getMoveNum());
        }
    }

    public CarMoveRule getCarMoveRule() {
        return carMoveRule;
    }

    public boolean isWinner(Position winnerPosition) {
        return gamePosition.getPosition() == winnerPosition.getPosition();
    }

    public String getPrintCurrentResult() {
        StringBuilder builder = new StringBuilder();
        builder.append(name.getName());
        builder.append(" : ");
        for (int i = 0; i < gamePosition.getPosition(); i++) {
            builder.append(carMoveRule.getPrintMoveWord());
        }
        return builder.toString();
    }
}
