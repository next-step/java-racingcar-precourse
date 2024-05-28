package controller;

import model.Car;
import model.Race;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<Car> cars = getValidatedCarNames();
        int attempts = getValidatedAttempts();

        Race race = new Race(cars);
        startRace(race, attempts);
        printWinners(race);
    }

    private List<Car> getValidatedCarNames() {
        while (true) {
            try {
                String carNamesInput = inputView.getCarNames();
                List<String> carNames = parseCarNames(carNamesInput);
                validateCarNames(carNames);
                return carNames.stream()
                        .map(Car::new)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getValidatedAttempts() {
        while (true) {
            try {
                int attempts = inputView.getAttempts();
                validateAttempts(attempts);
                return attempts;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        for (String name : carNames) {
            if (name.trim().isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }
        }
        long uniqueCount = carNames.stream().distinct().count();
        if (uniqueCount != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void startRace(Race race, int attempts) {
        for (int i = 0; i < attempts; i++) {
            race.moveCars(() -> (int) (Math.random() * 10));
            outputView.printRaceState(race.getCars());
        }
    }

    private void printWinners(Race race) {
        List<Car> winners = race.getWinners();
        outputView.printWinners(winners);
    }


}
