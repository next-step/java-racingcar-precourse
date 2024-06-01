package controller;

import io.Input;
import io.Output;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Car;

public class CarRaceGame {

    private static final Input input = new Input();
    private static final Output output = new Output();

    private static List<Car> carList;

    public void play() {
        boolean validInput = false;
        int number = 0;

        while (!validInput) {
            try {
                carList = input.inputCars();
                validInput = true;
            } catch (IllegalArgumentException e) {
                output.printCarNameErrorMessage();
            }
        }
        validInput = false;
        while (!validInput) {
            try {
                number = input.inputNumber();
                validInput = true;
            } catch (IllegalArgumentException e) {
                output.printNumberFormatErrorMessage();
            }
        }

        output.printResultMessage();
        while (number > 0) {
            Map<String, String> result = drive(carList);
            output.printResult(result);
            number--;
        }

        output.printWinner(decideWinner(carList));
    }

    private Map<String, String> drive(List<Car> carList) {
        return carList.stream().collect(Collectors.toMap(Car::getName, Car::drive));
    }

    private List<Car> decideWinner(List<Car> carList) {
        int longestDistance = carList.stream()
                                .mapToInt(car -> car.getState().length()).max().orElse(0);

        return carList.stream().filter(car -> car.getState().length() == longestDistance)
                .collect(Collectors.toList());
    }
}
