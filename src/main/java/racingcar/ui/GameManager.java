package racingcar.ui;

import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.PlayResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private static Cars cars;
    private static int numberOfRaces = -1;
    private static final String ERROR_MESSAGE_HEADER = "[ERROR]";

    public static void run() {
        initialize();
        play();
        printWinner();
    }

    private static void initialize() {
        List<CarName> carNames = new ArrayList<>();
        while (carNames.isEmpty()) {
            carNames = inputCarNames();
        }
        cars = new Cars(carNames);
        while (numberOfRaces < 0) {
            numberOfRaces = inputNumberOfRaces();
        }
    }

    private static List<CarName> inputCarNames() {
        try {
            return InputView.carNames();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_HEADER + " " + e.getMessage());
        }
        return Collections.emptyList();
    }

    private static int inputNumberOfRaces() {
        try {
            return InputView.numberOfRaces();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_HEADER + " " + e.getMessage());
        }
        return -1;
    }

    private static void play() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfRaces; i++) {
            PlayResult result = cars.play();
            ResultView.printRace(result);
        }
    }

    private static void printWinner() {
        PlayResult winners = cars.winners();
        ResultView.printWinners(winners);
    }
}
