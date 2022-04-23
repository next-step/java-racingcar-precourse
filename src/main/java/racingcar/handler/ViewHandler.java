package racingcar.handler;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class ViewHandler {
    private ViewHandler() {}

    public static void printNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTryCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printSimulateResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printSimulateResult(final List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }

        System.out.println();
    }

    private static void printCarStatus(final Car car) {
        System.out.printf("%s : ", car.getName());

        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public static void printWinners(final List<Car> cars) {
        final StringJoiner winners = new StringJoiner(", ");

        for (Car car : cars) {
            winners.add(car.getName());
        }

        System.out.printf("최종 우승자: %s", winners);
    }
}
