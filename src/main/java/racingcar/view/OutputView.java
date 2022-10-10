package racingcar.view;

import racingcar.common.Separator;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String MOVEMENT = "-";

    public static void printExecutionResultText() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRaceOneTurnResult(Cars cars) {
        for (int index = 0; index < cars.getRaceCarCount(); index++) {
            printCarResult(cars.getCar(index));
        }

        System.out.println();
    }

    private static void printCarResult(Car car) {
        System.out.print(car.getName() + " : ");

        for (int count = 0; count < car.getDistance(); count++) {
            System.out.print(MOVEMENT);
        }

        System.out.println();
    }

    public static void printWinner(String[] winners) {
        System.out.println("최종 우승자 : " + String.join(Separator.COMMA, winners));
    }
}
