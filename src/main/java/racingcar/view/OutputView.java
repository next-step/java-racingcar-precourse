package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGameRecord;
import racingcar.domain.RacingGame;

public class OutputView {
    private static final String OUTPUT_EXECUTION_RESULT = "실행 결과";
    private static final String RACING_CAR = "%s : %s\n";
    private static final String OUTPUT_FINAL_WINNER = "최종 우승자 : %s";

    public static void printRacingGameResult(RacingGame racingGame) {
        System.out.println(OUTPUT_EXECUTION_RESULT);
        printRacingGameRecord(racingGame.getRacingGameRecord());
        printFinalWinner(racingGame.getCars());
    }

    public static void printMessage(String message) {
        System.out.println(message);

    }

    private static void printRacingGameRecord(RacingGameRecord racingGameRecord) {
        for (Cars cars : racingGameRecord.getCarsList()) {
            for (Car car : cars.getAnswers()) {
                System.out.printf(RACING_CAR, car.getName().getName(), getCarMoveMark(car.getDistance()));
            }
            System.out.println();
        }
    }

    private static void printFinalWinner(Cars cars) {
        System.out.printf(OUTPUT_FINAL_WINNER, Cars.getWinnerNames(cars.getWinnerResult()));
    }

    private static String getCarMoveMark(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        while (distance-- > 0) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
