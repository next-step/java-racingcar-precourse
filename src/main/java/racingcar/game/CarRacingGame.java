package racingcar.game;

import racingcar.domain.Cars;
import racingcar.domain.CarsCreator;
import racingcar.domain.RaceResult;
import racingcar.domain.RaceRound;
import racingcar.io.GameConsole;
import racingcar.util.RandomUtil;

public class CarRacingGame {

    private final GameConsole console = GameConsole.create();
    private final CarsCreator carsCreator = CarsCreator.create();
    private final GameResultHandler resultHandler = GameResultHandler.create();
    private final RandomUtil randomUtil = RandomUtil.create();

    public void run() {
        String carNames = console.queryCarNames();

        Cars cars = carsCreator.createCarsBy(carNames);
        int round = console.queryRound();
        RaceResult latestRaceResult = raceWithTimes(round, cars);

        String resultMessage = resultHandler.pickWinner(latestRaceResult);
        console.printResultMessage(resultMessage);
    }


    private RaceResult raceWithTimes(int times, Cars cars) {
        RaceResult lastRaceResult = null;

        for (int i = 0; i < times; i++) {
            RaceRound raceRound = RaceRound.of(cars, randomUtil);
            lastRaceResult = raceRound.race();
            console.printMessage(lastRaceResult.toString());
        }
        return lastRaceResult;
    }
}
