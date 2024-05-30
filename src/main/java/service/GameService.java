package service;

import java.util.List;
import java.util.stream.Collectors;
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
            playRound();
            outputView.printRoundOutput(cars.getCars());
        }
        outputView.printWinners(whosTheWinner());
    }

    private void playRound() {
        for (Car car : cars.getCars()) {
            if (RandomNumberGenerator.generate() >= 4) {
                car.forward();
            }
        }
    }

    private List<Car> whosTheWinner() {
        int max = cars.getCars().stream()
                        .mapToInt(Car::getStep)
                        .max().orElse(0);
        return cars.getCars().stream()
                        .filter(car -> car.getStep().equals(max))
                        .collect(Collectors.toList());
    }
}
