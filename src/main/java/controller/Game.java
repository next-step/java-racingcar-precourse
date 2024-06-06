package controller;

import view.Input;
import view.Output;
import model.Cars;
import java.util.ArrayList;
import java.util.Collections;

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

        output.printWinners(getWinners());
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

    public String[] getWinners() {
        ArrayList<String> winners = new ArrayList<>();
        String maxDistance = Collections.max(this.cars.getCars().values());
        for (String carName : this.cars.getCars().keySet()) {
            if (this.cars.getCars().get(carName).equals(maxDistance)) {
                winners.add(carName);
            }
        }
        return winners.stream().toArray(String[]::new);
    }
}
