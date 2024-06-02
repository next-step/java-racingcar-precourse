// CarRacingGame.class
package controller;

import java.util.Arrays;
import java.util.HashMap;
import model.*;
import view.*;

public class CarRacingGame {

    private final Input input = new Input();
    private final HashMap<String, String> result = new HashMap<>();
    private final Result printResult = new Result();
    private final RaceResultAnalyzer winner = new RaceResultAnalyzer();
    private final Result printWinner = new Result();

    // 게임 시작
    public void gamePlay() {
        String[] carNames = inputCars();
        initializeResultMap(carNames);

        DriveCar driveCar = new DriveCar(result);
        int numberOfAttempts = attemptCount();

        System.out.println("실행 결과");
        performRace(carNames, driveCar, numberOfAttempts);
        announceWinners();
    }

    // 결과 초기화
    private void initializeResultMap(String[] carNames) {
        for (String car : carNames) {
            result.put(car, "");
        }
    }

    // 경주를 수행
    private void performRace(String[] carNames, DriveCar driveCar, int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            Arrays.stream(carNames).forEach(driveCar::drive);
            printResult.output(result);
        }
    }

    // 우승자 발표
    private void announceWinners() {
        String[] winnerList = winner.compareRaceCar(result).toArray(new String[0]);
        printWinner.theVictor(winnerList);
    }

    // 자동차 이름을 입력받는 메서드
    private String[] inputCars() {
        String[] carNames;
        while (true) {
            try {
                carNames = input.inputCars();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNames;
    }

    // 시도 횟수를 입력 받는 메서드
    private int attemptCount() {
        int numAttempts;
        while (true) {
            try {
                numAttempts = input.attemptCount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return numAttempts;
    }
}
