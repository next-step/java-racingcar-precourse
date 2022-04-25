package racingcar.view;

import racingcar.model.Cars;
import racingcar.model.Winner;
import racingcar.util.CarUtil;

public class ConsoleView {

    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ROUND = "시도할 횟수는 몇회인가요?";
    public static final String RESULT_INFO = "실행결과";
    public static final String SOLO_WIN = "최종";
    public static final String CO_WIN = "공동";
    public static final String WINNER_POSTFIX = " 우승자 : ";
    public static final String EMPTY = "";
    public static final String SEPARATOR = ", ";
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void inputRound() {
        System.out.println(INPUT_ROUND);
    }

    public static void printResultInfo() {
        System.out.println(RESULT_INFO);
    }

    public static void printRoundResult(Cars cars) {
        String result = EMPTY;

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getName() + " : " + CarUtil.dot(cars.get(i).getMileage(), "-"));
        }

        System.out.println("");
    }

    public static void printWinner(Winner winner) {
        String result = SOLO_WIN;

        if (!winner.isSolo()) {
            result = CO_WIN;
        }

        result += WINNER_POSTFIX;
        for (int i = 0; i < winner.size(); i++) {
            if (i != 0) {
                result += SEPARATOR;
            }
            result += winner.get(i);
        }

        System.out.println(result);
    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
