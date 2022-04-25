package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.RacingMessage.MESSAGE_QUESTION_CAR_NAMES;
import static racingcar.RacingMessage.MESSAGE_QUESTION_LAP_COUNT;

public class RacingView {

    private final Cars cars;
    private final int lapCount;

    public Cars getCars() {
        return cars;
    }

    public int getLapCount() {
        return lapCount;
    }

    private RacingView(Cars cars, int lapCount) {
        this.cars = cars;
        this.lapCount = lapCount;
    }

    public static RacingView init() {
        System.out.println(MESSAGE_QUESTION_CAR_NAMES);
        Cars cars = initCars();

        System.out.println(MESSAGE_QUESTION_LAP_COUNT);
        int lapCount = initLapCount();

        return new RacingView(cars, lapCount);
    }

    public static Cars initCars() {
        List<Car> carList = new ArrayList<>();
        String[] split = Console.readLine().split(",");
        for (String name : split) {
            try {
                carList.add(new Car(name));
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
        return new Cars(carList);
    }

    private static int initLapCount() {
        String line = Console.readLine();
        ValidUtils.validNumber(line);
        return Integer.parseInt(line);
    }

}
