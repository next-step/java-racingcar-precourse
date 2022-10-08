package racingcar.ui;

import racingcar.domain.CarDTO;
import racingcar.domain.PlayResult;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void printRace(final PlayResult result) {
        for (final CarDTO dto : result.getResults()) {
            printCarNameAndDistance(dto.getName(), dto.getDistance());
        }
        System.out.println();
    }

    private static void printCarNameAndDistance(final String name, final int distance) {
        System.out.println(name + " : " + getDistance(distance));
    }

    private static String getDistance(final int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printWinners(final PlayResult winners) {
        List<String> winnersNames = new ArrayList<>();
        for (final CarDTO dto : winners.getResults()) {
            winnersNames.add(dto.getName());
        }
        System.out.println("최종 우승자 : " + String.join(",", winnersNames));
    }
}
