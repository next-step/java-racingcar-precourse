package racingcar.car.service;

import java.util.List;
import racingcar.car.domain.external.CarMovePolicyStrategy;
import racingcar.car.domain.models.Cars;
import racingcar.car.domain.models.Winners;
import racingcar.car.service.dto.RacingCarPlayerCommand;
import racingcar.io.GamePlayReader;
import racingcar.io.GamePlayWriter;

public class RacingCarGameService {

    private static final int INITIAL_PLAY_TIME = 1;

    private final CarMovePolicyStrategy strategy;

    public RacingCarGameService(CarMovePolicyStrategy strategy) {
        this.strategy = strategy;
    }

    public void play() {
        RacingCarPlayerCommand command = getPlayerCommand();

        Cars initialCars = Cars.initCarsByName(command.getNames());

        GamePlayWriter.printPlayResult();
        Winners winners = playAsManyTimesAsTryCount(command, initialCars).getWinners();

        GamePlayWriter.printWinners(winners);
    }

    private RacingCarPlayerCommand getPlayerCommand() {
        GamePlayWriter.printRequirePlayerName();
        List<String> names = GamePlayReader.readPlayerNameInput();

        GamePlayWriter.printRequirePlayerTryCount();
        int tryCount = GamePlayReader.readPlayerTryCount();

        return new RacingCarPlayerCommand(names, tryCount);
    }

    private Cars playAsManyTimesAsTryCount(RacingCarPlayerCommand command, Cars cars) {
        int time = INITIAL_PLAY_TIME;

        while (time++ <= command.getTryCount()) {
            cars = cars.moveForward(strategy);
            GamePlayWriter.printEachGameResult(cars);
        }

        return cars;
    }

}
