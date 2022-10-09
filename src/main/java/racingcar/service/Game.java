package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Driving;
import racingcar.domain.RacingCars;
import racingcar.utils.ReaderBoard;
import racingcar.utils.Scanner;

import java.util.List;

public class Game {

    private static final String GAME_ROUND_PATTERN = "^[1-9][0-9]*$";

    private RacingCars racingCars;
    private int gameRound;

    public Game() {
        joinCar();
        setGameRound();
    }

    public void racing() {
        for (int i = 0; i < gameRound; i++) {
            drive();
        }
        winner();
    }

    private void drive() {
        for (Car car : racingCars.getCars()) {
            car.drive(Driving.isDrive());
        }
    }

    private void winner() {
        List<Car> winners = racingCars.winners();
    }

    private void joinCar() {
        try {
            String carNames = Scanner.carNames();
            racingCars = new RacingCars(carNames);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            this.joinCar();
        }
    }

    private void setGameRound() {
        try {
            String inputGameRound = Scanner.gameRound();
            validateGameRound(inputGameRound);
            gameRound = Integer.parseInt(inputGameRound);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            this.setGameRound();
        }
    }

    private void validateGameRound(final String gameRound) {
        if (!gameRound.matches(GAME_ROUND_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 큰 숫자여야 합니다.");
        }
    }
    
}
