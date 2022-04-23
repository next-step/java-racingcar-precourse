package racingcar.view.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.RacingGameView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameViewImpl implements RacingGameView {

    @Override
    public Cars createCars() {
        System.out.println(RacingGameView.CREATE_CARS_MSG);
        return new Cars(Console.readLine().split(RacingGameView.SPLIT_DELIMITER));
    }

    @Override
    public int insertTryCount() {
        System.out.println(RacingGameView.INSERT_COUNT_MSG);
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public void printExecute() {
        System.out.println(RacingGameView.EXECUTE_MSG);
    }

    @Override
    public void printExecuteResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car);
        }

        System.out.println();
    }

    @Override
    public void printWinner(List<Car> carList) {
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            carNames.add(car.getCarName());
        }

        System.out.printf(RacingGameView.WINNER_MSG_HOLDER, String.join(RacingGameView.SPLIT_DELIMITER, carNames));
    }
}
