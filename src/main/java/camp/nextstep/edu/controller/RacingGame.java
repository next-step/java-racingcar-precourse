package camp.nextstep.edu.controller;

import camp.nextstep.edu.domain.Car;
import camp.nextstep.edu.view.Input;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private Input input;
    private List<Car> cars;
    private int moveCount;

    public RacingGame(Input input) {
        this.input = input;
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
        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.moveLocation();
            }
            // TODO: 실행 결과 출력
        }
    }

    public void endRace() {
        // TODO: 우승자 출력
        input.endInput();
    }
}
