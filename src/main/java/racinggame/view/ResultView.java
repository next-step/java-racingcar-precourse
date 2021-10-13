package racinggame.view;

import racinggame.domain.GameResult;
import racinggame.domain.LapResult;
import racinggame.domain.Record;

import java.util.StringJoiner;

public class ResultView {
    private static final String JOIN_DELIMITER = ",";
    private static final String POSITION_SYMBOL = "-";

    public static void printEveryLapResult(GameResult gameResult) {
        System.out.println("실행 결과");
        for (LapResult lapResult : gameResult.getLapResults()) {
            printLapResult(lapResult);
        }
    }

    private static void printLapResult(LapResult lapResult) {
        for (Record record : lapResult.getRecords()) {
            System.out.printf("%s : %s%n", record.getName(), mapPosition(record.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(GameResult gameResult) {
        System.out.printf("최종 우승자는 %s 입니다.%n", mapWinners(gameResult));
    }

    private static String mapPosition(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_SYMBOL);
        }
        return builder.toString();
    }

    private static String mapWinners(GameResult gameResult) {
        StringJoiner stringJoiner = new StringJoiner(JOIN_DELIMITER);
        for (String winner : gameResult.getWinners()) {
            stringJoiner.add(winner);
        }
        return stringJoiner.toString();
    }
}
