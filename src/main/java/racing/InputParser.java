package racing;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static final String DELIMITER_NAME_INPUT = ",";

    public static List<Car> parseCarNames(String commaSeparateNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : commaSeparateNames.split(DELIMITER_NAME_INPUT)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static Round parseRound(String round) {
        return new Round(Integer.parseInt(round));
    }
}
