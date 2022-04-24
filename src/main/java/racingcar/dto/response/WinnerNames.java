package racingcar.dto.response;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.racing.racer.Winner;

public class WinnerNames {
    private static final String WINNER_NAME_DELIMITER = ", ";

    private final String names;

    public WinnerNames(String names) {
        this.names = names;
    }

    public static WinnerNames from(Winner winner) {
        List<String> winnerNames = new ArrayList<>();
        winner.getWinners().forEach(w -> winnerNames.add(w.getName()));

        String[] winnerNameArray = winnerNames.toArray(new String[winnerNames.size()]);
        return new WinnerNames(String.join(WINNER_NAME_DELIMITER, winnerNameArray));
    }

    public String get() {
        return names;
    }
}
