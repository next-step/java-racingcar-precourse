package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class ResultMessageView {
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void executionResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void nowCarDistanceMessage(List<Car> carList) {
        carList.forEach(
                car -> System.out.println(car.getCarName() + " : " + car.getDistance())
        );
        System.out.println();
    }

    public static void finalRacingWinnerMessage(List<String> carList) {
        System.out.println(FINAL_WINNER + String.join(", ", carList));
    }
}
