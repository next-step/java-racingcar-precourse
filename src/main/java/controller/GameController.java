package controller;

import static model.RaceCondition.IN_PROGRESS;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import model.Car;
import model.Race;
import view.OutputView;

public class GameController {

    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇회인가요?";
    private static final String EXECUTION_RESULT_HEADER = "\n실행결과";

    private final OutputView view;
    private final Scanner scanner;
    private Race race;

    public GameController(OutputView view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    public void playRacingCar() {
        initGame();
        view.println(EXECUTION_RESULT_HEADER);
        while (race.getRaceCondition() == IN_PROGRESS) {
            race.move();
        }
        race.removePropertyChangeListener(view);
    }

    public void initGame() {
        List<String> carNames = getCarNames();
        List<Car> carList = carNames.stream().map(Car::new).toList();

        int attemptCount = getAttemptCount();

        race = new Race(carList, attemptCount);
        race.addPropertyChangeListener(view);
    }

    private List<String> getCarNames() {
        view.println(CAR_NAME_PROMPT);
        String userInputStr = scanner.nextLine();
        return getCarNamesFromList(userInputStr);
    }

    private List<String> getCarNamesFromList(String userInputStr) {
        return Arrays.stream(userInputStr.split(","))
                .map(String::trim)
                .toList();
    }

    private int getAttemptCount() {
        view.println(ATTEMPT_COUNT_PROMPT);
        String userInputStr = scanner.nextLine();
        return Integer.parseInt(userInputStr);
    }
}
