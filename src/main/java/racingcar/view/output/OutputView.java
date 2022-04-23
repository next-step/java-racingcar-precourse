package racingcar.view.output;

import static racingcar.utils.WordUtils.BLANK;
import static racingcar.utils.WordUtils.COLON;
import static racingcar.utils.WordUtils.ERROR_HEADER_MESSAGE;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_HEADER_MESSAGE + " " + message);
    }

    public static void printRaceStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            carDistance(car);
        }
    }

    private static void carDistance(Car car) {
        System.out.println(car.getName() + BLANK + COLON + BLANK + car.getDistanceByDash());
    }

    public static void printWinners(Winners winners) {
        WinnersNameFactory winnersNameFactory = new WinnersNameFactory();
        WinnersName winnersName = winnersNameFactory.getWinnersName(winners);
        System.out.println(winnersName.getWinnersName(winners));
    }
}
