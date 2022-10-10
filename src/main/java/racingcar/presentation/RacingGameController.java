package racingcar.presentation;

import racingcar.application.RacingGameService;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResult;
import racingcar.domain.game.GameRoundResult;
import racingcar.domain.game.GameRoundResults;

import java.util.Map;

import static racingcar.application.ValidService.validRoundNumberAnswer;
import static racingcar.presentation.View.*;

public class RacingGameController {

    private RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void startGame() {
        //사용자 입력
        Cars carsNameAnswer = this.getCarsName();
        String roundNumberAnswer = this.getRoundNumber();

        //게임 진행
        GameResult gameResult = racingGameService.startGame(carsNameAnswer, roundNumberAnswer);

        //게임 결과 출력
        printGameResult(gameResult);
    }

    private Cars getCarsName() {
        try {
            return racingGameService.createCars(getCarsNameAnswer());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getCarsName();
        }
    }

    private String getRoundNumber() {
        String roundNumberAnswer = "";
        try {
            roundNumberAnswer = getRoundNumberAnswer();
            validRoundNumberAnswer(roundNumberAnswer);
            return roundNumberAnswer;
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getRoundNumberAnswer();
        }
    }

    private void printGameResult(GameResult gameResult) {
        printResultInformation();
        printGameRoundResults(gameResult.getGameRoundResults());
        printWinner(gameResult.getWinnerCars());
    }

    private void printGameRoundResults(GameRoundResults gameRoundResults) {
        for (GameRoundResult gameRoundResult : gameRoundResults.getGameRoundResults()) {
            printGameRoundResult(gameRoundResult.getGameRoundResultMap());
            printNewLine();
        }
    }

    private void printGameRoundResult(Map<CarName, CarPosition> gameRoundResultMap) {
        for (CarName carName : gameRoundResultMap.keySet()) {
            printCarNameWithPosition(carName, gameRoundResultMap.get(carName));
        }
    }
}
