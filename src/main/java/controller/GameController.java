package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.Car;
import model.Race;
import util.InputValidator;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class GameController {

    public void start() {
        Race race = new Race();
        boolean checkNameValidate = false;
        boolean checkAttemptValidate = false;
        List<String> names = new ArrayList<>();
        String attempt = "";

        while (!checkNameValidate) {
            names = Arrays.asList(InputView.inputCarName().split(","));
            checkNameValidate = InputValidator.checkDuplicatedName(names) && InputValidator.checkNameLength(names);
        }

        while (!checkAttemptValidate) {
            attempt = InputView.inputAttempt();
            checkAttemptValidate = InputValidator.checkValidAttempt(attempt) && InputValidator.checkAttemptSize(attempt);
        }

        race.setCars(
            names.stream()
                .map(name -> {
                    Car car = new Car();
                    car.setName(name);
                    car.setPosition(0);
                    return car;
                })
                .collect(Collectors.toList())
        );

        for (int i = 0; i < Integer.parseInt(attempt); i++) {
            race.getCars().stream()
                .forEach(car -> {
                    int randomNumber = RandomNumberGenerator.makeRandomNumber();
                    if (randomNumber >= 4) {
                        car.move();
                    }
                });
            OutputView.printResult(race.getCars());
        }
        OutputView.printWinner(race.getWinners());
    }
}
