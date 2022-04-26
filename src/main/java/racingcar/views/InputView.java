package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import racingcar.cars.Cars;
import racingcar.firstcollections.Positive;
import racingcar.utils.PrintUtils;

public class InputView {

    public static Cars inputCarNames() {
        Cars cars = null;
        try {
            cars = new Cars(Console.readLine());
        } catch (IllegalArgumentException e) {
            PrintUtils.error(e.getMessage());
        }
        return cars;
    }

    public static Positive inputRacingCount() {
        Positive positive = null;
        try {
            positive = new Positive(Console.readLine());
        } catch (IllegalArgumentException e) {
            PrintUtils.error(e.getMessage());
        }
        return positive;
    }
}
