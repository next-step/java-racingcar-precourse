package service;

import java.util.List;
import model.Car;
import model.Cars;
import utils.RandomNumberGenerator;
import view.OutputView;

public class GameService {

    private final Cars cars;
    private final OutputView outputView;

    public GameService() {
        cars = new Cars();
        outputView = new OutputView();
    }

    public void play(List<String> carNames, int attempt) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        outputView.printResult();
        while (attempt-- > 0) {
            round();
            outputView.printRoundOutput(cars.getCars());
        }
        whosTheWinner();
    }

    private void round() {
        for (Car car : cars.getCars()) {
            if (RandomNumberGenerator.generate() >= 4) {
                car.forward();
            }
        }
    }

    private void whosTheWinner() {
    }
}
