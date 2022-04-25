package racingcar.view;

import racingcar.model.record.Records;

public class Display {
    private static final String WINNERS = "최종 우승자: ";
    private static final String LINEUP_MESSAGE = "경주 할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String SET_LAPS_MESSAGE = "시도할 Laps 수를 입력하세요.";

    public static void printLineUpMessage() {
        System.out.println(LINEUP_MESSAGE);
    }

    public static void printSetLapsMessage() {
        System.out.println(SET_LAPS_MESSAGE);
    }

    public static void printEachLapsReport(Records records) {
        System.out.println(records.recordsSheet());
    }

    public static void printFinalRank(Records records) {
        System.out.println(WINNERS + records.rankSheet());
    }

    public static void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
