package service;

import java.util.List;
import model.Car;
import model.Cars;
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
        while (attempt-- > 0) {
            round();
        }
        whosTheWinner();
    }

    private void round() {
    }

    private void whosTheWinner() {
    }
}
