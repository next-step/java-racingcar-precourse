package racingcar.controller;

import racingcar.model.*;
import racingcar.policy.MovingPolicy;
import racingcar.policy.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.RacingCarGameErrorMessage.ERROR_COIN_NEGATIVE_MESSAGE;
import static racingcar.view.OutputView.*;

public class RacingGame {

    private static final int ERROR_POINT_COIN_STEP = 2;

    private RacingCars racingCars;
    private Coin coin;
    private final MovingPolicy movingPolicy = new RandomMovingPolicy();
    private int errorPoint;

    public RacingGame(int errorPoint){
        this.errorPoint = errorPoint;
    }

    public void ready() {
        if(this.errorPoint != ERROR_POINT_COIN_STEP) {
            readyRaceParticipant();
        }
        readyRaceCoin();
    }

    public void start() {

        printResultMessage();

        while (coin.isContinue()) {
            coin.useCoin();
            run();
        }

        printWinners(getWinners());
    }

    public void createErrorPoint(String errorMessage) {
        if(ERROR_COIN_NEGATIVE_MESSAGE.equals(errorMessage)) this.errorPoint = ERROR_POINT_COIN_STEP;
    }

    private void readyRaceParticipant() {
        String[] carNames = InputView.RacingCarInputNames();

        List<RacingCar> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }

        racingCars = new RacingCars(cars);
    }

    private void readyRaceCoin() {
        coin = new Coin(InputView.RacingCarInputsTry());
    }

    private void run() {
        racingCars.moveForwardWithAllRacingCar(movingPolicy);
        printProgress();
    }

    private void printProgress() {
        OutputView.printProgress(racingCars);
        OutputView.printLine();
    }


    private List<WinningRacingCar> getWinners() {
        return racingCars.winningCars(racingCars.getMaxPosition());
    }

}
