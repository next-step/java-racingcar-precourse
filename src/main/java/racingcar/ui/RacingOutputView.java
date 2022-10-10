package racingcar.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.racing.CarStatus;
import racingcar.domain.racing.CarStatuses;

public class RacingOutputView {

    public static final String WINNER_DELIMITER = ", ";
    private static final String TRIAL = "-";

    public static void printRacingStart() {
        System.out.println("실행 결과");
    }

    public static void printCarStatuses(CarStatuses carStatuses) {
        final List<CarStatus> carStatusList = carStatuses.toList();
        carStatusList.forEach(RacingOutputView::printCarStatus);
        System.out.println();
    }

    private static void printCarStatus(CarStatus carStatus) {
        final String trails = makeTrails(carStatus.getDistanceFromStartingPoint());
        System.out.println(carStatus.getName() + " : " + trails);
    }

    private static String makeTrails(int distanceFromStartingPoint) {
        return String.join("", Collections.nCopies(distanceFromStartingPoint, TRIAL));
    }

    public static void printWinners(CarStatuses winners) {
        final List<String> winnerNames = getWinnerNames(winners.toList());
        System.out.println("최종 우승자 : " + joinWinnerNames(winnerNames));
    }

    private static List<String> getWinnerNames(List<CarStatus> winners) {
        final List<String> result = new ArrayList<>();
        for (CarStatus status : winners) {
            final String winnerName = status.getName();
            result.add(winnerName);
        }
        return result;
    }

    private static String joinWinnerNames(List<String> winnerNames) {
        return String.join(WINNER_DELIMITER, winnerNames);
    }
}
