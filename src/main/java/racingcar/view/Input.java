package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static racingcar.util.Payload.*;

public class Input {

    public static String scan() {
        return readLine();
    }

    public static String[] parseNames(String scanned) {
        return scanned.split(SPLIT_REGEXP);
    }

    public static Cars scanCars() {
        try {
            Output.println(NOTICE_CAR_NAMES);
            String scanned = scan();
            return parseCars(scanned);
        } catch (IllegalArgumentException e) {
            Output.println(e.getMessage());
            return scanCars();
        }
    }

    public static Cars parseCars(String scanned) {
        String[] names = parseNames(scanned);
        Cars cars = new Cars();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static int scanTryNumber() {
        try {
            Output.println(NOTICE_TRY_NUMBER);
            return parseTryNumber(scan());
        } catch (IllegalArgumentException e) {
            Output.println(e.getMessage());
            return scanTryNumber();
        }
    }

    public static int parseTryNumber(String scanned) {
        try {
            return parseInt(scanned);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_TRY_NUMBER_TYPE);
        }
    }
}
