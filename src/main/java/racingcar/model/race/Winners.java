package racingcar.model.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.car.CarName;
import racingcar.model.value.ErrorMsg;

public class Winners {

    private final List<CarName> winners;

    public Winners(List<CarName> winners) {
        validateWinners(winners);
        this.winners = winners;

    }

    private void validateWinners(final List<CarName> winners) {
        if (winners.size() == 0) {
            throw new IllegalStateException(ErrorMsg.ZERO_WINNER);
        }
    }

    public int getWinnerCount() {
        return winners.size();
    }

    public boolean isSingleWinner() {
        return winners.size() == 1;
    }


    private String printSingleWinner() {
        return winners.get(0).toString();
    }

    private String printMultipleWinner() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getWinnerCount(); i++) {
            builder.append(returnWinnerText(i, winners.get(i)));
        }
        String winnerText = builder.toString();
        return winnerText;
    }

    private String returnWinnerText(int index, CarName carName) {
        if (index == 0) {
            return carName.toString();
        }
        return ", " + carName.toString();
    }

    public String printWinner() {
        if (isSingleWinner()) {
            return printSingleWinner();
        }
        return printMultipleWinner();
    }


}
