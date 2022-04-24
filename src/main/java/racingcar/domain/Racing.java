package racingcar.domain;

import org.assertj.core.util.Lists;

import java.util.List;

public class Racing {
    private final int racingCount;
    private final List<RacingCar> racingCars;
    private boolean isEnd = false;

    public Racing(int racingCount, List<RacingCar> racingCars) {
        this.racingCount = racingCount;
        this.racingCars = racingCars;
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public void race() {
        if (isEnd) throw new RuntimeException("이미 실행된 게임입니다. 잘못된 접근으로 게임을 종료합니다.");
        printInitResultMessage();
        for (int i = 0; i < racingCount; i++) {
            carsMove();
            printRacingState();
        }
        isEnd = true;
    }

    public boolean isEnd() { return isEnd; }

    private void carsMove() {
        for (RacingCar racingCar: racingCars) {
            racingCar.move();
        }
    }

    private void printRacingState() {
        for (RacingCar racingCar: racingCars) {
            racingCar.printState();
        }
        System.out.println();
    }

    private void printInitResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showRacingResult() {
        Winners winners = getWinners();
        winners.printWinners();
    }

    private Winners getWinners() {
        Winners winners = new Winners(Lists.newArrayList());
        int winStep = getWinStep();
        for (RacingCar racingCar: racingCars) {
            racingCar.addWinRacingCar(winStep, winners);
        }
        return winners;
    }

    private int getWinStep() {
        int winStep = 0;
        for (RacingCar racingCar: racingCars) {
            winStep = racingCar.isWinStep(winStep);
        }
        return winStep;
    }
}
