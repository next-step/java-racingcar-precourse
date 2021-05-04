package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static final String WINNER_NAME_DELIMITER = ", ";
    List<Car> winners = new ArrayList<>();

    public void add(Car car) {
        winners.add(car);
    }

    public String getWinnersName() {
        StringBuilder winnerName = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            appendWinnerName(winnerName, i);
        }
        return winnerName.toString();
    }

    private void appendWinnerName(StringBuilder winnerName, int i) {
        winnerName.append(winners.get(i).getCarName().getCarName());
        if (i != winners.size() - 1) {
            winnerName.append(WINNER_NAME_DELIMITER);
        }
    }

    public void clear() {
        winners.clear();
    }
}
