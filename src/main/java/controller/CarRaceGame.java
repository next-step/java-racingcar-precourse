package controller;

import io.Input;
import io.Output;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Car;

public class CarRaceGame {

    private static final Input input = new Input();
    private static final Output output = new Output();

    public void play() {
        List<Car> carList = inputCars();
        int number = inputNumber();

        output.printResultMessage();
        while (number > 0) {
            Map<String, String> result = drive(carList);
            output.printResult(result);
            number--;
        }

        output.printWinner(decideWinner(carList));
    }

    private static List<Car> inputCars() {
        List<Car> CarList;

        while (true) {
            try {
                CarList = input.inputCars();
                return CarList;
            } catch (IllegalArgumentException e) {
                output.printCarNameErrorMessage();
            }
        }
    }

    private static int inputNumber() {
        int number;

        while (true) {
            try {
                number = input.inputNumber();
                return number;
            } catch (IllegalArgumentException e) {
                output.printNumberFormatErrorMessage();
            }
        }
    }

    private static Map<String, String> drive(List<Car> carList) {
        return carList.stream().collect(Collectors.toMap(Car::getName, Car::drive));
    }

    private static List<Car> decideWinner(List<Car> carList) {
        int longestDistance = carList.stream()
                                .mapToInt(car -> car.getState().length()).max().orElse(0);

        return carList.stream().filter(car -> car.getState().length() == longestDistance)
                .collect(Collectors.toList());
    }
}
