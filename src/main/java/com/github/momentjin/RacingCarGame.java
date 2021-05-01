package com.github.momentjin;

import com.github.momentjin.core.model.car.CarFactory;
import com.github.momentjin.core.application.MaxPositionExtractionService;
import com.github.momentjin.core.model.MovableObject;
import com.github.momentjin.ui.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RacingCarGame {

    private final Scanner scanner;
    private final RacingCountInput racingCountInput;
    private final RacingCarNameInput racingCarNameInput;
    private final GameWinnerPrinter gameWinnerPrinter;
    private final MovableObjectStatusPrinter movableObjectStatusPrinter;

    public RacingCarGame(
            Scanner scanner,
            RacingCountInput racingCountInput,
            RacingCarNameInput racingCarNameInput,
            GameWinnerPrinter gameWinnerPrinter,
            MovableObjectStatusPrinter movableObjectStatusPrinter) {

        this.scanner = scanner;
        this.racingCountInput = racingCountInput;
        this.racingCarNameInput = racingCarNameInput;
        this.gameWinnerPrinter = gameWinnerPrinter;
        this.movableObjectStatusPrinter = movableObjectStatusPrinter;
    }

    public void execute() {

        RacingCarNameList racingCarNameList = racingCarNameInput.execute(scanner);
        List<MovableObject> cars = createMovableObject(racingCarNameList);
        int racingCount = racingCountInput.execute(scanner);
        startGame(cars, racingCount);
        List<MovableObject> filtered = new MaxPositionExtractionService().extract(cars);
        gameWinnerPrinter.execute(filtered);
    }

    private void startGame(List<MovableObject> cars, int racingCount) {
        for (int gameCount = 0; gameCount < racingCount; gameCount++) {
            startOneGame(cars);
        }
    }

    private void startOneGame(List<MovableObject> cars) {
        for (MovableObject car : cars) {
            car.moveForward();
        }
        movableObjectStatusPrinter.print(cars);
    }

    private List<MovableObject> createMovableObject(RacingCarNameList racingCarNameList) {

        List<MovableObject> movableObjects = new ArrayList<>();
        for (Iterator<String> it = racingCarNameList.iterator(); it.hasNext(); ) {
            String carName = it.next();
            movableObjects.add(CarFactory.create(carName));
        }

        return movableObjects;
    }
}

