package controller;

import model.Car;
import model.Race;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.stream.Collectors;


public class RacingGame {
    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> carNames = inputView.getCarNames();
        int tryCount = inputView.getTryCount();

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        Race race = new Race(cars, tryCount);
        race.startRace();

        resultView.printWinners(race.getWinners());
    }
}
