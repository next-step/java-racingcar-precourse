package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import racingcar.cars.Cars;
import racingcar.firstcollections.Positive;

public class InputView {

    public static Cars inputCarNames() {
        Cars cars = null;
        try {
            cars = new Cars(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.printf("%s %s%n", DisplayView.ERROR_MESSAGE_PREFIX, e.getMessage());
        }
        return cars;
    }

    public static Positive inputRacingCount() {
        Positive positive = null;
        try {
            positive = new Positive(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.printf("%s %s%n", DisplayView.ERROR_MESSAGE_PREFIX, e.getMessage());
        }
        return positive;
    }
}
