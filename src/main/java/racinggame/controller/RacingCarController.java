package racinggame.controller;

import racinggame.domain.*;
import racinggame.view.RacingCarInputView;
import racinggame.view.RacingCarOutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingCarController {

    private RacingCarController() {}

    private static Cars cars;
    private static TryCount tryCount;

    public static void play() {
        while (cars == null) {
            initCars();
        }

        while (tryCount == null) {
            initTryCount();
        }

        processGame();
        getGameWinners();
    }

    private static void getGameWinners() {
        Position maxPosition = cars.getMaxPosition();
        cars = cars.winners(maxPosition);
        RacingCarOutputView.printWinners(cars);
    }

    private static void processGame() {
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars = cars.move();
            Map<String, String> carsStatus = cars.getCarsStatus();
            RacingCarOutputView.printCarStatus(carsStatus);
        }
    }

    private static void initCars() {
        RacingCarOutputView.printCarInputMessage();
        try {
            List<String> names = RacingCarInputView.receiveCarName();
            cars = createCars(names);
        } catch (IllegalArgumentException e) {
            RacingCarOutputView.printErrorMessage(e);
        }
    }

    private static void initTryCount() {
        RacingCarOutputView.printTryCountInputMessage();
        try {
            int receiveCount = RacingCarInputView.receiveTryCount();
            tryCount = new TryCount(receiveCount);
        } catch (IllegalArgumentException e) {
            RacingCarOutputView.printErrorMessage(e);
        }
    }

    private static Cars createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            Name carName = new Name(name);
            carList.add(new Car(carName));
        }

        return new Cars(carList);
    }


}
