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
            int randomNumber = RandomGenerator.createRandomNumber();
            checkMoveOrStay(randomNumber, car);
        }

        maxMoved.updateMaxNumber(cars.getCars());
    }

    public void checkMoveOrStay(int i, Car a) {
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("게임 진행 도중 오류가 발생하였습니다.");
        }

        if (i >= THRESHOLD) {
            a.move();
        }
    }


}
