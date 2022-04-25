package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.Cars;
import racingcar.dto.RaceResult;

public class RaceService {
    public static final String INPUT_MESSAGE_FOR_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public void setupCars(Cars cars) {
        try {
            cars.ready(Console.readLine());
            System.out.println(INPUT_MESSAGE_FOR_TRY_COUNT);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setupCars(cars);
        }
    }

    public void raceCars(Cars cars) {
        try {
            RaceResult result = new RaceResult(Console.readLine());
            System.out.println();

            result.start(cars);
            result.showWinner(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            raceCars(cars);
        }
    }
}
