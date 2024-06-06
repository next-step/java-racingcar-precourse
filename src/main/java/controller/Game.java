package controller;

import view.Input;
import view.Output;
import model.Cars;

public class Game {

    private Input input = new Input();
    private Output output = new Output();
    private Cars cars = new Cars();
    private int number;

    public void start() {
        carNamesProcess();

        numberProcess();

        output.printResultProgress();
        for (int i = 0; i < number; i++) {
            addCarsDistance();
            output.printResult(cars.getCars());
        }
    }

    public void carNamesProcess() {
        output.printCarNamesProgress();
        while (true) {
            String[] carNames = input.scanCarNames();
            try {
                Validation.checkCarNames(carNames);
                this.cars.setCars(carNames);
                break;
            } catch (IllegalArgumentException e) {
                output.printException();
            }
        }
    }

    public void numberProcess() {
        output.printNumberProgress();
        while (true) {
            String strNumber = input.scanNumber();
            try {
                Validation.checkNumber(strNumber);
                this.number = Integer.parseInt(strNumber);
                break;
            } catch (IllegalArgumentException e) {
                output.printException();
            }
        }
    }

    public void addCarsDistance() {
        for (String carName : this.cars.getCars().keySet()) {
            int randNum = (int) (Math.random() * 10);
            if (randNum >= 4) {
                this.cars.addDistance(carName);
            }
        }
    }
}
