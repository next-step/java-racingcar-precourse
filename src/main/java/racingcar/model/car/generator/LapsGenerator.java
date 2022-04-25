package racingcar.model.car.generator;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Laps;
import racingcar.view.Display;

public class LapsGenerator {

    public static Laps generate() {
        Laps laps = null;
        while (laps == null) {
            laps = createLaps();
        }

        return laps;
    }

    private static Laps createLaps() {
        printSetLapsMessage();
        return laps();
    }

    private static Laps laps() {
        Laps laps = null;
        try {
            laps = new Laps(receiveFromUser());
        } catch (IllegalArgumentException e) {
            Display.printExceptionMessage(e);
        }
        return laps;
    }

    private static String receiveFromUser() {
        return Console.readLine();
    }

    private static void printSetLapsMessage() {
        Display.printSetLapsMessage();
    }
}
