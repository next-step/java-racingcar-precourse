package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Distance;
import racingcar.domain.GameCount;
import racingcar.domain.Name;
import racingcar.dto.CarPrintDto;
import racingcar.dto.WinnerDto;
import racingcar.rule.GoStopRule;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private Cars cars;
    private GameCount gameCount;

    public void play() {
        init();
        printResult();
        while (gameCount.isContinue()) {
            process();
            gameCount.playCount();
        }
        List<WinnerDto> winnerList = getWinners();
        printWinner(winnerList);
    }

    private void init() {
        this.cars = createCars();
        this.gameCount = readCount();
    }

    private Cars createCars() {
        try {
            List<String> carNames = readCarsName();
            return new Cars(carNames);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return createCars();
        }
    }

    private GameCount readCount() {
        try {
            String countString = InputView.readCount();
            return new GameCount(countString);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return readCount();
        }
    }

    private List<WinnerDto> getWinners() {
        Distance maxDistance = cars.getMaxDistance();
        List<WinnerDto> winnerList = new ArrayList<>();
        for (Name name : cars.getNames(maxDistance)) {
            winnerList.add(new WinnerDto(name));
        }
        return winnerList;
    }

    private void process() {
        cars.process(createGoStopParams());
        printCurrentStatus();
    }

    private GoStopRule createGoStopParams() {
        return new GoStopRule(cars.getSize());
    }

    private void printCurrentStatus() {
        for (int i = 0; i < cars.getSize(); i++) {
            Car car = cars.getCar(i);
            String nameString = car.getName().getNameString();
            int distance = car.getDistance().get();
            OutputView.printCurrentStatus(new CarPrintDto(nameString, distance));
        }
        OutputView.printLn();
    }
}
