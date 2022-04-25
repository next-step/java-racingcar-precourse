package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class GameOutput {

    private static final String GAME_START_MESSAGE = "\n실행 결과";
    private static final String GAME_RESULT_MESSAGE = "최종 우승자: ";
    private static final String RESULT_VALUE_SEPERATOR = " : ";

    public void gameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.name() + RESULT_VALUE_SEPERATOR + car.position());
        }
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        System.out.println(GAME_RESULT_MESSAGE + String.join(",", winner));
    }
}
