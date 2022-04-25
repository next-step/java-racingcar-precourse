package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.CarName;
import racingcar.domain.Round;
import racingcar.exception.InvalidParameterError;
import racingcar.view.Input;
import racingcar.view.Print;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private CarGroup carGroup;
    private Round round;

    public void run() {
        initializeCarGroup();
        initializeRound();
        startGame();
    }

    private void startGame() {
        List<List<Car>> resultByRound = carGroup.playGame(round.getRound());
        System.out.println();
        Print.printResultByRound(resultByRound);
        Print.printWinner();
    }

    public void initializeCarGroup() {
        while (this.carGroup == null) {
            inputValidCarGroup();
        }
    }

    public void inputValidCarGroup() {
        try {
            String inputCarNames = Input.inputCarNames();
            List<Car> carNames = setCarNames(inputCarNames);
            this.carGroup = new CarGroup(carNames);
        } catch (InvalidParameterError e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Car> setCarNames(String inputCarNames) {
        List<Car> carNames = new ArrayList<>();
        for (String carName : inputCarNames.trim().split(",")) {
            carNames.add(new Car(new CarName(carName.trim())));
        }
        return carNames;
    }

    public void initializeRound() {
        while (this.round == null) {
            inputValidRound();
        }
    }

    public void inputValidRound() {
        try {
            String inputRound = Input.inputRound();
            this.round = new Round(inputRound);
        } catch (InvalidParameterError e) {
            System.out.println(e.getMessage());
        }
    }
}
