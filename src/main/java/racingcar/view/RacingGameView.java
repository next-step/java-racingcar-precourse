package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.Utils;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGameView {
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    public static final String WINNER = "최종 우승자 : ";
    private static final String ERROR = "[ERROR] ";

    public static String inputCars() {
        System.out.println(INPUT_CAR_NAMES);
        return readLine();
    }

    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        return Utils.validateTryCount(readLine());
    }


    public static void printRacers(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(makeRacerPosition(car));
        }
        System.out.println(sb);
    }

    private static String makeRacerPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public static void printWinner(RacingGame racingGame) {
        List<Car> winners = racingGame.getWinners();
        System.out.println(makeResult(winners));

    }

    private static String makeResult(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER);
        for (Car winner : winners) {
            sb.append(winner.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}
