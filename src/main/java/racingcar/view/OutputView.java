package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.model.Distance;

public final class OutputView {

    private static final int DIVIDER_LINE_NO = 2;
    private static final String LINE_STYLE = "-";
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String SPACE = " ";

    private OutputView() {
    }

    public static void printException(final IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printWinners(final List<String> winnerCarNames) {
        System.out.println(createWinnersMessage(winnerCarNames));
    }

    public static void printGameResultTitle() {
        System.out.println(createGameResultTitleMessage());
    }

    public static void printDivider() {
        printEmptyLine(DIVIDER_LINE_NO);
    }

    public static void printEmptyLine(final int count) {
        for (int i = 0; i < count; i++) {
            System.out.println();
        }
    }

    public static void printCarsStatus(final List<CarStatusDto> carStatusDtos) {
        if (carStatusDtos == null || carStatusDtos.isEmpty()) {
            return;
        }
        for (final CarStatusDto carStatusDto : carStatusDtos) {
            printCarStatus(carStatusDto);
        }
    }

    private static void printCarStatus(final CarStatusDto carStatus) {
        if (carStatus == null) {
            return;
        }
        System.out.println(createCarStatusMessage(carStatus));
    }

    private static String createCarStatusMessage(final CarStatusDto carStatus) {
        return new StringBuilder()
            .append(createCarStatusTitleMessage(carStatus))
            .append(createCarStatusBodyMessage(carStatus))
            .toString();
    }

    private static String createCarStatusTitleMessage(final CarStatusDto carStatus) {
        return new StringBuilder()
            .append(carStatus.getCarName())
            .append(SPACE).append(COLON).append(SPACE)
            .toString();
    }

    private static String createCarStatusBodyMessage(final CarStatusDto carStatus) {
        return convertDistanceToLine(carStatus.getCarDistance());
    }

    private static String convertDistanceToLine(final Distance carDistance) {
        final StringBuilder stringBuilder = new StringBuilder();
        Distance current = Distance.ZERO;
        while (current.isLessThan(carDistance)) {
            stringBuilder.append(LINE_STYLE);
            current = current.plus(Distance.ONE);
        }
        return stringBuilder.toString();
    }

    private static String createWinnersMessage(final List<String> winnerCarNames) {
        return new StringBuilder()
            .append(createWinnersTitleMessage())
            .append(createWinnersBodyMessage(winnerCarNames))
            .toString();
    }

    private static String createWinnersTitleMessage() {
        return new StringBuilder()
            .append("최종 우승자").append(SPACE).append(COLON).append(SPACE)
            .toString();
    }

    private static String createWinnersBodyMessage(final List<String> winnerCarNames) {
        return String.join(COMMA + SPACE, winnerCarNames);
    }

    private static String createGameResultTitleMessage() {
        return "실행 결과";
    }

}
