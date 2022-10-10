package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameResult;

import java.util.Collections;

import static racingcar.util.Payload.*;

public class Output {

    public static void println(String payload) {
        System.out.println(payload);
    }

    public static void printWinners(GameResult gameResult) {
        String names = gameResult.winners().names();
        println(FINAL_WINNER + names);
    }

    public static void printCars(Cars cars) {
        for (Car car : cars) {
            println(car.name() + COLON + track(car.spot().at()));
        }
        println(EMPTY);
    }

    private static String track(int at) {
        return String.join(EMPTY, Collections.nCopies(at, TRACK_SHAPE));
    }
}
