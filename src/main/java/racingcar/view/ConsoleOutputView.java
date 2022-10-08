package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class ConsoleOutputView {
    private ConsoleOutputView() {

    }

    public static void println(Object message) {
        System.out.println(message);
    }

    public static void printCarsAfterMoved(Cars cars) {
        System.out.println("실행결과");
        System.out.println(cars.toString());
    }

    public static void printWinners(Winners winners) {
        System.out.printf("최종 우승자 : %s%n", winners);
    }
}
