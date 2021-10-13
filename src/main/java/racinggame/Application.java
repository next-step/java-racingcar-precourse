package racinggame;

import racinggame.domain.CarNames;
import racinggame.domain.RaceNum;
import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        startGame();
    }

    private static void startGame() {
        CarNames carNames = setCarNames();
        RaceNum raceNum = setRaceNum();
        RacingGame racingGame = new RacingGame(carNames, raceNum);
        OutputView.printResult(racingGame.getAllRaceStates(), racingGame.getWinners());
    }

    private static RaceNum setRaceNum() {
        String raceNumInput = InputView.getRaceNumberInput();
        while (true) {
            try {
                RaceNum raceNum = new RaceNum(raceNumInput);
                return raceNum;
            } catch (Exception e) {
                InputView.printInputErrorMsg(e.getMessage());
                raceNumInput = InputView.getRaceNumberInput();
            }
        }
    }

    private static CarNames setCarNames() {
        String carNamesInput = InputView.getCarNamesInput();
        while (true) {
            try {
                CarNames carNames = new CarNames(carNamesInput);
                return carNames;
            } catch (Exception e) {
                InputView.printInputErrorMsg(e.getMessage());
                carNamesInput = InputView.getCarNamesInput();
            }
        }
    }
}
