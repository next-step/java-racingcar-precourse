package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class GameView {

    private static final String GAME_ASK_CARS_INPUT = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_ASK_TRY_INPUT = "시도할 횟수는 몇회인가요?";
    private static final String GAME_RESULT = "실행결과";

    public static String askCarsInput() {
        System.out.println(GAME_ASK_CARS_INPUT);
        return Console.readLine();
    }

    public static String askTryInput() {
        System.out.println(GAME_ASK_TRY_INPUT);
        return Console.readLine();
    }

    public static void showGameResult() {
        System.out.println(GAME_RESULT);
    }

    public static void printCarsStatus(Cars cars) {
        List<Car> carlist = cars.getCars();

    }
}
