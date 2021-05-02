package racing;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public static List<Car> parseCarNames(String commaSeparateNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : commaSeparateNames.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public static Round parseRound(String round) {
        return new Round(Integer.parseInt(round));
    }
}
