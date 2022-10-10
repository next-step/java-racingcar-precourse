package racingcar.ui;

import racingcar.domain.car.Car;

import java.util.List;

public class OutputView {
    private static final String COLUMN = " : ";
    private static final String MOVE_PRINT = "-";

    private static StringBuilder stringBuilder;

    public static void printRacingGame(int tryTime, List<Car> carList) {
        stringBuilder = new StringBuilder();
        if (tryTime == 0) {
            stringBuilder.append("실행 결과\n");
        }

        for (Car car : carList) {
            stringBuilder.append(car.getName()).append(COLUMN);
            printPosition(car);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(MOVE_PRINT);
        }
    }

    public static void printWinners(List<Car> winnerList) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        boolean isFirst = true;
        for (Car car : winnerList) {
            if (!isFirst) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(car.getName());
            isFirst = false;
        }
        System.out.println(stringBuilder.toString());
    }

}
