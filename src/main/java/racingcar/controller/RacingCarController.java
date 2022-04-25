package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.factory.CarsFactory;
import racingcar.view.input.Input;
import racingcar.view.output.Output;
import racingcar.vo.racecount.RaceCount;

public class RacingCarController {
    private Output outputView;
    private Input inputView;

    public RacingCarController(Output outputView, Input inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        try {
            Cars cars = participateCars();
            race(cars);
            printCurrentSituation(cars);
            paradeWinningCars(cars);
        } catch (Exception exception) {
            outputView.printError(exception);
        }

    }

    private Cars participateCars() {
        outputView.enterCarName();
        return CarsFactory.fromNames(Arrays.asList(inputView.enterCarName()));
    }

    private void paradeWinningCars(Cars cars) {
        List<String> winningCarName = new ArrayList<>();
        for (Car winningCar : cars.getWinningCars()) {
            winningCarName.add(winningCar.getName().toString());
        }
        outputView.winningCars(winningCarName);
    }

    private void race(Cars cars) {
        outputView.enterTryNumber();
        int raceCount = inputView.enterTryNumber();
        outputView.runResultMessage();
        cars.raceRepeat(RaceCount.from(raceCount));
    }

    private void printCurrentSituation(Cars cars) {
        for (Car car : cars.getParticipatedCars()) {
            outputView.racingResult(car.getName().toString(), car.getDistance().toInteger());
        }
        outputView.racingResultDelimiter();
    }
}
