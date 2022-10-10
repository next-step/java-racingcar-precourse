package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Number;
import racingcar.domain.RacingCars;
import racingcar.domain.WinnerCondition;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView view;
    private final WinnerCondition winnerCondition;

    public RacingCarController(RacingCarView view, WinnerCondition winnerCondition) {
        this.view = view;
        this.winnerCondition = winnerCondition;
    }

    public void start() {
        RacingCars racingCars = makeRacingCars();
        Number numberToTry = getNumber();
        while (numberToTry.isPositive()) {
            race(racingCars);
            numberToTry.decrease();
        }
        finish(racingCars);
    }

    private RacingCars makeRacingCars() {
        view.init();
        String carNames = Console.readLine();
        try {
            return new RacingCars(carNames);
        } catch (IllegalArgumentException e) {
            view.println(e.getMessage());
            return this.makeRacingCars();
        }
    }

    private Number getNumber() {
        view.inputNumber();
        String line = Console.readLine();
        try {
            return new Number(line);
        } catch (IllegalArgumentException e) {
            view.println(e.getMessage());
            return this.getNumber();
        }
    }

    private void race(RacingCars racingCars) {
        view.println(racingCars.race());
    }

    private void finish(RacingCars racingCars) {
        view.finish(racingCars.finish(winnerCondition));
    }
}
