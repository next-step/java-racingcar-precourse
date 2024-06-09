package camp.nextstep.edu.controller;

import camp.nextstep.edu.domain.Car;
import camp.nextstep.edu.view.Input;
import camp.nextstep.edu.view.Output;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {

    private final Input input;
    private final Output output;
    private List<Car> cars;
    private int moveCount;

    public RacingGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void run() {
        prepareRace();
        race();
        endRace();
    }

    public void prepareRace() {
        String[] carNames = input.inputCarNames();
        moveCount = input.inputMoveCount();
        cars = Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    public void race() {
        System.out.println("실행 결과");
        IntStream.range(0, moveCount)
                .forEach(i -> {
                    for (Car car : cars) {
                        car.moveForward();
                    }
                    output.printCurrentState(cars);
                });
    }

    public void endRace() {
        String[] winners = getWinners();
        output.printWinners(winners);
        input.endInput();
    }

    private String[] getWinners() {
        int maxLocation = cars.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .orElseThrow(IllegalStateException::new)
                .getLocation();

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toArray(String[]::new);
    }
}
