package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Cars;

public class Outview {
    public static final String COLON = " : ";
    public static final String HYPHEN = "-";
    public static final String COMMA = ",";
    public static final String WINNER_MESSAGE = "최종 우승자: %s";

    public static void printForEachOrder(Cars cars) {
        for (Car car : cars.getCarList()) {
            String hypen = conversionDash(car.getPosition());
            System.out.println(car.getCarName() + COLON + hypen);
        }
    }

    private static String conversionDash(int postion) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < postion; i++) {
            builder.append(HYPHEN);
        }
        return builder.toString();
    }


    public static void printWinner(Cars cars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars.getWinnerList()) {
            winnerNames.add(car.getCarName());
        }
        String names = String.join(COMMA, winnerNames);
        System.out.printf(WINNER_MESSAGE, names);
    }
}
