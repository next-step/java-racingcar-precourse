package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class ResultView {

    private static final String DELIMITER = ":";
    private static final String BLANK = " ";
    private static final String POSITION_POINT = "-";
    private static final String WINNER_MESSAGE = "최종 우승자";
    private static final String NAME_DELIMITER = ", ";

    public void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            printCar(car);
        }
        System.out.println(getResultMessage(cars));
    }

    private void printCar(Car car) {
        String name = car.getName();
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(BLANK).append(DELIMITER).append(BLANK);
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(POSITION_POINT);
        }
        String resultString = builder.toString();
        System.out.println(resultString);
    }

    private String getResultMessage(Cars cars) {
        List<String> names = cars.getWinnersNames();
        String winnersNames = String.join(NAME_DELIMITER, names);
        return WINNER_MESSAGE + DELIMITER + BLANK + winnersNames;
    }

}
