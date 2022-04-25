package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarsDto;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.ProgressView;
import racingcar.view.WinnerView;

public class RacingGameController {
    private static final String ERROR_PREFIX = "[ERROR] ";


    public void run() {
        Cars cars = initCars();
        raceCars(cars);
    }

    private List<String> getCarNamesFromInput() {
        InputView.printCarNamesInputMessage();
        String input = Console.readLine();
        InputValidator.validateCarNamesString(input);
        return Arrays.asList(input.split(","));
    }

    private Cars initCars() {
        List<Car> carList = new ArrayList<>();

        try {
            List<String> inputCars = getCarNamesFromInput();
            for (String inputCar : inputCars) {
                carList.add(new Car(inputCar));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return initCars();
        }
        return new Cars(carList);
    }

    private int getTryTimesFromInput() {
        String input;
        try {
            InputView.printTryTimesInputMessage();
            input = Console.readLine();
            InputValidator.validateTryTime(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return getTryTimesFromInput();
        }
        return Integer.parseInt(input);
    }

    private void raceCars(Cars cars) throws IllegalArgumentException {
        int tryTimes = getTryTimesFromInput();
        ProgressView.printProgressStart();
        for (int i = 0; i < tryTimes; i++) {
            cars.carsMove();
            CarsDto carsDto = cars.movingProgress();
            ProgressView.printProgress(carsDto);
        }
        WinnerView.printWinners(cars.getWinnersDto());
    }

}
