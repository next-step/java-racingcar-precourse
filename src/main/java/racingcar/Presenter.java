package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Presenter {
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUT_DISPLAY_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_DISPLAY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String OUT_RESULT = "실행 결과";
    private static final int ENTER_LINE_COUNT = 2;

    public static Optional<Name[]> inputCarNames() {
        try {
            return Optional.of(validationForCarName(readLine().split(INPUT_DELIMITER)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    private static Name[] validationForCarName(final String[] names) {
        Set<Name> nameSet = new HashSet<>();
        for (String name : names) {
            nameSet.add(new Name((name)));
        }
        return nameSet.toArray(new Name[0]);
    }

    public static Optional<RacingCount> inputRacingCount() {
        try {
            return Optional.of(validationForTryCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    private static RacingCount validationForTryCount() {
        try {
            return new RacingCount(Integer.parseInt(readLine()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] input is invalid");
        }
    }

    public static void disPlayPrintForName() {
        System.out.println(INPUT_DISPLAY_NAME);
    }

    public static void disPlayPrintForTryCount() {
        System.out.println(INPUT_DISPLAY_COUNT);
    }

    public static void displayResultTitle() {
        enter(2);
        System.out.println(OUT_RESULT);
    }

    public static void disPlayCar(final Cars cars) {
        System.out.println(cars);
    }

    public static void winnerPrint(final Name[] winners) {
        System.out.print("최종 우승자: " + stringFormat(winners));
    }

    private static String stringFormat(final Name[] names) {
        return String.join(",", Arrays.toString(names))
                .replace("[", "")
                .replace("]", "");
    }

    private static void enter(final int num) {
        for (int i=1; i <= num; i++) {
            System.out.println();
        }
    }
}
