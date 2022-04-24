package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveResult;
import racingcar.view.View;
import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final View view;

    public RacingController(View view) {
        this.view = view;
    }

    public void start() {
        Cars cars = createCarsFromUser();

        int racingCount = getRacingCountFromUser();
        view.outputExecutionResultGuide();
        for (int i = 0; i < racingCount; i++) {
            List<Integer> numbers = generateRandomMoveNumber(cars.size());
            MoveResult moveResult = cars.moveForward(numbers);
            view.outputMoveResult(moveResult);
        }

        view.outputVictors(cars.getVictors());
    }

    private int getRacingCountFromUser() {
        try {
            return view.requestInputRacingCount();
        } catch (IllegalArgumentException e) {
            view.errorMessage(e);
            return getRacingCountFromUser();
        }
    }

    private Cars createCarsFromUser() {
        try {
            String names = view.requestInputCarNames();
            return new Cars(names);
        } catch (IllegalArgumentException e) {
            view.errorMessage(e);
            return createCarsFromUser();
        }
    }

    private List<Integer> generateRandomMoveNumber(int participatedCarCount) {
        List<Integer> numbers = new ArrayList<>();
        do {
            numbers.add(Randoms.pickNumberInRange(Car.MIN_NUMBER, Car.MAX_NUMBER));
        } while (numbers.size() < participatedCarCount);
        return numbers;
    }

}
