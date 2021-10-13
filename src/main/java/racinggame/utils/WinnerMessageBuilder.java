package racinggame.utils;

import racinggame.model.Car;
import racinggame.model.Cars;

public class WinnerMessageBuilder {
    private static final String WINNER_MSG_PREFIX = "최종 우승자는 ";
    private static final String WINNER_MSG_POSTFIX = " 입니다.";
    private static final String WINNER_MSG_DELIMITER = ",";

    public static String build(Cars winnerCars) {
        StringBuilder builder = new StringBuilder();

        builder.append(WINNER_MSG_PREFIX);
        for (int i = 0; i < winnerCars.size(); i++) {
            Boolean isLastWinner = i == winnerCars.size() - 1;

            builder.append(buildWinnerMsgInternal(winnerCars.get(i), isLastWinner));
        }
        builder.append(WINNER_MSG_POSTFIX);

        return builder.toString();
    }

    private static String buildWinnerMsgInternal(Car winnerCar, boolean isLastWinner) {
        String winnerMsg = winnerCar.getPlayerName().get();

        if (!isLastWinner) {
            winnerMsg += WINNER_MSG_DELIMITER;
        }

        return winnerMsg;
    }
}
