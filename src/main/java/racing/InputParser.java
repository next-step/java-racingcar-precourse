package racing;

public class InputParser {

    public static final String DELIMITER_NAME_INPUT = ",";

    public static CarSet parseCarNames(String commaSeparateNames) {
        CarSet cars = new CarSet();
        for (String name : commaSeparateNames.split(DELIMITER_NAME_INPUT)) {
            cars = cars.concat(new Car(name));
        }
        return cars;
    }

    public static Round parseRound(String round) {
        try {
            return new Round(Integer.parseInt(round));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("abnormal input round: " + round);
        }
    }
}
