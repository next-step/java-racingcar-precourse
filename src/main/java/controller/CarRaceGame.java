package controller;

import io.Input;
import io.Output;
import java.util.List;
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
    }
}
