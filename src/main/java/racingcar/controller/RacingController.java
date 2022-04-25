package racingcar.controller;

import racingcar.constant.StringConst;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.utils.ConvertUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public static void start(){
        RacingCars cars = createRacingCars();
        RacingGame game = createRacingGame(cars);
        playRacingGame(game);
    }

    private static RacingCars createRacingCars() {
        try {
            return new RacingCars(readCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return createRacingCars();
        }
    }

    private static RacingGame createRacingGame(RacingCars cars) {
        try {
            return new RacingGame(cars, readRepeatCount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return createRacingGame(cars);
        }
    }

    private static String[] readCarNames(){
        return InputView.readCarNames().split(StringConst.CHAR_COMMA);
    }

    private static int readRepeatCount(){
        try {
            String repeatCount = InputView.readRepeatCount();
            return ConvertUtils.convertRepeatCountToInteger(repeatCount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readRepeatCount();
        }
    }

    private static void playRacingGame(RacingGame game) {
        while(!game.isGameEnd()){
            game.playSingleRound();
            OutputView.printRacingGameSingleRoundResult(game);
        }
        OutputView.printRacingGameFinalResult(game);
    }
}
