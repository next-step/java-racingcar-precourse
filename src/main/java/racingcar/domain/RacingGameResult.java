package racingcar.domain;

import java.util.StringJoiner;

public class RacingGameResult {

    private static final String WINNER_TEXT_PREFIX = "최종 우승자: ";
    private static final String WINNER_SEPARATOR = ", ";

    private final String gameResult;

    private RacingGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public static RacingGameResult of(CarList carList) {
        String gameResult = getWinner(carList);
        return new RacingGameResult(gameResult);
    }

    private static String getWinner(CarList carList) {
        StringJoiner stringJoiner = new StringJoiner(WINNER_SEPARATOR);

        for (Car car : carList.getLongestDistanceCarList()) {
            stringJoiner.add(car.getName());
        }

        return stringJoiner.toString();
    }

    public String getGameResult() {
        return WINNER_TEXT_PREFIX + this.gameResult;
    }
}
