package racingcar.ui;

import racingcar.dto.RecordDto;

import java.util.List;

public class OutputView {
    private static final String RECORD_TITLE_MESSAGE = "실행 결과";
    private static final String EMPTY_LINE = "";
    private static final String WINNERS_MESSAGE = "최종 우승자 : %s";
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    private OutputView() {
    }

    public static void showRecord(RecordDto recordDto) {
        showLapPositions(recordDto.getLapPositions());
        showWinners(recordDto.getWinners());
    }

    private static void showLapPositions(List<List<String>> lapPositions) {
        print(EMPTY_LINE);
        print(RECORD_TITLE_MESSAGE);
        for (List<String> carPositions : lapPositions) {
            showCarPositions(carPositions);
        }
    }

    private static void showCarPositions(List<String> carPositions) {
        for (String carPosition : carPositions) {
            print(carPosition);
        }
        print(EMPTY_LINE);
    }

    private static void showWinners(List<String> winners) {
        print(String.format(WINNERS_MESSAGE, String.join(", ", winners)));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    public static void error(String message) {
        print(String.format(ERROR_MESSAGE, message));
    }
}
