package service;

import java.util.List;
import model.Car;
import model.Cars;
import model.MaxNumber;
import util.RandomGenerator;
import view.OutputView;

public class GameService {
    public static final int THRESHOLD = 4;


    public void playGame(Cars cars, int trial) {

        MaxNumber maxNumber = new MaxNumber(0);
        OutputView.printDefault();

        do {
            playOneTurn(cars.getCars());
            maxNumber.updateMaxNumber(cars.getCars());
            OutputView.printResult(cars.getCars());
            trial -= 1;
        } while (trial > 0);

        OutputView.printWinners(cars.getCars(), maxNumber.getMaxNumber());

    }


    public void playOneTurn(List<Car> cars) {

        for (Car car:cars) {
            int randomNumber = RandomGenerator.createRandomNumber();
            checkMoveOrStay(randomNumber, car);
        }

    }

    public void checkMoveOrStay(int i, Car a) {
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("게임 진행 도중 오류가 발생하였습니다.");
        }

        if (i >= THRESHOLD) {
            a.setCount(a.getCount() + 1);
        }
    }



}
