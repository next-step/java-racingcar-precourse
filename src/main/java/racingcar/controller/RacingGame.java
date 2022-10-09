package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.AttemptCount;
import racingcar.model.CarCollection;
import racingcar.model.CarNames;
import racingcar.view.Viewer;

import java.util.List;

public class RacingGame {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final String JOIN_DELIMITER = ",";
    private final Viewer viewer;
    private CarCollection racingCars;

    public RacingGame() {
        this.viewer = new Viewer();
    }

    public void start() {
        createRacingCars();
        AttemptCount attemptCount = getAttemptCount();
        cycle(attemptCount.getCount());
        printWinner();
    }

    private void printWinner() {
        String winner = findWinner();
        viewer.printWinner(winner);
    }

    private String findWinner() {
        List<String> first = racingCars.findFirst();
        return joinWinner(first);
    }

    private String joinWinner(List<String> first) {
        StringBuilder sb = new StringBuilder();
        for (String name : first) {
            sb.append(name);
            sb.append(JOIN_DELIMITER);
        }
        sb.delete(sb.lastIndexOf(JOIN_DELIMITER), sb.length());
        return sb.toString();
    }

    private void cycle(int count) {
        for (int i = 0; i < count; i++) {
            race();
            showCurrentStatus();
        }
    }

    private void showCurrentStatus() {
        viewer.print(racingCars.toString());
    }

    private AttemptCount getAttemptCount() {
        AttemptCount count;
        do {
            count = createAttemptCount();
        } while (count == null);
        return count;
    }

    private AttemptCount createAttemptCount() {
        try {
            String attemptCount = viewer.inputAttemptCount();
            return new AttemptCount(attemptCount);
        } catch (Exception e) {
            viewer.printErrorMessage(e.getMessage());
        }
        return null;
    }

    private void race() {
        for (int i = 0; i < racingCars.getCarCount(); i++) {
            move(i);
        }
    }

    private void move(int i) {
        if (canMove()) {
            racingCars.go(i);
            return;
        }
        racingCars.stop(i);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(MIN, MAX) >= 4;
    }

    private void createRacingCars() {
        do {
            String carNames = viewer.inputCarNames();
            racingCars = getCarCollection(carNames);
        } while (racingCars == null);
    }

    private CarCollection getCarCollection(String carNames) {
        try {
            CarNames names = new CarNames(carNames);
            return new CarCollection(names);
        } catch (Exception e) {
            viewer.printErrorMessage(e.getMessage());
        }
        return null;
    }

}
