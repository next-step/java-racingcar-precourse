package service;

import java.util.List;
import model.Car;
import model.Cars;
import model.MaxMoved;
import model.Trial;
import util.RandomGenerator;
import view.OutputView;

public class GameService {

    public static final int THRESHOLD = 4;

    public void playGame(Cars cars, Trial trial) {

        MaxMoved maxMoved = new MaxMoved(0);
        OutputView.printDefault();

        do {
            playOneTurn(cars, maxMoved);
            OutputView.printResult(cars.getCars());
            trial.endOneTrial();
        } while (trial.isContinued());

        OutputView.printWinners(cars.getCars(), maxMoved.getMaxNumber());

    }

    public void playOneTurn(Cars cars, MaxMoved maxMoved) {

        for (Car car : cars.getCars()) {
            checkMoveOrStay(car);
        }

        maxMoved.updateMaxNumber(cars.getCars());
    }

    public void checkMoveOrStay(Car a) {

        if (RandomGenerator.createRandomNumber() >= THRESHOLD) {
            a.move();
        }
    }


}
