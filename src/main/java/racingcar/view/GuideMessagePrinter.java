package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winners;
import racingcar.domain.response.CarRaceResult;
import racingcar.domain.response.RoundResult;

import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 1:21
 */
public class GuideMessagePrinter {
    public static final String INPUT_CAR_NAMES_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ROUND_COUNT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String FINAL_WINNERS_GUIDE_MESSAGE = "최종 우승자: %s";
    public static final String RACE_RESULT = "실행 결과";
    private static final String PROGRESS = "-";
    public static final String ROUND_RESULT_FORMAT = "%s : %s";

    public static void printInputCarNamesGuideMessage() {
        System.out.println(INPUT_CAR_NAMES_GUIDE_MESSAGE);
    }

    public static void printInputRoundCountGuideMessage() {
        System.out.println(INPUT_ROUND_COUNT_GUIDE_MESSAGE);
    }

    public static void printRaceResultGuildMessage() {
        System.out.println();
        System.out.println(RACE_RESULT);
    }

    public static void printRoundResult(RoundResult roundResult) {
        List<CarRaceResult> raceResults = roundResult.getRaceResults();
        for (CarRaceResult carRaceResult : raceResults) {
            Car car = carRaceResult.getCar();
            System.out.println(String.format(ROUND_RESULT_FORMAT, car.getCarName(), scoreToProgress(car.getScore())));
        }
        System.out.println();
    }

    public static void printFinalWinners(Winners winners) {
        System.out.println(String.format(FINAL_WINNERS_GUIDE_MESSAGE, winners.getWinnerNames()));
    }

    private static String scoreToProgress(int score) {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < score; i++) {
            progress.append(PROGRESS);
        }
        return progress.toString();
    }
}
