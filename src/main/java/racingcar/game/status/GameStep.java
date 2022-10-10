package racingcar.game.status;

import racingcar.domain.Car;
import racingcar.game.GameContext;
import racingcar.view.port.outbound.StandardOutput;

public class GameStep implements Status {

    public static final String DELIMITER = " : ";

    @Override
    public Status next(GameContext gameContext) {
        for (Car car : gameContext.getCarList().getCarList()) {
            car.play();
            StandardOutput.println(getCarNameAndLocation(car));
        }
        StandardOutput.println();
        if (isRetryStepEnd(gameContext)) {
            return new GameResult();
        }
        gameContext.increaseStep();
        return new GameStep();
    }

    private String getCarNameAndLocation(Car car) {
        return car.getCarName().getName() + DELIMITER + car.getLocation().print();
    }

    private boolean isRetryStepEnd(GameContext gameContext) {
        return gameContext.getRetryCount() == gameContext.getStepCount();
    }
}
