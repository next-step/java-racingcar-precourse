package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.utils.StringUtils;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    public static void play() {
        List<String> names = createNames();
        int moveCount = InputView.inputMoveCount();
        Cars cars = createCars(names);
        ResultView.printResultSubject();

        for (int i = 0; i < moveCount; i++) {
            cars.race(new RandomMovingStrategy());
            ResultView.printCar(cars);
        }
        ResultView.printWinner(cars.findWinners());
    }

    private static Cars createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }

        return new Cars(carList);
    }

    private static List<String> createNames() {
        try {
            String inputNameString = InputView.inputNameString();
            return StringUtils.inputStringSeparator(inputNameString);
        } catch (IllegalArgumentException e) {
            ResultView.printError(e.getMessage());
            return createNames();
        }
    }
}
