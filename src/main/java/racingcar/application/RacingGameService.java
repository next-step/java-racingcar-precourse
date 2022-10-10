package racingcar.application;

import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.GameRoundResults;

import java.util.Arrays;

import static racingcar.application.ValidService.validCarsNameAnswer;
import static racingcar.presentation.CarViewConstants.CAR_NAME_SPLITTER;

public class RacingGameService {

    public GameResult startGame(Cars cars, String roundNumberAnswer) {
        GameRoundResults gameRoundResults = this.playGameRounds(cars, Integer.parseInt(roundNumberAnswer));

        return GameResult.createGameResult(gameRoundResults, cars.getWinnerCarNames());
    }

    public Cars createCars(String carsNameAnswer) {
        validCarsNameAnswer(carsNameAnswer);

        String[] carNamesSplit = carsNameAnswer.split(CAR_NAME_SPLITTER);
        CarNames carNames = CarNames.createCarNamesWithStringCarName(Arrays.asList(carNamesSplit));

        return Cars.createCarsWithNames(carNames);
    }

    private GameRoundResults playGameRounds(Cars cars, int roundCount) {
        GameRoundResults gameRoundResults = GameRoundResults.createEmptyGameRoundResults();
        for (int i = 0; i < roundCount; i++) {
            gameRoundResults.addGameRoundResult(cars.carsPlayRound());
        }

        return gameRoundResults;
    }
}
