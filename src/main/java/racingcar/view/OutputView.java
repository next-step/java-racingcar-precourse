package racingcar.view;

import racingcar.domain.*;

import java.util.List;

public class OutputView {

    public static final String WINNER_DELIMITER = ",";
    private static final String ERROR_PREFIX_MESSAGE = "[ERROR] ";
    private static final String GAME_RECORD_PREFIX_MESSAGE = "실행 결과";
    private static final String WINNER_PREFIX_MESSAGE = "최종 우승자 : ";
    private static final String ROUND_DISTANCE_SYMBOL = "-";
    private static final String ROUND_DISTANCE_DELIMITER = " : ";


    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX_MESSAGE + errorMessage);
    }
    public void printResult(Result result) {
        System.out.println(GAME_RECORD_PREFIX_MESSAGE);
        List<Records> recordsList = result.getRecordsList();
        for (Records records : recordsList) {
            System.out.println();
            printRoundDistance(records);
        }
    }

    public void printWinners(Winners winners) {
        StringBuilder sb = new StringBuilder();
        List<String> names = winners.getNames();
        sb.append(WINNER_PREFIX_MESSAGE);
        sb.append(String.join(WINNER_DELIMITER, names));
        System.out.println(sb);
    }

    private void printRoundDistance(Records records) {
        List<Record> recordList = records.getRecordList();
        for (Record record : recordList) {
            printRoundDistance(record.getName(), record.getPosition());
        }
    }

    private void printRoundDistance(String carName, CurrentPosition currentLocation) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentLocation.getValue(); i++) {
            sb.append(ROUND_DISTANCE_SYMBOL);
        }
        System.out.println(carName + ROUND_DISTANCE_DELIMITER + sb);
    }

}
